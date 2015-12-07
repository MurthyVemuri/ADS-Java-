import java.lang.reflect.*;

public class CovariantArrays<T> {
 	
  // declare the class instance
  private Class<T> tClass;

  // code to initialise tClass

  // returns an array of the parameterised type
  public <T> T[] CovariantArrays(){
    return (T[])java.lang.reflect.Array.newInstance(tClass, 10);
  }

	/**
	 * This program throws runtime error. Because arrays are covariant,
	 * assigning integer array to number array is successful at compile time
	 * But, arrays enforce their element types at runtime. ArrayStoreException
	 * is thrown while adding double to integer array
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
 	
		CovariantArrays<Integer> ca = new CovariantArrays<Integer>();
	}
 
}