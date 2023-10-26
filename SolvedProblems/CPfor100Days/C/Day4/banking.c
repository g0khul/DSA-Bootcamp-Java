#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "stack.h"
#include "queue.h"
#include "hashtable.h"
#include <unistd.h>

// Define user data structure
typedef struct UserData {
    char username[50];
    int balance;
    Queue* userQueue;
    Stack* transactionStack;
} UserData;

// Global hashtable to store user data
Hashtable* userTable = NULL;

// Function to open an account
void openAccount(char* username) {
    UserData* newUser = (UserData*)malloc(sizeof(UserData));
    strcpy(newUser->username, username);
    newUser->balance = 0;
    newUser->userQueue = createQueue();
    newUser->transactionStack = createStack();
    insert(userTable, username, newUser);
    printf("Account for %s has been created with a balance of $%d\n", username, newUser->balance);
}

// Function to deposit money
void deposit(char* username, int amount) {
    UserData* user = (UserData*)get(userTable, username);
    if (user) {
        printf("User found: %s\n", username);
        enqueue(user->userQueue, amount);
    } else {
        printf("User not found: %s\n", username);
    }
}

// Function to withdraw money
void withdraw(char* username, int amount) {
    UserData* user = (UserData*)get(userTable, username);
    if (user) {
        enqueue(user->userQueue, -amount);
    }
}

// Function to process user operations
void processUserOperations() {
    for (int i = 0; i < userTable->size; i++) {
        HashtableEntry* entry = userTable->table[i];
        while (entry != NULL) {
            UserData* user = (UserData*)entry->value;
            while (!isQueueEmpty(user->userQueue)) {
                int amount = dequeue(user->userQueue);
                user->balance += amount;
                if (amount > 0) {
                    push(user->transactionStack, amount);
                } else {
                    push(user->transactionStack, amount);
                }
            }
            entry = entry->next;
        }
    }
}

// Function to display balance
void displayBalance(char* username) {
    UserData* user = (UserData*)get(userTable, username);
    if (user) {
        printf("Balance for %s: $%d\n", username, user->balance);
    }
}

// Function to display transaction history
void displayTransactions(char* username) {
    UserData* user = (UserData*)get(userTable, username);
    if (user) {
        printf("Transaction History for %s:\n", username);
        while (!isStackEmpty(user->transactionStack)) {
            int amount = pop(user->transactionStack);
            if (amount > 0) {
                printf("Deposited: $%d\n", amount);
            } else {
                printf("Withdrawn: $%d\n", -amount);
            }
        }
    }
}

// Function to close an account
void closeAccount(char* username) {
    UserData* user = (UserData*)get(userTable, username);
    if (user) {
        // First, free the memory used by the user's data structures
        freeQueue(user->userQueue);
        freeStack(user->transactionStack);
        free(user);

        // Remove the user from the hashtable
        removeEntry(userTable, username);

        printf("Account for %s has been closed.\n", username);
    } else {
        printf("User not found: %s\n", username);
    }
}

int main() {
    // Create a hashtable to store user data
    userTable = createHashtable(100);

    openAccount("user1");
    openAccount("user2");
    openAccount("user3");
    openAccount("user4");

    deposit("user1", 100);
    deposit("user2", 200);
    deposit("user3", 50);
    deposit("user4", 300);

    withdraw("user1", 30);
    withdraw("user2", 50);
    withdraw("user3", 20);
    withdraw("user4", 100);

    // Process user operations every 5 seconds
    for (int i = 0; i < 5; i++) {
        processUserOperations();
        printf("Processing user operations...\n");
        sleep(5);
    }

    displayBalance("user1");
    displayBalance("user2");
    displayBalance("user3");
    displayBalance("user4");

    displayTransactions("user1");
    displayTransactions("user2");
    displayTransactions("user3");
    displayTransactions("user4");

    closeAccount("user1");    

    return 0;
}
