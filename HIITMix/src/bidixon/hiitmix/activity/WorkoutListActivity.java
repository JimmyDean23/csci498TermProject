/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.activity;

import java.util.List;
import bidixon.hiitmix.R;
import bidixon.hiitmix.database.*;
import bidixon.hiitmix.domain.*;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class WorkoutListActivity extends Activity {

	private List<Workout> workouts;
	private WorkoutHelper workoutHelper;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
    }
    
    @Override
	public void onResume() { 
		super.onResume();
		workoutHelper = new WorkoutHelper(this);
		initializeList(); 
	}
    
    @Override
	public void onPause() { 
    	workoutHelper.close();
		super.onPause(); 
	}
    
    @Override
	public void onDestroy() { 
    	workoutHelper.close();
		super.onDestroy(); 
	}

    private void initializeList() {
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_workout_list, menu);
        return true;
    }
    
}
