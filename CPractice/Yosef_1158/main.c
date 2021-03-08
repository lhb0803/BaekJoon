#include <stdio.h>
#include <stdlib.h>

int main(void) {
    int N, K;

    scanf("%d %d", &N, &K);
    int numArr[N];
    for (int i=0; i<N; i++) {
        numArr[i] = i+1;
    }

    printf("<");
    int ix=K-1;
    while (N > 0) {
        printf("%d", numArr[ix]);
        N--;

        if (N > 0) {
            for (int i=ix; i<N; i++) {
                numArr[i] = numArr[i+1];
            }
            ix = (ix + K-1) % N;
            printf(", ");
        }
        else {
            printf(">");
        }
    }
    printf("\n");
    return 0;
}