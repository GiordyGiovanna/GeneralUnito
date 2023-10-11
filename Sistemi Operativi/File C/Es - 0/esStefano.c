#include <stdio.h>
/* Codice che concatena le due stringhe v1 e v2 */
int main()
{
	char v1[10] = "Prima,";
	char v2[10] = " dopo";
	char ret[20] = "";

	int len1, len2, i;

	 /* Lunghezza delle due stringhe */
	len1 = sizeof(v1) / sizeof(v1[0]);
	len2 = sizeof(v2) / sizeof(v2[0]);
	for(i = 0; i < len1 - 2; i++){
		ret[i] = v1[i];
	}
	i = 0;
    for(int k = 0; k < 20; k++){
        if(ret[k] == '\0'){
            printf("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
            ret[k] = " ";
        }
    }
    printf("%s\n", ret);
	/* Copia la seconda stringa alla fine della prima */
	for (i = 0; i < len2; i++){
        int j = i + 10;
		ret[j] = v2[i];
        printf("%c\n", ret[j]);

	}
    ret[len1 + len2] = '\0';

	
	/* Stampa la stringa concatenata */
	printf("%s\n", ret);
	
}
