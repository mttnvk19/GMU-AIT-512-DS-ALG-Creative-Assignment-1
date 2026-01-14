/**
 * Module 1A - C
 * Creative Assignment
 * Linked List Bag for Autonomous Vehicle
 */

package m1ac;

import java.util.Iterator;


public class m1aclinkedlistbag<Item> implements Bagm1ac<Item> {
	/**
	 * A node in the list
	 */
	private class Node {
		
		/**
		 * The next node, following after this node.
		 * Null if none.
		 */
		Node nextNode;
		
		/**
		 * The item stored at this node.
		 */
		Item item;
	}
	
	/**
	 * The start node in the list of items.
	 */
	private Node startNode;
	
	/**
	 * The end node in the list of items.
	 */
	private Node endNode;
	
	/**
	 * The number of elements in the list.
	 */
	private int numberOfElements; 
	
	/**
	 * Creates an empty list of items.
	 */
	public m1aclinkedlistbag() {
		startNode = null;
		endNode = null;
		numberOfElements = 0;
	}
	
	@Override
	public int size() {
		return numberOfElements;
	}
	
	public void add(Item item) {
		// create a new node for the item
		Node itemNode = new Node();
		itemNode.nextNode = null;
		itemNode.item = item;
		// if the list is empty - initialize the list with this new node
		if (startNode==null) {
			startNode = itemNode;
			endNode = itemNode;
		} else {
			// the list has elements, last element is not null
			endNode.nextNode = itemNode;
			endNode = itemNode;
		}
        numberOfElements++;
	}

	@Override
	public Iterator<Item> iterator() {
		return new Iterator<Item>() {
			private Node currentNode=startNode;

			@Override
			public boolean hasNext() {
				return currentNode!=null;
			}

			@Override
			public Item next() {
				Item item = currentNode.item;
				currentNode = currentNode.nextNode;
				return item;
			}
			
		};
	}	


	@Override
	public String toString() {
		return toString("[","]"," stars, ");
	}
}


