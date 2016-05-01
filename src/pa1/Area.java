package pa1;

/**
 * @author Rakkan Tiasakul 5810546013
 * This is Area enum  that implements Unit Interface
 */
public enum Area implements Unit {
	/**
	 *  This part is using for setting names of units and the value of units.
	 * 
	 */
	SQUAREMETER ("Square metre",1),
	SQUAREKILOMETER("Square kilometer",1000000),
	SQUARECENTIMETER("Square Centimeter", -1000000),
	FOOT("Square foot", 0.0929),
	ACRE ("Acre",2.53),
	RAI ("Rai", 1600),
	NGANG ("Ngan", 4);
	
	

	/**
	 * public property for Area enum. It's immutable. 
	 */
	public final String name ;

	public final double value;

	/**
	 * @param to get name and value and set them.
	 */
	Area (String name, double value){
		this.name = name;
		this.value = value;
	}
	
	/**
	 * @return to return the value after getting it.
	 */
	public double getValue(){
		return value;
	}

	/**
	 * @return to return name into String. 
	 */

	public String toString(){	 
		return name;
	}
}
