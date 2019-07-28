
public class ParkingSpot {
	
	int SpotNo;
	int priority;
	String vechileType;
	ParkingSlot[] slots;
	int totalSlots;
	int blockedRoyal;
	
	public void setSlotsSize(String vechileType){
	
		if(vechileType.equals("Bike")){
			slots= new ParkingSlot[5];
			this.totalSlots=5;
			this.vechileType="Bike";
		}
			else if(vechileType.equals("Car")){
				this.slots= new ParkingSlot[2];
				this.totalSlots=2;	
				this.vechileType="Car";
			}
	}
	
	public int getRemainingSlots(){
		int count=0;
		for(ParkingSlot eachslot:slots){
			if(eachslot!=null)
			count++;
		}
		return totalSlots-count;
	
	}
	
	public boolean isSpotSpaceAvailable(){
		for(ParkingSlot eachslot:slots){
			if(eachslot.occupied){
				return true;
			}
		}
		return false;
	}

	public int getSpotNo() {
		return SpotNo;
	}

	public void setSpotNo(int spotNo) {
		SpotNo = spotNo;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public String getVechileType() {
		return vechileType;
	}

	public void setVechileType(String vechileType) {
		this.vechileType = vechileType;
	}

	public ParkingSlot[] getSlots() {
		return slots;
	}

	public void setSlots(ParkingSlot[] slots) {
		this.slots = slots;
	}

	public int getTotalSlots() {
		return totalSlots;
	}

	public void setTotalSlots(int totalSlots) {
		this.totalSlots = totalSlots;
	}

	public int getBlockedRoyal() {
		return blockedRoyal;
	}

	public void setBlockedRoyal(int blockedRoyal) {
		this.blockedRoyal = blockedRoyal;
	}
	
	
	
	
}
