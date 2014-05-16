package spiderGame;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Strand {
	
	/* Sign Integers
	 * 1 = + (add)
	 * 2 = - (sub)
	 * 3 = * (mul)
	 * 4 = / (div)
	 * */	
	public int nodeOne = 0;
	public int nodeTwo = 0;
	public int nodeThree = 0;
	
	public void setValues(int sign, int one, int two, int three){		
		this.nodeOne = one;
		this.nodeTwo = two;
		this.nodeThree = three;
		if(sign == 1 || sign == 3){
			shuffleNodes();
		}
	}
	
	public void shuffleNodes(){
		List<Integer> nodes = new ArrayList<Integer>();
		nodes.add(nodeOne);
		nodes.add(nodeTwo);
		nodes.add(nodeThree);
		Collections.shuffle(nodes);
		nodeOne = nodes.get(0);
		nodeTwo = nodes.get(1);
		nodeThree = nodes.get(2);
	}
	
	public int getFirst(){
		return this.nodeOne;
	}
	
	public int getSecond(){
		return this.nodeTwo;
	}
	
	public int getThird(){
		return this.nodeThree;
	}
	
}
