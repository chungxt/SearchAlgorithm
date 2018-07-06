import java.io.IOException;

public class DFS {

  public static void main(String[] args) {
    // your code goes here
    // open input file whose file name is args[0] and the size of the matrix is Integer.parseInt(args[1]) * Integer.parseInt(argv[1]), do not alter variable args

    String fileName = "";
    int msize = 0;
    if (args.length == 2) {
      fileName = args[0];
      msize =  Integer.parseInt(args[1]);
      System.out.println("using " + fileName);
      System.out.println("the size of the matrix is " + msize + "*" + msize);
    }
    else {
      System.out.println("the args is not correct.");
      System.exit(0);
    }


    ReadFiles readFiles = new ReadFiles(fileName, msize);

    try {
			readFiles.readMatrix();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int puzzleMap[][] = readFiles.getFileElement();

		int option = 2 * puzzleMap.length + 2;

		Map map = new Map(puzzleMap);

    // DFS
		DFSProcess dfs = new DFSProcess(option, map);
		dfs.searchDFS();



  }
}
