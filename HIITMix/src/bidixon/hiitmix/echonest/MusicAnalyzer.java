/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.echonest;

import com.echonest.api.v4.*;

public class MusicAnalyzer {
	
	private static final String API_KEY = "GG0IO4JU1FZQJ0IH1";
	
	public MusicAnalyzer() {
		EchoNestAPI echoNest = new EchoNestAPI(API_KEY);
	}

}
