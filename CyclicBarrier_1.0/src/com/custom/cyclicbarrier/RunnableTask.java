package com.custom.cyclicbarrier;

public class RunnableTask implements Runnable {

	final CyclicBarrier cyclicBarrierObject;

	public RunnableTask(CyclicBarrier cyclicBarrierObject) {
		this.cyclicBarrierObject = cyclicBarrierObject;
	}
	@Override
	public void run() {

		System.out.println(Thread.currentThread().getName() + " is waiting for all other threads to reach common barrier point");

		try {
			Thread.sleep(1000);
			cyclicBarrierObject.await();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(" All threads have reached common barrier point " + Thread.currentThread().getName() + " has been released");
	}

}
