package pa1;
/**
 * @author Rakkan Tiasakul 5810546013
 * This is Weight enum  that implements Unit Interface
 */

public enum Weight implements Unit{

	/**
	 *  This part is using for setting names of units and the value of units.
	 * 
	 */
	KEED ("KEED", 1),
	GRAM ("Gram", 100),
	KILOGRAM ("Kilogram", 1000),
	TON("Ton", 1000000);
	
	/**
	 * public property for Weight enum. It's immutable. 
	 */
	public final String name ;

	public final double value;

	/**
	 * @param to get name and value and set them.
	 */
	
	Weight(String name, double value){
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
