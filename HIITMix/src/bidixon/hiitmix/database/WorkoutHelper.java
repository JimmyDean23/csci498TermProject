/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WorkoutHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "hiitmix_workouts.db";
	private static final int SCHEMA_VERSION = 1;
	
	public WorkoutHelper(Context context) {
		super(context, DATABASE_NAME, null, SCHEMA_VERSION);
	}

	/* 
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	/* 
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
