#include <stdio.h>
#define LEN 54
int main(int argc, char* argv[]) {
	unsigned char cle = 0b011001011;
	unsigned char msg[LEN] = {
		233, 251, 74,  126, 207, 28,  145, 151, 174, 227, 3,   126, 223, 94,
		151, 150, 191, 183, 94,	 43,  155, 16,	158, 197, 165, 176, 86,	 126,
		221, 89,  147, 144, 168, 226, 65,  126, 213, 23,  149, 151, 174, 243,
		70,	 59,  210, 13,	210, 150, 174, 244, 93,	 59,  200, 91};
	// a
	int count = 0;
	for (int j = 0; j < LEN; j++) {
		for (int i = 7; i >= 0; i--) {
			if ((1 << i) & msg[j]) {
				count = count + 1;
			}
		}
	}
	printf("count = %d\n", count);
	// b
	for (int i = 0; i < LEN; i++) {
		unsigned char c = msg[i] ^ cle;
		if (cle & 0b10000000) {
			cle = (cle << 1) | 0b00000001;
		} else {
			cle = cle << 1;
		}
		printf("%c", c);
	}
	printf("\n");
}