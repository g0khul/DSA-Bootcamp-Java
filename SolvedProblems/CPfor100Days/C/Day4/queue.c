// queue.c
#include <stdio.h>
#include <stdlib.h>
#include "queue.h"

// Function to create an empty queue
Queue* createQueue() {
    Queue* queue = (Queue*)malloc(sizeof(Queue));
    if (!queue) {
        exit(1); // Memory allocation error
    }
    queue->front = queue->rear = NULL;
    return queue;
}

// Function to check if the queue is empty
int isQueueEmpty(Queue* queue) {
    return queue->front == NULL;
}

// Function to add an item to the queue
void enqueue(Queue* queue, int data) {
    QueueNode* newNode = (QueueNode*)malloc(sizeof(QueueNode));
    if (!newNode) {
        exit(1); // Memory allocation error
    }
    newNode->data = data;
    newNode->next = NULL;

    if (isQueueEmpty(queue)) {
        queue->front = queue->rear = newNode;
    } else {
        queue->rear->next = newNode;
        queue->rear = newNode;
    }
}

// Function to remove an item from the queue
int dequeue(Queue* queue) {
    if (isQueueEmpty(queue)) {
        exit(1); // Queue is empty
    }

    QueueNode* temp = queue->front;
    int data = temp->data;

    queue->front = temp->next;
    free(temp);

    return data;
}

// Function to display the queue
void displayQueue(Queue* queue) {
    QueueNode* current = queue->front;
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

// Function to remove queue from memory
void freeQueue(Queue* queue) {
    // Free any dynamically allocated memory used by the queue
    while (!isQueueEmpty(queue)) {
        dequeue(queue);
    }
    free(queue);
}