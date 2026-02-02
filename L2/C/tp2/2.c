#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/wait.h>
#define N 10
#define NS_ATTENTE 500000000
struct timespec attente = {0, NS_ATTENTE};
void compter(int n) {}
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
}