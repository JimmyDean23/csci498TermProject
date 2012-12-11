/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.activity;

import java.io.File;
import java.util.*;
import com.db4o.*;
import bidixon.hiitmix.R;
import bidixon.hiitmix.domain.*;
import android.os.Bundle;
import android.app.*;
import android.content.*;
import android.view.*;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class WorkoutListActivity extends Activity {

	public final static String ID_EXTRA = "bidixon.hiitmix.activity._ID";
	public static String APPLICATION_DATA_PATH = null;	
	private List<Workout> workouts = null;
	private ListView listView = null;
	private ObjectContainer db = null;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_list);
        initializeList();
    }
    
    @Override
	public void onResume() {
		super.onResume();		 
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
    	APPLICATION_DATA_PATH = this.getDir("data", 0) + "/";
    	
    	new File(APPLICATION_DATA_PATH + "WorkoutDatabase.db4o").delete();
    	db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), APPLICATION_DATA_PATH + "WorkoutDatabase.db4o");
    	
    	try {
    		listView = (ListView) findViewById(R.id.workout_list);
    		View header = (View)getLayoutInflater().inflate(R.layout.workout_header, null);
            
    		
    		// testing stuff, will be removed
    		Workout w = new Workout(APPLICATION_DATA_PATH);
    		Workout w1 = new Workout(APPLICATION_DATA_PATH);
    		Interval interval = new Interval(30, 50);    		
    		HIITMixPlaylist p = new HIITMixPlaylist(null);
    		p.setName("Muzik");
    		
    		w.setName("cats");
    		w.add(interval);
    		w.addPlaylist(p);
    		db.store(w);
    		w1.setName("meow");
    		db.store(w1);
    		
    		workouts = new ArrayList<Workout>();
    		List<Workout> list = db.query(Workout.class);
    		for (Workout i : list) {
    			workouts.add(i);
    		}
    	    WorkoutAdapter adapter = new WorkoutAdapter(this, R.layout.workout_row, workouts);
    	    
    	    listView.addHeaderView(header, null, false);
    	    listView.setAdapter(adapter);
    	    listView.setOnItemClickListener(new OnItemClickListener() { 
    	        @Override
    	        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {            
    	        	Intent i = new Intent(view.getContext(), IntervalListActivity.class);
    	        	//Workout selected = new Workout(APPLICATION_DATA_PATH);
    	        	//List<Workout> results = db.queryByExample(selected);
    	    		i.putExtra(ID_EXTRA, String.valueOf(id));
    	    		startActivity(i);                 
    	        }
    	    });
    	} finally {
    	    db.close();
    	}
	}
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_workout_list, menu);
        return true;
    }
	
	private class WorkoutAdapter extends ArrayAdapter<Workout> {

		public WorkoutAdapter(Context context, int textViewResourceId, List<Workout> objects) {
			super(context, textViewResourceId, objects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			
			WorkoutHolder holder = null;
	        
	        if (row == null) {
	        	LayoutInflater inflater = getLayoutInflater();
	            row = inflater.inflate(R.layout.workout_row, parent, false);
	            
	            holder = new WorkoutHolder(row);
	            
	            row.setTag(holder);
	        } else {
	            holder = (WorkoutHolder) row.getTag();
	        }
	        
	        Workout workout_cursor = workouts.get(position);
	        holder.name.setText(workout_cursor.getName());
	        if (workout_cursor.getPlaylist() != null) {
	        	holder.playlist.setText(workout_cursor.getPlaylist());
	        }	        
	        
	        return row;
		}
		
	}
	
	static class WorkoutHolder {
		
        private TextView name = null;
        private TextView playlist = null;
        
        public WorkoutHolder(View row) {
        	name = (TextView) row.findViewById(R.id.workout_name);
        	playlist = (TextView) row.findViewById(R.id.playlist_name);
		}
        
    }
	
}