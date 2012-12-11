/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import java.util.*;
import android.content.*;
import com.db4o.*;

public class Workout {

	private List<Interval> intervals = null;
	private HIITMixPlaylist playlist = null;
	private String name = null;
	
	public Workout(Context c) {
		intervals = new ArrayList<Interval>();
		playlist = new HIITMixPlaylist(null);
		ObjectContainer db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), 
				c.getDir("data", 0) + "/workouts/" + name + ".db4o");
	}
	
	public void add(Interval i) {
		intervals.add(i);
	}
	
	public void edit(int index, int duration, int intensity) {
		intervals.get(index).setDuration(duration);
		intervals.get(index).setIntensity(intensity);
	}
	
	public void move(int oldIndex, int newIndex) {
		Interval i = intervals.get(newIndex);
		intervals.set(newIndex, intervals.get(oldIndex));
		intervals.set(oldIndex, i);
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void addPlaylist(HIITMixPlaylist playlist) {
		this.playlist = playlist;
	}
	
	public String getPlaylist() {
		return playlist.getName();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
