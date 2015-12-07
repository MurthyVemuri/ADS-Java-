class InsertionSort<T extends Comparable<T>>{

	InsertionSort() {}

	public void getInsertionSort(T[] list){
		for (int i = 0; i < list.length; i++){
			T value = list[i];
			int hole = i;
			while(hole > 0 && list[hole - 1].compareTo(value) > 0) {
				list[hole] = list[hole - 1];
				hole = hole - 1;
			}
			list[hole] = value;
		}
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}

public class InsertionDemoProblem {
	public static void main(String[] args) {
		InsertionSort<String> ss = new InsertionSort<String>();
		String[] a = new String[6];
		a[0] = "ae";
		a[1] = "ab";
		a[2] = "ad";
		a[3] = "ac";
		a[4] = "aa";
		a[5] = "ag";
		ss.getInsertionSort(a);
	}
}