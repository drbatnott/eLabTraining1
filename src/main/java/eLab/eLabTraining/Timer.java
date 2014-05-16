package eLab.eLabTraining;

public class Timer {
	private int levelTimer;
	private int currentTimer;
	
	public Timer(int maxTime){
		setLevelTimer(maxTime);
		setCurrentTimer(0);
	}
	public Timer(){
		
	}
	
	public boolean isFinished() {
		if(getCurrentTimer()<getLevelTimer()){
			return false;
		}else{
			return true;
		}
		
	}
	
	public int getLevelTimer() {
		return levelTimer;
	}
	public void setLevelTimer(int levelTimer) {
		this.levelTimer = levelTimer;
	}
	public int getCurrentTimer() {
		return currentTimer;
	}
	public void setCurrentTimer(int currentTimer) {
		this.currentTimer = currentTimer;
	}
}
