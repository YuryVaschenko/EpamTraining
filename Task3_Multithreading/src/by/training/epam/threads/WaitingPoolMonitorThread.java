package by.training.epam.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

import by.training.epam.resourses.WaitingPool;

public class WaitingPoolMonitorThread extends Thread {

	private static Logger log = Logger.getLogger(WaitingPoolMonitorThread.class);
	private final Lock lock = new ReentrantLock();
	WaitingPool pool;

	public WaitingPoolMonitorThread(WaitingPool pool) {
		this.pool = pool;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(3_000);
			} catch (InterruptedException e) {
				log.error(e);
			}

			try {
				lock.lock();
				System.out.println("Pool size = " + pool.getSize());
			} finally {
				lock.unlock();
			}

		}

	}

}
