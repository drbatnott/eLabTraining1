package eLab.eLabTraining;

import java.util.ArrayList;
import java.util.Iterator;

public class Radial {
	int radialID;
	int operator;
	CoOrds cOFrom, cOTo;
	ArrayList<Node> nodes;
	
	public Radial(int rID, int o, CoOrds cofrom, CoOrds coto, ArrayList<Node> n){
		radialID = rID;
		operator = o;
		cOFrom = cofrom;
		cOTo = coto;
		nodes = n;
	}
	
	public int getXTo(){
		return cOTo.getX();
	}
	
	public int getYTo(){
		return cOTo.getY();
	}
	
	public CoOrds getCoOrdsTo(){
		return cOTo;
	}
	
	public int getXFrom(){
		return cOFrom.getX();
	}
	
	public int getYFrom(){
		return cOFrom.getY();
	}
	public CoOrds getCoOrdsFrom(){
		return cOFrom;
	}
	
	public ArrayList<Node> getNodes(){
		return nodes;
	}
	
	public int getRadialID(){
		return radialID;
	}
	
	public int getOperator(){
		return operator;
	}
	
	public boolean removeNode(int nID){
		
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			if(node.getNodeID() == nID){
				nodes.remove(node);
				System.out.println("NODE REMOVED FROM RADIAL");
				return true;
			}
		}
		return false;
		
		/*if(nodes.remove(n)){
			return true;
		}
		else{
			return false;
		}*/
		
	}
	
	public int getNodeValue(int nID){
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			if(node.getNodeID() == nID){
				
				return node.getValue();
			}
		}
		return 0;
	}
	
	public boolean setNodeDisplayed(int nID, boolean b){
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			if(node.getNodeID() == nID){
				node.setDisplay(b);
				return true;
			}
		}
		return false;
	}
	
	public boolean getNodeDisplayed(int nID){
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			if(node.getNodeID() == nID){
				
				return node.getDisplay();
			}
		}
		return false;
	}
	
	public boolean setNodeSelected(int nID, boolean b){
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			if(node.getNodeID() == nID){
				node.setSelected(b);
				return true;
			}
		}
		return false;
	}
	
	public boolean getNodeSelected(int nID){
		Iterator<Node> i = nodes.iterator();
		while(i.hasNext()){
			Node node = i.next();
			if(node.getNodeID() == nID){
				
				return node.getSelected();
			}
		}
		return false;
	}
}
