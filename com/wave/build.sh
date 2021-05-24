#!/bin/bash
javac -d . Zygote.java
javah -jni com.wave.Zygote
gcc -fPIC  -I/usr/lib/jvm/java-8-openjdk-amd64/include  -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -shared -o libhello.so  HelloWorld.c 
export LD_LIBRARY_PATH=./:./:./:
java com.wave.Zygote
