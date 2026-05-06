class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
			if (isOperator(token)) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(applyToken(a, b, token));
			} else {
				stack.push(Integer.parseInt(token));
			}
		}
        return stack.pop();
    }

    private Integer applyToken(int a, int b, String token) {
		switch (token) {
		case "+":
			return b + a;
		case "-":
			return b - a;
		case "*":
			return b * a;
		case "/":
			return b / a;
		default:
			throw new IllegalArgumentException("Invalid operator");
		}
	}

    private boolean isOperator(String token) {

		return "+-/*".contains(token);
	}
}
