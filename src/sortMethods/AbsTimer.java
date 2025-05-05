package sortMethods;

/**
 * Abstract class for a timer that measures the elapsed time of an operation.
 * It provides methods to start and stop the timer, and to retrieve the elapsed time in milliseconds.
 */
abstract class AbsTimer {
    private long startTime = 0;
    private long runTimeMillis = 0;
    private boolean used = false;

    public long getRunTimeMillis() {
        if (!used) {
            used = true;
            return runTimeMillis;
        }
        throw new IllegalStateException("Timer has not been started or has already been stopped.");
    }

    protected void stratTimer() {
        startTime = System.currentTimeMillis();
    }

    protected void stopTimer() {
        runTimeMillis = System.currentTimeMillis() - startTime;
        used = false;
    }
}
