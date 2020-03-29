import java.util.NoSuchElementException;

public class LinkedList {

	public class Node {
		int data;
		Node next;

		Node() {
			this.data = 0;
			this.next = null;
		}

		Node(int data) {
			this.data = data;
			this.next = null;
		}

		Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}

		@Override
		public String toString() {
			return (this.data + "");
		}
	}

	protected Node head = null;
	protected Node tail = null;
	protected int size = 0;

	protected void addNodeFirst(Node node) {
		if (head == null) {
			head = tail = node;
			return;
		}
		Node tmp = head;
		head = node;
		head.next = tmp;
	}

	protected void addNodeLast(Node node) {
		if (tail == null) {
			head = tail = node;
			return;
		}
		tail.next = node;
		tail = tail.next;
	}

	// The index here is the index after which we have to add the node.
	protected void addNodeAt(Node node, int index) {
		Node prevNode = getNodeAt(index);
		Node tmp = prevNode.next;
		prevNode.next = node;
		node.next = tmp;
	}

	protected Node getNodeHead() {
		if (this.head != null) {
			return this.head;
		} else {
			throw new NoSuchElementException();
		}
	}

	protected Node getNodeTail() {
		if (this.tail != null) {
			return this.tail;
		} else {
			throw new NoSuchElementException();
		}
	}

	protected Node getNodeAt(int index) {
		if (index < 0 || index >= size) {
			throw new NoSuchElementException();
		} else {
			Node tmp = this.head;
			for (int i = 0; i < index; i++) {
				tmp = tmp.next;
			}
			return tmp;
		}
	}

	protected Node removeNodeFirst() {
		if (this.head == null) {
			throw new NullPointerException();
		}
		Node tmp = this.head;
		this.head = this.head.next;
		tmp.next = null;
		if (size == 1) {
			tail = null;
		}
		return tmp;
	}

	protected Node removeNodeLast() {
		if (size == 1) {
			Node node = removeNodeFirst();
			return node;
		}
		if (this.tail == null) {
			throw new NullPointerException();
		}
		Node tmp = getNodeAt(size-2);
		Node retNode = this.tail;
		retNode.next = null;
		tail = tmp;
		tail.next = null;
		tmp.next = null;
		return retNode;
	}

	// The index here is the index after which we have to remove the node.
	protected Node removeNodeAt(int index) {
		Node tmp = getNodeAt(index);
		Node retNode = tmp.next;
		tmp.next = retNode.next;
		retNode.next = null;
		return retNode;
	}

	public void addFirst(int data) {
		Node node = new Node(data);
		addNodeFirst(node);
		size++;
	}

	public void addLast(int data) {
		Node node = new Node(data);
		addNodeLast(node);
		size++;
	}

	public void addAt(int data, int index) {
		if (index < 0 || index > size) {
			System.out.println("Cannot add node at index : " + index);
		}
		Node node = new Node(data);
		if (index == 0) {
			addNodeFirst(node);
		} else if (index == size) {
			addNodeLast(node);
		} else {
			addNodeAt(node, index - 1);
		}
		size++;
	}

	public Integer getFirst() {
		Node node = getNodeHead();
		if (node != null)
			return node.data;
		else
			return -1;
	}

	public int getLast() {
		Node node = getNodeTail();
		if (node != null)
			return node.data;
		else
			return -1;
	}

	public int getAt(int index) {
		Node node = getNodeAt(index);
		if (node != null)
			return node.data;
		else
			return -1;
	}

	public int removeFirst() {
		Node node = removeNodeFirst();
		size--;
		return node.data;
	}

	public int removeLast() {
		Node node = removeNodeLast();
		size--;
		return node.data;	
	}

	public int removeAt(int index) {
		if (index > size || index < 0) {
			System.out.println("Cannot remove node at index : " + index);
		}
		Node node;
		if (index == 0) {
			node = removeNodeFirst();
		} else if (index == size) {
			node = removeNodeLast();
		} else {
			node = removeNodeAt(index - 1);
		}
		size--;
		return node.data;
	}

	public int getSize() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	@Override
	public String toString() {
		Node tmp = head;
		StringBuilder sb = new StringBuilder();
		while(tmp != tail) {
			sb.append(tmp.data + " -> ");
			tmp = tmp.next;
		}
		try {
			sb.append(getLast());
		} catch (NoSuchElementException e) {
			// Do nothing.
		}
		return sb.toString();
	}

	public Node getHead() {
		return this.head;
	}

	public Node getTail() {
		return this.head;
	}

	public LinkedList() {
		this.size = 0;
		this.head = null;
		this.tail = null;
	}

}
