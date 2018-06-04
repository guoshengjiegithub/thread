package com.thread.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest implements Callable<String>{

	@Override
	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		
		return Thread.currentThread().getName();
	}

	public static void main(String[] args) throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<String> submit = executor.submit(new CallableTest());
		String string = submit.get();
		System.out.println(string);
	}
}
