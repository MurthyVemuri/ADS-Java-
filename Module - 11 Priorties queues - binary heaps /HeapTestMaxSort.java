class Heap {
	
	int[] heapArray;
	int arraySize;
	int curIndex;

	Heap(int size) {
		curIndex = 0;
		arraySize = size;
		heapArray = new int[size];
	}

	public void insert(int element) {
		if(curIndex < arraySize) {
			curIndex++;
			heapArray[curIndex] = element;
			siftUp(curIndex);
		}
	}

	private void siftUp(int n) {
		if( n == 1 || heapArray[n/2] >= heapArray[n]) {
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
			if( ((2 * value) + 1) > curIndex || heapArray[2*value] >= heapArray[(2*value) + 1] )
				m = 2*value;
			else
				m = (2*value) + 1;

			if(heapArray[value] < heapArray[m])
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
}

public class HeapTestMaxSort {
	public static void main(String[] args) {
		Heap heapObject = new Heap(10);
		heapObject.insert(2);
		heapObject.insert(4);
		heapObject.insert(8);
		heapObject.insert(9);
		heapObject.insert(12);
		heapObject.insert(9);
		heapObject.insert(11);
		heapObject.insert(13);
		heapObject.insert(1);
		heapObject.removedElements();

	}
}
