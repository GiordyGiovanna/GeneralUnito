#include <stdio.h> // <> Aperto e chiuso tag cerca la libreria nelle cartelle di sistema

int main()
{	
	printf("Test\n");
	return 0;
}

// NON esiste l'overload!
// tutte quante le funzioni in c devono almeno essere dichiarate prima di essere utilizzate, This is because C uses a single-pass compiler, which means it processes code from top to bottom, and it needs to know the function's signature (declaration) before it can correctly interpret how the function is used.
// Es. void println(char) oppure void println(char c) --> il nome del parametro non è necessaro


// I tipi primitivo sono:
// int, short int, long int
// unsigned int, unsigned short int, unsigned long int
// float, double--> numeri con la virgola, una e due precisioni
// char --> numero che è la codifica di un carattere --> char di c è diverso dal char di java
// * --> i puntatori sono tipi primitivi che puntano ad aree di memoria

// uso * per dichiarare un PUNTATORE (posso utilizzare operazioni)
// I puntatori necessitano di aver specifcato il tipo Es. int *, void *, double *
// Puntatori generici: void * --> non voglio specificae il tipo del dato a cui quel valore punta, lo specificherò dopo con un cast
// int ** in questo modo dichiaro un puntatore ad un puntatore (questo perchè sono tipi primitivi)
//
//La dichiarazione allora una variabile in memoria Es. int i; -->i ha un valore indefinito,ha il valore che si trova nella memoria (letto come intero)
// int* ptr = NULL; --> null è una costante simbolica definira altrove--> (che cazzo significa??) (che indica il valore di un puntatore non valido)
// Meglio inizializzare sempre i puntatori a NULL perchè potrebbe puntare ad un area di memoria illegale o legale(sbaliata)
// Quando assegno i valori è importante che il valore assegnato sia in accordo con il tipo della variabile (type matching)
// posso mettere una short dentro una int , il contrario è possibile perchè avviene una conversione (il programma da degli warning che potrebbero portare ad errori logici)
//
// Il c deve assegnare un tipo ad ogni valore (se è indeciso tra 2 prende quello con la memoria più grande es: 2.0*2 --> prende double)
//
// ESEMPI:
// int i = 9;
// double j = 2.0*i/2;		// --> j == 9
// double j = 2.0*(i/2);	// --> j == 2.0*4 == 8		(i/2) --> è una divisione tra interi (int), quindi fa 4
// double j = 2.0*(i/2.0);	// --> j == 9
//
//
// SCELTA MIGLIORE:
// double j = 2*i/2.0; --> perchè almeno faccio prima delle operazioni con interi e poi con double
// sono sottigliezze che contano
//
//
//
// Regole di visibilità
//
// Tutte le instruzioni devono appartenere ad un 'blocco', un blocco è una parte di codice racchiusa in delle graffe {Blocco}
// 
// {	BLOCCO A
//	
//	int a = 0;
//	int j = 0;
//	{	Blocco A.1
//
//		int i = 0;
//		i++; --> questo si chiama variable hiding e va a incrementare la i più interna
//		int j = 0;
//	}
//	j++; --> ERRORE: Operazione non possibile, j è dichiara in un'altro blocco
//
// }
// {	BLOCCO B
//
//	int i = 0; --> le due variabili i non 
//
// }
// Per convenzione non posso dichiarare variabili tra blocchi delle lo stesso livello (a e b), lo posso fare solo all'inizio di ogni blocco
// 
// Le variabili vengono disallocate quando si esce dal blocco di dichiarazione
//
// I nomi di funzione sono a livello 0 (sono globali) --> si possono anche cambiare ma non ci ha detto come (fanculo)
// 
// Una varibile è caratterizzata da 4 cose:
//  - Nome
//  - Typo
//  - Valore
//  - Indirizzo
//			-----------> LMAOOOOOOOOOOOOOOOOOOOOOOOOOOO
//
// 
// int i = 10;
// int* ptr = &i; --> & è un'operatore unario che ritorna il valore del puntatore di i
//
// int main(){
// 	
// 	printf("L'indirizzo di memoria di i: %p\n", ptr);
// 	printf("Indirizzo di memoria di ptr: %d\n", &ptr); //--> p per i pointer
// }
//
// Una volta finito il programma tutte le variabili allocate vengono allocate--> OMMIODDIO CHI LO AVREBBE MAI DETTO !!!!!!!!!!!!!!!!!!!
// Il % identifica una specifica di formata che viene indicata con il valore successivo (Es. p --> pointer, d --> cazzo ne so, credo intero)
//
//
// NULL è definito in <stddef.h>
// operatori:
//  - * Deferenziamento
//  - & indirizzo
//  - >> shift right << shift left
//  - | OR bit a bit
//  - & AND bit a bit
//  - *Tilde* NOT bit a bit
//  - Altri
//
//
//
// Strutture di Iterazione
//
// While(exp){}
//
// do{}While(exp);
//
// for( ; ; ){}
//
// In C non ci sono i boolean, un valore diverso da 0 è vero, altrimenti se è 0 è sempre falso
//
// branch multivia:
// if(){}
// else if(){}
// else if(){}
// else if(){}
// else{}
//
// Esempio:
// if(ptr == NULL && *prt == 10){
//	Blocco A
// }
// else{
// 	Blocco B
// }
//
//	Usando gli switch il compilatore riesce a velocizzare l'esecuzione
// switch(expr){
// 	case val1:
//	break;
//	case val2:
//	break;
// }
//
// 
// Diramazione incondizionata (Da non usare a livello applicativo)
//	  ...
//	  goto label;
//	  ...
//	  ...
//	  ...
// label: ...
// 	  ...
//
// continue --> porta avanti di un ciclo il 
//
// Come si usano le funzioni?????
// int ceiling(int, int);
//
// int main() {
//	int a = 8;
//	const int b = 47; --> Le costanti sono in sola lettura
//
//	printf("I need %d packs id snacks for &d students.\n", ceiling(a, b), a);
//
// }	
//
// int ceiling(int n, int b){
//	//cond: n>=0, b>0
//	return (n+b-1)/b;
// }
//
// man + nome funzione --> spiegazione dell'isruzione
// 
//
// Tutti i programmi in c se hanno una definizione di funzione implicita assume che sia intero
//
// In C non esiste overloading
//
// Esiste una parola chiave extern prima della dichiarazione di una funzione (se la funzione non è definita nel modulo corrente)--> non necessario
//
//
// Comandi di shell:
// 	- ls --> lista dei file di una cartella -l (long)
// 	- cp --> copia un file sorgente (primo paramentro) in un percorso destinazione (secondo parametro)
//
//
//
//In programmazione in linguaggio C, i "file di intestazione" sono file speciali che contengono le dichiarazioni di funzioni, macro, tipi di dati e altre dichiarazioni che vengono utilizzate in uno o più file sorgente (.c) all'interno di un progetto. Questi file di intestazione hanno solitamente un'estensione di file ".h" (per esempio, "myfile.h").

