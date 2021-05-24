#include "jni.h"
#include "com_wave_Zygote.h"
#include <stdio.h>
#include <stdlib.h>

JNIEXPORT void JNICALL Java_com_wave_Zygote_helloWorld(JNIEnv * env, jobject obj)
{

          printf("Hello World!\n");

}  

