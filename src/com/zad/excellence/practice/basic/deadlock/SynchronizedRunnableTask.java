package com.zad.excellence.practice.basic.deadlock;

public class SynchronizedRunnableTask implements Runnable
{
        private Object resource1;
        private Object resource2;

        public SynchronizedRunnableTask(Object resource1, Object resource2)
        {
                super();
                this.resource1 = resource1;
                this.resource2 = resource2;
        }

        @Override
        public void run()
        {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " acquiring lock on " + resource1);
                synchronized (resource1)
                {
                        System.out.println(threadName + " acquired lock on " + resource1);
                        work();
                        System.out.println(threadName + " acquiring lock on " + resource2);
                        synchronized (resource2)
                        {
                                System.out.println(threadName + " acquired lock on " + resource2);
                                work();
                        }
                        System.out.println(threadName + " released lock on " + resource2);
                }
                System.out.println(threadName + " released lock on " + resource1);
                System.out.println(threadName + " finished execution.");
        }

        private void work()
        {
                try
                {
                        Thread.sleep(30000);
                } catch (InterruptedException ex)
                {
                        ex.printStackTrace();
                }
        }
}
