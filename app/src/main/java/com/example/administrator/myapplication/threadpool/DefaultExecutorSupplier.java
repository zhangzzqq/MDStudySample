//package com.example.administrator.mdapplication.threadpool;
//
//import java.util.concurrent.Executor;
//import java.util.concurrent.LinkedBlockingQueue;
//import java.util.concurrent.ThreadFactory;
//import java.util.concurrent.ThreadPoolExecutor;
//import java.util.concurrent.TimeUnit;
//
///**
// * Created by steven on 2018/1/2.
// */
//
///*
//* 一个executor单例
//*/
//public class DefaultExecutorSupplier{
//    /*
//    * 核心线程数量
//    */
//    public static final int NUMBER_OF_CORES = Runtime.getRuntime().availableProcessors();
//
//    /*
//    * 后台任务Executor
//    */
//    private final ThreadPoolExecutor mForBackgroundTasks;
//    /*
//    * 轻量级后台任务Executor
//    */
//    private final ThreadPoolExecutor mForLightWeightBackgroundTasks;
//    /*
//    * 主线程任务Executor
//    */
//    private final Executor mMainThreadExecutor;
//    /*
//    * DefaultExecutorSupplier单例对象
//    */
//    private static DefaultExecutorSupplier sInstance;
//
//    /*
//    * 返回一个DefaultExecutorSupplier单例
//    */
//    public static DefaultExecutorSupplier getInstance() {
//        if (sInstance == null) {
//            synchronized (DefaultExecutorSupplier.class) {
//                sInstance = new DefaultExecutorSupplier();
//            }
//        }
//        return sInstance;
//    }
//
//    /*
//    * DefaultExecutorSupplier构造函数
//    */
//    private DefaultExecutorSupplier() {
//
//            // 设置线程工厂对象
//            ThreadFactory backgroundPriorityThreadFactory = new
//                    PriorityThreadFactory(Process.THREAD_PRIORITY_BACKGROUND);
//
//            // 初始化mForBackgroundTasks
//            mForBackgroundTasks = new ThreadPoolExecutor(
//                    NUMBER_OF_CORES * 2,
//                    NUMBER_OF_CORES * 2,
//                    60L,
//                    TimeUnit.SECONDS,
//                    new LinkedBlockingQueue<Runnable>(),
//                    backgroundPriorityThreadFactory
//            );
//
//            // 初始化mForLightWeightBackgroundTasks
//            mForLightWeightBackgroundTasks = new ThreadPoolExecutor(
//                    NUMBER_OF_CORES * 2,
//                    NUMBER_OF_CORES * 2,
//                    60L,
//                    TimeUnit.SECONDS,
//                    new LinkedBlockingQueue<Runnable>(),
//                    backgroundPriorityThreadFactory
//            );
//
//            // 初始化mMainThreadExecutor
//            mMainThreadExecutor = new MainThreadExecutor();
//    }
//
//    /*
//    * 返回后台任务Executor
//    */
//    public ThreadPoolExecutor forBackgroundTasks() {
//        return mForBackgroundTasks;
//    }
//
//    /*
//    * 返回轻量级的Executor
//    */
//    public ThreadPoolExecutor forLightWeightBackgroundTasks() {
//        return mForLightWeightBackgroundTasks;
//    }
//
//    /*
//    * 返回主线程Executor
//    */
//    public Executor forMainThreadTasks() {
//        return mMainThreadExecutor;
//    }
//
//}
