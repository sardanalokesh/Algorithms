package lsardana.algorithms;

public class MyLinkedListTest {
	
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