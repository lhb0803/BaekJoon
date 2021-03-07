#include <stdio.h>
#include <stdlib.h>

struct elem{
    int d;
    struct elem* next;
};
typedef struct elem elem;

struct circle{
    int size;
    elem* head;
};
typedef struct circle circle;

int main(void) {
    int N, K;

    circle* people = (circle*) malloc(sizeof(circle));
    scanf("%d %d", &N, &K);
    for (int i=N; i>0; i--) {
        elem* person = (elem*) malloc(sizeof(elem));
        person->d = i;
        if (i==N) {
            person->next = NULL;
            people->head = person;
        }
        else {
            person->next = people->head;
            people->head = person;
        }
    }
    elem* curr = people->head;
    while (curr->next != NULL) {
        curr = curr->next;
    }
    curr->next = people->head;

    printf("<");
    elem* prev;
    for (int j=0; j<K; j++) {
        prev = curr;
        curr = curr->next;
    }
    prev->next = curr->next;
    while (N > 0) {
        printf("%d", curr->d);
        elem* to_free = curr;
        for (int j=0; j<K; j++) {
            prev = curr;
            curr = curr->next;
        }
        prev->next = curr->next;
        free(to_free);
        N--;

        if (N >= 1) {
            printf(", ");
        }
    }
    printf(">\n");
    return 0;
}