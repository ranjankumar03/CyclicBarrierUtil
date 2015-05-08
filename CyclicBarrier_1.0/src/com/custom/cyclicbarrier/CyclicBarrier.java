package com.custom.cyclicbarrier;


/**
 * @author Ranjan Kumar
 * @description New CyclicBarrier is created where parties number of thread wait for each other to reach common 
 * barrier point,when all threads have reached common barrier point, parties number of waiting threads are released
 * and barrierAction (event) is triggered.
 */
public class CyclicBarrier {
	final int initialParties;
	int partiesAwait;
	final Runnable cyclicBarrierEvent;

	public CyclicBarrier(int initialParties, CyclicBarrierEvent cyclicBarrierEvent2) {
		// TODO Auto-generated constructor stub
		this.initialParties = initialParties;
		this.partiesAwait = initialParties;
		this.cyclicBarrierEvent = cyclicBarrierEvent2;
	}

	public synchronized void await() throws InterruptedException{
		partiesAwait--;
		//If the current thread is not the last to arrive, thread will wait
		if (partiesAwait > 0)
			this.await();//Main Thread put on wait
		else {
			partiesAwait = initialParties;
			notifyAll();

			cyclicBarrierEvent.run();

		}

	}

}
