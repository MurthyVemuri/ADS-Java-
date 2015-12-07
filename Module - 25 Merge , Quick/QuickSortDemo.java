import java.util.*;

class Quicksort {

	Quicksort() {}

	public void sort(Comparable[] set) {
		sort(set, 0, set.length - 1);
	}

	public void sort(Comparable[] set, int left, int right) {
		if (left < right) {
			int p = partition(set, left, right);
			sort(set, left, p - 1); 
			sort(set, p + 1, right);
		}   
	}

	public int partition(Comparable[] set, int left, int right) {
		
		int pivotIndex = left + (right - left) / 2;
		Comparable pivot = set[pivotIndex];  

		swap(set, pivotIndex, right);

		int storeIndex = left;

		for (int i = left; i < right; i++) {
			if (set[i].compareTo(pivot) < 0) {
				swap(set, i, storeIndex);
				storeIndex++;
			}   
		}
		swap(set, storeIndex, right);
		return storeIndex;
	}

	public void swap(Comparable[] set, int i, int j) {
		
		Comparable temp = set[i];
		set[i] = set[j];
		set[j] = temp;
	}   
}

public class QuickSortDemo {

	public static void main(String[] args) {
		
		Quicksort qs = new Quicksort();

		Integer[] set = { 3, 6, 1, 5, 12, 10 };
		String[] sets = {"aa","af","ag","ae","ab","ad","ac"};

		System.out.println(Arrays.toString(set));
		System.out.println(Arrays.toString(sets));
		qs.sort(set); 
		qs.sort(sets); 
		System.out.println(Arrays.toString(set));
		System.out.println(Arrays.toString(sets));
	}
}