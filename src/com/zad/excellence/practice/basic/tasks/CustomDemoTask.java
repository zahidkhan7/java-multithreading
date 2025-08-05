package com.zad.excellence.practice.basic.tasks;

public class CustomDemoTask implements Runnable
{
        private String name = null;

        public CustomDemoTask(String name)
        {
                this.name = name;
        }

        public String getName()
        {
                return this.name;
        }

        @Override
        public void run()
        {
                try
                {
                        Thread.sleep(5000);
                } catch (InterruptedException e)
                {
                        e.printStackTrace();
                }
                System.out.println("Executing : " + name);
        }
}
