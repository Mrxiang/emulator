all: run

Zygote.class: com/wave/Zygote.java
	javac com/wave/Zygote.java

app_process: app_process.c
	gcc -D__int64="long long" -I/usr/lib/jvm/java-8-openjdk-amd64/include  -I/usr/lib/jvm/java-8-openjdk-amd64/include/linux -o app_process app_process.c  -L/usr/lib/jvm/java-8-openjdk-amd64/jre/lib/amd64/server -ljvm

run: Zygote.class app_process
	./app_process

clean:
	rm -f com/wave/*.class app_process