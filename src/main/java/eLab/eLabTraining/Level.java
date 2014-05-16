package eLab.eLabTraining;

public class Level {
	private int levelNumber;
	private int levelTargetScore;
	
	public Level(int number,int targetScore){
		setLevelNumber(number);
		setLevelTargetScore(targetScore);
		
	}
	public Level(){
		
	}
	public int getLevelTargetScore() {
		return levelTargetScore;
	}
	public void setLevelTargetScore(int levelTargetScore) {
		this.levelTargetScore = levelTargetScore;
	}
	public int getLevelNumber() {
		return levelNumber;
	}
	public void setLevelNumber(int levelNumber) {
		this.levelNumber = levelNumber;
	}
}
