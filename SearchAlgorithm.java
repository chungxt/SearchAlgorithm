import java.util.ArrayList;

public class SearchAlgorithm {

	public Map[] subMap(int option, Map m) { // order big -> small

		Map[] candidateMap = null;
		int n = m.getMap().length;
		int[][] initMap = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				initMap[i][j] = m.getMap()[i][j];
			}
		}

		int direction = option, sub = Integer.MAX_VALUE;

		if (direction >= 0 && direction <= n - 1) { // Row
			int index = direction % n;

			for (int i = 0; i < n; i++) {
				if (sub > initMap[index][i]) {
					sub = initMap[index][i];
				}
			}

			candidateMap = new Map[sub];

			for (int s = sub; s > 0; s--) {

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						initMap[i][j] = m.getMap()[i][j];
					}
				}

				for (int i = 0; i < n; i++) {
					initMap[index][i] = initMap[index][i] - s;

				}

				ArrayList<String> log = new ArrayList<>();
				if (m.getLog() != null) {
					for (int i = 0; i < m.getLog().size(); i++) {
						log.add(m.getLog().get(i));
					}
					log.add("<" + direction + ", " + s + ">");
				} else {
					log.add("<" + direction + ", " + s + ">");
				}

				candidateMap[sub - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1
			}

		} else if (direction >= n && direction <= 2 * n - 1) { // Column
			int index = direction % n;
			for (int i = 0; i < n; i++) {
				if (sub > initMap[i][index]) {
					sub = initMap[i][index];
				}
			}

			candidateMap = new Map[sub];

			for (int s = sub; s > 0; s--) {

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						initMap[i][j] = m.getMap()[i][j];
					}
				}

				for (int i = 0; i < n; i++) {
					initMap[i][index] = initMap[i][index] - s;

				}
				ArrayList<String> log = new ArrayList<>();
				if (m.getLog() != null) {
					for (int i = 0; i < m.getLog().size(); i++) {
						log.add(m.getLog().get(i));
					}
					log.add("<" + direction + ", " + s + ">");
				} else {
					log.add("<" + direction + ", " + s + ">");
				}
				candidateMap[sub - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1
			}

		} else if (direction >= 2 * n && direction <= 2 * n + 1) { // Diagonal
			int index = direction % n;

			if (index == 0) {
				for (int i = 0; i < n; i++) {
					if (sub > initMap[i][i]) {
						sub = initMap[i][i];
					}
				}

				candidateMap = new Map[sub];

				for (int s = sub; s > 0; s--) {

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							initMap[i][j] = m.getMap()[i][j];
						}
					}

					for (int i = 0; i < n; i++) {
						initMap[i][i] = initMap[i][i] - s;

					}

					ArrayList<String> log = new ArrayList<>();
					if (m.getLog() != null) {
						for (int i = 0; i < m.getLog().size(); i++) {
							log.add(m.getLog().get(i));
						}
						log.add("<" + direction + ", " + s + ">");
					} else {
						log.add("<" + direction + ", " + s + ">");
					}
					candidateMap[sub - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1
				}

			} else if (index == 1) {
				for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
					if (sub > initMap[i][j]) {
						sub = initMap[i][j];
					}
				}

				candidateMap = new Map[sub];
				// System.out.println(sub);

				for (int s = sub; s > 0; s--) {

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							initMap[i][j] = m.getMap()[i][j];
						}
					}

					for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
						initMap[i][j] = initMap[i][j] - s;

					}

					ArrayList<String> log = new ArrayList<>();
					if (m.getLog() != null) {
						for (int i = 0; i < m.getLog().size(); i++) {
							log.add(m.getLog().get(i));
						}
						log.add("<" + direction + ", " + s + ">");
					} else {
						log.add("<" + direction + ", " + s + ">");
					}
					// System.out.println(log);
					candidateMap[sub - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1

				}
			} else {

			}
		}

		return candidateMap;

	}

	public Map[] addMap(int option, Map m, Map target) { // order big -> small

		Map[] candidateMap = null;
		int n = m.getMap().length;
		int[][] initMap = new int[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				initMap[i][j] = target.getMap()[i][j] - m.getMap()[i][j];
			}
		}

		int direction = option, add = Integer.MAX_VALUE;

		if (direction >= 0 && direction <= n - 1) { // Row
			int index = direction % n;

			for (int i = 0; i < n; i++) {
				if (add > initMap[index][i]) {
					add = initMap[index][i];
				}
			}

			candidateMap = new Map[add];

			for (int s = add; s > 0; s--) {

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						initMap[i][j] = m.getMap()[i][j];
					}
				}

				for (int i = 0; i < n; i++) {
					initMap[index][i] = initMap[index][i] + s;

				}

				ArrayList<String> log = new ArrayList<>();
				if (m.getLog() != null) {
					for (int i = 0; i < m.getLog().size(); i++) {
						log.add(m.getLog().get(i));
					}
					log.add("<" + direction + ", " + s + ">");
				} else {
					log.add("<" + direction + ", " + s + ">");
				}

				candidateMap[add - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1
			}

		} else if (direction >= n && direction <= 2 * n - 1) { // Column
			int index = direction % n;
			for (int i = 0; i < n; i++) {
				if (add > initMap[i][index]) {
					add = initMap[i][index];
				}
			}

			candidateMap = new Map[add];

			for (int s = add; s > 0; s--) {

				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						initMap[i][j] = m.getMap()[i][j];
					}
				}

				for (int i = 0; i < n; i++) {
					initMap[i][index] = initMap[i][index] + s;

				}
				ArrayList<String> log = new ArrayList<>();
				if (m.getLog() != null) {
					for (int i = 0; i < m.getLog().size(); i++) {
						log.add(m.getLog().get(i));
					}
					log.add("<" + direction + ", " + s + ">");
				} else {
					log.add("<" + direction + ", " + s + ">");
				}
				candidateMap[add - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1
			}

		} else if (direction >= 2 * n && direction <= 2 * n + 1) { // Diagonal
			int index = direction % n;
			// System.out.println(index);

			if (index == 0) {
				for (int i = 0; i < n; i++) {
					if (add > initMap[i][i]) {
						add = initMap[i][i];
					}
				}

				candidateMap = new Map[add];

				for (int s = add; s > 0; s--) {

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							initMap[i][j] = m.getMap()[i][j];
						}
					}

					for (int i = 0; i < n; i++) {
						initMap[i][i] = initMap[i][i] + s;

					}

					ArrayList<String> log = new ArrayList<>();
					if (m.getLog() != null) {
						for (int i = 0; i < m.getLog().size(); i++) {
							log.add(m.getLog().get(i));
						}
						log.add("<" + direction + ", " + s + ">");
					} else {
						log.add("<" + direction + ", " + s + ">");
					}

					candidateMap[add - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1
				}

			} else if (index == 1) {
				for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
					if (add > initMap[i][j]) {
						add = initMap[i][j];
					}
				}

				candidateMap = new Map[add];
				// System.out.println(sub);

				for (int s = add; s > 0; s--) {

					for (int i = 0; i < n; i++) {
						for (int j = 0; j < n; j++) {
							initMap[i][j] = m.getMap()[i][j];
						}
					}

					for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
						initMap[i][j] = initMap[i][j] + s;

					}

					ArrayList<String> log = new ArrayList<>();
					if (m.getLog() != null) {
						for (int i = 0; i < m.getLog().size(); i++) {
							log.add(m.getLog().get(i));
						}
						log.add("<" + direction + ", " + s + ">");
					} else {
						log.add("<" + direction + ", " + s + ">");
					}
					// System.out.println(log);
					candidateMap[add - s] = new Map(initMap, direction, s, log); // 0 ~ sub-1

				}
			} else {

			}
		}

		// if(candidateMap.length == 0) {
		// System.out.println("dir" + direction);
		// }

		return candidateMap;

	}

	public boolean goalTest(Map map) {
		int[][] temp_map = map.getMap();
		int sum = 0;

		for (int i = 0; i < temp_map.length; i++) {
			for (int j = 0; j < temp_map[i].length; j++) {
				sum = sum + temp_map[i][j];
			}
		}

		if (sum == 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean fringeTest(ArrayList<Map> expandListAsc, ArrayList<Map> expandListDesc) {

		boolean isSameFringe = false;

		for (int i = 0; i < expandListAsc.size(); i++) {
			for (int j = 0; j < expandListDesc.size(); j++) {
				if (expandListAsc.get(i).sameMapTest(expandListDesc.get(j)))
					isSameFringe = true;
			}
		}

		return isSameFringe;
	}

}
