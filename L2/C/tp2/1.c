#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#define N 10
#define NS_ATTENTE 500000000  // [0, 999999999]
struct timespec attente = {0, NS_ATTENTE};
int main() {
	// b
	pid_t pid = fork();
	if (pid == -1) {
		exit(-1);
	}
	if (pid == 0) {
		printf("Parent process %d\n", getppid());
	} else {
		printf("Child process %d\n", pid);
	}
	for (int i = 1; i <= N; i++) {
		nanosleep(&attente, 0);
		printf("%d/%d (pid=%d)\n", i, N, getpid());
		fflush(stdout);
	}
}