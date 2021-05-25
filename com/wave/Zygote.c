//
// Created by xshx on 2021/5/25.
//

#include "jni.h"
#include "com_wave_Zygote.h"
#include <stdio.h>
#include <stdlib.h>


JNIEXPORT jint JNICALL Java_com_wave_Zygote_nativeForkSystemServer (JNIEnv *env, jobject obj){

    printf("fork \n");
}