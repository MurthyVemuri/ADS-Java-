// Arrays dyanimc

import java.util.*;

class ArraysConcept<E> {

	public E[] values;
	private int size;
	private int curIndex;

	@SuppressWarnings("unchecked")
	public ArraysConcept(int arraySize) {
		size = arraySize;
		curIndex = -1;
		values = (E[])new Object[size];
	}

	public void addValue(E e) {
		if(curIndex % 4 == 0) {
			growArray();
		}
		curIndex++;
		values[curIndex] = e;
	}

	public void removeValue(E e) {
		for (curIndex = 0; curIndex < values.length; curIndex++) {
			if (e == values[curIndex] || e.equals(values[curIndex])) {
				break;
			}
		}
		if(curIndex == values.length) {
			System.out.println("Element is not found");
		}else {
			while(curIndex < values.length - 1) {
				values[curIndex] = values[curIndex + 1];
				curIndex++;
			}
		}
	}

	public void removeIndexValue(int index) {
		int i = 0;
		for(i = 0 ; i < values.length; i++) {
			if(index == i) {
				break;
			}
		}
		if(i == values.length){
			System.out.println("List is empty");
		} else {
			while(i < values.length - 1) {
				values[i] = values[i + 1];
				i++;
			}
		}
	} 

	public void modify(int index , E e) {
		for(int i = 0; i < values.length; i++) {
			if(index == i) {
				values[i] = e;
			}
		}
	}	

	public void modifyValue(E e , E ee) {
		for(int i = 0 ; i < values.length; i++) {
			if(values[i] == e || e.equals(values[i]))
				values[i] = ee;
		}
	}


	public void getValue(int index) {
		if(index < values.length) {
			for (int i = 0 ; i < values.length; i++) {
				if( index == i) {
					System.out.println(values[index]);
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private void growArray() {
		E[] t = (E[])new Object[values.length * 2];
		System.arraycopy(values , 0 , t , 0 , values.length);
		values = t;

	}

	public void printValues() {
		for (int i = 0; i < curIndex + 1; ++i) {
			if(values[i]!=null){
				System.out.print(values[i]);
				if(i < curIndex)
					System.out.print(",");
			}
		}
	}
}

public class ListArrayDemo {
	public static void main(String[] args) {
		ArraysConcept<Integer> ac = new ArraysConcept<Integer>(4);
		ArraysConcept<Float> acf = new ArraysConcept<Float>(4);
		ArraysConcept<String> acs = new ArraysConcept<String>(4);
		Scanner scan = new Scanner(System.in);
		String record = scan.nextLine();
		if(record.equals("I")) {
			while(true) {
				String function = scan.next();
				if(function.equals("add")){
					int num = scan.nextInt();
					ac.addValue(num);
				}else if(function.equals("removeElement")) {
					int num = scan.nextInt();
					ac.removeValue(num);
				}else if(function.equals("read")) {
					int num = scan.nextInt();
					ac.getValue(num);
				}else if(function.equals("modifyIndex")) {
					int num = scan.nextInt();
					int num2 = scan.nextInt();
					ac.modify(num,num2);
				}else if(function.equals("modifyElement")) {
					int num = scan.nextInt();
					int num2 = scan.nextInt();
					ac.modifyValue(num,num2);
				}else if(function.equals("print")) {
					ac.printValues();
				}else if(function.equals("end")) {
					break;
				}
			}
		} else if(record.equals("F")) {
			while(true) {
				String function = scan.next();
				if(function.equals("add")){
					float numf = scan.nextFloat();
					acf.addValue(numf);
				}else if(function.equals("removeElement")) {
					float numf = scan.nextFloat();
					acf.removeValue(numf);
				}else if(function.equals("read")) {
					int numf = scan.nextInt();
					acf.getValue(numf);
				}else if(function.equals("modifyIndex")) {
					int num = scan.nextInt();
					float numf2 = scan.nextFloat();
					acf.modify(num,numf2);
				}else if(function.equals("modifyElement")) {
					float num = scan.nextFloat();
					float numf2 = scan.nextFloat();
					acf.modifyValue(num,numf2);
				}else if(function.equals("print")) {
					acf.printValues();
				}else if(function.equals("end")) {
					break;
				} 
			}
		} else if(record.equals("S") || record.equals("C")) {
			while(true) {
				String function = scan.next();
				if(function.equals("add")){
					String numf = scan.next();
					acs.addValue(numf);
				}else if(function.equals("removeElement")) {
					String numf = scan.next();
					acs.removeValue(numf);
				}else if(function.equals("read")) {
					int numf = scan.nextInt();
					acs.getValue(numf);
				}else if(function.equals("modifyIndex")) {
					int num = scan.nextInt();
					String numf2 = scan.next();
					acs.modify(num,numf2);
				}else if(function.equals("modifyElement")) {
					String num = scan.next();
					String numf2 = scan.next();
					acs.modifyValue(num,numf2);
				}else if(function.equals("print")) {
					acs.printValues();
				}else if(function.equals("end")) {
					break;
				} 
			}
		}
	}
}