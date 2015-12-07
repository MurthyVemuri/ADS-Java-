import java.io.IOException;

class StackProblem {

	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackProblem(int max) {
		maxSize = max;
		stackArray = new char[maxSize];
		top = -1;
	}

	public void push(char bracket) {
		stackArray[++top] = bracket;
	}

	public char pop() {
		return stackArray[top--];
	}

	public char getTop() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

public class StackDemo {

	private String input;

	public StackDemo(String in) {
		input = in;
	}

	public void check() {
		boolean flag = false;
		int stackSize = input.length(); 
		StackProblem theStack = new StackProblem(stackSize); 

		for (int j = 0; j < input.length(); j++) {
			char ch = input.charAt(j);

				if(ch == '{' || ch == '[' || ch == '(')
					theStack.push(ch); 

				if(ch == '}' || ch == ']' || ch == ')') {
					char chx = theStack.getTop();
				if ((ch == '}' && chx == '{') || (ch == ']' && chx == '[') || (ch == ')' && chx == '('))
					theStack.pop();
					flag = true;
				}
			}

		if (theStack.isEmpty() == true && flag == true)
			System.out.println("Balanced");
		else 
			System.out.println(" Not Balanced");
	}

	public static void main(String[] args) throws IOException {
		String input = "{ [ ( ) ] ( ] ) }";
		StackDemo theChecker = new StackDemo(input);
		theChecker.check(); 
	}
}
