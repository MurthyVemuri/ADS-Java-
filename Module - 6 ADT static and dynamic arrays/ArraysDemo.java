// Unbounded arrays

import java.util.*;

class ArraysConcept<E> {

	public int alpha;
	public int beta; 
	private E[] values;
	private int size;
	private int curIndex;
	private ArrayList<Integer> capacity;

	public void setAlpha(int a) {
		alpha = a;
	}

	public void setBeta(int b) {
		beta = b;
	}

	@SuppressWarnings("unchecked")
	public ArraysConcept(int arraySize) {
		capacity = new ArrayList<Integer>();
		size = arraySize;
		curIndex = 0;
		values = (E[])new Object[size];
		capacity.add(values.length);
	}

	public void addValue(E e) {
		if(curIndex == size) {
			growArray(beta * curIndex);
			values[curIndex++] = e;
		}else
			values[curIndex++] = e;
	}


	public void removeValue() {
		if( ((alpha * size) <= values.length) && size > 0) {
			growArray(beta * size);
		}else {
			curIndex--;
		}
	}

	@SuppressWarnings("unchecked")
	private void growArray(int size) {
		E[] t = (E[])new Object[size];
		System.arraycopy(values , 0 , t , 0 , curIndex);
		values = t;
		this.size = size;
		capacity.add(values.length);

	}

	public void getSize

	public void printCapacity() {
		
		for (int i =0; i < capacity.size() - 1;i++ ) {
			System.out.print(capacity.get(i) + ",");
		}
		System.out.println(capacity.get(capacity.size() - 1));
	}
}
public class ArraysDemo {
	public static void main(String[] args) {
		ArraysConcept<Integer> arraysConceptIntegers = new ArraysConcept<Integer>(1);
		ArraysConcept<Float> arraysConceptFloat = new ArraysConcept<Float>(1);
		ArraysConcept<String> arraysConceptString = new ArraysConcept<String>(1);
		Scanner scan = new Scanner(System.in);
		String record = scan.nextLine();
		if(record.equals("I")) {
			while(true) {
				String function = scan.next();
				if(function.equals("push")){
					int num = scan.nextInt();
					arraysConceptIntegers.addValue(num);
				}else if(function.equals("pop")) {
					arraysConceptIntegers.removeValue();
				}else if(function.equals("size")){
					arraysConceptIntegers.getSize();
				}else if(function.equals("capacity")) {
					arraysConceptIntegers.getCapacity();
				}else if(function.equals("print")) {
					arraysConceptIntegers.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		} else if(record.equals("F")) {
			while(true) {
				String function = scan.next();
				if(function.equals("push")){
					float num = scan.nextFloat();
					arraysConceptFloat.addValue(num);
				}else if(function.equals("pop")) {
					arraysConceptFloat.removeValue();
				}else if(function.equals("size")){
					arraysConceptFloat.getSize();
				}else if(function.equals("capacity")) {
					arraysConceptFloat.getCapacity();
				}else if(function.equals("print")) {
					arraysConceptFloat.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		} else if(record.equals("S") || record.equals("C")) {
			while(true) {
				String function = scan.next();
				if(function.equals("push")){
					String num = scan.next();
					arraysConceptString.addValue(num);
				}else if(function.equals("pop")) {
					arraysConceptString.removeValue();
				}else if(function.equals("size")){
					arraysConceptString.getSize();
				}else if(function.equals("capacity")) {
					arraysConceptString.getCapacity();
				}else if(function.equals("print")) {
					arraysConceptString.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		}
	}
}