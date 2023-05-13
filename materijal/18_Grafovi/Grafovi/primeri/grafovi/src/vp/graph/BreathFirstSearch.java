package vp.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class BreathFirstSearch<T> {
	
	public String convertToString(Node<T> startNode) {
		ArrayDeque<Node<T>> discovered = new ArrayDeque<>();
		HashSet<Node<T>> processed = new HashSet<>();
		discovered.add(startNode);
		StringBuilder sb = new StringBuilder();
		while (discovered.size() != 0) {
			Node<T> node = discovered.poll();
			if (!processed.contains(node)) {
				sb.append(node.getValue() + ";");
				discovered.addAll(node.getAdjacencyList());
				processed.add(node);
			}
		}
		return sb.toString();
	}

	public List<T> findPath(Node<T> startNode, Node<T> endNode) {
		ArrayDeque<Node<T>> discovered = new ArrayDeque<>();
		HashSet<Node<T>> processed = new HashSet<>();
		HashMap<Node<T>, Node<T>> predecessors = new HashMap<>();
		discovered.add(startNode);
		while (discovered.size() != 0) {
			Node<T> node = discovered.poll();
			if (node.equals(endNode)) {
				ArrayList<T> retVal = new ArrayList<>();
				while (predecessors.get(node) != null) {
					retVal.add(0, node.getValue());
					node = predecessors.get(node);
				}
				retVal.add(0, node.getValue());
				return retVal;
			}
			if (!processed.contains(node)) {
				for (int i = 0; i < node.getAdjacencyList().size(); i++) {
					Node<T> n = node.getAdjacencyList().get(i);
					if (!processed.contains(n)) {
						predecessors.put(n, node);
					}
				}
				discovered.addAll(node.getAdjacencyList());
				processed.add(node);
			}
		}
		return null;
	}

}
