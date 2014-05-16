package eLab.eLabTraining;

public class Target {
	
	private int currentScore;
	private String winningState;
	private int playerID;
	
	public Target(int ID){
	setPlayerID(ID);
	setWinningState("none");
	setCurrentScore(0);
	}
	public Target(){
		
	}
	
	public void targetScoreCheck(int targetScore) {
		if(getCurrentScore()==targetScore){
			setWinningState("win");
		}
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	public String getWinningState() {
		return winningState;
	}
	public void setWinningState(String winningState) {
		this.winningState = winningState;
	}
	public int getPlayerID() {
		return playerID;
	}
	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}
	
	
	
}
