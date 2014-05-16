package spiderGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenPath {

	public final boolean PRINT = true;
	public final boolean DIFF_GOALS = true;

	public final int NUM_SECTIONS = 3;
	public final int MAX_GOAL = 40;
	public final int STRAND_COUNT = 4;
	public final int MAX_NODE = 5;
	public final int GOAL_FLEX_STRAND = 2;
	public final int GOAL_FLEX_FULL = 10;

	public final int ADD = 1;
	public final int SUB = 2;
	public final int MUL = 3;
	public final int DIV = 4;
	
	public static String strPath = "";
	public List<Integer> mulGoals = new ArrayList<Integer>(Arrays.asList(4,8,9,10,12,15,20,24));

	public int total = 0;

	public String generatePath(){
		
		int goal = 0;
		
		//SstrPath = strPath.concat("WE 'don't' HATE YOU Sammy");
		
		for(int i = 1; i <= NUM_SECTIONS; i++){
			if(i == 1 ||DIFF_GOALS){
				goal = getGoal(MAX_GOAL, GOAL_FLEX_FULL);
			}
			strPath = strPath.concat(":G" + goal);
			strPath = strPath.concat(genDivisionStrand(getGoal(goal/STRAND_COUNT, GOAL_FLEX_STRAND)));
			strPath = strPath.concat(genMultiplicationStrand(getGoal(goal/STRAND_COUNT, GOAL_FLEX_STRAND)));
			strPath = strPath.concat(genAdditionStrand(getGoal(goal/STRAND_COUNT, GOAL_FLEX_STRAND)));
			strPath = strPath.concat(genSubtractionStrand(goal - total));
		}	
		
		if(PRINT){
			System.out.println(strPath);
		}
		
		PathLists pl = new PathLists();
		pl.sortString(strPath);
		return strPath;
	}

	public String genSubtractionStrand(int goal){
		Strand subStrand = new Strand();		
		int firstNode = 0, secondNode = 0, thirdNode = 0;
		int one = 0, two = 0, three = 0;

		if(getRand(1,true) > 0){
			thirdNode = getRand(goal, true);
			secondNode = getRand(goal, true);
			firstNode = goal + (secondNode + thirdNode);
			one = two = three = 1;

			subStrand.setValues(SUB, firstNode, secondNode, thirdNode);
		}else{
			thirdNode = getRand(goal, true);
			secondNode = getRand(goal, true);
			firstNode = goal + secondNode;
			one = two = 1;

			subStrand.setValues(SUB, firstNode, secondNode, thirdNode);
		}
		
		String strand = ":S" + SUB + ":N" + firstNode + ":C" + one + ":N" + secondNode + ":C" + two + ":N" + thirdNode + ":C" + three; 

		total = total + goal;

		return strand;
	}

	public String genAdditionStrand(int goal){

		int firstNode = 0, secondNode = 0, thirdNode = 0;
		int one = 0, two = 0, three = 0;

		if(getRand(1,true) > 0){
			thirdNode = getRand(goal/3, true);
			secondNode = getRand(goal-thirdNode, true);
			firstNode = goal - (secondNode + thirdNode);
			one = two = three = 1;
			
		}else{
			thirdNode = getRand(10, true);
			secondNode = getRand(goal, true);
			firstNode = goal - secondNode;
			one = two = 1;
		}
		
		String strand = ":S" + ADD + ":N" + firstNode + ":C" + one + ":N" + secondNode + ":C" + two + ":N" + thirdNode + ":C" + three;
		total = total + goal;

		return strand;
	}

	public String genMultiplicationStrand(int startGoal){

		String strand = "";
		int currDiff = 42, checkDiff = 0, goal = 0;
		int one = 0, two = 0, three = 0;

		if(getRand(4,true) == 0){
			int[] strandList = {1, goal, getRand(10, false)};
			total = total + startGoal;
			strand = ":S" + MUL + ":N" + strandList[0] + ":C1:N" + strandList[0] + ":C1:N" + strandList[2] + ":C0";
			return strand;
		}

		for(int i = 0; i < mulGoals.size(); i++){
			checkDiff = startGoal - mulGoals.get(i);
			checkDiff = (int) Math.sqrt(checkDiff*checkDiff);
			if(checkDiff < currDiff){
				currDiff = checkDiff;
				goal = mulGoals.get(i);
			}
		}

		int length = getRand(1, true);
		
		int node1 = 0, node2 = 0, node3 = 0;
		
		switch(goal){
		case 4:
			node1 = 2;
			node2 = 2;
			node3 = getRand(10, false);
			one = two = 1;
			break;
		case 9:
			node1 = 3;
			node2 = 3;
			node3 = getRand(10, false);
			one = two = 1;
			break;
		case 10:
			node1 = 5;
			node2 = 2;
			node3 = getRand(10, false);
			one = two = 1;
			break;
		case 15:
			node1 = 5;
			node2 = 3;
			node3 = getRand(10, false);
			one = two = 1;
			break;
		case 8:
			if(length > 0){
				node1 = 2;
				node2 = 2;
				node3 = 2;
				one = two = three = 1;
			}else{
				node1 = 4;
				node2 = 2;
				node3 = getRand(10, false);
				one = two = 1;
			}
			break;
		case 12:
			if(length > 0){
				node1 = 2;
				node2 = 2;
				node3 = 3;
				one = two = three = 1;
			}else if (getRand(1,true) > 0){
				node1 = 6;
				node2 = 2;
				node3 = getRand(10, false);
				one = two = 1;
			}else{
				node1 = 3;
				node2 = 4;
				node3 = getRand(10, false);
				one = two = 1;
			}
			break;
		case 20:
			if(length > 0){
				node1 = 2;
				node2 = 2;
				node3 = 5;
				one = two = three = 1;
			}else if (getRand(1,true) > 0){
				node1 = 10;
				node2 = 2;
				node3 = getRand(10, false);
				one = two = 1;
			}else{
				node1 = 5;
				node2 = 4;
				node3 = getRand(10, false);
				one = two = 1;
			}
			break;
		case 24:
			if(length > 0){
				if (getRand(1,true) > 0){
					node1 = 2;
					node2 = 2;
					node3 = 6;
					one = two = three = 1;
				}else{
					node1 = 2;
					node2 = 3;
					node3 = 4;
					one = two = three = 1;
				}
			}else if (getRand(1,true) > 0){
				node1 = 12;
				node2 = 2;
				node3 = getRand(10, false);
				one = two = 1;
			}else{
				node1 = 6;
				node2 = 4;
				node3 = getRand(10, false);
				one = two = 1;
			}
		default:
			break;
		}
		
		strand = ":S" + MUL + ":N" + node1 + ":C" + one + ":N" + node2 + ":C" + two + ":N" + node3 + ":C" + three;
		
		total = total + goal;
		return strand;
	}

	public String genDivisionStrand(int goal){
		int firstNode, secondNode, thirdNode;
		int one = 0, two = 0, three = 0;
		
		if(getRand(1, true) == 1){
			thirdNode = getRand(MAX_NODE, false);
			secondNode = getRand(MAX_NODE, false);
			firstNode = thirdNode * secondNode * goal;
			one = two = three = 1;
			if(firstNode > 45){
				firstNode = secondNode * goal;
				one = two = 1;
			}
		}else{
			thirdNode = getRand(MAX_NODE, false);
			secondNode = getRand(MAX_NODE, false);
			firstNode = secondNode * goal;
			one = two = 1;
		}

		String strand = ":S" + DIV + ":N" + firstNode + ":C" + one + ":N" + secondNode + ":C" + two + ":N" + thirdNode + ":C" + three; 

		total = goal;
		return strand;
	}

	public int getGoal(int start, int flex){
		int goal = 0;

		if(getRand(1, true) > 0){
			goal = start + getRand(flex, true);
		}else{
			goal = start - getRand(flex, true);
		}		
		return goal;
	}

	public String getSign(int sign){
		switch(sign){
		case 1:
			return "ADD";
		case 2:
			return "SUB";
		case 3:
			return "MUL";
		case 4:
			return "DIV";
		case 5:
			return "GOAL";
		default:
			return null;
		}
	}

	public int getRand(int limit, boolean zero){
		int randomNum = 0;
		limit++;
		do{
			randomNum = (int)(Math.random() * limit);
		}while(randomNum == 0 && !zero);
		return randomNum;
	}

}
