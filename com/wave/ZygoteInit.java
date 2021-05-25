package com.wave;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.lang.Thread;
import java.lang.Exception;

public class ZygoteInit{

    public native void helloWorld(); // 注意，这个native方法就是调用C语言接口用的

//     static{
//         System.loadLibrary("hello");  // 这行是调用动态链接库
//     }
    static void preload( ) {
          preloadSharedLibraries();
    }
    private static void preloadSharedLibraries() {
            System.out.println("Preloading shared libraries...");
            System.loadLibrary("android");
            System.out.println("loading over...");


//             System.loadLibrary("compiler_rt");
//             System.loadLibrary("jnigraphics");
    }
	public static void main(String[] args){
		System.out.println("Hello, ZygoteInit");
		ZygoteServer zygoteServer = new ZygoteServer();

        preload();
		Zygote.forkSystemServer();

        String abiList = null;
        zygoteServer.runSelectLoop(abiList);
	}


}