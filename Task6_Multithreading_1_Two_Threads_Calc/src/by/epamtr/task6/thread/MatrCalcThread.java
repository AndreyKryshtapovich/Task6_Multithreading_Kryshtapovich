package by.epamtr.task6.thread;

import by.epamtr.task6.thread.lock.LockContext;

public class MatrCalcThread extends Thread {

	private LockContext lockContext;
	private int[][] matrA;
	private int[][] matrB;
	private int[][] matrResult;

	public MatrCalcThread(LockContext lockContext, int[][] matrA, int[][] matrB, int[][] matrResult) {

		this.lockContext = lockContext;
		this.matrA = matrA;
		this.matrB = matrB;
		this.matrResult = matrResult;
	}

	public void run() {
		while (true) {
			int row;
			synchronized (lockContext) {
				if (lockContext.isFinished()) {
					break;
				}
				row = lockContext.numOfNextRow();
			}
			System.out.println(Thread.currentThread().getName() + " calculating row number " + row);
			
			for (int j = 0; j < matrB[0].length; j++) {
				for (int k = 0; k < matrA[0].length; k++) {
					matrResult[row][j] += matrA[row][k] * matrB[k][j];
				}
				//System.out.println(Thread.currentThread().getName() + " calculated cell number " + row + " " + j);
			}
		}
	}

}
