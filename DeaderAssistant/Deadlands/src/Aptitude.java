import java.util.ArrayList;

public class Aptitude {

	//An aptitude can have a name
	private String aptitudeName;
	
	//An aptitude can have a aptitude level for an object
	private int aptitudeValue = 0;
	
	//An aptitude can identify as a SubAptitude
	private boolean aptitudeSubAptitudeBoolean;
	
	//A aptitude can have SubAptitudes(which are zero to many aptitude)
	private ArrayList<Aptitude> aptitudeSubAptitudeArrayListAptitudes = new ArrayList<Aptitude>();
	
	public Aptitude(String sName, int sValue)
	{
		setAptitudeName(sName);
		setAptitudeValue(sValue);
	}
	
	/**
	 * @return the aptitudeName
	 */
	public String getAptitudeName() {
		return aptitudeName;
	}
	/**
	 * @param aptitudeName the aptitudeName to set
	 */
	public void setAptitudeName(String aptitudeName) {
		this.aptitudeName = aptitudeName;
	}
	/**
	 * @return the aptitudeValue
	 */
	public int getAptitudeValue() {
		return aptitudeValue;
	}
	/**
	 * @param aptitudeValue the aptitudeValue to set
	 */
	public void setAptitudeValue(int aptitudeValue) {
		this.aptitudeValue = aptitudeValue;
	}

	/**
	 * @return the aptitudeSubAptitudeArrayListAptitudes
	 */
	public ArrayList<Aptitude> getAptitudeSubAptitudeArrayListAptitudes() {
		return aptitudeSubAptitudeArrayListAptitudes;
	}


	/**
	 * @param aptitudeSubAptitudeArrayListAptitudes the aptitudeSubAptitudeArrayListAptitudes to set
	 */
	public void setAptitudeSubAptitudeArrayListAptitudes(ArrayList<Aptitude> aptitudeSubAptitudeArrayListAptitudes) {
		this.aptitudeSubAptitudeArrayListAptitudes = aptitudeSubAptitudeArrayListAptitudes;
	}


	/**
	 * @return the aptitudeSubAptitudeBoolean
	 */
	public boolean isAptitudeSubAptitudeBoolean() {
		return aptitudeSubAptitudeBoolean;
	}


	/**
	 * @param aptitudeSubAptitudeBoolean the aptitudeSubAptitudeBoolean to set
	 */
	public void setAptitudeSubAptitudeBoolean(boolean aptitudeSubAptitudeBoolean) {
		this.aptitudeSubAptitudeBoolean = aptitudeSubAptitudeBoolean;
	}

	
}

