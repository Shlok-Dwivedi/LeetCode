#define MAX_SIZE 100

typedef struct {
    int data[MAX_SIZE];
    int top;
} Stack;

void stackInit(Stack* s) {
    s->top = -1;
}

bool stackEmpty(Stack* s) {
    return s->top == -1;
}

void stackPush(Stack* s, int x) {
    if (s->top < MAX_SIZE - 1)
        s->data[++(s->top)] = x;
}

int stackPop(Stack* s) {
    if (s->top >= 0)
        return s->data[(s->top)--];
    return -1; // empty
}

int stackPeek(Stack* s) {
    if (s->top >= 0)
        return s->data[s->top];
    return -1; // empty
}

// Queue using two stacks
typedef struct {
    Stack stack_in;
    Stack stack_out;
} MyQueue;

MyQueue* myQueueCreate() {
    MyQueue* obj = (MyQueue*)malloc(sizeof(MyQueue));
    stackInit(&obj->stack_in);
    stackInit(&obj->stack_out);
    return obj;
}

void transferIfNeeded(MyQueue* obj) {
    if (stackEmpty(&obj->stack_out)) {
        while (!stackEmpty(&obj->stack_in)) {
            stackPush(&obj->stack_out, stackPop(&obj->stack_in));
        }
    }
}

void myQueuePush(MyQueue* obj, int x) {
    stackPush(&obj->stack_in, x);
}

int myQueuePop(MyQueue* obj) {
    transferIfNeeded(obj);
    return stackPop(&obj->stack_out);
}

int myQueuePeek(MyQueue* obj) {
    transferIfNeeded(obj);
    return stackPeek(&obj->stack_out);
}

bool myQueueEmpty(MyQueue* obj) {
    return stackEmpty(&obj->stack_in) && stackEmpty(&obj->stack_out);
}

void myQueueFree(MyQueue* obj) {
    free(obj);
}