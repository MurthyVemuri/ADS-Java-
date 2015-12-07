import java.util.*;

class Heap implements Comparator<Heap>{
	
	Object[] heapArray;
	int arraySize;
	int curIndex;

	public int compareTo(Heap c) {
		return (this.Object).compareTo(c.Object);
	}

	public Object compare(Heap c,Heap h) {
		return c - h;
	}


	Heap(int size) {
		curIndex = 0;
		arraySize = size;
		heapArray = new Object[size];
	}

	public void insert(Object element) {
		if(curIndex < arraySize) {
			curIndex++;
			heapArray[curIndex] = element;
			siftUp(curIndex);
		}
	}

	private void siftUp(int n) {
		if( n == 1 || ( heapArray[n/2].compareTo(heapArray[n]) )<=0 ) {
			return;
		}
		swap(n,n/2);
		siftUp(n/2);
	}

	public int deleteMin() {
		int result = 0;
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
			if( ((2 * value) + 1) > curIndex || heapArray[2*value] <= heapArray[(2*value) + 1] )
				m = 2*value;
			else
				m = (2*value) + 1;

			if(heapArray[value] > heapArray[m])
				swap(value,m);
			siftDown(m);
		}
	}

	private void swap(int a ,int b) {
		int temp = 0;
		temp = heapArray[a];
		heapArray[a] = heapArray[b];
		heapArray[b] = temp;
	}

	public void removedElements() {
		int newIndex = curIndex;
		System.out.println("After sorting");
		for(int i = 1; i <= newIndex; i++) {
			System.out.print(deleteMin() + " ");
		}
		System.out.println();
	}

	public void display() {
		System.out.println("Before sorting, actual array");
		for(int i = 1; i <= curIndex; i++) {
			System.out.print(heapArray[i] + " ");
		}
	}
}

public class HeapGenericTest {
	public static void main(String[] args) {
		Heap heapObject = new Heap(10);
		heapObject.insert(new Integer(4));
		heapObject.insert(new Integer(4));
		heapObject.insert(new Integer(8));
		heapObject.insert(new Integer(9));
		heapObject.insert(new Integer(4));
		heapObject.insert(new Integer(12));
		heapObject.insert(new Integer(9));
		heapObject.insert(new Integer(11));
		heapObject.insert(new Integer(13));
		heapObject.display();
		heapObject.removedElements();

	}
}
