package com.zad.excellence.practice.basic.intercommunication;

import java.util.Queue;

public class SharedResource {

	private Queue<Integer> sharedBuffer;

	private int bufferSize;

	public Queue<Integer> getSharedBuffer() {
		return sharedBuffer;
	}

	public void setSharedBuffer(Queue<Integer> sharedBuffer) {
		this.sharedBuffer = sharedBuffer;
	}

	public int getBufferSize() {
		return bufferSize;
	}

	public void setBufferSize(int bufferSize) {
		this.bufferSize = bufferSize;
	}

}
