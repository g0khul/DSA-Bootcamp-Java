#ifndef HASHTABLE_H
#define HASHTABLE_H

// Define the structure for a hashtable entry
typedef struct HashtableEntry {
    char* key;
    void* value;
    struct HashtableEntry* next;
} HashtableEntry;

// Define the structure for a hashtable
typedef struct Hashtable {
    int size;
    HashtableEntry** table;
} Hashtable;

// Function prototypes
Hashtable* createHashtable(int size);
int hash(const char* key, int size);
void insert(Hashtable* hashtable, const char* key, void* value);
void* get(Hashtable* hashtable, const char* key);
void display(Hashtable* hashtable);
void removeEntry(Hashtable* hashtable, const char* key);

#endif
