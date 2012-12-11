/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import java.io.*;
import java.util.*;
import com.db4o.*;

public class Workout {

	private List<Interval> intervals = null;
	private HIITMixPlaylist playlist = null;
	private String name = null;
	private String APPLICATION_DATA_PATH = null;
	private ObjectContainer db = null;
	
	public Workout(String APPLICATION_DATA_PATH) {
		this.APPLICATION_DATA_PATH = APPLICATION_DATA_PATH;
		
		intervals = new ArrayList<Interval>();
		addPlaylist(new HIITMixPlaylist(null));		
		setName("New Workout");
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
		// delete old database if it exists
		//if (this.name != null) { new File(APPLICATION_DATA_PATH + "workouts/" + this.name + ".db4o").delete(); }
		
		// change name and create new database
		this.name = name;
		//db = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), APPLICATION_DATA_PATH + "workouts/" + this.name + ".db4o");
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
