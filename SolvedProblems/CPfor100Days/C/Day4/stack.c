// stack.c
#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

// Function to create an empty stack
Stack* createStack() {
    Stack* stack = (Stack*)malloc(sizeof(Stack));
    if (!stack) {
        exit(1); // Memory allocation error
    }
    stack->top = NULL;
    return stack;
}

// Function to check if the stack is empty
int isStackEmpty(Stack* stack) {
    return stack->top == NULL;
}

// Function to push an item onto the stack
void push(Stack* stack, int data) {
    StackNode* newNode = (StackNode*)malloc(sizeof(StackNode));
    if (!newNode) {
        exit(1); // Memory allocation error
    }
    newNode->data = data;
    newNode->next = stack->top;
    stack->top = newNode;
}

// Function to pop an item from the stack
int pop(Stack* stack) {
    if (isStackEmpty(stack)) {
        exit(1); // Stack is empty
    }

    StackNode* temp = stack->top;
    int data = temp->data;
    stack->top = temp->next;
    free(temp);

    return data;
}

// Function to get the top item without popping it
int peek(Stack* stack) {
    if (isStackEmpty(stack)) {
        exit(1); // Stack is empty
    }
    return stack->top->data;
}

// Function to display the stack
void displayStack(Stack* stack) {
    StackNode* current = stack->top;
    while (current != NULL) {
        printf("%d -> ", current->data);
        current = current->next;
    }
    printf("NULL\n");
}

// Function to remove stack from memory
void freeStack(Stack* stack) {
    // Free any dynamically allocated memory used by the stack
    while (!isStackEmpty(stack)) {
        pop(stack);
    }
    free(stack);
}