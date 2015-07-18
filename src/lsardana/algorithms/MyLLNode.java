package lsardana.algorithms;

public class MyLLNode {
	
	private MyLLNode next;
	private Object value;
	
	public MyLLNode(Object value) {
		this.next = null;
		this.value = value;
	}
	public MyLLNode(Object value, MyLLNode next) {
		this.next = next;
		this.value = value;
	}
	
	public MyLLNode getNext() {
		return next;
	}
	public void setNext(MyLLNode next) {
		this.next = next;
	}
	public Object getValue() {
		return value;
	}
	public void setValue(Object value) {
		this.value = value;
	}

}
