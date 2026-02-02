#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#define N 10
#define NS_ATTENTE 500000000
struct timespec attente = {0, NS_ATTENTE};
void compter(int n) {
	for (int i = 1; i <= n; i++) {
		nanosleep(&attente, 0);
		printf("%d/%d (pid=%d)\n", i, n, getpid());
		fflush(stdout);
	}
}
int main(int argc, char* argv[]) {
	if (argc != 3) {
		printf("Veuillez entrer 2 entiers positifs en arguments\n");
		exit(-1);
	}
	int x = atoi(argv[1]);
	int y = atoi(argv[2]);
	if (x <= 0 || y <= 0) {
		printf("Veuillez entrer 2 entiers positifs en arguments\n");
		exit(-1);
	}
	pid_t pid = fork();
	if (pid == -1) {
		exit(-1);
	}
	if (pid == 0) {
		printf("Parent process %d\n", getppid());
		compter(y);
	} else {
		printf("Child process %d\n", pid);
		compter(x);
		wait(NULL);
		printf("End of parent process\n");
	}
}