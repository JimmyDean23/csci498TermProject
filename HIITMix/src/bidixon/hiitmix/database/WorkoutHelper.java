/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WorkoutHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "hiitmix_workouts.db";
	private static final int SCHEMA_VERSION = 1;
	
	public WorkoutHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	}

	
	public void insert(String name, String playlist) {
		ContentValues cv = new ContentValues();
		
		cv.put("name", name);
		cv.put("playlist", playlist);
		
		getWritableDatabase().insert("hiitmix_workouts", "name", cv);
	}
	
	public void update(String id, String name, String playlist) {
		ContentValues cv = new ContentValues();
		String[] args = {id};
		
		cv.put("name", name);
		cv.put("playlist", playlist);
		
		getWritableDatabase().update("hiitmix_workouts", cv, "_ID=?", args);
	}
	
	/* 
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE hiitmix_workouts (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, playlist TEXT);");
	}

	/* 
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}
	
	public Cursor getById(String id) {
		String[] args = {id};
		return getReadableDatabase().rawQuery("SELECT _id, name, playlist FROM hiitmix_workouts WHERE _ID=?", args);
	}
	
	public Cursor getAll() {
		return getReadableDatabase().rawQuery("SELECT _id, name, playlist FROM hiitmix_workouts ORDER BY name", null);
	}
	
	public String getName(Cursor c)			{ return c.getString(1); }
	public String getPlaylist(Cursor c) 	{ return c.getString(2); }

}
