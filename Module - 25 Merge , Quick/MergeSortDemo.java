import java.util.Arrays;
import java.util.Random;

class MergeSort {	

	public Comparable[] mergeSort(Comparable[] input){
		
		if(input.length == 1){
			return input;
		}

		int middle = 0;
		if(input.length % 2 == 0) {
			middle = (input.length) / 2;
		}else {
			middle = ( (input.length) / 2) + 1;
		}

		Comparable[] left = new Comparable[middle];
		
		int rightLength = 0;
		if(input.length % 2 == 0){
			rightLength = middle;
		}
		else{
			rightLength = middle - 1;
		}
		Comparable[] right = new Comparable[rightLength];
		
		int leftIndex = 0; 
		int rightIndex = 0;
		
		for (int i = 0; i < input.length; i++) {
			if(i < middle){
				left[leftIndex] = input[i];
				leftIndex++;
			}
			else{
				right[rightIndex] = input[i];
				rightIndex++;
			}
		}
		
		left = mergeSort(left);
		right = mergeSort(right);
		
		return merge(left, right);
	}
	
	@SuppressWarnings("unchecked")
	private Comparable[] merge(Comparable[] left, Comparable[] right){
		Comparable[] result = new Comparable[left.length + right.length];
		int leftIndex = 0;
		int rightIndex = 0;
		int resultIndex = 0;
		
		while(leftIndex < left.length || rightIndex < right.length){
			if(leftIndex < left.length && rightIndex < right.length){
				if(left[leftIndex].compareTo(right[rightIndex]) < 0){
					result[resultIndex] = left[leftIndex];
					leftIndex++;
					resultIndex++;
				}
				else{
					result[resultIndex] = right[rightIndex];
					rightIndex++;
					resultIndex++;
				}
			}
			else if(leftIndex < (left.length) ){
				for (int i = resultIndex; i < result.length; i++) {
					result[i] = left[leftIndex];
					leftIndex++;
				}
			}
			else if(rightIndex < (right.length)){
				for (int i = resultIndex; i < result.length; i++) {
					result[i] = right[rightIndex];
					rightIndex++;
				}
			}
		}
		return result;
	}

}

public class MergeSortDemo {
	public static void main(String[] args) {
		MergeSort app = new MergeSort();
		
	    Integer[] input = {1,7,2,6,3,5,4};
	    String[] inputs = {"aa","af","ag","ae","ab","ad","ac"};	
	    System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(inputs));
	    System.out.println(Arrays.toString(app.mergeSort(input)));
	    System.out.println(Arrays.toString(app.mergeSort(inputs)));
	}
}