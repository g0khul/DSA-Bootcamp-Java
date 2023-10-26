// queue.h
#ifndef QUEUE_H
#define QUEUE_H

// Define a structure for a queue node
typedef struct QueueNode {
    int data;
    struct QueueNode* next;
} QueueNode;

// Define a structure for the queue
typedef struct Queue {
    QueueNode* front;
    QueueNode* rear;
} Queue;

// Function declarations
Queue* createQueue();
int isQueueEmpty(Queue* queue);
void enqueue(Queue* queue, int data);
int dequeue(Queue* queue);
void displayQueue(Queue* queue);
void freeQueue(Queue* queue);

#endif
