package by.epamtr.task6.start;

import by.epamtr.task6.thread.MatrCalcThread;
import by.epamtr.task6.thread.lock.LockContext;
import by.epamtr.task6.view.View;

public class Main {

	public static void main(String[] args) {

		int[][] a = new int[][] { { 1, 2, 3, 4, 6, 9 }, { 4, 5, 6, 5, 7, 3 }, { 7, 8, 9, 6, 2, 1 },
				{ 1, 2, 3, 7, 9, 3 }, { 7, 8, 9, 6, 8, 2 }, { 7, 8, 9, 6, 9, 1 } };
		int[][] b = new int[][] { { 9, 8, 7, 6, 9, 3 }, { 6, 5, 4, 7, 8, 2 }, { 3, 2, 1, 8, 5, 3 },
				{ 9, 8, 7, 9, 4, 8 }, { 3, 2, 1, 8, 2, 9 }, { 3, 2, 1, 8, 1, 7 } };

		int[][] result = new int[a.length][a[0].length];

		LockContext lockContext = new LockContext(result.length);

		int threadCount = a.length / 2; // number of threads for counting

		Thread[] threads = new Thread[threadCount];

		for (int i = 0; i < threads.length; i++) {
			threads[i] = new MatrCalcThread(lockContext, a, b, result);
		}

		for (int i = 0; i < threads.length; i++) {
			threads[i].setName("thread" + (i + 1));
			threads[i].start();
		}

		for (int i = 0; i < threads.length; i++) {

			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			;
		}
		
		System.out.println();
		View.printMatrix(result);
	}

}
