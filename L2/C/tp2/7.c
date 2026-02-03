#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
#define N 3
void init_processus_fils() {
	while (1) {
		sleep(1);
	}
}
int main() {
	int t[N];
	int paused[N];
	for (int i = 0; i < N; i++) {
		int pid = fork();
		if (pid == 0)
			init_processus_fils();
		t[i] = pid;
	}
	int r;
	int statut;
	do {
		printf("Processus fils : ");
		for (int i = 0; i < N; i++) {
			if (i > 0) {
				printf("; ");
			}
			if (paused[i] == 1) {
				printf("%d paused", t[i]);
			} else {
				printf("%d active", t[i]);
			}
		}
		printf("\n");
		r = waitpid(-1, &statut, WSTOPPED | WCONTINUED);
		printf(" ... waitpid a retourné %d\n\n", r);
		if (r != -1) {
			int process_index = 0;
			int found = 0;
			while (process_index < N && !found) {
				if (r == t[process_index]) {
					found = 1;
				} else {
					process_index = process_index + 1;
				}
			}
			if (found) {
				if (WIFSTOPPED(statut)) {
					paused[process_index] = 1;
				} else if (WIFCONTINUED(statut)) {
					paused[process_index] = 0;
				}
			}
		}
	} while (r != -1);
}