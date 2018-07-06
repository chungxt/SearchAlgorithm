import java.util.ArrayList;

public class biBFSProcess extends SearchAlgorithm {

	private int option;
	private Map mapOrg;
	private Map mapAsc;
	private Map mapDesc;
	private ArrayList<Map> expandListAsc;
	private ArrayList<Map> expandListDesc;

	public biBFSProcess(int option, Map map) {
		setOption(option);
		mapOrg = new Map(map.getMap());
		mapOrg.copyMap(map);

		setMapAsc(map);
		expandListAsc = new ArrayList<>();
		expandListAsc.add(map);

		int n = map.getMap().length;
		int[][] temp = new int[n][n];

		Map mapDesc = new Map(temp);
		setMapDesc(mapDesc);
		expandListDesc = new ArrayList<>();
		expandListDesc.add(mapDesc);
	}

	public void searchBiBFS() {

		int exploredNum = 0;
		String log = "";

		while (expandListAsc.size() != 0 || expandListDesc.size() != 0) {

			if (expandListAsc.size() != 0) {

				// System.out.println("ASC" + expandListAsc.size());
				// for (int i = 0; i < expandListAsc.size(); i++) {
				// expandListAsc.get(i).printNowLog();
				// }
				// System.out.println();

				// log += "<" + mapAsc.getDirection() + ", " + mapAsc.getSub() + ">";

				if (fringeTest(expandListAsc, expandListDesc)) { // do goal test

					// exploredNum = exploredNum + 1; // add one for one of the fringe

					boolean stop = false;
					String text = "";

					// System.out.println("ASC fringe");
					// for (int i = 0; i < expandListAsc.size(); i++) {
					// expandListAsc.get(i).printMap();
					// //expandListAsc.get(i).printLog();
					// System.out.println(expandListAsc.get(i).printLog());
					// }
					// System.out.println("DESC fringe");
					// for (int i = 0; i < expandListDesc.size(); i++) {
					// expandListDesc.get(i).printMap();
					// expandListDesc.get(i).printLog();
					// System.out.println(expandListDesc.get(i).printLog());
					// }

					for (int i = 0; i < expandListAsc.size() && !stop; i++) {
						for (int j = 0; j < expandListDesc.size() && !stop; j++) {

							if (expandListAsc.get(i).sameMapTest(expandListDesc.get(j))) {
								// System.out.println("ASC end");
								//
								// System.out.println(expandListAsc.get(i).printLog());
								// System.out.println(expandListDesc.get(j).printLog());

								// expandListAsc.get(i).printMap();
								// expandListDesc.get(j).printMap();

								text = expandListAsc.get(i).printBiBFSLog(expandListDesc.get(j));

								stop = true;
							}

						}
					}

					// exploredNum = exploredNum + 2;

					System.out.println("log: " + text);
					// System.out.println("total: " + log);
					System.out.println("num: " + exploredNum);
					break;

				} else { // expend this node

					mapAsc = expandListAsc.get(0);
					expandListAsc.remove(0);

					// mapAsc.printMap();
					// System.out.println();

					// get all candidate, then add to candidateList

					for (int i = 0; i < option; i++) { // option big -> small
						Map[] candidate = subMap(i, mapAsc);

						for (int j = 0; j < candidate.length; j++) { // sub small -> big

							expandListAsc.add(candidate[j]);
						}
					}

					exploredNum = exploredNum + 1;

				}

			}

			if (expandListDesc.size() != 0) {

				// System.out.println("DESC" + expandListDesc.size());
				// for (int i = 0; i < expandListDesc.size(); i++) {
				// expandListDesc.get(i).printNowLog();
				// }
				// System.out.println();
				//
				//
				// log += "<" + mapDesc.getDirection() + ", " + mapDesc.getSub() + ">";

				if (fringeTest(expandListAsc, expandListDesc)) { // do goal test

					// exploredNum = exploredNum + 1; // add one for one of the fringe

					boolean stop = false;
					String text = "";

					for (int i = 0; i < expandListAsc.size() && !stop; i++) {

						for (int j = 0; j < expandListDesc.size() && !stop; j++) {
							if (expandListAsc.get(i).sameMapTest(expandListDesc.get(j))) {

								// System.out.println("DESC end");

								// expandListAsc.get(i).printMap();
								// expandListDesc.get(j).printMap();

								text = expandListAsc.get(i).printBiBFSLog(expandListDesc.get(j));

								stop = true;
							}

						}
					}

					// exploredNum = exploredNum + 2;

					System.out.println("log: " + text);
					System.out.println("total: " + log);
					System.out.println("num: " + exploredNum);
					break;

				} else { // expend this node

					mapDesc = expandListDesc.get(0);
					expandListDesc.remove(0);

					// mapDesc.printMap();
					// System.out.println();

					// get all candidate, then add to candidateList

					for (int i = option - 1; i >= 0; i--) { // option big -> small
						Map[] candidate = addMap(i, mapDesc, mapOrg);

						for (int j = candidate.length - 1; j >= 0; j--) { // sub small -> big
							expandListDesc.add(candidate[j]);

						}
					}

					exploredNum = exploredNum + 1;

				}
			}
		}

	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Map getMapAsc() {
		return mapAsc;
	}

	public void setMapAsc(Map mapAsc) {
		this.mapAsc = mapAsc;
	}

	public Map getMapOrg() {
		return mapAsc;
	}

	public void setMapOrg(Map mapOrg) {
		this.mapOrg = mapOrg;
	}

	public Map getMapDesc() {
		return mapDesc;
	}

	public void setMapDesc(Map mapDesc) {
		this.mapDesc = mapDesc;
	}

	public ArrayList<Map> getExpandListAsc() {
		return expandListAsc;
	}

	public void setExtendListAsc(ArrayList<Map> expandListAsc) {
		this.expandListAsc = expandListAsc;
	}

	public ArrayList<Map> getExpandListDesc() {
		return expandListDesc;
	}

	public void setExtendListDesc(ArrayList<Map> expandListDesc) {
		this.expandListDesc = expandListDesc;
	}
}
