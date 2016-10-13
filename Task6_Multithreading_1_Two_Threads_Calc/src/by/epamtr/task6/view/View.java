package by.epamtr.task6.view;

public class View {
	private View(){}
	
	public static void printMatrix(int[][] A){
		
		for(int i = 0; i < A.length;i++){
			for(int j = 0; j < A[i].length;j++){
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
	}

}
