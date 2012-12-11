/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import java.util.*;

import com.echonest.api.v4.*;

public class HIITMixPlaylist extends com.echonest.api.v4.Playlist {
	
	private List<Song> songs = null;
	private String name = null;
	
	public HIITMixPlaylist(List<Song> s) {
		super(s);
		this.songs = s;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
}
