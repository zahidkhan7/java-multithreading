package com.zad.excellence.practice.basic.intercommunication;

public class ResourceWaiterTask implements Runnable
{
        private MessageResource message;

        public ResourceWaiterTask(MessageResource message)
        {
                this.message = message;
        }

        @Override
        public void run()
        {
                String threadName = Thread.currentThread().getName();
                synchronized (message)
                {
                        System.out.println(threadName + " waiting to get notified at time:" + System.currentTimeMillis());
                        try
                        {
                                message.wait();
                        } catch (InterruptedException ex)
                        {
                                ex.printStackTrace();
                        }
                        System.out.println(threadName + " waiter thread got notified at time:" + System.currentTimeMillis());
                        // process the message now
                        System.out.println(threadName + " processed: " + message.getMessage());
                }
        }
}
