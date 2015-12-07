public class TestArray {
	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[] b = a;
		a[1]=100;
		System.out.println(a[0] + a[1] + a[2]);
		b[0] = 10;
		System.out.println(b[0] + b[1] + b[2]);
	}
}