package com.thread.test;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
/**
 * 
 * @author Administrator
 *
 */
public class CountDownlatchTest {
	public static void main(String[] args) throws InterruptedException {
		final CountDownLatch countDownLatch = new CountDownLatch(2);
		T1 t1 = new T1(1, countDownLatch);
		T1 t2 = new T1(3, countDownLatch);
		T1 t3 = new T1(7, countDownLatch);
		t1.start();
		t2.start();
		countDownLatch.await(); // 计数不为0时 一直阻塞
		t3.start();
	}

}

class T1 extends Thread {
	private int a;
	private CountDownLatch countDownLatch;

	public T1(int a, CountDownLatch countDownLatch) {
		this.a = a;
		this.countDownLatch = countDownLatch;
	}

	@Override
	public void run() {
		System.out.println("子" + a);
		countDownLatch.countDown();// 计数减一
	}
}



