class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            Character ch = s.charAt(i);
            if(ch == '{' || ch == '[' || ch == '('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){ // stack is empty but we have closing bracket 
                    return false;
                }
                Character peekCh = stack.peek();
                stack.pop();
                if(ch == '}' && peekCh == '{' ||
                ch == ']' && peekCh == '[' ||
                ch == ')' && peekCh == '('  )
                {
                    
                    continue;
                }
                else{
                    return false; 
                    }

            }
        }
        return stack.isEmpty();
    }
}
