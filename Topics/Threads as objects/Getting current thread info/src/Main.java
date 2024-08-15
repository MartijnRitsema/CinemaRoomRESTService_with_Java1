class Info {

    public static void printCurrentThreadInfo() {
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.getName();
        int threadPriority = currentThread.getPriority();

        System.out.println("name: " + threadName);
        System.out.println("priority: " + threadPriority);
    }
}
