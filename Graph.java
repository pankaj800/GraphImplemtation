package com.optimiser.second;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class Graph<T> {

	Map<Node<T>, List<Node<T>>> linkedElement = new HashMap<Node<T>, List<Node<T>>>();

	public boolean addVertex(T obj) {
		Node<T> nodeObject = new Node(obj);
		if (this.linkedElement.containsKey(nodeObject)) {
			return false;
		}

		else {
			List<Node<T>> vertexList = new CopyOnWriteArrayList();
			this.linkedElement.put(nodeObject, vertexList);
			return true;

		}

	}

	public boolean addEdge(T vertex, T edgeVertex) {
		Node<T> vertexNode=new Node<T>(vertex);
		Node<T> edgeVertexNode=new Node<T>(edgeVertex);

		Set<Node<T>> keys=this.linkedElement.keySet();
		for(Node<T> key:keys) {
			if(key.equals(vertexNode)) {
				vertexNode=key;
			}
			if(key.equals(edgeVertexNode)) {
				edgeVertexNode=key;
			}
			
			
			
		}
		
		List<Node<T>> edgeVertexList=this.linkedElement.get(vertexNode);
		if(edgeVertexList!=null) {
			edgeVertexList.add(edgeVertexNode);
		}
		
		
		else {
			edgeVertexList=new ArrayList<>();
			edgeVertexList.add(edgeVertexNode);

		}
		this.linkedElement.put(vertexNode, edgeVertexList);

		List<Node<T>> edgeVertexList2=this.linkedElement.get(edgeVertexNode);
		if(edgeVertexList2==null) {
			List<Node<T>> list=new ArrayList<>();
			this.linkedElement.put(edgeVertexNode, list);

		}

		
		return true;
	}
	
	public List<Node<T>> getEdge(T vertex) throws Exception{
		
		Node<T> vertexNodeObject=new Node(vertex);
		Set<Node<T>> keys=this.linkedElement.keySet();
		
		List<Node<T>> edgeNodeObjectList=null;
		List<Node<T>> edgeNodeObjectList2=new ArrayList<>();

		for(Node<T> key:keys) {
			if(key.equals(vertexNodeObject))
				vertexNodeObject=key;
			else {
				throw new Exception();
			}
			vertexNodeObject.setVisited(true);
			edgeNodeObjectList=this.linkedElement.get(vertexNodeObject);
			Iterator<Node<T>> it=edgeNodeObjectList.iterator();
			while(it.hasNext())  {
				
				Node<T>edgeNodeObject=it.next();
				edgeNodeObject.setVisited(true);
				edgeNodeObjectList2.add(edgeNodeObject);
			}
			this.linkedElement.put(vertexNodeObject, edgeNodeObjectList2);

			return edgeNodeObjectList;
		
		}
		return null;
		
	}
	
	public boolean isObjectAvailable(T t) {
		
		Node<T> obj=new Node<>(t);
		if(this.linkedElement.containsKey(obj)) {
			return true;
		}
		else
			return false;
	}
	
	public  List<Node<T>> getUnvisitedVertices(){
		Set<Node<T>> vertexSet=this.linkedElement.keySet();
		
		List<Node<T>> unvisitedVertices=new ArrayList<>();
		for(Node<T> vertex:vertexSet) {
			if(vertex.visited==false) {
				unvisitedVertices.add(vertex);
			}
		}
		return unvisitedVertices;

	}
}
