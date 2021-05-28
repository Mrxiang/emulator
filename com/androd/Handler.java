package com.wave;


public class Handler {
    final Looper mLooper;
    final MessageQueue mQueue;


    public Handler() {
        this( false);
    }

    public Handler( boolean async) {


        mLooper = Looper.myLooper();
        if (mLooper == null) {
            throw new RuntimeException(
                    "Can't create handler inside thread " + Thread.currentThread()
                            + " that has not called Looper.prepare()");
        }
        mQueue = mLooper.mQueue;
    }





    public boolean sendMessage(Message msg ) {
        System.out.println("sendMessage");
        synchronized(mQueue) {

        	msg.target = this;
            mQueue.add(msg);
            System.out.println("唤醒");
            mQueue.notifyAll();
        }
        return true;
    }

    public void handleMessage(Message msg) {
    }
    public void dispatchMessage(Message msg) {
        System.out.println("dispatchMessage");

            handleMessage(msg);

    }
}
