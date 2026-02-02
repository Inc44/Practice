#include <stdio.h>
int main(int argc, char* argv[]) {
	if (argc < 2) {
		printf("No command-line argument\n");
		return -1;
	}
	int len = 0;
	while (argv[1][len] != '\0')
		len++;
	int isPalindrome = 1;
	int i = 0;
	while (i < len / 2 && isPalindrome) {
		if (argv[1][i] != argv[1][len - 1 - i]) {
			isPalindrome = 0;
		}
		i++;
	}
	if (isPalindrome) {
		printf("'%s' is a palindrome\n", argv[1]);
	} else {
		printf("'%s' is not a palindrome\n", argv[1]);
	}
	return 0;
}