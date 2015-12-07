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

public class SelectionDemo {
	public static void main(String[] args) {
		SelectionSort<String> ss = new SelectionSort<String>();
		String[] a = {"ae","ab","ad","ac","aa","af","ag"};
		ss.getSelectionSort(a);

		SelectionSort<Integer> ssi = new SelectionSort<Integer>();
		Integer[] ai = {2,5,1,3,7,4,9,8};
		ssi.getSelectionSort(ai);

		SelectionSort<Float> ssf = new SelectionSort<Float>();
		Float[] af = {4.4f,3.3f,7.7f,1.3f,8.5f,4.3f,67.6f};
		ssf.getSelectionSort(af);
	}
}

/*
public void selectionSort(Comparable[] list){   
for (int i = 0; i < list.length; i++){
        for (int j = i; j < list.length; j++){
            if (list[j].compareTo(list[i]) < 0){
                Comparable temp = list[i];
                list[i] = list[j];
                list[j] = temp;
            }
        }
       }
    }

*/