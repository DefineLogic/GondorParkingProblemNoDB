
public class TestFloor {

	public static void main(String[] args) {
		Floor f=new Floor(0);
			System.out.println(f);
			String ps=f.getFreeParkingSpotAndSlotIncoming("Car","280",false,false);
			System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","281",false,false);
			System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","282",false,false);
			System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","283",false,false);
			System.out.println(ps);
			System.out.println(f.summaryString());
			ps=f.outgoing("Car","282");
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","234",false,true);
			System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","233",true,true);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.outgoing("Car","233");
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","245",false,true);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			ps=f.getFreeParkingSpotAndSlotIncoming("Car","290",false,true);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","291",false,true);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","246",true,true);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.outgoing("Car","245");
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","247",false,false);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.outgoing("Car","234");
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Bike","911",false,false);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Bike","912",false,false);
			 System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","271",true,false);
			 System.out.println(ps);
			 System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","272",false,false);
			 System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","273",true,false);
			 System.out.println(ps);
			System.out.println(f.summaryString());
			 ps=f.getFreeParkingSpotAndSlotIncoming("Car","274",false,false);
			 System.out.println(ps);
			System.out.println(f.summaryString());
			

	}
	

}
