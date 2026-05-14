class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        int open=0,close=0;
        generateParenthesis(result,current,open,close,n);
        return result;
    }

    private void generateParenthesis(List<String> result,StringBuilder current ,int open,int close,int max){

        if(current.length() == max*2){
            result.add(current.toString());
            return;
        }

        //Choice 1: Can we add an opening bracket?
        if(open < max){
            current.append("(");
            generateParenthesis(result,current,open+1,close,max);
            current.deleteCharAt(current.length() - 1);
        }

        //Choice 2: Can we add a closing bracket?
        if(close < open){
            current.append(")");
            generateParenthesis(result,current,open,close+1,max);
            current.deleteCharAt(current.length() - 1);
        }

    }

}
