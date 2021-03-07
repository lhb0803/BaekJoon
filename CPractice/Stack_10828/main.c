#include <stdio.h>
#include <stdlib.h>
#include <string.h>

struct elem{
    int d;
    struct elem* next;
};

typedef struct elem elem;

struct stack {
    int size;
    elem* top;
};

typedef struct stack stack;

void init(stack*);
void push(int, stack*);
int pop(stack*);
int top(stack*);
int empty(stack*);
int size(stack*);

int string_to_int(char*);

int main(void) {
    int N;
    scanf("%d", &N);
    stack* stk = (stack*) malloc(sizeof(stack));
    getchar();
    init(stk);
    while(N > 0) {
        char* command = (char*) malloc(sizeof(char)*12);
        scanf("%[^\n]", command); getchar();
        // printf("%ld\n", strlen(command));

        if (strlen(command) >= 6) {
            char* to_push = command + 5;
            push(string_to_int(to_push), stk);
        }
        else if (strcmp(command, "pop") == 0) {
            printf("%d\n", pop(stk));
        }
        else if (strcmp(command, "size") == 0) {
            printf("%d\n", size(stk));
        }
        else if (strcmp(command, "empty") == 0) {
            printf("%d\n", empty(stk));
        }
        else if (strcmp(command, "top") == 0) {
            printf("%d\n", top(stk));
        }

        free(command);
        N--;
    }

    free(stk);
    return 0;
}

void init(stack* stk) {
    stk -> size = 0;
    stk -> top = NULL;
}

void push(int input, stack* stk) {
    elem* new_elem = (elem*) malloc(sizeof(elem));
    new_elem->d = input;
    new_elem->next = stk->top;
    
    stk->top = new_elem;
    stk->size++;
}

int pop(stack* stk) {
    if (stk->size == 0) {
        return -1;
    }
    elem* to_pop = stk->top;
    stk->top = to_pop->next;
    stk->size--;
    int to_return = to_pop->d;
    free(to_pop);
    return to_return;
}

int top(stack* stk) {
    if (stk->size == 0) {
        return -1;
    }
    int t = stk->top->d;
    return t;
}

int empty(stack* stk) {
    if (stk->size == 0) {
        return 1;
    }
    else {
        return 0;
    }
}

int size(stack* stk) {
    return stk->size;
}

int string_to_int(char* s) {
    int digit_size = strlen(s);
    int tens = 1;
    int sum = 0;
    for (int i=digit_size-1; i>=0; i--) {
        int n = s[i] - '0';
        sum += n * tens;
        tens *= 10;
    }
    return sum;
}