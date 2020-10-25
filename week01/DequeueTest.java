import java.util.*;

public class DequeueTest {
    public static void main(String[] args) {
        test1(); // Old version
        test2(); // New API version
    }

    static void test1() {
        System.out.println("--------TEST 1--------");
        Deque<String> deque = new LinkedList<String>();

        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);

        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);

        System.out.println("--------END--------");
    }

    static void test2() {
        System.out.println("--------TEST 2--------");
        Deque<String> deque = new LinkedList<String>();
        
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        
        while (deque.size() > 0) {
        System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
        
        System.out.println("--------END--------");
    }
    
}

