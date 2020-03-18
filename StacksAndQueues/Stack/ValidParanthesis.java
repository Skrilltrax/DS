import java.util.Stack;

public class ValidParanthesis {

    public static solve(String s) {
        Stack<Character> st = new Stack();
        int flag = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch(ch) {
                    case '}': 
                    if (st.size() != 0 && st.peek() == '{') {
                        st.pop();
                    } else {
                        flag = 1;
                    }
                    break;

                    case ']': 
                    if (st.size() != 0 && st.peek() == ']') {
                        st.pop();
                    } else {
                        flag = 1;
                    }
                    break;
                    
                    case ')': 
                    if (st.size() != 0 && st.peek() == '(') {
                        st.pop();
                    } else {
                        flag = 1;
                    }
                    break;

                    default: st.push(ch);
                }

                if (flag == 1) {
                    break;
                }
            }

        }

    public static void main(String args[]) {

        solve("{[()]}");
    }
}