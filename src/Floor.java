import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Floor {
	int floorNo;
	ParkingSpot[][] ps = new ParkingSpot[4][5];
	final int[] floorXeroSpots = { 2, 0, 3, 0, 2, 1, 3, 1, 2, 2, 3, 2, 2, 3, 3,
			3, 2, 4, 3, 4, 0, 4, 1, 4, 0, 3, 1, 3, 0, 2, 1, 2, 0, 1, 1, 1, 0,
			0, 1, 0 };

	// final HashMap<Integer,ArrayList<Integer>> hm= new
	// HashMap<Integer,ArrayList<Integer>>();
	// final int[] floorOtherSpots={0,4,1,4,2,4,3,4,0,3,1,3,2,3,3,3,};

	public ParkingSpot[][] getPs() {
		return ps;
	}

	public void setPs(ParkingSpot[][] ps) {
		this.ps = ps;
	}

	public Floor(int floorNumber) {
		this.floorNo = floorNumber;
		int count = 1;
		// if(floorNumber==0){
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				ParkingSpot pss = new ParkingSpot();
				ps[i][j] = pss;
				pss.setSpotNo(count);
				if (j == 0 && i < 2) {
					pss.setPriority(10);
				} else if (j == 1 && i < 2) {
					pss.setPriority(9);
				} else if (j == 2 && i < 2) {
					pss.setPriority(8);
				} else if (j == 3 && i < 2) {
					pss.setPriority(7);
				} else if (j == 4 && i < 2) {
					pss.setPriority(6);
				}

				else if (j == 0 && i >= 2) {
					pss.setPriority(1);
				} else if (j == 1 && i >= 2) {
					pss.setPriority(2);
				} else if (j == 2 && i >= 2) {
					pss.setPriority(3);
				} else if (j == 3 && i >= 2) {
					pss.setPriority(4);
				} else if (j == 4 && i >= 2) {
					pss.setPriority(5);
				}
				count++;
			}
		}
		// }
		/*
		 * else{
		 * 
		 * for(int i=0;i<4;i++){ for(int j=0;j<5;j++){ ParkingSpot pss=new
		 * ParkingSpot(); ps[i][j]=pss; pss.setSpotNo(count); if(j==0){
		 * pss.setPriority(5); } else if(j==1){ pss.setPriority(4); } else
		 * if(j==2){ pss.setPriority(3); } else if(j==3){ pss.setPriority(2); }
		 * else if(j==4){ pss.setPriority(1); } count++; } }
		 * 
		 * }
		 */
	}

	public boolean isFloorSpaceAvailable() {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (ps[i][j].isSpotSpaceAvailable())
					return true;
			}
		}
		return false;
	}

	public String getFreeParkingSpotAndSlotIncoming(String vechileType,
			String vechileNumber, Boolean isElderly, Boolean isRoyal) {
		ParkingSlot result = null;
		ParkingSpot resultAsSpot = null;
		String returnResult = "";
		int[] spotsOnPriority = null;
		spotsOnPriority = floorXeroSpots;

		// //////////////////////////////////////////////////////////////////////////////////////////ROYALLLLLLLL/////////////////////////////////////////
		if (vechileType.equals("Car") && isRoyal) {
			for (int i = 0; i < 40; i++) {
				int a = i++;
				int b = i;
				ParkingSpot eachSpot = ps[spotsOnPriority[a]][spotsOnPriority[b]];
				int c = spotsOnPriority[a];
				int d = spotsOnPriority[b];
				if (eachSpot.getVechileType() == null) {
					if (d == 0) {
						if (ps[c][d + 1].getVechileType() == null) {
							eachSpot.setSlotsSize("Car");
							result = new ParkingSlot(true, vechileNumber, 0,
									isElderly, isRoyal);
							eachSpot.getSlots()[0] = result;
							resultAsSpot = eachSpot;
							ps[c][d].blockedRoyal++;
							ps[c][d + 1].blockedRoyal++;
							break;
						}
					} else if (d == 4) {
						if (ps[c][d - 1].getVechileType() == null) {
							eachSpot.setSlotsSize("Car");
							result = new ParkingSlot(true, vechileNumber, 0,
									isElderly, isRoyal);
							eachSpot.getSlots()[0] = result;
							resultAsSpot = eachSpot;
							ps[c][d].blockedRoyal++;
							ps[c][d - 1].blockedRoyal++;
							break;
						}
					} else {
						if (ps[c][d - 1].getVechileType() == null
								&& ps[c][d + 1].getVechileType() == null) {
							eachSpot.setSlotsSize("Car");
							resultAsSpot = eachSpot;
							result = new ParkingSlot(true, vechileNumber, 0,
									isElderly, isRoyal);
							eachSpot.getSlots()[0] = result;
							ps[c][d].blockedRoyal++;
							ps[c][d + 1].blockedRoyal++;
							ps[c][d - 1].blockedRoyal++;
							break;
						}
					}
				}
			}
			if (resultAsSpot != null) {
				returnResult += "Car " + vechileNumber
						+ " to be parked at ParkingSpot:"
						+ resultAsSpot.getSpotNo() + " at slot:0 ";
				if (isElderly) {
					returnResult += "--ELDER";
				}
				returnResult += "--ROYAL";
			}

			return returnResult;
		}

		// //////////////////////////////////////////////////////////////////////////////////////////CARRRRRRRR/////////////////////////////////////////
		if (vechileType.equals("Car") && !isRoyal) {
			outerloop1: for (int i = 0; i < 40; i++) {
				int a = i++;
				int b = i;
				ParkingSpot eachSpot = ps[spotsOnPriority[a]][spotsOnPriority[b]];
				if (eachSpot.blockedRoyal > 0)
					continue;
				// System.out.println(spotsOnPriority[a]+" "+spotsOnPriority[b]);
				if (eachSpot.getVechileType() == null) {
					eachSpot.setSlotsSize("Car");
					result = new ParkingSlot(true, vechileNumber, 0, isElderly,
							isRoyal);
					eachSpot.getSlots()[0] = result;
					if (result != null) {
						returnResult += "Car " + vechileNumber
								+ " to be parked at ParkingSpot:"
								+ eachSpot.getSpotNo() + " at slot:0";
						if (isElderly) {
							returnResult += "--ELDER";
						}
					}
					break;
				}

				if (result == null && eachSpot.getVechileType() != null
						&& (eachSpot.getVechileType()).equals("Car")
						&& eachSpot.getRemainingSlots() == 1) {
					ParkingSlot pl0 = eachSpot.getSlots()[0];
					// ParkingSlot pl1 =eachSpot.getSlots()[1];
					if (pl0 == null) {
						result = new ParkingSlot(true, vechileNumber, 0,
								isElderly, isRoyal);
						eachSpot.getSlots()[0] = result;
						if (result != null)
							returnResult += "Car " + vechileNumber
									+ " to be parked at ParkingSpot:"
									+ eachSpot.getSpotNo() + " at slot:"
									+ result.slotNo;
						break outerloop1;
					}
					if (!isElderly && pl0 != null) {

						if (pl0.isElderly) {
							result = new ParkingSlot(true, vechileNumber, 1,
									isElderly, isRoyal);
							eachSpot.getSlots()[1] = result;
							returnResult += "***"
									+ " ELDER Car "
									+ pl0.getVechileNo()
									+ " at ParkingSpot:"
									+ eachSpot.getSpotNo()
									+ " to be moved for letting incoming vechile to upper deck.*** ";
						} else {
							result = new ParkingSlot(true, vechileNumber, 0,
									isElderly, isRoyal);
							eachSpot.getSlots()[1] = pl0;
							eachSpot.getSlots()[1].setSlotNo(1);
							eachSpot.getSlots()[0] = result;
							returnResult += "***" + "Car " + pl0.getVechileNo()
									+ " at ParkingSpot:" + eachSpot.getSpotNo()
									+ " to be shifted to upper deck:1" + "*** ";
						}

						if (result != null) {
							returnResult += "Car " + vechileNumber
									+ " to be parked at ParkingSpot:"
									+ eachSpot.getSpotNo() + " at slot:"
									+ result.slotNo;
						}
						break outerloop1;
					} else if (isElderly && pl0 != null) {

						if (pl0.isElderly) {
							continue outerloop1;
						} else {
							result = new ParkingSlot(true, vechileNumber, 0,
									isElderly, isRoyal);
							eachSpot.getSlots()[1] = pl0;
							eachSpot.getSlots()[1].setSlotNo(1);
							eachSpot.getSlots()[0] = result;
							returnResult += "***" + "Car " + pl0.getVechileNo()
									+ " at ParkingSpot:" + eachSpot.getSpotNo()
									+ " to be shifted to upper deck:1" + "*** ";
						}
						if (result != null) {
							returnResult += "Car " + vechileNumber
									+ " to be parked at ParkingSpot:"
									+ eachSpot.getSpotNo() + " at slot:"
									+ result.slotNo;
							returnResult += "--ELDER";
						}
						break outerloop1;

					}

				}
			}

		}

		// //////////////////////////////////////////////////////////////////////////////////////////BIKEEEEEEEEEEE/////////////////////////////////////////
		if (vechileType.equals("Bike")) {
			outerloop2: for (int i = 0; i < 40; i++) {
				int a = i++;
				int b = i;
				ParkingSpot eachSpot = ps[spotsOnPriority[a]][spotsOnPriority[b]];
				if (eachSpot.blockedRoyal > 0)
					continue;
				if (eachSpot.getVechileType() == null) {
					eachSpot.setSlotsSize("Bike");
					result = new ParkingSlot(true, vechileNumber, 0, false,
							false);
					eachSpot.getSlots()[0] = result;
					if (result != null)
						returnResult = "Bike " + vechileNumber
								+ " to be parked at ParkingSpot:"
								+ eachSpot.getSpotNo() + " at slot:0";
					break;
				}

				if (result == null && eachSpot.getVechileType() != null
						&& (eachSpot.getVechileType()).equals("Bike")
						&& eachSpot.getRemainingSlots() > 0) {
					for (int j = 0; j < 5; j++) {
						if (eachSpot.getSlots()[j] == null) {
							result = new ParkingSlot(true, vechileNumber, j,
									false, false);
							eachSpot.getSlots()[j] = result;
							if (result != null)
								returnResult = "Bike " + vechileNumber
										+ " to be parked at ParkingSpot:"
										+ eachSpot.getSpotNo() + " at slot:"
										+ result.slotNo;
							break outerloop2;
						}
					}

				}
			}

		}

		return returnResult;
	}

	public String outgoing(String vechileType, String vechileNumber) {
		String returnResult = "----";
		ParkingSpot pss = null;
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				if (ps[i][j] != null && ps[i][j].getSlots() != null) {
					{
						int count = 0;
						for (ParkingSlot psl : ps[i][j].getSlots()) {
							if (psl != null) {
								if (psl.getVechileNo().equals(vechileNumber)) {
									pss = ps[i][j];
									ps[i][j].getSlots()[count] = null;
									if (vechileType.equals("Car")) {
										if (psl.getSlotNo() == 1
												&& pss.getRemainingSlots() == 1) {
											returnResult += "**** Below vechile needs to be moved for letting upper vechile out ****";
										}
									}
									returnResult += vechileType + " "
											+ vechileNumber
											+ " removed from ParkingSpot:"
											+ ps[i][j].getSpotNo()
											+ " from slot:" + psl.getSlotNo();
									if (vechileType.equals("Car")) {
										if (psl.isElderly)
											returnResult += "--ELDER";
										if (psl.isRoyal) {
											returnResult += "--ROYAL";
											pss.blockedRoyal--;
											if (j == 0) {
												ps[i][j + 1].blockedRoyal--;
											} else if (j == 4) {
												ps[i][j - 1].blockedRoyal--;
											} else {
												ps[i][j - 1].blockedRoyal--;
												ps[i][j + 1].blockedRoyal--;
											}

										}
									}
									break;
								}
							}
							count++;
						}
					}
				}
			}

		}
		if (vechileType.equals("Bike")) {
			if (pss != null && pss.getRemainingSlots() == 5) {
				pss.setVechileType(null);
			}
		}

		if (vechileType.equals("Car")) {
			if (pss != null && pss.getRemainingSlots() == 2) {
				pss.setVechileType(null);
			}
		}

		// returnResult= "vechileNotfound.";
		return returnResult;

	}

	public String toString() {
		String a = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				a = a + ps[i][j].getSpotNo() + "-" + ps[i][j].getPriority()
						+ "  ";
			}
			a = a + "\n";
		}
		return a;
	}

	public String summaryString() {
		String a = "";
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++) {
				a = a + ps[i][j].getSpotNo() + "-" + ps[i][j].getPriority()
						+ "-";
				if (ps[i][j].blockedRoyal > 0)
					a = a + "RYL-";
				if (ps[i][j].getVechileType() == null) {
				} else {
					for (ParkingSlot psl : ps[i][j].getSlots()) {
						if (psl != null) {
							a = a + psl.getVechileNo();
							if (psl.isElderly) {
								a = a + "^";
							}
							a = a + "|";
						}

						else {
							a = a + "null|";
						}
					}

				}
				a = a + "  ";
			}
			a = a + "\n";
		}
		return a;
	}

}
