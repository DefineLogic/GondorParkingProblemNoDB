
public class ParkingSlot {
	Boolean occupied;
	String vechileNo;
	int slotNo;
	Boolean isElderly;
	Boolean isRoyal;

	
	
	public ParkingSlot(Boolean occupied, String vechileNo , int slotNo , Boolean isElderly, Boolean isRoyal) {
		this.occupied = occupied;
		this.vechileNo = vechileNo;
		this.slotNo = slotNo;
		this.isElderly = isElderly;
		this.isRoyal = isRoyal;
	}
	public Boolean getOccupied() {
		return occupied;
	}
	public void setOccupied(Boolean occupied) {
		this.occupied = occupied;
	}
	public String getVechileNo() {
		return vechileNo;
	}
	public void setVechileNo(String vechileNo) {
		this.vechileNo = vechileNo;
	}
	public int getSlotNo() {
		return slotNo;
	}
	public void setSlotNo(int slotNo) {
		this.slotNo = slotNo;
	}
	public Boolean getIsElderly() {
		return isElderly;
	}
	public void setIsElderly(Boolean isElderly) {
		this.isElderly = isElderly;
	}
	public Boolean getIsRoyal() {
		return isRoyal;
	}
	public void setIsRoyal(Boolean isRoyal) {
		this.isRoyal = isRoyal;
	}
	
	
}
