/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import java.util.*;

public class Playlist {
	
	private List<Track> tracks;
	private String name;
	
	public Playlist() {
		tracks = new ArrayList<Track>();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
