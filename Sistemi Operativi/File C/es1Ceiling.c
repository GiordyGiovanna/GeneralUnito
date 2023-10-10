#include <stdio.h>

int ceiling(int n, int b){
	return (n+b-1)/b;
}

int main(){
	
	int n = 47; // numero di studenti
	const int b = 8;

	printf("I need %d snack for %d students\n", ceiling(n, b), b);

	return 0;
}
