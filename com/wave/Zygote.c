//
// Created by xshx on 2021/5/25.
//

#include "jni.h"
#include "com_wave_Zygote.h"
#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>



JNIEXPORT jint JNICALL Java_com_wave_Zygote_nativeForkSystemServer (JNIEnv *env, jobject obj){
    printf("fork \n");
    pid_t pid = fork();
    if( pid == 0 ){
        printf("创建了子进程 ID :%d \n",getpid());

        jclass launcher_class;
        jmethodID main_method;
//        launcher_class =(*env)->FindClass(env, "com/wave/Launcher");
        launcher_class =(*env)->FindClass(env, "com/wave/SystemServer");
        main_method =(*env)->GetStaticMethodID(env, launcher_class, "main","([Ljava/lang/String;)V");
        (*env)->CallStaticVoidMethod(env,launcher_class, main_method, NULL);
        if ((*env)->ExceptionCheck(env)) {
            printf("Error calling post fork hooks. \n");
        }
        printf("start launcher.main \n");

    }else {
        printf("这是zygote 进程 ID :%d \n", getpid());
        int status;
        if (waitpid(pid, &status, WNOHANG) == pid) {
            printf("System server process %d has died. Restarting Zygote!", pid);
        }
    }

    return pid;
}