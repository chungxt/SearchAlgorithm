import java.util.ArrayList;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class Map implements Comparable {

	private int[][] map;
	private int direction;
	private int sub;
	private int f;
	private int g;
	private int h;
	private ArrayList<String> log;

	public Map() {
		setMap(new int[3][3]);
		setDirection(-1);
		setSub(0);
		setLog(new ArrayList<>());

	}

	public Map(int[][] map) {
		setMap(map);
		setDirection(-1);
		setSub(0);
		setLog(new ArrayList<>());

	}

	public Map(int[][] map, int direction, int sub, ArrayList<String> log) {
		setMapVal(map);
		setDirection(direction);
		setSub(sub);
		setLog(log);

	}

	// public Map(int[][] map, int direction, int sub, ArrayList<String> log, int g,
	// int h) {
	// setMapVal(map);
	// setDirection(direction);
	// setSub(sub);
	// setLog(log);
	// setG(g);
	// setH(h);
	// setF(g+h);
	//
	// }

	public int[][] getMap() {
		return map;
	}

	public void setMapVal(int[][] map) {

		this.map = new int[map.length][map.length];
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				this.map[i][j] = map[i][j];
			}
		}

	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSub() {
		return sub;
	}

	public void setSub(int sub) {
		this.sub = sub;
	}

	public ArrayList<String> getLog() {
		return log;
	}

	public void setLog(ArrayList<String> log) {
		this.log = log;
	}

	public void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void copyMap(Map m) {
		setMapVal(m.getMap());
		setDirection(m.getDirection());
		setSub(m.getSub());
		setLog(m.getLog());
	}

	public boolean sameMapTest(Map m) {
		boolean isSameMap = false;
		int sameNum = 0;

		for (int i = 0; i < m.getMap().length; i++) {
			for (int j = 0; j < m.getMap()[i].length; j++) {
				if (this.getMap()[i][j] == m.getMap()[i][j]) {
					sameNum = sameNum + 1;
				}
			}
		}

		if (sameNum == m.getMap().length * m.getMap()[0].length) {
			isSameMap = true;
		} else {
			isSameMap = false;
		}

		return isSameMap;
	}

	public String printLog() {

		String text = "";
		for (int i = 0; i < log.size(); i++) {
			text += log.get(i) + " ";
		}

		return text;
	}

	public String printBiBFSLog(Map mapDesc) {

		String text = "";

		for (int i = 0; i < log.size(); i++) {
			text += log.get(i) + " ";
		}

		for (int i = mapDesc.getLog().size() - 1; i >= 0; i--) {
			text += mapDesc.getLog().get(i) + " ";
		}

		return text;
	}

	public void printNowLog() {

		System.out.print("<" + direction + ", " + sub + "> ");
	}

	public int getF() {
		return f;
	}

	public void setF(int f) {
		this.f = f;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	public void setCost(int g, int h) {
		setG(g);
		setH(h);
		setF(g + h);

	}

	@Override
	public int compareTo(Object o) {

		int compareF = ((Map) o).getF();

		return this.f - compareF; // cost: small -> big

	}

}
