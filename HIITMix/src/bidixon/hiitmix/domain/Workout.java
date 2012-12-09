/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import java.util.*;

public class Workout {

	private List<Interval> intervals;
	private Playlist playlist;
	private String name;
	
	public Workout() {
		intervals = new ArrayList<Interval>();
		playlist = new Playlist();
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
	
	public void addPlaylist(Playlist playlist) {
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
