package com.example.ktrxvm

import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger

/**
 * Created by Niklaus on 2017/9/5.
 */
object JobExecutor {
    private val CPU_COUNT = Runtime.getRuntime().availableProcessors()
    private val CORE_POOL_SIZE = CPU_COUNT + 1
    private val MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1
    private val KEEP_ALIVE = 1
    var eventExecutor: ExecutorService
    private val eventPoolWaitQueue = LinkedBlockingQueue<Runnable>(128)

    private val eventHandler = ThreadPoolExecutor.CallerRunsPolicy()

    private val eventThreadFactory = object : ThreadFactory {
        private val mCount = AtomicInteger(1)

        override fun newThread(r: Runnable): Thread {
            return Thread(r, "Job #" + mCount.getAndIncrement())
        }
    }

    init {
        eventExecutor = ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, KEEP_ALIVE.toLong(), TimeUnit.SECONDS,
                eventPoolWaitQueue, eventThreadFactory, eventHandler)
    }
}