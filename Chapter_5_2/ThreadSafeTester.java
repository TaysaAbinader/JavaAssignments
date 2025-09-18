package Chapter_5_2;

public class ThreadSafeTester {

    public static void main(String[] args) {
        ArrayListManager shoppinglist = new ArrayListManager();
        
        Thread thread1 = new Thread(() -> {
            long threadId = Thread.currentThread().threadId();
            shoppinglist.queryManagedArray(threadId);
            shoppinglist.addElement(threadId, "bread");
            shoppinglist.addElement(threadId, "soap");
            shoppinglist.addElement(threadId, "milk");
            shoppinglist.addElement(threadId, "tomato");
            shoppinglist.addElement(threadId, "shampoo");
            shoppinglist.queryManagedArray(threadId);
        });

        Thread thread2 = new Thread(() -> {
            long threadId = Thread.currentThread().threadId();
            shoppinglist.queryManagedArray(threadId);
            shoppinglist.addElement(threadId, "bread");
            shoppinglist.addElement(threadId, "butter");
            shoppinglist.queryManagedArray(threadId);
        });

        Thread thread3 = new Thread(() -> {
            long threadId = Thread.currentThread().threadId();
            shoppinglist.queryManagedArray(threadId);
            shoppinglist.removeElement(threadId, "bread");
            shoppinglist.removeElement(threadId, "milk");
            shoppinglist.queryManagedArray(threadId);
        });

        Thread thread4 = new Thread(() -> {
            long threadId = Thread.currentThread().threadId();
            shoppinglist.queryManagedArray(threadId);
            shoppinglist.removeElement(threadId, "tomato");
            shoppinglist.removeElement(threadId, "soap");
            shoppinglist.queryManagedArray(threadId);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e){
            System.err.println(e);
        }
    }
}
