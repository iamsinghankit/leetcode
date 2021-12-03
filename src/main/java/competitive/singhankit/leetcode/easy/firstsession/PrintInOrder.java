package competitive.singhankit.leetcode.easy.firstsession;

/**
 * Suppose we have a class:
 * <p>
 * public class Foo {
 * public void first() { print("first"); }
 * public void second() { print("second"); }
 * public void third() { print("third"); }
 * }
 * The same instance of Foo will be passed to three different threads. Thread A will call first(), thread B will call second(), and thread C will call third(). Design a mechanism and modify the program to ensure that second() is executed after first(), and third() is executed after second().
 * <p>
 * Note:
 * <p>
 * We do not know how the threads will be scheduled in the operating system, even though the numbers in the input seem to imply the ordering. The input format you see is mainly to ensure our tests' comprehensiveness.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,2,3]
 * Output: "firstsecondthird"
 * Explanation: There are three threads being fired asynchronously. The input [1,2,3] means thread A calls first(), thread B calls second(), and thread C calls third(). "firstsecondthird" is the correct output.
 *
 * @author _singhankit
 */
public class PrintInOrder{
    public static void main(String[] args) {
        Foo foo=new Foo();
        Thread t1= new Thread(() -> {
            try {
                foo.first(() -> System.out.println("first"));
            } catch (InterruptedException ex) {
            }
        });
        Thread t2= new Thread(()->{
            try {
                foo.second(() -> System.out.println("second"));
            } catch (InterruptedException ex) {
            }
        });
        Thread t3= new Thread(() -> {
            try {
                foo.third(() -> System.out.println("third"));
            } catch (InterruptedException ex) {
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
    class Foo {

        boolean secondflag = false;
        boolean firstFlag = false;

        public Foo() {

        }

        public void first(Runnable printFirst)throws InterruptedException {
            synchronized (this) {
                printFirst.run();
                firstFlag = true;
                this.notifyAll();
            }
        }

        public void second(Runnable printSecond) throws InterruptedException {
            synchronized (this) {
                while (!firstFlag)
                    this.wait();
                printSecond.run();
                this.secondflag = true;
                this.notifyAll();
            }
        }

        public void third(Runnable printThird) throws InterruptedException {
            synchronized (this) {
                while (!secondflag)
                    this.wait();
                printThird.run();
            }
        }
    }