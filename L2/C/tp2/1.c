#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#define N 10
#define NS_ATTENTE 200000000
struct timespec attente = {0, NS_ATTENTE};
int main() {
	for (int i = 1; i <= N; i++) {
		nanosleep(&attente, 0);
		printf("%d/%d\n", i, N);
		fflush(stdout);
	}
}