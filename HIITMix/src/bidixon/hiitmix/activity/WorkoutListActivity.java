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
import android.content.Context;
import android.view.*;
import android.widget.*;

public class WorkoutListActivity extends Activity {

	private List<Workout> workouts = null;
	private ListView listView = null;
	
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
    	new File(this.getDir("data", 0) + "/WorkoutDatabase.db4o").delete();
    	ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded
    	        .newConfiguration(), this.getDir("data", 0) + "/WorkoutDatabase.db4o");
    	try {
    		listView = (ListView) findViewById(R.id.workout_list);
    		View header = (View)getLayoutInflater().inflate(R.layout.header, null);
            
    		Workout w = new Workout();
    		Workout w1 = new Workout();
    		Workout w2 = new Workout();
    		Playlist p = new Playlist();
    		p.setName("Muzik");
    		
    		w.setName("I");
    		w.addPlaylist(p);
    		db.store(w);
    		w1.setName("<3");
    		db.store(w1);
    		w2.setName("Jiyoon");
    		db.store(w2);
    		
    		workouts = new ArrayList<Workout>();
    		List<Workout> list = db.query(Workout.class);
    		for (Workout i : list) {
    			workouts.add(i);
    		}
    	    WorkoutAdapter adapter = new WorkoutAdapter(this, R.layout.row, workouts);
    	    
    	    listView.addHeaderView(header, null, false);
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
	            row = inflater.inflate(R.layout.row, parent, false);
	            
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
