/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import com.echonest.api.v4.*;

public class HIITMixSong extends com.echonest.api.v4.Song {

	public HIITMixSong(EchoNestAPI en, String id) throws EchoNestException {
		super(en, id);
	}
	
}
