package com.zad.excellence.practice.basic.deadlock;

public class SynchronizedTaskDeadlockCauseExample
{
        public static void main(String args[]) throws InterruptedException
        {
                CustomResource resource1 = new CustomResource("resource1");
                CustomResource resource2 = new CustomResource("resource2");
                CustomResource resource3 = new CustomResource("resource3");
                SynchronizedTaskDeadlockCauseExample instance = new SynchronizedTaskDeadlockCauseExample();
                instance.verifySynchronizedTaskDeadlockCause(resource1, resource2, resource3);
        }

        private void verifySynchronizedTaskDeadlockCause(Object resource1, Object resource2, Object resource3) throws InterruptedException
        {
                Thread thread1 = new Thread(new SynchronizedRunnableTask(resource1, resource2), "Task1");
                Thread thread2 = new Thread(new SynchronizedRunnableTask(resource2, resource3), "Task2");
                Thread thread3 = new Thread(new SynchronizedRunnableTask(resource3, resource1), "Task3");
                thread1.start();
                Thread.sleep(500);
                thread2.start();
                Thread.sleep(500);
                thread3.start();
        }
}
