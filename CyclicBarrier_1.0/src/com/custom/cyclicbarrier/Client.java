package com.custom.cyclicbarrier;

public class Client {

	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(3, new CyclicBarrierEvent());
		System.out.println("CyclicBarrier created with parties=3," + 
		" when all 3 parties will reach common barrier point CyclicBarrrierEvent will be triggered");

		RunnableTask task = new RunnableTask(cyclicBarrier);

		// create threads
		new Thread(task, "Thread-1").start();
		new Thread(task, "Thread-2").start();
		new Thread(task, "Thread-3").start();

	}

}
