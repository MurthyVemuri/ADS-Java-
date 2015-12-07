import java.util.*;

class ModuleThreeProblemOne {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter size: ");
		int size = scan.nextInt();

		String[] a = new String[size];
		String[] b = new String[size];
		int[] c = new int[size + 1];

		for(int i = 0; i <a.length; i++) {
			System.out.println("Enter " + i +" element");
			a[i] = scan.next();
		}

		for(int i = 0; i <b.length; i++) {
			System.out.println("Enter " + i +" element");
			b[i] = scan.next();
		}


		int value = 0;
		int carry = 0;

		for(int i = a.length; i > 0; i--) {

			carry = Integer.parseInt(a[i-1]) + Integer.parseInt(b[i-1]) + value;
			if(carry >= 10) {
				c[i] = carry % 10;
				value = carry / 10;
			}else {
				c[i] = Integer.parseInt(a[i-1]) + Integer.parseInt(b[i-1])Integer.parseInt + value;
				value = 0;
			}
					c[0] = value;
		}


		for(int i = 0; i <c.length; i++)
		System.out.print(c[i]);
	}

}

