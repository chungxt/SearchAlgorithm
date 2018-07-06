import java.util.ArrayList;
import java.util.Collections;

public class AstarProcess extends SearchAlgorithm {

	private int option;
	private Map map;
	private ArrayList<Map> expandList;

	public AstarProcess(int option, Map map) {
		setMap(map);
		setOption(option);
		expandList = new ArrayList<>();
		expandList.add(map);
	}

	@SuppressWarnings("unchecked")
	public void searchAstar() {

		int exploredNum = 0;
		String log = "";

		while (expandList.size() != 0) {

			// for (int i = 0; i < expandList.size(); i++) {
			// expandList.get(i).printNowLog();
			// }
			// System.out.println();

			map = expandList.get(0);
			expandList.remove(0);

			// System.out.println(exploredNum);

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

						// set g and h (priority)

						int g = candidate[j].getLog().size();

						Heuristic H = new Heuristic();
						int h = H.heuristic(map.getMap(), map.getMap().length, candidate[j].getDirection(),
								candidate[j].getSub());

						// redundant =________=

						candidate[j].setCost(g, h);

						expandList.add(candidate[j]);
					}
				}

				// sort by f

				Collections.sort(expandList);

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
