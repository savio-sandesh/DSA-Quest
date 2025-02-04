class Solution {
    public boolean isValid(String s) {
        Stack <Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(stack.isEmpty() || ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
                continue;
            }
            if(ch==')'){
                if(stack.peek()=='('){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(ch==']'){
                if(stack.peek()=='['){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
            else if(ch=='}'){
                if(stack.peek()=='{'){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}