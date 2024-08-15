class CountDownCounter {
    public int count;

    public CountDownCounter(int initial) {
        this.count = initial;
    }

    public synchronized void decrement() {
        count--;
    }

    public synchronized int getCount() {
        return count;
    }
}
