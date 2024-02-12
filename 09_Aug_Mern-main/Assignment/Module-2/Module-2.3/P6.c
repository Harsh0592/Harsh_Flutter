//WAP to make addition, Subtraction and multiplication of two matrix using
//2-D Array
#include <stdio.h>
//matrix addition
void matrixAddition(int A[][100], int B[][100], int result[][100], int rows, int cols) {
    int i,j;
	for(i = 0; i < rows; i++) {
        for(j = 0; j < cols; j++) {
            result[i][j] = A[i][j] + B[i][j];
        }
    }
}

//matrix subtraction
void matrixSubtraction(int A[][100], int B[][100], int result[][100], int rows, int cols) {
    int i,j;
	for(i = 0; i < rows; i++) {
        for(j = 0; j < cols; j++) {
            result[i][j] = A[i][j] - B[i][j];
        }
    }
}

// matrix multiplication
void matrixMultiplication(int A[][100], int B[][100], int result[][100], int rows1, int cols1, int cols2) {
    int i,j,k;
	for(i = 0; i < rows1; i++) {
        for(j = 0; j < cols2; j++) {
            result[i][j] = 0;
            for (k = 0; k < cols1; k++) {
                result[i][j] += A[i][k] * B[k][j];
            }
        }
    }
}

// Function to display a matrix
void displayMatrix(int matrix[][100], int rows, int cols) {
    int i,j;
	for(i = 0; i < rows; i++) {
        for(j = 0; j < cols; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    int rows1, cols1, rows2, cols2;

    printf("Enter the number of rows and columns of the first matrix: ");
    scanf("%d %d", &rows1, &cols1);

    printf("Enter the number of rows and columns of the second matrix: ");
    scanf("%d %d", &rows2, &cols2);

    if (cols1 != rows2) {
        printf("Matrix multiplication is not possible. The number of columns in the first matrix must be equal to the number of rows in the second matrix.\n");
        return 1;
    }

    int A[100][100], B[100][100], result[100][100];

    printf("Enter elements of the first matrix:\n");
    int i,j;
	for(i = 0; i < rows1; i++) {
        for(j = 0; j < cols1; j++) {
            scanf("%d", &A[i][j]);
        }
    }

    printf("Enter elements of the second matrix:\n");
    
	for(i = 0; i < rows2; i++) {
        for(j = 0; j < cols2; j++) {
            scanf("%d", &B[i][j]);
        }
    }

    //addition
    matrixAddition(A, B, result, rows1, cols1);

    printf("Matrix Addition:\n");
    displayMatrix(result, rows1, cols1);

    //subtraction
    matrixSubtraction(A, B, result, rows1, cols1);

    printf("Matrix Subtraction:\n");
    displayMatrix(result, rows1, cols1);

    //multiplication
    matrixMultiplication(A, B, result, rows1, cols1, cols2);

    printf("Matrix Multiplication:\n");
    displayMatrix(result, rows1, cols2);

    return 0;
}

