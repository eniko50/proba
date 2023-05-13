package vp.graph;

import java.util.ArrayList;

public class Node<T> {
	
	public Node(T value) {
		super();
		this.value = value;
	}

	T value;
	
	ArrayList<Node<T>> adjacencyList = new ArrayList<Node<T>>();

	public void addAdjacentNode(Node<T> adjacentNode){
		this.adjacencyList.add(adjacentNode);
	}
	
	public boolean removeAdjacentNode(Node<T> adjacentNode){
		if(adjacencyList.contains(adjacentNode)){
			this.adjacencyList.remove(adjacentNode);
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean adjacentTo(Node<T> adjacentNode){
		return adjacencyList.contains(adjacentNode);
	}
	
	@Override
	public String toString() {
		return value.toString();
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public ArrayList<Node<T>> getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(ArrayList<Node<T>> adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
}
