package com.mukundmadhav.springboot.springboot;

import java.util.PriorityQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadTest {
    static Thread t1=null,t2=null;
    public static void main(String[] args) {

        char[] a = "12345".toCharArray();
        char[] b = "ABCDE".toCharArray();
        t1 = new Thread(()->{
            for (char c : a) {
                System.out.println(c);
                LockSupport.park();
                LockSupport.unpark(t2);
            }
        });
        t2=new Thread(()->{
            for (char c : b) {
                System.out.println(c);
                LockSupport.unpark(t1);
                LockSupport.park();
            }
        });
        t1.start();
        t2.start();

    }
    public static void main2(String[] args) {
        PriorityQueue pq = new PriorityQueue();
        pq.add(3);
        pq.add(1);
        pq.add(2);
        for (int i = 0; i < 3; i++) {
            System.out.println(pq.poll());
        }
    }
    public static void main1(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        lock.lock();
        lock.unlock();

        byte[] bytes = "customer_resource_browse".getBytes();
        System.out.println(bytes);
        System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> submit = executorService.submit(new MyCall());
        try {
            String s = submit.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();

        FutureTask f=new FutureTask(new MyCall());

    }

    public static class MyCall implements Callable<String>{
        @Override
        public String call() throws Exception {
            return "hi call";
        }
    }


}
