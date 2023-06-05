package corejava;

class Hi1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hi");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
class Hello1 extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}

class Hi2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hi");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
class Hello2 implements Runnable {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Hello");
            try { Thread.sleep(500); } catch(Exception e) {}
        }
    }
}
public class ThreadDemo {
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hi");
                try { Thread.sleep(500); } catch(Exception e) {}
            }
        }, "Hi Thread");
        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Hello");
                try { Thread.sleep(500); } catch(Exception e) {}
            }
        }, "Hello Thread");
        t1.start();
        try { Thread.sleep(10); } catch(Exception e) {}
        t2.start();

        System.out.println(t1.getName());   // print Thread-0, now Hi Thread
        System.out.println(t2.getName());   // print Thread-1, now Hello Thread
        t1.setName("Thread-Hi");
        t2.setName("Thread-Hello");
        System.out.println(t1.getName());   // print Thread-Hi
        System.out.println(t2.getName());   // print Thread-Hello
        System.out.println(t1.getPriority());   // print Thread-0
        System.out.println(t2.getPriority());   // print Thread-1
        t1.setPriority(Thread.MIN_PRIORITY);    // same as t1.setPriority(1);
        t2.setPriority(Thread.MAX_PRIORITY);    // same as t2.setPriority(10);
        t2.setPriority(Thread.NORM_PRIORITY);    // same as t2.setPriority(5);

        System.out.println(t1.isAlive());   // print true
        t1.join();
        t2.join();
        System.out.println(t1.isAlive());   // print false
        System.out.println("Bye");
    }
}
