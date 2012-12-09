/**
 * @author		Billy Dixon
 * @version     1.0.0
 */

package bidixon.hiitmix.domain;

import java.io.Serializable;

public class Interval implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int duration;
	private int intensity;
	
	public Interval(int duration, int intensity) {
		this.duration = duration;
		this.intensity = intensity;
	}
	
	public void setDuration(int d) {
		duration = d;
	}
	
	public void setIntensity(int i) {
		intensity = i;
	}
	
	public int getDuration() {
		return duration;
	}
	
	public int getIntensity() {
		return intensity;
	}
	
}
