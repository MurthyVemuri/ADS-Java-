class SelectionSort<T extends Comparable<T>>{

	SelectionSort() {}

	public void getSelectionSort(T[] list){
		int iMin = 0;
		for (int i = 0; i < list.length - 2; i++){
			iMin = i;
			for (int j = i + 1; j < list.length - 1; j++){
				if (list[j].compareTo(list[iMin]) < 0){
					iMin = j;
				}
			}
			T temp = list[i];
			list[i] = list[iMin];
			list[iMin] = temp;
		}
		for(int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}

public class SelectionDemoProblem {
	public static void main(String[] args) {
		SelectionSort<String> ss = new SelectionSort<String>();
		String[] a = new String[6];
		a[0] = "ae";
		a[1] = "ab";
		a[2] = "ad";
		a[3] = "ac";
		a[4] = "aa";
		a[5] = "ag";
		ss.getSelectionSort(a);
	}
}