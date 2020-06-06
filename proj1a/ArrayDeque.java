public class ArrayDeque<T> {

    private int size;
    private T[] arr;
    private int first;
    private int last;

    //Creates an empty linked list deque.
    public ArrayDeque() {
        arr =  (T[]) new Object[8];
        size = 0;
        first = 0;
        last = -1;
    }

    private void order() {
        if (first == 0) {
            return;
        }
        int length = arr.length;
        T[] temp = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            temp[i] = arr[i];
        }
        int index = 0;
        for (int i = first; i < length; i++) {
            arr[index] = temp[i];
            index++;
        }
        for (int i = 0; i <= last; i++) {
            arr[index] = temp[i];
            index++;
        }
        first = 0;
        last = index - 1;
    }

    private void doubleLength() {
        int length = arr.length;
        order();
        T[] temp = (T[]) new Object[length * 2];
        int index = 0;
        for (T t : arr) {
            temp[index] = t;
            index++;
        }
        arr = temp;
    }

    private void halfLength() {
        int length = arr.length;
        if (length <= 8) {
            return;
        }
        order();
        length = length / 2;
        T[] temp = (T[]) new Object[length];
//        int index = 0;
        for (int i = 0; i < length; i++) {
            temp[i] = arr[i];
//            index++;
        }
        arr = temp;
    }

    //Adds an item of type T to the front of the deque.
    //constant
    public void addFirst(T item) {
        if (size == 0) {
            arr[0] = item;
            last++;
        } else {
            first--;
            if (first < 0) {
                first += arr.length;
            }
            arr[first] = item;
        }
        size++;
        double usage = size / arr.length;
        if (usage > 0.5) {
            doubleLength();
        }
    }

    //constant
    //Adds an item of type T to the back of the deque.
    public void addLast(T item) {
        last++;
        arr[last] = item;
        size++;
        double usage = size / arr.length;
        if (usage > 0.5) {
            doubleLength();
        }
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
        order();
        for (int i = 0; i < size; i++) {
            System.out.println(arr[i] + " ");
        }
    }

    //constant
    //Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst() {
        if (size <= 0) {
            return null;
        }
        T output = arr[first];
        if (first == 0) {
            for (int i = 1; i < size; i++) {
                arr[i - 1] = arr[i];
            }
            last--;
        } else {
            first++;
            if (first >= arr.length) {
                first -= arr.length;
            }
        }
        size--;
        double usage = size / arr.length;
        if (usage < 0.25) {
            halfLength();
        }
        return output;
    }
    //constant
    //Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast() {
        if (size <= 0) {
            return null;
        }
        T output = arr[last];
        last--;
        size--;
        double usage = size / arr.length;
        if (usage < 0.25) {
            halfLength();
        }
        return output;
    }

    //constant
    //Gets the item at the given index, where 0 is the front, 1 is the next item,
    // and so forth. If no such item exists,
    // returns null. Must not alter the deque!
    public T get(int index) {
        if (index > size - 1 || index < 0) {
            return null;
        }
        if (first == 0) {
            return arr[index];
        }
        int gap = arr.length - first;
        if (index < gap) {
            return arr[first + gap - index];
        } else {
            return arr[first + index - arr.length];
        }
    }
}
