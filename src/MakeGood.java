import java.util.Stack;

public class MakeGood {
	public static void main(String[] args) {
		String s = "LeEeetCode";
		System.out.println(makeGood(s));

	}

	private static String makeGood(String s) {
		if (s.length() == 0 || s.length() == 1)
			return s;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);

			if (stack.isEmpty()) {
				stack.push(curr);
				continue;
			}
			char temp = stack.peek();
			if (Math.abs(temp - curr) == 32) {
				stack.pop();
			} else {
				stack.push(curr);
			}

		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.peek());
			stack.pop();
		}

		return sb.reverse().toString();

	}

}
