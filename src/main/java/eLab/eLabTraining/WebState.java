package eLab.eLabTraining;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class WebState {

	private ArrayList<Radial> webNodes = new ArrayList<Radial>();
	private int currentRadial;
	private int initialRadial;
	private int totalRadials;
	@SuppressWarnings("unused")
	private int totalSpiralsPerRadial;
	private int currentOperator;
	private int currentTotalValue = 0, currentRadialValue = 0;
	//private int nodesSelected;
	private CoOrds webCentre;
	private int webSectionValidationType;
	private ArrayList<Integer> nodeIDsSelected = new ArrayList<Integer>();
	private ArrayList<Integer> goalValues = new ArrayList<Integer>();
	private ArrayList<Integer> itemValues = new ArrayList<Integer>();
	private int currentGoalIndex = 0;
	private boolean lostPreviousGame = false;
	
	//private int value1, value2;
	
	private boolean playersGo = false, playersGoSetup = false;
	
	public WebState(ArrayList<Radial> nodes, int radials, int spirals, int radialStart, CoOrds webCentrePoint, ArrayList<Integer> goalVals, ArrayList<Integer> itemVals){
		webNodes = nodes;
		totalRadials = radials;
		totalSpiralsPerRadial = spirals;
		currentRadial = radialStart;
		initialRadial = radialStart;
		webCentre = webCentrePoint;
		goalValues = goalVals;
		itemValues = itemVals;
		//nodesSelected = 0;
		setOperator(currentRadial);
	}
	
	public void setWebNodes(ArrayList<Radial> nodes){
		webNodes = nodes;
	}
	
	public ArrayList<Radial> getWebNodes(){
		return webNodes;
	}
	
	public void setCurrentRadial(int radial){
		currentRadial = radial;
	}
	
	public void setNextRadial(){
		if(playersGoSetup){
			updateRadialCalculation();
			currentRadial++;
			//nodesSelected = 0;
			currentTotalValue += currentRadialValue;
			currentRadialValue = 0;
			//value1 = 0;
			setOperator(currentRadial);
			webSectionValidationType = setUserXYValidationType();
		}else{
			playersGoSetup = true;
		}
	}
	
	public void setOperator(int r){
		currentOperator = webNodes.get(r).getOperator();
	}
	
	public int getOperator(){
		return currentOperator;
	}
	
	public int getCurrentRadial(){
		return currentRadial;
	}
	
	public void setCurrentTotalValue(int val){
		currentTotalValue = val;
	}
	
	public int getCurrentTotalVaue(){
		return currentTotalValue;
	}
	
	public void setPlayersGoOn(){
		playersGo = true;
		setNextRadial();
	}
	
	public void setPlayersGoOff(){
		playersGo = false;
		setNextRadial();
	}
	
	public boolean getPlayersGo(){
		return playersGo;
	}
	
	public void setLostPreviousGame(){
		lostPreviousGame = true;
	}
	
	public void setWonPreviousGame(){
		lostPreviousGame = false;
	}
	
	public boolean getLostPreviousGame(){
		return lostPreviousGame;
	}
	
	public int getFirstRadial(){
		return initialRadial;
	}
	
	public int getLastRadial(){
		return initialRadial + 3;
	}
		
	
	/*public int getValue1(){
		return value1;
	}
	
	public int getValue2(){
		return value2;
	}*/
	
	public int getWebCentreX(){
		return webCentre.getX();
	}
	
	public int getWebCentreY(){
		return webCentre.getY();
	}
	
	public ArrayList<Integer> getNodeIDsSelected(){
		return nodeIDsSelected;
	}
	
	public int getCurrentGoal(){
		return goalValues.get(currentGoalIndex);
	}
	
	public int getCurrentItem(){
		return itemValues.get(currentGoalIndex);
	}
	
	public double getCurrentRadialAngle(){
		float degreesForRadial = (360 / totalRadials) * currentRadial;
		//System.out.println("totalRadials:" + totalRadials + " currentRadial:" + currentRadial + " degrees:" + degreesForRadial);
		double radians = Math.toRadians(degreesForRadial);
		return radians;
	}
	
	public int getWebSectionValidationType(){
		return webSectionValidationType;
	}
	
	public boolean checkGoalReached(){
		
			if(currentTotalValue == getCurrentGoal()){
				//answer correct
				//currentGoalIndex++;
				return true;
			}else{
				//reset game, unselct + display all nodes reset both players nodes
				return false;
			}
		
	}
	
	public boolean checkEndGameReached(){
		if(((currentGoalIndex+1) * 4) == (currentRadial+1)){
			updateRadialCalculation();
			currentTotalValue += currentRadialValue;
			currentRadialValue = 0;
			return true;
		}else{
			return false;
		}
	}
	
	public boolean resetToLastGame(boolean pG){
		updateRadialCalculation();
		playersGo = pG;
		currentRadial = currentRadial -  3;
		if(currentRadial < 0){
			currentRadial = 0;
		}
		
		initialRadial = currentRadial;
		
		currentRadialValue = currentTotalValue = 0;
		webSectionValidationType = setUserXYValidationType();
		setOperator(currentRadial);
		for(int e = 0; e <= 3; e++){
			List<Node> validNodes = webNodes.get(currentRadial + e).getNodes();
			Iterator<Node> i = validNodes.iterator();
			while(i.hasNext()){
				Node node = i.next();
				node.setDisplay(true);
				node.setSelected(false);
			}
		}
		
		if(playersGo == true){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean playNextGame(boolean pG){
		updateRadialCalculation();
		playersGo = pG;
		currentRadial++;
		currentGoalIndex++;
		initialRadial = initialRadial + 3;		
		currentRadialValue = currentTotalValue = 0;
		webSectionValidationType = setUserXYValidationType();
		setOperator(currentRadial);
		
		if(playersGo == true){
			return true;
		}else{
			return false;
		}
	}
	
	public int checkNodeHit(int spriteX, int spriteY){
		
		int nodeID = -1;
		List<Node> validNodes = webNodes.get(currentRadial).getNodes();
		Iterator<Node> i = validNodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			int nodeX = node.getX();
			int nodeY = node.getY();
			if((nodeX-10) <= spriteX && spriteX <= (nodeX+10) && (nodeY-10) <= spriteY && spriteY <= (nodeY+10)){
				//System.out.println("node hit!!");
				if(!node.getSelected()){//selected a node
					nodeSelected(node.getNodeID());
					nodeID = node.getNodeID();
				}else{//deselect a node
					nodeDeselected(node.getNodeID());
					nodeID = node.getNodeID();
				}
				break;
			}
		}
		
		return nodeID;
	}
	
	public void nodeSelected(int nodeID){
		
		
		
		if(!webNodes.get(currentRadial).getNodeSelected(nodeID)){
			webNodes.get(currentRadial).setNodeSelected(nodeID, true);
			nodeIDsSelected.add(nodeID);
		}/*else{
			updateRadialCalculation(webNodes.get(currentRadial).getNodeValue(nodeID));
			webNodes.get(currentRadial).setNodeDisplayed(nodeID, false);
			//return false;
		}*/
		
		/*if(webNodes.get(currentRadial).removeNode(nodeID)){
			return true;
		}else{
			return false;
		}*/
	}
	
	public void nodeDeselected(int nodeID){
		if(webNodes.get(currentRadial).getNodeSelected(nodeID) && webNodes.get(currentRadial).getNodeDisplayed(nodeID)){
			webNodes.get(currentRadial).setNodeSelected(nodeID, false);
			ListIterator<Integer> i = nodeIDsSelected.listIterator();
			while(i.hasNext()){
				int nID = i.next();
				if(nID == nodeID){
					i.remove();
					break;
				}
			}
			
		}
	}
	
	public void updateTotalValue(){
		updateRadialCalculation();
		currentTotalValue += currentRadialValue;
		currentRadialValue = 0;
	}
	
	public void updateRadialCalculation(){
		
		int value1 = 0, value2 = 0, nodesSelected = 0;
		
		Iterator<Integer> i = nodeIDsSelected.iterator();
		while(i.hasNext()){
			int nID = i.next();
			
			List<Node> validNodes = webNodes.get(currentRadial).getNodes();
			Iterator<Node> i2 = validNodes.iterator();
			while(i2.hasNext()){
				Node node = i2.next();
				if(node.getNodeID() == nID){
					//updateRadialCalculation(node.getValue());
					
					if(nodesSelected == 0){
						currentRadialValue = value1 = node.getValue();
						nodesSelected++;
					}else{
						value2 = node.getValue();
						currentRadialValue = value1 = changeTotalValue(value1, value2, currentOperator);
						value2 = 0;
					}
					node.setDisplay(false);
					break;
				}
			}
			
		}
		nodeIDsSelected.clear();
	}
	
	/*public void updateRadialCalculation(){
		
		int value1 = 0, value2 = 0, nodesSelected = 0;
		
		List<Node> validNodes = webNodes.get(currentRadial).getNodes();
		ListIterator<Node> i = validNodes.listIterator(validNodes.size());//.iterator();
		while(i.hasPrevious()){
			Node node = i.next();
			if(node.getSelected()){
				//updateRadialCalculation(node.getValue());
				
				if(nodesSelected == 0){
					value1 = node.getValue();
					nodesSelected++;
				}else{
					value2 = node.getValue();
					currentRadialValue = value1 = changeTotalValue(value1, value2, currentOperator);
					value2 = 0;
				}
			}
		}
		
	}*/
	
	/*public void updateRadialCalculation(int value){
		if(nodesSelected == 0){
			value1 = value;
			nodesSelected++;
		}else{
			value2 = value;
			currentRadialValue = value1 = changeTotalValue(value1, value2, currentOperator);
			value2 = 0;
			System.out.println(currentRadialValue);
		}
	}*/
	
	public int changeTotalValue(int totalVal, int newVal , int operator){
		int newTotalVal = 0;
		if(operator == 1){//addition
			newTotalVal = totalVal + newVal;
		}else if(operator == 2){//subtraction
			newTotalVal = totalVal - newVal;
		}else if(operator == 3){//multiplaction
			newTotalVal = totalVal * newVal;
		}else if(operator == 4){//divsion
			newTotalVal = totalVal / newVal;
		}else{}
		
		return newTotalVal;
	}
	
	public synchronized CoOrds playerMoved(int ux, int uy, int deltadistance){
		
		CoOrds cO = null;
		int xFrom = webNodes.get(currentRadial).getXFrom();
		int yFrom = webNodes.get(currentRadial).getYFrom();
		int xTo = webNodes.get(currentRadial).getXTo();
		int yTo = webNodes.get(currentRadial).getYTo();
		
		if(deltadistance > 0){
			if(validateUserXYOutwards(ux,uy)){
				int d1 = (int)Math.round(Math.sqrt((xFrom-xTo)*(xFrom-xTo) + (yFrom-yTo)*(yFrom-yTo)));
				int d2 = (int)Math.round(Math.sqrt((xFrom-ux)*(xFrom-ux) + (yFrom-uy)*(yFrom-uy)));
				
				int difference = d1 - d2;
				if(difference >= deltadistance){
					cO = pointOnALine(ux,uy,xTo, yTo, deltadistance);
				}else if(difference < deltadistance && difference >= 0){
					deltadistance = difference;
					cO = pointOnALine(ux,uy,xTo, yTo, deltadistance);
				}else{
					cO = new CoOrds(ux,uy);
				}
			}else{
			    cO = new CoOrds(ux,uy);
			}
		}else{
			if(validateUserXYInwards(ux,uy)){
					int d1 = (int)Math.round(Math.sqrt((xTo-xFrom)*(xTo-xFrom) + (yTo-yFrom)*(yTo-yFrom)));
					int d2 = (int)Math.round(Math.sqrt((xTo-ux)*(xTo-ux) + (yTo-uy)*(yTo-uy)));
					
					int difference = d1 - d2;
					if(difference >= -deltadistance){
						cO = pointOnALine(ux,uy,xFrom, yFrom, -deltadistance);
					}else if(difference < -deltadistance && difference >= 0){
						deltadistance = -difference;
						cO = pointOnALine(ux,uy,xFrom, yFrom, -deltadistance);
					}else{
						cO = new CoOrds(ux,uy);
					}
				}else{
					cO = new CoOrds(ux,uy);
				}
			}
		return cO;
	}
	
	public CoOrds initalUserXY(int radial){
		
		return webNodes.get(radial).getCoOrdsTo();
	}
	
	public boolean validateUserXYOutwards(int ux, int uy){
		
		if(webSectionValidationType == 0){
			if(!(ux >= webNodes.get(currentRadial).getXTo()) || !(uy <= webNodes.get(currentRadial).getYTo())){
				return true;
			}else{
				return false;
			}
		}else if(webSectionValidationType == 1){
			if(!(ux >= webNodes.get(currentRadial).getXTo()) || !(uy >= webNodes.get(currentRadial).getYTo())){
				return true;
			}else{
				return false;
			}
		}else if(webSectionValidationType == 2){
			if(!(ux <= webNodes.get(currentRadial).getXTo()) || !(uy >= webNodes.get(currentRadial).getYTo())){
				return true;
			}else{
				return false;
			}
		}else{
			if(!(ux <= webNodes.get(currentRadial).getXTo()) || !(uy <= webNodes.get(currentRadial).getYTo())){
				return true;
			}else{
				return false;
			}
		}
	}
	
	public boolean validateUserXYInwards(int ux, int uy){
		
		if(webSectionValidationType == 0){
			if(!(ux <= webNodes.get(currentRadial).getXFrom()) || !(uy >= webNodes.get(currentRadial).getYFrom())){
				return true;
			}else{
				return false;
			}
		}else if(webSectionValidationType == 1){
			if(!(ux <= webNodes.get(currentRadial).getXFrom()) || !(uy <= webNodes.get(currentRadial).getYFrom())){
				return true;
			}else{
				return false;
			}
		}else if(webSectionValidationType == 2){
			if(!(ux >= webNodes.get(currentRadial).getXFrom()) || !(uy <= webNodes.get(currentRadial).getYFrom())){
				return true;
			}else{
				return false;
			}
		}else{
			if(!(ux >= webNodes.get(currentRadial).getXFrom()) || !(uy >= webNodes.get(currentRadial).getYFrom())){
				return true;
			}else{
				return false;
			}
		}
	}
	
	
	public int setUserXYValidationType(){
		
		int x = webNodes.get(currentRadial).getCoOrdsTo().getX();
		int y = webNodes.get(currentRadial).getCoOrdsTo().getY();
		
		int validationType;
		
		if(x >= webCentre.getX() && y <= webCentre.getY()){
			validationType = 0; //top right section
		}else if(x >= webCentre.getX() && y >= webCentre.getY()){
			validationType = 1; //bottom right section
		}else if(x <= webCentre.getX() && y >= webCentre.getY()){
			validationType = 2; //bottom left section
		}else{
			validationType = 3; //top left section 
		}
		
		return validationType;
	}
	
    public CoOrds pointOnALine(int x1, int y1, int x2, int y2, int spiralDistance){
		
		float distance = Math.round(Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
		float lineSegment = spiralDistance / distance;
		int nx = (int) Math.round(lineSegment * x2 + (1 - lineSegment) * x1);
		int ny = (int) Math.round(lineSegment * y2 + (1 - lineSegment) * y1);
		CoOrds cO = new CoOrds(nx,ny);
		
		return cO;
	}
}
