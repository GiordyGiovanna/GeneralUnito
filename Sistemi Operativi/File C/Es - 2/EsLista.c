#include <stdio.h>
#include <stdlib.h>
#include <malloc.h>
#include "data.h"
#define L_EMPTY NULL

typedef struct _node {
	unsigned int id;
	data *d;
	struct _node *next;
} node;

typedef node *list;

list add_to_list(unsigned int i, data* d, list l){

	int j = 0;
	// non funziona con 0 perchè o mette alla seconda posizione
	while(l->next != NULL){
		if(j == i){
			node * n = (node*) malloc(sizeof(node));
			n->d = d;
			n->next = l->next;
			l->next = n;			
		}	
		l = l->next;
	}
	return l;
}

int main()
{	
	// TESTATO SOLO CON HEAD E TAIL UGUALI A NULL
	list list = L_EMPTY;
	data p;

	return 0;
}