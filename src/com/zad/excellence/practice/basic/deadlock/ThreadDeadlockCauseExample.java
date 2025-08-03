package com.zad.excellence.practice.basic.deadlock;

/*
	 Sample Example Taken From:
	 https://www.developer.com/java/java-prevent-thread-deadlock/
 */
public class ThreadDeadlockCauseExample
{
        public static Object lockObjectA = new Object();
        public static Object lockObjectB = new Object();

        public static void main(String[] args)
        {
                ThreadClassA threadInstanceA = new ThreadClassA();
                ThreadClassB threadInstanceB = new ThreadClassB();
                threadInstanceA.start();
                threadInstanceB.start();
        }

        private static class ThreadClassA extends Thread
        {
                @Override
                public void run()
                {
                        synchronized (lockObjectA)
                        {
                                System.out.println("Thread A: Acquired lock A");
                                try
                                {
                                        Thread.sleep(1000);
                                } catch (Exception ex)
                                {
                                }
                                System.out.println("Thread A: Waiting for lock B");
                                synchronized (lockObjectB)
                                {
                                        System.out.println("Thread A: Acquired lock on A and B");
                                }
                        }
                }
        }

        private static class ThreadClassB extends Thread
        {
                @Override
                public void run()
                {
                        synchronized (lockObjectB)
                        {
                                System.out.println("Thread B: Acquired lock B");
                                try
                                {
                                        Thread.sleep(100);
                                } catch (Exception ex)
                                {
                                }
                                System.out.println("Thread B: Waiting for lock A");
                                synchronized (lockObjectA)
                                {
                                        System.out.println("Thread B: Acquired lock on A and B");
                                }
                        }
                }
        }
}
