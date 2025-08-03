package com.zad.excellence.practice.basic.execution;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableVsCallableExample2
{
        public static void main(String[] args)
        {
                RunnableVsCallableExample2 instance = new RunnableVsCallableExample2();
                instance.executeRunnableTaskUsingThreadWithLambdaExpression();
                instance.executeRunnableTaskUsingExecutorServiceWithLambdaExpression();
                instance.executeCallableTaskUsingExecutorServiceWithLambdaExpression();
        }

        private void executeRunnableTaskUsingThreadWithLambdaExpression()
        {
                Runnable runnableTask = () -> {
                        System.out.println("This is Runnable Task with Lambda Expression and executed By Thread");
                };
                Thread runnableThread = new Thread(runnableTask);
                runnableThread.start();
        }

        private void executeRunnableTaskUsingExecutorServiceWithLambdaExpression()
        {
                ExecutorService executorService = Executors.newFixedThreadPool(2);
                executorService.execute(() -> {
                        System.out.println("This is Runnable Task with Lambda Expression and executed By Executor Service");
                        System.out.println("Runnable Task does not return any response");
                }
                );
                executorService.shutdown();
        }

        private void executeCallableTaskUsingExecutorServiceWithLambdaExpression()
        {
                ExecutorService executorService = Executors.newFixedThreadPool(2);
                Callable<String> callableTask = () -> {
                        System.out.println("This is Callable Task with Lambda Expression and executed By Executor");
                        return "Callable";
                };
                Future<String> future = executorService.submit(callableTask);
                try
                {
                        String response = future.get();
                        System.out.println(" The Response received from future : " + response);
                } catch (InterruptedException | ExecutionException e)
                {
                        e.printStackTrace();
                } finally
                {
                        executorService.shutdown();
                }
        }
}
