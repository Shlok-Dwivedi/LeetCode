#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int* data;
    int head;
    int tail;
    int size;
    int count;
} MyCircularQueue;

MyCircularQueue* myCircularQueueCreate(int k) {
    MyCircularQueue* obj = (MyCircularQueue*)malloc(sizeof(MyCircularQueue));
    if (!obj) {
        return NULL;
    }
    
    obj->data = (int*)malloc(k * sizeof(int));
    if (!obj->data) {
        free(obj);
        return NULL;
    }
    
    obj->head = 0;
    obj->tail = 0;
    obj->size = k;
    obj->count = 0;
    
    return obj;
}

bool myCircularQueueIsEmpty(MyCircularQueue* obj) {
    return obj->count == 0;
}

bool myCircularQueueIsFull(MyCircularQueue* obj) {
    return obj->count == obj->size;
}

bool myCircularQueueEnQueue(MyCircularQueue* obj, int value) {
    if (myCircularQueueIsFull(obj)) {
        return false;
    }
    
    obj->data[obj->tail] = value;
    obj->tail = (obj->tail + 1) % obj->size;
    

    obj->count++;
    
    return true;
}

bool myCircularQueueDeQueue(MyCircularQueue* obj) {
    if (myCircularQueueIsEmpty(obj)) {
        return false;
    }

    obj->head = (obj->head + 1) % obj->size;
    
    obj->count--;
    
    return true;
}

int myCircularQueueFront(MyCircularQueue* obj) {
    if (myCircularQueueIsEmpty(obj)) {
        return -1;
    }
    

    return obj->data[obj->head];
}

int myCircularQueueRear(MyCircularQueue* obj) {

    if (myCircularQueueIsEmpty(obj)) {
        return -1;
    }
    
    int rearIndex = (obj->tail - 1 + obj->size) % obj->size;
    return obj->data[rearIndex];
}

void myCircularQueueFree(MyCircularQueue* obj) {
    free(obj->data);
    free(obj);
}

/**
 * Your MyCircularQueue struct will be instantiated and called as such:
 * MyCircularQueue* obj = myCircularQueueCreate(k);
 * bool param_1 = myCircularQueueEnQueue(obj, value);
 * bool param_2 = myCircularQueueDeQueue(obj);
 * int param_3 = myCircularQueueFront(obj);
 * int param_4 = myCircularQueueRear(obj);
 * bool param_5 = myCircularQueueIsEmpty(obj);
 * bool param_6 = myCircularQueueIsFull(obj);
 * myCircularQueueFree(obj);
 */
