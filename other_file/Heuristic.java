import java.util.Arrays;

public class Heuristic {

	public Heuristic() {
		//
	}

	// ver.2
	public int heuristic(int[][] matrix, int matrixDim, int operation, int subtrahend) {

		int h = 0;

		int[][] initMap = new int[matrixDim][matrixDim];

		for (int i = 0; i < matrixDim; i++) {
			for (int j = 0; j < matrixDim; j++) {
				initMap[i][j] = matrix[i][j];
			}
		}

		if (operation >= 0 && operation <= matrixDim - 1) { // Row
			int index = operation % matrixDim;

			for (int i = 0; i < matrixDim; i++) {
				initMap[index][i] = initMap[index][i] - subtrahend;
			}

		} else if (operation >= matrixDim && operation <= 2 * matrixDim - 1) { // Column
			int index = operation % matrixDim;

			for (int i = 0; i < matrixDim; i++) {
				initMap[i][index] = initMap[i][index] - subtrahend;
			}

		} else if (operation >= 2 * matrixDim && operation <= 2 * matrixDim + 1) { // Diagonal
			int index = operation % matrixDim;

			if (index == 0) {

				for (int i = 0; i < matrixDim; i++) {
					initMap[i][i] = initMap[i][i] - subtrahend;
				}

			} else if (index == 1) {

				for (int i = 0, j = matrixDim - 1; i < matrixDim && j >= 0; i++, j--) {
					initMap[i][j] = initMap[i][j] - subtrahend;
				}

			} else {

			}
		}

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				h = h + initMap[i][j];
			}
		}
		h = h / matrixDim;

		// int[] elements = new int[matrixDim*matrixDim];
		//
		// for (int i = 0; i < matrixDim*matrixDim; i++) {
		// elements[i] = initMap[i/matrixDim][i%matrixDim];
		// System.out.println(elements[i]);
		// }
		//
		// Arrays.sort(elements);
		// System.out.println(elements[matrixDim*matrixDim-1] + "," +
		// elements[matrixDim*matrixDim-2] + " , 1");
		//
		//
		// h = h + elements[matrixDim*matrixDim-1] - elements[0];
		//

		// int elementMax = Integer.MIN_VALUE;
		// int elementMin = Integer.MAX_VALUE;
		//
		// for (int i = 0; i < matrix.length; i++) {
		// for (int j = 0; j < matrix[i].length; j++) {
		// if (initMap[i][j] > elementMax) {
		// elementMax = initMap[i][j];
		// }
		// if (initMap[i][j] < elementMin && initMap[i][j] != 0) {
		// elementMin = initMap[i][j];
		// }
		// }
		// }

		// if ((elementMax - elementMin) >= matrixDim)
		// h += (elementMax - elementMin);

		// h += (elementMax - elementMin) / matrixDim;

		// h += (elementMax - elementMin);

		return h;
	}

	// ver.1
	// public int heuristic(int[][] matrix, int matrixDim, int operation, int
	// subtrahend) {
	//
	// int h = 0;
	//
	// int[][] initMap = new int[matrixDim][matrixDim];
	//
	// for (int i = 0; i < matrixDim; i++) {
	// for (int j = 0; j < matrixDim; j++) {
	// initMap[i][j] = matrix[i][j];
	// }
	// }
	//
	// if (operation >= 0 && operation <= matrixDim - 1) { // Row
	// int index = operation % matrixDim;
	//
	// for (int i = 0; i < matrixDim; i++) {
	// initMap[index][i] = initMap[index][i] - subtrahend;
	// }
	//
	// } else if (operation >= matrixDim && operation <= 2 * matrixDim - 1) { //
	// Column
	// int index = operation % matrixDim;
	//
	// for (int i = 0; i < matrixDim; i++) {
	// initMap[i][index] = initMap[i][index] - subtrahend;
	// }
	//
	// } else if (operation >= 2 * matrixDim && operation <= 2 * matrixDim + 1) { //
	// Diagonal
	// int index = operation % matrixDim;
	//
	// if (index == 0) {
	//
	// for (int i = 0; i < matrixDim; i++) {
	// initMap[i][i] = initMap[i][i] - subtrahend;
	// }
	//
	// } else if (index == 1) {
	//
	// for (int i = 0, j = matrixDim - 1; i < matrixDim && j >= 0; i++, j--) {
	// initMap[i][j] = initMap[i][j] - subtrahend;
	// }
	//
	// } else {
	//
	// }
	// }
	//
	// for (int i = 0; i < matrix.length; i++) {
	// for (int j = 0; j < matrix[i].length; j++) {
	// h = h + initMap[i][j];
	// }
	// }
	// h = h / matrixDim;
	//
	// return h;
	// }

}
