// stack.h
#ifndef STACK_H
#define STACK_H

// Define a structure for a stack node
typedef struct StackNode {
    int data;
    struct StackNode* next;
} StackNode;

// Define a structure for the stack
typedef struct Stack {
    StackNode* top;
} Stack;

// Function declarations
Stack* createStack();
int isStackEmpty(Stack* stack);
void push(Stack* stack, int data);
int pop(Stack* stack);
int peek(Stack* stack);
void displayStack(Stack* stack);
void freeStack(Stack* stack);

#endif
