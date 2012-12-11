/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.activity;

import java.util.*;
import com.db4o.ObjectContainer;
import bidixon.hiitmix.R;
import bidixon.hiitmix.domain.*;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class IntervalListActivity extends Activity {

	private List<Interval> intervals = null;
	private ListView listView = null;
	private ObjectContainer db = null;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_list);
        initializeList();
    }
	
	public void initializeList() {
		listView = (ListView) findViewById(R.id.interval_list);
		View header = (View)getLayoutInflater().inflate(R.layout.header, null);
		
		List<Interval> list = db.query(Interval.class);
		for (Interval i : list) {
			intervals.add(i);
		}
		
		IntervalAdapter adapter = new IntervalAdapter(this, R.layout.interval_row, intervals);
	    
	    listView.addHeaderView(header, null, false);
	    listView.setAdapter(adapter);
	}
	
	private class IntervalAdapter extends ArrayAdapter<Interval> {

		public IntervalAdapter(Context context, int textViewResourceId, List<Interval> objects) {
			super(context, textViewResourceId, objects);
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View row = convertView;
			
			IntervalHolder holder = null;
	        
	        if (row == null) {
	        	LayoutInflater inflater = getLayoutInflater();
	            row = inflater.inflate(R.layout.interval_row, parent, false);
	            
	            holder = new IntervalHolder(row);
	            
	            row.setTag(holder);
	        } else {
	            holder = (IntervalHolder) row.getTag();
	        }
	        
	        Interval interval_cursor = intervals.get(position);
	        holder.intensity.setText(interval_cursor.getIntensity());
	        holder.duration.setText(interval_cursor.getDuration());
	        
	        return row;
		}
		
	}
	
	static class IntervalHolder {
		
        private TextView intensity = null;
        private TextView duration = null;
        
        public IntervalHolder(View row) {
        	intensity = (TextView) row.findViewById(R.id.workout_name);
        	duration = (TextView) row.findViewById(R.id.playlist_name);
		}
        
    }
	
}
