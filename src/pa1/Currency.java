package pa1;

/**
 * @author Rakkan Tiasakul 5810546013
 * This is Curency enum  that implements Unit Interface
 */
public enum Currency implements Unit{
	/**
	 *  This part is using for setting names of units and the value of units.
	 * 
	 */
	BAHT ("THB", 0.57),
	DOLLAR ("USD", 20.0),
	YAUN ("CHY",27.0),
	EURO ("EUR",20.0),
	POUND("GBP",25.5);

	/**
	 * public property for Currency enum. It's immutable. 
	 */
	public final String name ;

	public final double value;
	
	/**
	 * @param to get name and value and set them.
	 */
	Currency(String name, double value){
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
