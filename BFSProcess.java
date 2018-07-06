import java.util.ArrayList;

public class BFSProcess extends SearchAlgorithm {

	private int option;
	private Map map;
	private ArrayList<Map> expandList;

	public BFSProcess(int option, Map map) {
		setMap(map);
		setOption(option);
		expandList = new ArrayList<>();
		expandList.add(map);
	}

	public void searchBFS() {
		int exploredNum = 0;
		String log = "";

		while (expandList.size() != 0) {

			// for (int i = 0; i < expandList.size(); i++) {
			// expandList.get(i).printNowLog();
			// }
			// System.out.println();
			// System.out.println(exploredNum);

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

				// get all candidate, then add to candidateList

				for (int i = 0; i < option; i++) { // option big -> small

					Map[] candidate = subMap(i, map);

					for (int j = 0; j < candidate.length; j++) { // sub small -> big

						expandList.add(candidate[j]);
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

	public void setExpandList(ArrayList<Map> extendList) {
		this.expandList = extendList;
	}
}
