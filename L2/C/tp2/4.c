#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>
static int sum = 0;
void handle_signal(int signum) {
	printf("Total = %d\n", sum);
	exit(0);
}
int main() {
	struct sigaction act1;
	sigemptyset(&(act1.sa_mask));
	act1.sa_flags = 0;
	act1.sa_handler = handle_signal;
	sigaction(SIGINT, &act1, NULL);
	int x;
	while (1) {
		scanf("%d", &x);
		sum = sum + x;
	}
}