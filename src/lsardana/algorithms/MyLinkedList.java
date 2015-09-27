package lsardana.algorithms;

public class MyLinkedList {
	
	private MyLLNode head;
	private int listLength;
	
	public MyLinkedList() {
		this.head = null;
		this.listLength = 0;
	}
	
	public void add(Object nodeValue) {
		if (head == null) {
			this.head = new MyLLNode(nodeValue);
		} else {
			MyLLNode lastNode = gotoIndex(listLength);
			lastNode.setNext(new MyLLNode(nodeValue));
		}
		listLength++;
	}
	
	public void addAtFirst(Object nodeValue) {
		if (head == null) {
			this.head = new MyLLNode(nodeValue);
		} else {
			MyLLNode newNode = new MyLLNode(nodeValue, head);
			this.head = newNode;
		}
		listLength++;
	}
	
	public void addAtIndex(int index, Object nodeValue) {
		MyLLNode nodeAtIndex = gotoIndex(index-1);
		MyLLNode tail = nodeAtIndex.getNext();
		nodeAtIndex.setNext(new MyLLNode(nodeValue, tail));
		listLength++;
	}
	
	public Object getValueAtIndex(int index) {
		return gotoIndex(index).getValue();
	}
	
	public Object getFirstValue() {
		if (head != null) {
			return head.getValue();
		} else {
			return null;
		}
	}
	
	public Object getLastValue() {
		return gotoIndex(listLength - 1).getValue();
	}
	
	public void removeFirstValue() {
		if (head != null) {
			head = head.getNext();
			listLength--;
		}
	}
	
	public void removeLastValue() {
		if (listLength > 1) {
			MyLLNode secondLastNode = gotoIndex(listLength - 2);
			secondLastNode.setNext(null);
		} else {
			head = null;
		}
		listLength--;
	}
	
	public void removeValueFromIndex(int index) {
		MyLLNode nodeAtIndexBefore = gotoIndex(index -1);
		nodeAtIndexBefore.setNext(nodeAtIndexBefore.getNext().getNext());
		listLength--;
	}
	
	public String toString() {
		String returnString = "[";
		MyLLNode node = head;
		while(node != null) {
			if (node.getNext() != null) {
				returnString += node.getValue().toString() + ", ";
			} else {
				returnString += node.getValue().toString();
			}
			node = node.getNext();		
		}
		returnString += "]";
		return returnString;
	}
	
	private MyLLNode gotoIndex(int index) {
		MyLLNode returnNode;
		returnNode = head;
		int i = 0;
		while (i < index && returnNode.getNext() != null) {
			returnNode = returnNode.getNext();
			i++;
		}
		return returnNode;
	}
	
	public static void main(String args[]) {
		MyLinkedList list = new MyLinkedList();
		list.add(2);
		list.add(4);
		list.add(6);
		list.add(1);
		list.add(9);
		list.add(3);
		list.add(0);
		System.out.println("initial list: "+list.toString());
		list.addAtFirst(10);
		System.out.println("adding 10 at beginning: "+list.toString());
		list.addAtIndex(3, 11);
		System.out.println("adding 11 at index 3: "+list.toString());
		System.out.println("first value of the list: "+list.getFirstValue());
		System.out.println("last value of the list:"+list.getLastValue());
		System.out.println("value at index 5: "+list.getValueAtIndex(5));
		list.removeFirstValue();
		System.out.println("removing first value: "+list.toString());
		list.removeLastValue();
		System.out.println("removing last value: "+list.toString());
		list.removeValueFromIndex(4);
		System.out.println("removing value from index 4: "+list.toString());
	}

}
