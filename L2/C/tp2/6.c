#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
#define N 3
void init_processus_fils() {
	struct sigaction act;
	act.sa_handler = SIG_IGN;
	sigaction(SIGINT, &act, NULL);
	while (1) {
		sleep(1);
	}
}
int main() {
	int t[N];
	for (int i = 0; i < N; i++) {
		int pid = fork();
		if (pid == 0)
			init_processus_fils();
		t[i] = pid;
	}
	printf("Processus fils : ");
	for (int i = 0; i < N; i++) {
		printf("%d ", t[i]);
	}
	printf("\n");
	int r;
	do {
		printf("avant waitpid ...\n");
		r = waitpid(-1, NULL, WSTOPPED | WCONTINUED);
		printf(" ... waitpid a retourné %d\n\n", r);
	} while (r != -1);
	printf("fin du processus père\n");
}