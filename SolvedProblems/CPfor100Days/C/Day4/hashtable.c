#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "hashtable.h"

// Function to create a new hashtable
Hashtable* createHashtable(int size) {
    Hashtable* hashtable = (Hashtable*)malloc(sizeof(Hashtable));
    hashtable->size = size;
    hashtable->table = (HashtableEntry**)malloc(sizeof(HashtableEntry*) * size);

    for (int i = 0; i < size; i++) {
        hashtable->table[i] = NULL;
    }

    return hashtable;
}

// Hash function for generating an index based on the key
int hash(const char* key, int size) {
    int hash = 0;
    while (*key) {
        hash = (hash * 31) + *key;
        key++;
    }
    return (hash >= 0 ? hash : -hash) % size;
}

// Function to insert a key-value pair into the hashtable
void insert(Hashtable* hashtable, const char* key, void* value) {
    int index = hash(key, hashtable->size);
    HashtableEntry* newEntry = (HashtableEntry*)malloc(sizeof(HashtableEntry));
    newEntry->key = strdup(key); // Make a copy of the key
    newEntry->value = value;
    newEntry->next = NULL;

    if (hashtable->table[index] == NULL) {
        // No collision, insert the new entry
        hashtable->table[index] = newEntry;
    } else {
        // Collision, add to the linked list
        HashtableEntry* current = hashtable->table[index];
        while (current->next != NULL) {
            current = current->next;
        }
        current->next = newEntry;
    }
}

// Function to retrieve a value associated with a key from the hashtable
void* get(Hashtable* hashtable, const char* key) {
    int index = hash(key, hashtable->size);
    HashtableEntry* entry = hashtable->table[index];
    while (entry != NULL) {
        if (strcmp(entry->key, key) == 0) {
            return entry->value; // Return the value associated with the key
        }
        entry = entry->next;
    }
    return NULL; // Key not found
}

// Function to remove an entry
void removeEntry(Hashtable* hashtable, const char* key) {
    int index = hash(key, hashtable->size);
    HashtableEntry* entry = hashtable->table[index];
    HashtableEntry* prevEntry = NULL;

    while (entry != NULL) {
        if (strcmp(entry->key, key) == 0) {
            if (prevEntry != NULL) {
                prevEntry->next = entry->next;
            } else {
                hashtable->table[index] = entry->next;
            }
            free(entry->key);
            free(entry->value);
            free(entry);
            return;
        }
        prevEntry = entry;
        entry = entry->next;
    }
}

// Function to display the contents of the hashtable
void display(Hashtable* hashtable) {
    for (int i = 0; i < hashtable->size; i++) {
        HashtableEntry* entry = hashtable->table[i];
        while (entry != NULL) {
            printf("Key: %s, Value: %p\n", entry->key, entry->value);
            entry = entry->next;
        }
    }
}
