#include <stdio.h>
#include <stdlib.h>
typedef struct {
	int nb_ligne;
	int nb_col;
	int** m;
} Matrice;
// a
Matrice alloue_matrice(int nb_ligne, int nb_col) {
	Matrice mat;
	mat.nb_ligne = nb_ligne;
	mat.nb_col = nb_col;
	mat.m = malloc(nb_ligne * sizeof(int*));
	for (int i = 0; i < nb_ligne; i++) {
		mat.m[i] = malloc(nb_col * sizeof(int));
		for (int j = 0; j < nb_col; j++) {
			mat.m[i][j] = 0;
		}
	}
	return mat;
}
// b
void print_matrix(Matrice mat) {
	for (int i = 0; i < mat.nb_ligne; i++) {
		for (int j = 0; j < mat.nb_col; j++) {
			printf("%d ", mat.m[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}
// c
Matrice multiply_matrix(Matrice mat1, Matrice mat2) {
	Matrice mat = alloue_matrice(mat1.nb_ligne, mat2.nb_col);
	for (int i = 0; i < mat1.nb_ligne; i++) {
		for (int j = 0; j < mat2.nb_col; j++) {
			int cell = 0;
			for (int k = 0; k < mat1.nb_col; k++) {
				cell = cell + mat1.m[i][k] * mat2.m[k][j];
			}
			mat.m[i][j] = cell;
		}
	}
	return mat;
}
// d
void libere_matrice(Matrice mat) {
	for (int i = 0; i < mat.nb_ligne; i++) {
		free(mat.m[i]);
	}
	free(mat.m);
}
int main() {
	// a
	Matrice mat1 = alloue_matrice(2, 3);
	mat1.m[0][0] = 1;
	mat1.m[0][1] = 2;
	mat1.m[0][2] = 0;
	mat1.m[1][0] = 4;
	mat1.m[1][1] = 3;
	mat1.m[1][2] = -1;
	// b
	print_matrix(mat1);
	Matrice mat2 = alloue_matrice(3, 2);
	mat2.m[0][0] = 5;
	mat2.m[0][1] = 1;
	mat2.m[1][0] = 2;
	mat2.m[1][1] = 3;
	mat2.m[2][0] = 3;
	mat2.m[2][1] = 4;
	print_matrix(mat2);
	// c
	Matrice mat3 = multiply_matrix(mat1, mat2);
	print_matrix(mat3);
	Matrice mat4 = multiply_matrix(mat2, mat1);
	print_matrix(mat4);
	// d
	for (int i = 0; i < 2000000; i++) {
		Matrice m = alloue_matrice(10, 10);
		libere_matrice(m);
	}
	printf("fin\n");
	getchar();
}