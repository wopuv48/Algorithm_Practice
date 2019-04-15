package algotest1;

import java.util.LinkedList;

class hashtable {
	class Node {
		String key;
		String value;
		public Node(String key, String value) {
			this.key = key;
			this.value = value;
		}
		String value() {
			return value;
		}
		void value(String value) {
			this.value = value;
		}
	}
	LinkedList<Node>[] data;
	hashtable(int size) {
		this.data = new LinkedList[size];
	}
	int getHashCode(String key) {
		int hashcode = 0;
		for(char c : key.toCharArray()) {
			hashcode += c;
		}
		return hashcode;
	}
	
	int convertToIndex(int hashcode) {
		return hashcode % data.length;
	}
	
	Node searchkey(LinkedList<Node> list, String key) {
		if(list == null) return null;
		for(Node node : list) {
			if(node.key.equals(key)) {
				return node;
			}
		}
		return null;
	}
	
	void put(String key, String value) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		if(list == null) {
			list = new LinkedList<Node>();
			data[index] = list;
		}
		Node node = searchkey(list, key);
		if(node == null) {
			list.addLast(new Node(key, value));
		} else {
			node.value(value);
		}
	}
	
	String get(String key) {
		int hashcode = getHashCode(key);
		int index = convertToIndex(hashcode);
		LinkedList<Node> list = data[index];
		Node node = searchkey(list, key);
		return node == null? "Not founded" : node.value();
	}
}
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hashtable h = new hashtable(3);
		h.put("sung", "she is pretty");
		h.put("jin", "she is a model");
		h.put("min", "she is an angel");
		h.put("hee", "she is cute");
		System.out.println(h.get("sung"));
		System.out.println(h.get("jin"));
		System.out.println(h.get("min"));
		System.out.println(h.get("hee"));

	}

}
