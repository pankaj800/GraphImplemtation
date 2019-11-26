package com.optimiser.second;

public class Node<T> {
	
	T t;
	boolean visited=false;
	public T getT() {
		return t;
	}
	
	public  Node(T t) {
		this.t=t;
	}
	public void setT(T t) {
		this.t = t;
	}
	public boolean isVisited() {
		return visited;
	}
	public void setVisited(boolean visited) {
		this.visited = visited;
	}
	
	
	public boolean equals(Object obj) {
		Node node;
		if(obj instanceof Node) {
			node =(Node)obj;
			return node.t==this.t?true:false;
		}
		else 
			return false;
	}
	
	public int hashCode() {
		return t.hashCode();
		
	}
	
	public String toString() {
		return t.toString();
	}

}
