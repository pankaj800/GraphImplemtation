package com.optimiser.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph<T> {

	Map<Node<T>, List<Node<T>>> linkedElement = new HashMap<Node<T>, List<Node<T>>>();

	public boolean addVertex(T obj) {
		Node<T> nodeObject = new Node(obj);
		if (this.linkedElement.containsKey(nodeObject)) {
			return false;
		}

		else {
			List<Node<T>> vertexList = new ArrayList<>();
			this.linkedElement.put(nodeObject, vertexList);
			return true;

		}

	}

	public boolean addEdge(T vertex, T edgeVertex) {
		Node<T> vertexNodeObject = new Node(vertex);
		Node<T> edgeVertexNodeObject = new Node(edgeVertex);
		List<Node<T>> edgeVertexObjects = null;
		if (this.linkedElement.containsKey(vertexNodeObject)) {

			edgeVertexObjects = linkedElement.get(vertexNodeObject);
			edgeVertexObjects.add(edgeVertexNodeObject);
		}

		else {
			edgeVertexObjects = new ArrayList<>();
			edgeVertexObjects.add(edgeVertexNodeObject);
		}

		linkedElement.put(vertexNodeObject, edgeVertexObjects);

		return true;
	}
	
	public List<Node<T>> getEdge(T vertex) throws Exception{
		
		Node<T> vertexNodeObject=new Node(vertex);
		List<Node<T>> edgeNodeObjectList=null;
		if(this.linkedElement.containsKey(vertexNodeObject)) {
			edgeNodeObjectList=this.linkedElement.get(vertexNodeObject);
			for(Node<T> edgeNodeObject:edgeNodeObjectList)  {
				edgeNodeObject.setVisited(true);
				
			}
			return edgeNodeObjectList;
		}
		
		else {
			throw new Exception();
		}
	}
	
	public  List<Node<T>> getUnvisitedVertices(){
		Set<Node<T>> vertexSet=this.linkedElement.keySet();
		
		List<Node<T>> unvisitedVertices=new ArrayList<>();
		for(Node<T> vertex:vertexSet) {
			if(vertex.visited=false) {
				unvisitedVertices.add(vertex);
			}
		}
		return unvisitedVertices;

	}
}
