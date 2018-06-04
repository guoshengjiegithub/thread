package com.thread.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SyncTest {

	public void test1(){
		synchronized (this) {
			for(int i=0;i<10;i++){
				log.info("i : {}",i);
			}
		}
	}
	
	public synchronized void test2(){
			for(int i=0;i<10;i++){
				log.info("i : {}",i);
			}
	}
	
	public static void main(String[] args) {
		final SyncTest syncTest1=new SyncTest();
		final SyncTest syncTest2=new SyncTest();
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				syncTest1.test2();
			}
		});
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				syncTest2.test2();
			}
		});
	}
}
