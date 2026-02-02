#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
// a
const int process_count = 10;
int main() {
	for (int i = 0; i < process_count; i++) {
		int pid = fork();
		if (pid == 0) {
			// b
			int left_bound = 1 + i * 100;
			int right_bound = (i + 1) * 100;
			int sum = 0;
			for (int j = left_bound; j <= right_bound; j++)
				sum = sum + j;
			printf("La somme de %d à %d est %d (pid=%d)\n", left_bound,
				   right_bound, sum, getpid());
			sleep(3);
			exit(0);
		} else {
			printf("Child process %d\n", pid);
		}
	}
	for (int i = 0; i < process_count; i++) {
		pid_t pid = wait(NULL);
		printf("End of child process %d\n", pid);
	}
	printf("End of all child processes\n");
}