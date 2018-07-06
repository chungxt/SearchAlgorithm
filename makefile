all: 
	javac DFS.java BFS.java biBFS.java Astar.java other_file/Heuristic.java
	java DFS matrix.txt 3
	java BFS matrix.txt 3
	java biBFS matrix.txt 3
	java -cp .:other_file/ Astar matrix.txt 3
DFS: 
	javac DFS.java
	java DFS matrix.txt 3
BFS: 
	javac BFS.java
	java BFS matrix.txt 3
biBFS: 
	javac biBFS.java
	java biBFS matrix.txt 3
Astar: 
	javac Astar.java other_file/Heuristic.java
	java -cp .:other_file/ Astar matrix.txt 3
clean:
	rm -f DFS.class DFSProcess.class BFS.class BFSProcess.class biBFS.class biBFSProcess.class Astar.class AstarProcess.class  Map.class Readfiles.class SearchAlgorithm.class other_file/Heuristic.class