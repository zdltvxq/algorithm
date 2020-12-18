package com.mukundmadhav.springboot.springboot;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    public static class Node {
        int data;
        Node next;
        Node(int dt){
            this.data=dt;
        }
    }

    public static Node reverse(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node cur = head;
        Node pre = null;
        Node rst = null;
        while(cur != null){
            Node next = cur.next;
            if(next==null){
                rst=cur;
            }
            cur.next=pre;
            pre=cur;
            cur=next;
        }
        return rst;
    }

    public static void main(String[] args) {
        Node head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        head.next.next.next=new Node(4);
        head.next.next.next.next=new Node(5);

        Node rst = reverse(head);
        System.out.println(rst);
    }
    public static void main1(String[] args) {
        Integer i1 = 100;
        Integer i2 = 50 + 50;
        Integer i3 = 200;
        Integer i4 = 200;

        System.out.println(i1 == i2);
        System.out.println(i3 == i4);
        System.out.println(i1.equals(i2) + " " + i3.equals(i4));
    }

    /**
     * Java 程序通过强制循环等待来创建死锁。 * *
     */
    public class DeadLockDemo {
        /*     * 此方法请求两个锁,第一个字符串,然后整数     */
        public void method1() {
            synchronized (String.class) {
                System.out.println("Aquired lock on String.class object");
                synchronized (Integer.class) {
                    System.out.println("Aquired lock on Integer.class object");
                }
            }
        }

        /**
         * * 此方法也请求相同的两个锁,但完全
         * * 相反的顺序,即首先整数,然后字符串。
         * * 如果一个线程持有字符串锁,则这会产生潜在的死锁
         * * 和其他持有整数锁,他们等待对方,永远。
         **/
        public void method2() {
            synchronized (Integer.class) {
                System.out.println("Aquired lock on Integer.class object");
                synchronized (String.class) {
                    System.out.println("Aquired lock on String.class object");
                }
            }
        }

    }

    public static void main2(String[] args) {
        String uid="abc";
        System.out.println(1);
    }
}