// Ecco alcuni punti chiave sui file di intestazione in C:

// Dichiarazioni di funzioni: I file di intestazione contengono spesso dichiarazioni di funzioni che saranno definite in un file sorgente separato. Questo consente al compilatore di verificare che le chiamate di funzione siano fatte correttamente senza conoscere i dettagli di implementazione.

// Dichiarazioni di macro: Possono anche contenere macro pre-processore, che sono direttive utilizzate per eseguire sostituzioni di testo durante la fase di preprocessamento del codice sorgente.

// Dichiarazioni di tipi di dati: Le dichiarazioni di tipi di dati personalizzati o strutture possono essere incluse nei file di intestazione, consentendo così l'uso di tali tipi di dati in più parti del codice.

// Prevenzione delle inclusioni multiple: I file di intestazione sono progettati per essere inclusi in più file sorgente (.c) all'interno del progetto. Per evitare l'inclusione multipla dello stesso file di intestazione, si utilizzano direttive di precompilazione come #ifndef, #define, e #endif. Queste direttive creano "guardie di inclusione" per assicurarsi che il file di intestazione venga incluso solo una volta in ogni file sorgente.

// Separazione tra interfaccia e implementazione: L'uso dei file di intestazione aiuta a separare l'interfaccia di un modulo software (le dichiarazioni visibili all'esterno) dalla sua implementazione (il codice reale delle funzioni). Questo favorisce la modularità e la manutenibilità del codice.
///

/// Giovedì 28/09/2023
// 
// Le scanf servono per gli input
// 
// int n;
// scanf("%d", &n); --> Deve salvare il valore nell'indirizzo di n (&n ==> sarebbe l'indirizzo di n) 
// 	|	il valore restituire rispecchia il numero di conversioni avvenute con successo
//	ˡ--> Scansione Formattata 
// Il carattere di fine riga viene considerato nella lettura dello stream di input
// EOF è definito stdio.h ed è una costante simbolica il cui valore viene restituito quando la lettura di un file è finita 
// 
// L'utilizzo di extern è importante quando si lavora con variabili globali che devono essere condivise tra più file sorgente di un progetto. Senza extern, ogni file sorgente considererà la variabile globale come se fosse locale a quel file, portando a comportamenti indesiderati e a errori di collegamento durante la fase di compilazione. La dichiarazione extern consente di dichiarare una variabile globale in un file e di utilizzarla in altri file, garantendo che siano effettivamente condivise
// fflush pulisce il buffer di input
// Le costanti simbolice sono definite a livello di precompilatore --> #define NOME *valore*
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//