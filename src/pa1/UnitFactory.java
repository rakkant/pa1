package pa1;

/**
 * 
 * @author Rakkan Tiasakul 5810546013
 * This is the class which is singleton.
 *
 */
public class UnitFactory {
	/**
	 * constructor
	 */
	private static UnitFactory testForUnit = null;
	
	/**
	 * 
	 * @return to make us sure that we only have one UnitFactory.
	 */
	public static UnitFactory getInstance(){
		if(testForUnit == null){
			testForUnit = new UnitFactory();
		}
		return testForUnit;
	}
	
	/**
	 * 
	 * @return value of each unit after getting it.
	 */
	public UnitType[] getUnitTypes(){
		return UnitType.values();
	}
	
	/**
	 * 
	 * @param utype to check if it equals to any UnitType.
	 * @return that value if it equals.
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
