/**
 * 
 */
package bidixon.hiitmix.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author napoleon2340
 *
 */
public class PlaylistHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "hiitmix_playlists.db";
	private static final int SCHEMA_VERSION = 1;
	
	public PlaylistHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	}

	
	public void insert(String name, String tracks) {
		ContentValues cv = new ContentValues();
		
		cv.put("name", name);
		cv.put("tracks", tracks);
		
		getWritableDatabase().insert("hiitmix_playlists", "name", cv);
	}
	
	public void update(String id, String name, String tracks) {
		ContentValues cv = new ContentValues();
		String[] args = {id};
		
		cv.put("name", name);
		cv.put("tracks", tracks);
		
		getWritableDatabase().update("hiitmix_playlists", cv, "_ID=?", args);
	}
	
	/* 
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE hiitmix_playlists (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, tracks TEXT);");
	}

	/* 
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public Cursor getById(String id) {
		String[] args = {id};
		return getReadableDatabase().rawQuery("SELECT _id, name, tracks FROM hiitmix_playlists WHERE _ID=?", args);
	}
	
	public Cursor getAll(String orderBy) {
		return getReadableDatabase().rawQuery("SELECT _id, name, tracks FROM hiitmix_playlists ORDER BY " + orderBy, null);
	}
	
	public String getName(Cursor c)			{ return c.getString(1); }
	public String getTracks(Cursor c) 		{ return c.getString(2); }

}
