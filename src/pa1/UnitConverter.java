package pa1;

/**
 *  @author Rakkan Tiasakul 5810546013
 *  This class is used for converting the unit.
 */

public class UnitConverter {
	/**
	 * @param getting the amount (in double) and the units (meter, centimeter, etc.) for converting
	 * @return return a number that is converted by multiply the amount to its unit then divide with another unit 
	 * that we want to know the value.
	 */
	public double convert (double amount, Unit fromUnit, Unit toUnit){
		return ((amount*fromUnit.getValue())/toUnit.getValue());
	}
	/**
	 * @return return values from 4 Unit classes.
	 */
	public Unit[] getUnits(UnitType utype){
		if (utype == UnitType.Length){
			return   Length.values();
		}
		else if (utype == UnitType.Weight){
			return Weight.values();
		}
		else if (utype == UnitType.Area){
			return Area.values();
		}
		else{
			return Currency.values();
		} 
	}
}
