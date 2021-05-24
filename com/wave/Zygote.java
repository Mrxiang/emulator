package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;

public class Zygote{
    public native void helloWorld(); // 注意，这个native方法就是调用C语言接口用的

    static{
        System.loadLibrary("hello");  // 这行是调用动态链接库
    }

	public static void main(String[] args){
		System.out.println("Hello, Zygote");
		new Zygote().helloWorld();

	}

}