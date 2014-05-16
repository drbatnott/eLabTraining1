package spiderGame;

import java.awt.Toolkit;
import java.util.*;


public class WebGenerator {

	private int radials;
	private int spirals;
	@SuppressWarnings("unused")
	private int screenSpace;
	ArrayList<List<CoOrds>> allRadials = new ArrayList<List<CoOrds>>();
	final int SCREEN_HEIGHT = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	final int SCREEN_WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
	
	//private arraylist of all radials passed from server
	//private arraylist of all goal values for each game
	
	private ArrayList<Integer> goalValues;
	private ArrayList<Integer> operatorValues;
	private ArrayList<Integer> itemValues;
	private ArrayList<List<List<Integer>>> nodes;
	
	//private WebState wS = new WebState();
	
	public WebGenerator(int radials, int spirals, ArrayList<Integer> goalList, ArrayList<Integer> itemList, ArrayList<Integer> signList, ArrayList<List<List<Integer>>> nodeList, int screenSpace){
		this.radials = radials;
		this.spirals = spirals;
		this.screenSpace = screenSpace;
		
		goalValues = goalList;
		operatorValues = signList;
		itemValues = itemList;
		nodes = nodeList;
		
		//BuildWeb();
	}
	
	public WebState BuildWeb (){
		
		ArrayList<Radial> webNodes = new ArrayList<Radial>();
		
	
	    int distancePerSpiral = 90;//((SCREEN_HEIGHT-screenSpace) / (spirals*2));//70;// (SCREEN_HEIGHT / (spirals*2)) - screenSpace;
	    //System.out.println("distance per spiral ="+distancePerSpiral);
		float degreesPerRadial = 360 / radials;
		int radialLength = distancePerSpiral * spirals;
		int radialsDrawn = 0;
		@SuppressWarnings("unused")
		int spiralsDrawn = 0;
		int x = 0, y = -radialLength;
		double radians = Math.toRadians(degreesPerRadial);
		double cosR = Math.cos(-radians);
		double sinR = Math.sin(-radians);
		
		for(int i = 0; i < radials; i++){
			int nx,ny;
			//if(i >= 1){
			
			//}else{
			//nx = x;
			//ny = y;
			//}
			CoOrds from = new CoOrds(0,0);
			CoOrds to = new CoOrds(x,y);
			ArrayList<CoOrds> newRadial = new ArrayList<CoOrds>();
			newRadial.add(from);
			newRadial.add(to);
			allRadials.add(newRadial);
			 nx = (int) Math.round(((x * cosR) - (y * -sinR)));
			 ny = (int) Math.round(((x * -sinR) + (y * cosR)));
			//Radial r = new Radial();
			
			//if(radialsDrawn >=1){
			
			ArrayList<Node> nodesOnRadial = new ArrayList<Node>();
				for(int e = 1; e <= spirals; e++){

					CoOrds cO1 = pointOnALine(0,0,x,y,(distancePerSpiral * e));
					CoOrds cO2 = pointOnALine(0,0,nx,ny,(distancePerSpiral * e));
					ArrayList<CoOrds> newSpiral = new ArrayList<CoOrds>();
					newSpiral.add(cO1);
					newSpiral.add(cO2);
					allRadials.add(newSpiral);
					spiralsDrawn++;
					
					Node node = new Node();
					node.setCoOrds(cO1);
					//node.setNodeID(spiralsDrawn);
					//node.setValue(spiralsDrawn);
					
					node.setNodeID(nodes.get(radialsDrawn).get(e-1).get(0));
					node.setValue(nodes.get(radialsDrawn).get(e-1).get(1));
					node.setCorrect(nodes.get(radialsDrawn).get(e-1).get(2));
					node.setDisplay(true);
					node.setSelected(false);
					nodesOnRadial.add(node);
					
				}
			Radial r = new Radial(radialsDrawn, operatorValues.get(radialsDrawn),from,to,nodesOnRadial);
			webNodes.add(r);
			//webNodes.add(nodesOnRadial);	
			//}
			
			x = nx;
			y = ny;
			radialsDrawn++;
		}
		
		
		CoOrds webCentre = new CoOrds(0, 0);
		WebState wS = new WebState(webNodes, radials, spirals, 0, webCentre, goalValues, itemValues);
		
		//System.out.println("radials = " + radialsDrawn + " spirals" + spiralsDrawn);
		return wS;
	}
	
	public CoOrds pointOnALine(int x1, int y1, int x2, int y2, int spiralDistance){
		
		float distance = Math.round(Math.sqrt((x1-x2)*(x1-x2) + (y1-y2)*(y1-y2)));
		//System.out.println("distance poal:" + distance);
		float lineSegment = spiralDistance / distance;
		int nx = (int) Math.round(lineSegment * x2 + (1 - lineSegment) * x1);
		int ny = (int) Math.round(lineSegment * y2 + (1 - lineSegment) * y1);
		//System.out.println("GENERATED X Y "+ nx + " " + ny);
		CoOrds cO = new CoOrds(nx,ny);
		
		return cO;
	}
	
}
