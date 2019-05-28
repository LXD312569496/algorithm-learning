package array;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 生产者和消费者
 */
public class ProducerAndConsumer {
    public static void main(String[] args) {
//        ArrayBlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue(5);
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    blockingQueue.put(10);
//                    blockingQueue.put(11);
//                    blockingQueue.put(12);
//                    blockingQueue.put(13);
//                    blockingQueue.put(14);
//                    System.out.println("111");
//                    blockingQueue.put(15);
//                    System.out.println("222");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                    blockingQueue.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();


        final Object lock = new Object();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread A is waiting to get lock");
                synchronized (lock) {
                    try {
                        System.out.println("thread A get lock");
                        TimeUnit.SECONDS.sleep(1);
                        System.out.println("thread A do wait method");
                        lock.wait();
                        System.out.println("wait end");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread B is waiting to get lock");
                synchronized (lock) {
                    System.out.println("thread B get lock");
                    try {
                        TimeUnit.SECONDS.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    lock.notify();
                    System.out.println("thread B do notify method");
                }
            }
        }).start();

    }

    /**
     * 利用wait和notify进行实现
     */
    class Storag{
        private int MAX_COUNT=10;

        private LinkedList<Object> list=new LinkedList<>();

        public void produce(){
            synchronized (list){
                if (list.size()==MAX_COUNT){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.add(new Object());

                list.notifyAll();
            }
        }

        public void consume(){
            synchronized (list){
                if (list.size()==0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                list.remove();
                list.notifyAll();
            }
        }

    }


}
