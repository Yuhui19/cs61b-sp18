public class LinkedListDeque<T> {

    private int size ;
    private Node first;

    //Creates an empty linked list deque.
    public LinkedListDeque() {
        first = new Node();
        size = 0;
    }

    //Adds an item of type T to the front of the deque.
    //constant
    public void addFirst(T item) {
        Node node = new Node(item);
        if(size == 0) {
            first.next = node;
            node.previous = first;
            node.next = first;
            first.previous = node;
        }else{
            Node temp = first.next;
            first.next = node;
            node.previous = first;
            node.next = temp;
            temp.previous = node;
        }
        size++;
    }

    //constant
    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        if(size == 0) {
            addFirst(item);
        }else{
            Node node = new Node(item);
            Node temp = first.previous;
            temp.next = node;
            node.previous = temp;
            node.next = first;
            first.previous = node;
        }
        size++;
    }

    //Returns true if deque is empty, false otherwise.
    public boolean isEmpty() {
        return size == 0;
    }

    //constant
    //Returns the number of items in the deque.
    public int size() {
        return size;
    }

    //Prints the items in the deque from first to last, separated by a space.
    public void printDeque() {
        Node temp = first.next;
        for(int i=0;i<size;i++){
            System.out.println(temp.item + " ");
            temp = temp.next;
        }
    }

    //constant
    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if(size == 0){
            return null;
        }
        Node temp = first.next;
        first.next = temp.next;
        first.next.previous = first;
        size--;
        return temp.item;
    }
    //constant
    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if(size == 0){
            return null;
        }
        Node temp = first.previous;
        first.previous = temp.previous;
        first.previous.next = first;
        size--;
        return temp.item;
    }

    //iteration
    //Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index) {
        if(index > size-1 || index < 0){
            return null;
        }
        Node temp = first.next;
        while(index > 0){
            temp = temp.next;
            index--;
        }
        return temp.item;
    }

    //Same as get, but uses recursion.
    private Node helper(int index, Node node) {
        if(index == 0){
            return node;
        }
        return helper(index-1, node.next);
    }
    public T getRecursive(int index) {
        if(index > size-1 || index < 0){
            return null;
        }
        return helper(index, first.next).item;
    }


    private class Node {
        T item;
        Node previous;
        Node next;

        public Node() {
            item = null;
            previous = null;
            next = null;
        }

        public Node(T item) {
            this.item = item;
            previous = null;
            next = null;
        }
    }


}
