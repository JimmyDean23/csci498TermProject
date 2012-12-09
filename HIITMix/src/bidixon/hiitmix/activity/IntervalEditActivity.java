/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.activity;

import bidixon.hiitmix.R;
import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

public class IntervalEditActivity extends Activity {
	
	private EditText duration;
	private EditText intensity;
	String workoutId;
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interval_edit);
    }
	
	@Override
	public void onDestroy() {
		super.onDestroy();
	}
	
}
