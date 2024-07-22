package multiThread;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Print {
    private static int state = 0;
    private static final Object lock = new Object();
    public static void printSynchronized() {

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 0) {
                                lock.wait();
                            }
                            System.out.println("Thread A" + i);
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 1) {
                                lock.wait();
                            }
                            System.out.println("Thread B" + i);
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        synchronized (lock) {
                            while (state % 3 != 2) {
                                lock.wait();
                            }
                            System.out.println("Thread C" + i);
                            state++;
                            lock.notifyAll();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static void printReentrantLock() {
        state = 0;
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition conditionA = reentrantLock.newCondition();
        Condition conditionB = reentrantLock.newCondition();
        Condition conditionC = reentrantLock.newCondition();

        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        try {
                            reentrantLock.lock();
                            while (state % 3 != 0) {
                                conditionA.await();
                            }

                            System.out.println("Thread A" + i);
                            state++;
                            conditionB.signal();
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        try {
                            reentrantLock.lock();
                            while (state % 3 != 1) {
                                conditionB.await();
                            }

                            System.out.println("Thread B" + i);
                            state++;
                            conditionC.signal();
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });


        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 100; i++) {
                        try {
                            reentrantLock.lock();
                            while (state % 3 != 2) {
                                conditionC.await();
                            }

                            System.out.println("Thread C" + i);
                            state++;
                            conditionA.signal();
                        } finally {
                            reentrantLock.unlock();
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public static void printCompleteFuture() {
        for (int i = 0 ; i < 10; i++) {
            CompletableFuture<Void> futureA = CompletableFuture.runAsync(() -> {
                System.out.println("Thread A");
            }).thenRunAsync(() -> {
                System.out.println("Thread B" );
            }).thenRunAsync(() -> {
                System.out.println("Thread C");
            });

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //printSynchronized();
        //printReentrantLock();
        printCompleteFuture();
    }
}
