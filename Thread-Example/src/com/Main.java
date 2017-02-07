package com;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String args[]) {

		// threadRunType_1();
		// threadRunType_2();
		// threadRunType_3();
		// threadRunType_4();
		// threadRunType_5();
		// threadRunType_6();
	}

	/**
	 * 继承Thread实现线程
	 */
	public static void threadRunType_1() {

		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 30) {

				// 创建一个新的线程myThread1,此线程进入新建状态
				Thread myThread1 = new MyThread();

				// 创建一个新的线程myThread2,此线程进入新建状态
				Thread myThread2 = new MyThread();

				// 调用start()方法使得线程进入就绪状态
				myThread1.start();

				// 调用start()方法使得线程进入就绪状态
				myThread2.start();
			}
		}
	}

	/**
	 * 实现接口Runnable的方式实现线程
	 */
	public static void threadRunType_2() {

		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 30) {

				// 创建一个Runnable实现类的对象
				Runnable myRunnable = new MyRunnable();

				// 将myRunnable作为Thread的target创建新的线程
				Thread thread1 = new Thread(myRunnable);
				Thread thread2 = new Thread(myRunnable);

				// 调用start()方法使得线程进入就绪状态
				thread1.start();
				thread2.start();
			}
		}
	}

	/**
	 * 用FutureTask实现线程
	 */
	public static void threadRunType_3() {

		// 创建MyCallable对象
		Callable<Integer> myCallable = new MyCallable();

		// 使用FutureTask来包装MyCallable对象
		FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);

		for (int i = 0; i < 200; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);

			if (i == 30) {

				// FutureTask对象作为Thread对象的target创建新的线程
				Thread thread = new Thread(ft);

				// 线程进入到就绪状态
				thread.start();
			}
		}

		System.out.println("主线程for循环执行完毕..");

		try {

			// 取得新创建的新线程中的call()方法返回的结果,get会导致使用这个方法的线程阻塞,直到子线程执行完毕才会执行后面的代码
			int sum = ft.get();
			System.out.println("sum = " + sum);

		} catch (InterruptedException e) {

			e.printStackTrace();

		} catch (ExecutionException e) {

			e.printStackTrace();
		}

		System.out.println("-= End =-");
	}

	/**
	 * 信号量使用示例
	 */
	public static void threadRunType_4() {

		// 信号量初始化
		Semaphore semaphore = new Semaphore(0);

		// 第一个线程
		RunnableThread.Start(() -> {

			System.out.println("RunnableThread 1 start");

			// 休眠1秒钟
			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println("RunnableThread 1 end");

			// 释放一个信号量
			semaphore.release(1);
		});

		// 第二个线程
		RunnableThread.Start(() -> {

			System.out.println("RunnableThread 2 start");

			// 休眠3秒钟
			try {

				Thread.sleep(3000);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println("RunnableThread 2 end");

			// 释放一个信号量
			semaphore.release(1);
		});

		// 第三个线程
		RunnableThread.Start(() -> {

			System.out.println("RunnableThread start");

			// 信号量进行阻塞
			try {

				semaphore.acquire(2);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			System.out.println("RunnableThread end");
		});
	}

	/**
	 * synchronized的使用
	 */
	public static void threadRunType_5() {

		PrintDemo demo = new PrintDemo();

		RunnableThread.Start(() -> {

			System.out.println("线程1 开始");
			synchronized (demo) {

				demo.printCount();
			}

			System.out.println("线程1 结束");
		});

		RunnableThread.Start(() -> {

			System.out.println("线程2 开始");
			synchronized (demo) {

				demo.printCount();
			}

			System.out.println("线程2 结束");
		});
	}

	/**
	 * wait 与 notify 的使用
	 */
	public static void threadRunType_6() {

		ChatDemo chatDemo = new ChatDemo();

		// 提问题
		RunnableThread.Start(() -> {

			chatDemo.Question("How old are you ?");
		});

		// 延时1秒后回答
		RunnableThread.Start(() -> {

			try {

				Thread.sleep(1000);

			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			chatDemo.Answer("18.");
		});
	}
}

class MyThread extends Thread {

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

class MyRunnable implements Runnable {

	@Override
	public void run() {

		for (int i = 0; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);
		}
	}
}

class MyCallable implements Callable<Integer> {

	private int i = 0;

	// 与run()方法不同的是，call()方法具有返回值
	@Override
	public Integer call() {

		int sum = 0;
		for (; i < 100; i++) {

			System.out.println(Thread.currentThread().getName() + " " + i);
			sum += i;
		}

		return sum;
	}
}

class RunnableThread {

	public static void Start(Runnable runnable) {

		if (runnable != null) {

			Thread thread = new Thread(runnable);
			thread.start();
		}
	}

	public static void Start(Runnable runnable, String name) {

		if (runnable != null) {

			Thread thread = new Thread(runnable, name);
			thread.start();
		}
	}
}

class PrintDemo {

	public void printCount() {

		try {

			for (int i = 15; i > 0; i--) {

				System.out.println(String.format("Counter  ---  %d", i));
			}

		} catch (Exception e) {

			System.out.println("Thread interrupted.");
		}
	}
}

class ChatDemo {

	String answer = "";

	public synchronized void Question(String string) {

		System.out.println(string);

		try {

			// 阻塞了
			wait();

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

		System.out.println(answer);
	}

	public synchronized void Answer(String string) {

		this.answer = string;

		// 通知
		notify();
	}
}
