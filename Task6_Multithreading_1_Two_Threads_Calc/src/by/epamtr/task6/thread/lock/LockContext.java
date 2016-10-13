package by.epamtr.task6.thread.lock;

public class LockContext {
	
	private int nextRow = 0;
	private final int rowCount;
	
	public LockContext(int number){
		this.rowCount = number;
	}
	
	public  int numOfNextRow(){
		if(this.isFinished()){
			throw new IllegalStateException();
		}
		int rowToreturn = nextRow;
		nextRow++;
		return rowToreturn;
	}
	
	public  boolean isFinished() {
		
		if(nextRow == rowCount){
			return true;
		}else{
			return false;
		}
	}

}
