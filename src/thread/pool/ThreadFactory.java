package thread.pool;

public interface ThreadFactory {

    /**
     * 创建线程
     * @param runnable
     * @return
     */
    Thread createThread(Runnable runnable);
}
