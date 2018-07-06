import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ReadFiles {

	private String filePath;
	private String fileContent;
	private int fileElement[][];
	private int lineNum;

	public ReadFiles(String fp, int num) {
		setFilePath(fp);
		setFileContent("");
		setLineNum(num);
	}

	public void readMatrix() throws IOException {

		FileReader fr = new FileReader(filePath);
		BufferedReader br = new BufferedReader(fr);
		String temp = "";
		
		setFileContent("");

		while ((temp = br.readLine()) != null) {
			setFileContent(getFileContent() + temp + "\n");
		}
		fr.close();
		
		
		fileElement = new int[lineNum][lineNum];
		
		String line[] = getFileContent().split("\n");
		String[][] m = new String[lineNum][];
		
		for (int i = 0; i < lineNum; i++) {
			m[i] = line[i].split(" ");
		}
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				fileElement[i][j] = Integer.parseInt(m[i][j]);
			}
		}

		
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileContent() {
		return fileContent;
	}

	public void setFileContent(String fileContent) {
		this.fileContent = fileContent;
	}

	public int[][] getFileElement() {
		return fileElement;
	}

	public void setFileElement(int fileElement[][]) {
		this.fileElement = fileElement;
	}

	public int getLineNum() {
		return lineNum;
	}

	public void setLineNum(int lineNum) {
		this.lineNum = lineNum;
	}

}