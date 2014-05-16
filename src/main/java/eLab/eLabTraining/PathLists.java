package eLab.eLabTraining;

import java.util.ArrayList;
import java.util.List;

public class PathLists {

	public static final boolean PRINT = true;

	public static ArrayList<Integer> goalList = new ArrayList<Integer>();
	public static ArrayList<Integer> signList = new ArrayList<Integer>();
	public static ArrayList<List<List<Integer>>> nodeList = new ArrayList<List<List<Integer>>>();
	//public static List<List<Integer>> nodeList = new ArrayList<List<Integer>>();

	public static final boolean PRINTNODE = true;
	public static final boolean PRINTSIGN = false;
	public static final boolean PRINTGOAL = false;

	public static int nodeID = 1; //first node's ID

	public ArrayList<Integer> getGoalList(){
		return goalList;
	}
	
	public ArrayList<Integer> getSignList(){
		return signList;
	}
	
	public ArrayList<List<List<Integer>>> getNodeList(){
		return nodeList;
	}
	
	public void sortString(String strPath){
		String[] path = strPath.split(":");
		int goal = 0;
		int sign = 0;		

		for(int i = 1; i < path.length; i++){
			switch(path[i].charAt(0)){
			case 'G':
				goal = Integer.valueOf(path[i].substring(1));
				goalList.add(goal);
				break;
			case 'S':
				sign = Integer.valueOf(path[i].substring(1));
				signList.add(sign);
				break;
			case 'N':
				i = sortNode(path, i);
				break;
			default:
				break;
			}
		}

		if(PRINT){	
			System.out.println("GOALS: " + goalList);
			System.out.println("SIGNS: " + signList);
			System.out.println("NODES: " + nodeList);
		}
	}

	public int sortNode(String[] path, int i){
		List<List<Integer>> radial = new ArrayList<List<Integer>>();
		int value, correct = 0;
		//List<Integer> node = new ArrayList<Integer>();
		for(int j = 0; j < 3; j++){
			//node.add(nodeID);
			//node.add(Integer.valueOf(path[i].substring(1)));
			//radial.add(packNode(Integer.valueOf(path[i].substring(1))));
			value = Integer.valueOf(path[i].substring(1));
			nodeID++;
			i++;
			if(path[i].charAt(0) == 'C'){
				//System.out.println(path[i]);
				correct = Integer.valueOf(path[i].substring(1));	
			}
			i++;
			radial.add(packNode(value, correct));
		}
		nodeList.add(radial);
		//nodeList.add(node);
		return i-1;
	}
	
	public List<Integer> packNode(int value, int correct){
		List<Integer> node = new ArrayList<Integer>();
		node.add(nodeID);
		node.add(value);
		node.add(correct);
		return node;
	}

}
