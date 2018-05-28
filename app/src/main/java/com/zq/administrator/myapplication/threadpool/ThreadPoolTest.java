package com.zq.administrator.myapplication.threadpool;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.zq.administrator.mdapplication.R;
import com.zq.administrator.myapplication.BaseActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by steven on 2018/1/2.
 * <p>
 * ThreadPoolExecutor-->AbstractExecutorService-->ExecutorService-->Executor
 */

public class ThreadPoolTest extends BaseActivity {

    private static final String TAG = "ThreadPoolTest";

    private TextView tvTest;
    private PausableThreadPoolExecutor pausableThreadPoolExecutor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        tvTest = (TextView) findViewById(R.id.tv_test);

        /**
         * 创建一定数量的线程
         * 该方法返回一个固定线程数量的线程池，该线程池中的线程数量始终不变，
         * 即不会再创建新的线程，也不会销毁已经创建好的线程
         */

//        newFixedThreadPool ();

        /**
         * 只创建一个（单个）线程
         */
//        newSingleThreadExecutor();

        /**
         * CachedThreadPool只有非核心线程，最大线程数非常大，所有线程都活动时，会为新任务创建新线程，
         * 否则利用空闲线程（60s空闲时间，过了就会被回收，所以线程池中有0个线程的可能）处理任务。
         *
         *   为了体现该线程池可以自动根据实现情况进行线程的重用，而不是一味的创建新的线程去处理任务
         */

//        newCachedThreadPool();

        /**
         * 有延迟执行和周期重复执行的线程池
         *
         *  核心线程数固定，非核心线程（闲着没活干会被立即回收）数没有限制。
         *
         *  从上面代码也可以看出，ScheduledThreadPool主要用于执行定时任务以及有固定周期的重复任务。
         *
         *
         */
//        newScheduledThreadPool();

        /**
         * 自定义线程池
         *
         * 具有优先级
         */

//        customThreadPool();

        /**
         *
         * 有暂停功能
         */

//        functionPauseThreadPool();


        /**
         * 优先级测试
         */

    }


    private void functionPauseThreadPool() {
        pausableThreadPoolExecutor = new PausableThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
        for (int i = 1; i <= 100; i++) {
            final int priority = i;
            pausableThreadPoolExecutor.execute(new PriorityRunnable(priority) {
                @Override
                public void doSth() {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            tvTest.setText(priority + "");
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void customThreadPool() {
        ExecutorService priorityThreadPool = new ThreadPoolExecutor(3, 3, 0L, TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
        for (int i = 1; i <= 10; i++) {
            final int priority = i;
            priorityThreadPool.execute(new PriorityRunnable(priority) {
                @Override
                public void doSth() {
                    String threadName = Thread.currentThread().getName();
                    Log.v("zxy", "线程：" + threadName + ",正在执行优先级为：" + priority + "的任务");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void newScheduledThreadPool() {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        //延迟2秒后执行该任务
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                Log.v("zxy", "线程_a：" + threadName + ",正在执行");
            }
        }, 2, TimeUnit.SECONDS);
        //延迟1秒后，每隔2秒执行一次该任务
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                Log.v("zxy", "线程_b：" + threadName + ",正在执行");
            }
        }, 1, 2, TimeUnit.SECONDS);
    }


    private void newSingleThreadExecutor() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    Log.v("zxy", "线程：" + threadName + ",正在执行第" + index + "个任务");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private void newFixedThreadPool() {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    Log.v("zxy", "线程：" + threadName + ",正在执行第" + index + "个任务");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    private void newCachedThreadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    Log.v("zxy", "线程：" + threadName + ",正在执行第" + index + "个任务");
                    try {
                        long time = index * 500;
                        Thread.sleep(time);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }


    public void btnSwitch(View view) {

        if (pausableThreadPoolExecutor.isPause()) {
            pausableThreadPoolExecutor.resume();
            pausableThreadPoolExecutor.setPaused(false);
        } else {
            pausableThreadPoolExecutor.pause();
            pausableThreadPoolExecutor.setPaused(true);
        }
    }

}
