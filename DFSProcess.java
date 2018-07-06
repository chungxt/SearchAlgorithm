import java.util.ArrayList;

public class DFSProcess extends SearchAlgorithm {

	private int option;
	private Map map;
	private ArrayList<Map> expandList;

	public DFSProcess(int option, Map map) {
		setMap(map);
		setOption(option);
		expandList = new ArrayList<>();
		expandList.add(map);

	}

	public void searchDFS() {

		int exploredNum = 0;
		String log = "";

		while (expandList.size() != 0) {

			// for (int i = 0; i < expandList.size(); i++) {
			// expandList.get(i).printNowLog();
			// }
			// System.out.println();

			map = expandList.get(0);
			expandList.remove(0);

			// if (map.getDirection() != -1) { // not start node
			// if (log != "") { // not first expand
			// log += ", ";
			// }
			// log += "<" + map.getDirection() + ", " + map.getSub() + ">";
			// }

			// map.printMap();

			if (goalTest(map)) { // do goal test

				exploredNum = exploredNum + 1; // add for start node

				System.out.println("log: " + map.printLog());
				System.out.println("num: " + exploredNum);
				break;

			} else { // expend this node

				// System.out.println(exploredNum);

				// get all candidate, then add to candidateList

				for (int i = option - 1; i >= 0; i--) { // option big -> small

					Map[] candidate = subMap(i, map);

					for (int j = candidate.length - 1; j >= 0; j--) { // sub small -> big
						// candidateList.add(tempCandidate[j]);
						expandList.add(0, candidate[j]);
					}
				}

				exploredNum = exploredNum + 1;

			}
		}

	}

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
	}

	public ArrayList<Map> getExpandList() {
		return expandList;
	}

	public void setExpandList(ArrayList<Map> expandList) {
		this.expandList = expandList;
	}

}
