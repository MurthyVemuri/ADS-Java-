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

public class InsertionDemo {
	public static void main(String[] args) {
		InsertionSort<String> ss = new InsertionSort<String>();
		String[] a = {"aa","af","ag","ae","ab","ad","ac"};
		ss.getInsertionSort(a);

		InsertionSort<Integer> ssi = new InsertionSort<Integer>();
		Integer[] ai = {4,9,8,2,5,1,3,7};
		ssi.getInsertionSort(ai);

		InsertionSort<Float> ssf = new InsertionSort<Float>();
		Float[] af = {1.3f,8.5f,4.3f,67.6f,4.4f,3.3f,7.7f};
		ssf.getInsertionSort(af);
	}
}

/*
public void InsertionSort(Comparable[] list){   
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