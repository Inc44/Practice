#include <stdio.h>
int main(int argc, char* argv[]) {
	if (argc < 2) {
		printf("No command-line argument\n");
		return -1;
	}
	for (int i = 0; i < argc; i++) {
		int len = 0;
		while (argv[i][len] != '\0')
			len++;
		printf("Argument %d = %s, length = %d\n", i, argv[i], len);
	}
	return 0;
}