import java.util.Stack;

/**
 * 1544. Make The String Great
 * <p>
 * Given a string s of lower and upper case English letters.
 * <p>
 * A good string is a string which doesn't have two adjacent characters s[i] and s[i + 1] where:
 * <p>
 * 0 <= i <= s.length - 2
 * s[i] is a lower-case letter and s[i + 1] is the same letter but in upper-case or vice-versa.
 * To make the string good, you can choose two adjacent characters that make the string bad and remove them. You can keep doing this until the string becomes good.
 * <p>
 * Return the string after making it good. The answer is guaranteed to be unique under the given constraints.
 * <p>
 * Notice that an empty string is also good.
 */

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
