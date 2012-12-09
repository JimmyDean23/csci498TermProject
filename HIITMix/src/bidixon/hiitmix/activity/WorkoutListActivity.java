/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.activity;

import java.util.*;
import com.db4o.*;
import bidixon.hiitmix.R;
import bidixon.hiitmix.domain.*;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.*;

public class WorkoutListActivity extends Activity {

	private List<Workout> workouts;
	private ListView listView;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
    }
    
    @Override
	public void onResume() {
		super.onResume();
		initializeList(); 
	}
    
    @Override
	public void onPause() {
		super.onPause(); 
	}
    
    @Override
	public void onDestroy() {
		super.onDestroy(); 
	}

    private void initializeList() {
    	ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
    	        .newConfiguration(), this.getDir("data", 0) + "/WorkoutDatabase.db4o");
    	try {
    		listView = (ListView) findViewById(R.id.workout_list);
    		Workout w = new Workout();
    		w.setName("Test");
    		db.store(w);
    		workouts = new ArrayList<Workout>();
    		workouts.add(w);
    	    ArrayAdapter<Workout> adapter = new ArrayAdapter<Workout>(this, android.R.layout.simple_list_item_1, workouts);
    	    listView.setAdapter(adapter);
    	} finally {
    	    db.close();
    	}
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_workout_list, menu);
        return true;
    }
	
}
