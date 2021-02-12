package demo;

import java.util.Stack;


public class BigIntAddSub {
	public Stack<Integer> sum(Stack<Integer> leadingStack, Stack<Integer> secondStack) {
		int carry = 0;
		Stack<Integer> resultStack = new Stack<Integer>();
		while (leadingStack.isEmpty() == false && secondStack.isEmpty() == false) {
			int dig1 = leadingStack.pop();
			int dig2 = secondStack.pop();
			int result = dig1 + dig2 + carry;
			int resultDig = result % 10;
			carry = result / 10;
			resultStack.push(resultDig);
		}

		Stack<Integer> leftStack = leadingStack.isEmpty() ? secondStack : leadingStack;
		while (leftStack.isEmpty() == false) {
			int dig = leftStack.pop();
			if (carry > 0) {
				dig += carry;
				carry = 0;
			}
			resultStack.push(dig);
		}

		if (carry > 0)
			resultStack.push(carry);
		return reverse(resultStack);
	}

	public Stack<Integer> reverse(Stack<Integer> inStack) {
		Stack<Integer> outStack = new Stack<>();
		while (inStack.isEmpty() == false)
			outStack.push(inStack.pop());
		return outStack;
	}
	
	public Stack<Integer> convertStringToStack(String input){
		Stack<Integer> resultStack = new Stack<Integer>();
		for(int i=0;i<input.length();i++) {
			resultStack.push(Integer.parseInt(input.substring(i,i+1)));
		}
		return resultStack;
	}
	public static void main(String[] args) {
		String input1 = "123456789";
		String input2 = "123456789";
		BigIntAddSub d = new BigIntAddSub();
		System.out.println(d.sum(d.convertStringToStack(input1),d.convertStringToStack(input2)));
	}
	
}
