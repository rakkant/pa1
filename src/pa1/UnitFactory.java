package pa1;

public class UnitFactory {
	private static UnitFactory testForUnit = null;
	public static UnitFactory getInstance(){
		if(testForUnit == null){
			testForUnit = new UnitFactory();
		}
		return testForUnit;
	}
	public UnitType[] getUnitTypes(){
		return UnitType.values();
	}
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
