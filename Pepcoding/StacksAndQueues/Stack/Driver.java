public class Driver {

    public static void main(String[] args) {
        MinStack st = new MinStack();
        st.push(512);
        st.push(-1024);
        st.push(-1024);
        st.push(512);

        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
        st.pop();
        System.out.println(st.getMin());
    }
}