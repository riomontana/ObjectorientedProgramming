package sound;

import java.util.LinkedList;

class RunOnThreadN {
    private Buffer<Runnable> buffer = new Buffer<Runnable>();
    private LinkedList<Worker> workers;
    private int n;
    private int running = 0;

    public RunOnThreadN(int n) {
        this.n = n;
    }

    public void start() {
        Worker worker;
        if(workers==null) {
            workers = new LinkedList<Worker>();
            for(int i=0; i<n; i++) {
                worker = new Worker(Thread.NORM_PRIORITY);
                worker.setName("PP"+i);
                worker.start();
                workers.add(worker);
            }
        }
    }

    private synchronized void incRunning() {
        running++;
    }

    private synchronized void decRunning() {
        running--;
    }

    public synchronized int getRunning() {
        return running;
    }

    public synchronized void execute(Runnable runnable) {
//        System.out.println("ROTN.execute, " + Thread.currentThread() +", " + runnable);
//        System.out.println(exec.toString() + " to exec-buffer");
        if(getRunning()<n)
            buffer.put(runnable);
        else
            System.out.println("System busy, too many threads in use");
    }

    public synchronized void stop() {
        // Arbetsuppgifter i buffert utförs ej
        if(workers!=null) {
            buffer.clear();
            for(Worker worker : workers) {
                worker.interrupt();
            }
            workers = null;
        }
    }

    private class Worker extends Thread {
        public Worker (int priority) {
            setPriority(priority);
        }

        public void run() {
            Runnable runnable=null;
            while(!Thread.interrupted()) {
                try {
                    runnable = buffer.get();
                    incRunning();
                    try {
                        System.out.println("Thread: " + Thread.currentThread());
                        runnable.run();
                    } catch(Exception e) {}
                    decRunning();
                } catch(InterruptedException e1) {
                    System.out.println(e1);
                    break;
                }
            }
        }
    }

    private class Buffer<T> {
        private LinkedList<T> buffer = new LinkedList<T>();

        public synchronized void put(T obj) {
            buffer.addLast(obj);
            notifyAll();
        }

        public synchronized T get() throws InterruptedException {
            while(buffer.isEmpty()) {
                wait();
            }
            return buffer.removeFirst();
        }

        public synchronized void clear() {
            buffer.clear();
        }
    }
}

