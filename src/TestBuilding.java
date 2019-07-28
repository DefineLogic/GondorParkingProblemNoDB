import java.util.HashMap;


public class TestBuilding {
	static ParkingBuilding pb;	
	static HashMap<String,Integer> hm;
	static int numberOfFloors=2;

	


	public static void main(String[] args) {
		pb=new ParkingBuilding(numberOfFloors);
		hm= new HashMap<String,Integer>();
		 findSpotinBuilding1("Car","280",false,true,false);
		 findSpotinBuilding1("Car","280",false,true,true);
		 findSpotinBuilding1("Car","245",false,true,true);
		 findSpotinBuilding1("Car","282",false,true,false);
		 findSpotinBuilding1("Car","283",false,true,false);
		 findSpotinBuilding1("Car","234",false,true,false);
		 findSpotinBuilding1("Car","233",true,true,false);
		 findSpotinBuilding1("Car","233",true,true,false);
		 findSpotinBuilding1("Car","290",false,true,false);
		 findSpotinBuilding1("Car","291",false,true,false);
		 findSpotinBuilding1("Car","246",true,true,false);
		 findSpotinBuilding1("Car","247",true,false,false);
		 findSpotinBuilding1("Bike","911",false,false,true);
		 findSpotinBuilding1("Bike","912",false,false,true);
		 findSpotinBuilding1("Car","271",false,false,false);
		 findSpotinBuilding1("Car","272",false,false,false);
		 findSpotinBuilding1("Car","273",false,false,false);
		 findSpotinBuilding1("Car","274",false,true,false);
		 processOutgoing("Bike","911");
		 processOutgoing("Car","1111");

			
			
		}
		
	
			
			public static void findSpotinBuilding1(String vechileType, String vechileNumber,boolean isElderly, boolean isRoyal, boolean isPooled) {
				String ps=findSpotinBuilding2(vechileType,vechileNumber,isElderly,isRoyal,isPooled);
				if(ps==null){
					String c="";
					c+="No Suitable Space Available for incoming "+ vechileType;
					if(isRoyal){
					c+=" for Royal";	
					}
					if(isElderly){
					c+=" for Elder";	
					}
					System.out.println(c);
					}
					
				else{
					if(hm.get(vechileNumber)==null){
					hm.put(vechileNumber, 1);
					}
					else 
					{
						hm.put(vechileNumber,hm.get(vechileNumber)+1);
					}
				}
	}


			public static String findSpotinBuilding2(String vechileType,String vechileNumber,Boolean isElderly,boolean isRoyal,boolean isPooled){
				String ps="";
				for(int i=0;i<numberOfFloors;i++){
					Floor f=pb.getFloors()[i];
					ps=f.getFreeParkingSpotAndSlotIncoming(vechileType,vechileNumber,isElderly,isRoyal);
					if(ps.equals("")){
						continue;
					}
					if(!ps.equals("")){
					System.out.print("Floor No:"+i+" :");
					System.out.println(ps);
					if(isPooled)
					{
						System.out.println("Pooled incentives added.");
					}
					if(hm.get(vechileNumber)!=null){
						System.out.println("Discount  amount:"+hm.get(vechileNumber)*10);
					}
					System.out.println(f.summaryString());
					System.out.println();
					return ps;
					}
					
				}
				return null;

			}
			
			private static void processOutgoing(String vechileType, String vechileNumber) {
				for(int i=0;i<numberOfFloors;i++){
					Floor f=pb.getFloors()[i];
					String ps=f.outgoing(vechileType, vechileNumber);
					if(ps.equals("----")){
						if(i==numberOfFloors-1)
						{
							System.out.println(vechileType+" "+vechileNumber+" not entered in building.");
						}
						continue;
					}
					else{
					System.out.print("----Floor No:"+i+" :");
					System.out.println(ps);
					System.out.println(f.summaryString());
					System.out.println();
					break;
					}
					
				}
				
				
		
	}

			
			
			
}
