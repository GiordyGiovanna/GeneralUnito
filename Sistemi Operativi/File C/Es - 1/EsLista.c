#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "client.h"

#define L_EMPTYLIST_CL {NULL,NULL}

typedef struct _node {
	unsigned int id;
	client person;
	struct _node *next;
} l_node;

typedef struct {
	l_node *head;
	l_node *tail;
} list_cl;

list_cl l_add_cl(list_cl l, client p){
	l_node *node = (l_node *) malloc(sizeof(l_node));
	node->person = p;
	if(l.head == NULL){
		l.head = node;
		l.head->next = NULL;
	}
	else if(l.tail == NULL){
		l.tail = node;
		l.tail->next = NULL;
	}
	else{
		l.tail->next = node;
		l.tail = node;
	}
	return l;
} 

int main()
{	
	// TESTATO SOLO CON HEAD E TAIL UGUALI A NULL
	list_cl list = L_EMPTYLIST_CL;
	client p;
	p.first_name = "A";
	p.last_name = "B";
	list = l_add_cl(list, p); // Ricordarsi di "list ="
	printf("%s\n\n\n", list.head->person.first_name);

	return 0;
}