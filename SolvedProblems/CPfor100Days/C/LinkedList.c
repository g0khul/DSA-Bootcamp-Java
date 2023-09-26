#include <stdio.h>
#include <stdlib.h>

struct listnode {
    int data;
    struct listnode* next;
};

typedef struct listnode node;

node* insertAtBeginning(int val, node* head){
    node* newNode = (node*) malloc(sizeof(node));
    
    if(newNode == NULL){
        printf("Out of memory");
        return NULL;
    }
    
    newNode->data = val;
    newNode->next = NULL;
    node* temp = head;
    head = newNode;
    head->next = temp;
    return head;
}

node* insert(int val, node* head){
    if(head == NULL){
        head = insertAtBeginning(val, head);
        return head;
    }
    
    node* newNode = (node*) malloc(sizeof(node));
    newNode -> data = val;
    node* temp = head;
    
    while(temp->next != NULL){
        temp = temp -> next;
    }
    
    temp->next = newNode;
    return head;
}


// Displaying the list 
void display(node* head){
    node* temp = head;
    while(temp != NULL){
        printf("%d ", temp -> data);
        temp = temp -> next;
    }
    printf("\n");
}


// Problems:
// 21. Merge Two Sorted Lists
node* mergeTwoSortedList(node* list1, node* list2){
    node* result = (node*) malloc(sizeof(node*));
    node* temp = result;
    
    while(list1 != NULL && list2 != NULL){
        if(list1->data <= list2->data){
            node* newNode = (node*) malloc(sizeof(node*));
            newNode->data = list1->data;
            temp->next = newNode;
            temp = temp->next;
            list1 = list1->next;
        } else {
            node* newNode = (node*) malloc(sizeof(node*));
            newNode->data = list2->data;
            temp->next = newNode;
            temp = temp->next;
            list2 = list2->next;
        }
    }
    
    if(list1 != NULL){
        temp->next = list1;
    }
    
    if(list2 != NULL){
        temp->next = list2;
    }
    
    return result->next;
}

// 61. Rotate List
node* rotateList(node* head, int k){
    if(head == NULL){
        return NULL;
    }
    
    int length = 1;
    node* tail = head;
    while(tail->next != NULL){
        tail = tail->next;
        length++;
    }
    printf("%d\n", length);
    
    node* temp = head;
    for(int i = 0; i < length - k - 1; i++){
        temp = temp->next;
    }
    tail->next = head;
    head = temp->next;
    temp->next = NULL;
    return head;
}

// 82. Remove Duplicates from Sorted List II
node* deleteDuplicates(node* head){
    if(head == NULL || head->next == NULL){
        return head;
    }
    
    node* temp = head;
    
    node* result = (node*) malloc(sizeof(node*));
    node* tresult = result;
    int flag = 0;
    while(temp->next != NULL){
        if(temp->data != temp->next->data){
            if(!flag){
                node* newNode = (node*) malloc(sizeof(node*));
                newNode->data = temp->data;
                tresult->next = newNode;
                tresult = tresult->next;
            } else {
                flag = 0;
            }
        } else {
            flag = 1;
        }
        temp = temp->next;
    }
    
    if(!flag){
        node* newNode = (node*) malloc(sizeof(node*));
        newNode->data = temp->data;
        tresult->next = newNode;
    }
    
    return result->next;
}

int main()
{
    // node* list1 = NULL;
    // list1 = insert(10, list1);
    // list1 = insert(20, list1);
    // list1 = insert(30, list1);
    // display(list1);
    
    // node* list2 = NULL;
    // list2 = insert(20, list2);
    // list2 = insert(40, list2);
    // list2 = insert(45, list2);
    // display(list2);
    
    // node* result = mergeTwoSortedList(list1, list2);
    // display(result);
    
    
    
    
    
    // node* list = NULL;
    // for(int i = 1; i <= 5; i++){
    //     list = insert(i, list);
    // }
    // display(list);
    // list = rotateList(list, 2);
    // display(list);
    
    node* duplicateList = NULL;
    duplicateList = insert(1, duplicateList);
    duplicateList = insert(1, duplicateList);
    duplicateList = insert(1, duplicateList);
    duplicateList = insert(2, duplicateList);
    duplicateList = insert(3, duplicateList);
    duplicateList = insert(4, duplicateList);
    
    duplicateList = deleteDuplicates(duplicateList);
    
    display(duplicateList);
    
    
    


    return 0;
}

