
public class ParkingBuilding {
	
	Floor fl[];
	
	 public Floor[] getFloors() {
		return fl;
	}

	public void setFloors(Floor[] fl) {
		this.fl = fl;
	}

	public ParkingBuilding(int noOfFloors){
		 this.fl=new Floor[noOfFloors];
		 for(int i=0;i<noOfFloors;i++){
			 fl[i]=new Floor(i);
		 }
	 }
	 

}
