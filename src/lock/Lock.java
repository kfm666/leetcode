package lock;

import java.util.List;
import java.util.Set;

public interface Lock {
    void lock() throws InterruptedException;
    boolean tryLock(long mils) throws InterruptedException;
    void unlock();
    Set<Thread> getBlockedThread();
}
