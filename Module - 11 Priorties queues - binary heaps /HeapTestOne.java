class Heap<E extends Comparable<E>> {
	
	E[] heapArray;
	int arraySize;
	int curIndex;

	@SuppressWarnings("unchecked")
	Heap(int size) {
		curIndex = 0;
		arraySize = size;
		heapArray = (E[])new Comparable<?>[size];
	}

	public void insert(E element) {
		if(curIndex < arraySize) {
			curIndex++;
			heapArray[curIndex] = element;
			siftUp(curIndex);
		}
	}

	private void siftUp(int n) {
		if( n == 1 || (heapArray[n/2].compareTo(heapArray[n]) <= 0) ) {
			return;
		}
		swap(n,n/2);
		siftUp(n/2);
	}

	public E deleteMin() {
		E result = null;
		if(curIndex > 0) {
			result = heapArray[1];
			heapArray[1] = heapArray[curIndex];
			curIndex--;
			siftDown(1);
		}
		return result;
	}

	public void siftDown(int value) {
		int m;
		if((2*value) <= curIndex) {
			if( ((2 * value) + 1) > curIndex || ( heapArray[2*value].compareTo(heapArray[(2*value) + 1] ) <= 0) )
				m = 2*value;
			else
				m = (2*value) + 1;

			if(heapArray[value].compareTo(heapArray[m]) > 0)
				swap(value,m);
			siftDown(m);
		}
	}

	private void swap(int a ,int b) {
		E temp = null;
		temp = heapArray[a];
		heapArray[a] = heapArray[b];
		heapArray[b] = temp;
	}

	public void display() {
		int newIndex = curIndex;
		for (int i = 1; i <= newIndex ; i++ ) {
			System.out.print(heapArray[i] + " ");
		}
	}

	public void sortOrder() {
		int newIndex = curIndex;
		System.out.println("After sorting");
		for(int i = 1; i <= newIndex; i++) {
			System.out.print(deleteMin() + " ");
		}
		System.out.println();
	}


}

public class HeapTestOne {
	public static void main(String[] args) {
		Heap<Integer> heapObject = new Heap<Integer>(10);
		heapObject.insert(4);
		heapObject.insert(8);
		heapObject.insert(9);
		heapObject.insert(11);
		heapObject.insert(9);
		heapObject.insert(40);
		heapObject.insert(12);
		heapObject.insert(111);
		heapObject.insert(13);
		heapObject.display();
		heapObject.sortOrder();
	}
}
