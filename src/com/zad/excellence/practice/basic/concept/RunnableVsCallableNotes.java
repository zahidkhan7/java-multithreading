package com.zad.excellence.practice.basic.concept;

/*
 Some Basic notes for Runnable and Callable Interface taken from 
 https://howtodoinjava.com/java/multi-threading/java-runnable-vs-callable/
 
 */
public class RunnableVsCallableNotes {

/*
	Runnable is a core interface and it can be implemented by a class.
	Callable is a also core interface and it can be implemented by a class.
	
	We can execute Runnable implementing instances as a Thread or submit to ExecutorService.
	This interface contains only one abstract method run(), which we must override to define the Thread�s job.
	
	But, We can only execute Callable implementing instances via ExecutorService and not by the traditional Thread class. 
	It contains one abstract method call() which should contain the business logic to be executed by the ExecutorService. 
	
	Runnable and Callable both are FunctionalInterface:
	
	Sample Example For Runnable and Callable: 
	
	@FunctionalInterface
	public interface Runnable {
    	public abstract void run();
	}
	
	@FunctionalInterface
	public interface Callable<V> {
    	V call() throws Exception;
	}
	 
*/
	

}
