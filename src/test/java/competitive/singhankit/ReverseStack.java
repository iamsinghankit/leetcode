package competitive.singhankit;

import java.util.Stack;

/**
 * Input : 1->2->3->4
 * Output : 4->3->2->1
 *
 * @author _singhankit
 */
public class ReverseStack {
    static Stack<Integer> st = new Stack<>();

    public static void main(String[] args) {
       // Stack<Integer> stack = new Stack();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        System.out.println(st);
        reverse();
        System.out.println(st);
    }

    static void insert_at_bottom(int x) {
        if (st.isEmpty())
            st.push(x);
        else {
            int a=st.pop();
            insert_at_bottom(x);
            st.push(a);
        }
    }


    static void reverse() {
        if(st.isEmpty()){
            return;
        }
        Integer el = st.pop();
        reverse();
        insert_at_bottom(el);
    }

}
