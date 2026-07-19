import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {

    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftForkId = philosopher;
        int rightForkId = (philosopher + 1) % 5;

        if (philosopher % 2 == 0) {
            forks[leftForkId].lock();
            forks[rightForkId].lock();
        } else {
            forks[rightForkId].lock();
            forks[leftForkId].lock();
        }

        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forks[leftForkId].unlock();
            forks[rightForkId].unlock();
        }
    }
}