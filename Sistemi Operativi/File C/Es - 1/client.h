#ifndef _CLIENT_H
#define _CLIENT_H

#include "address.h"

#define CL_EMPTYCF  {'X', 'X', 'X', 'X','X', 'X', 'X', 'X','X', 'X', 'X', 'X','X', 'X', 'X', 'X'}
#define CL_EMPTYCLIENT { CL_EMPTYCF, NULL, NULL, ADDR_EMPTYADDRESS}
#define CL_CFLENGTH 16

// Definizione del tipo 'client'
typedef struct {
   char         cf[CL_CFLENGTH];        
   const char  *first_name;
   const char  *last_name;
   address      addr;
} client;

// Operazioni su dati di tipo 'client'
extern client cl_set_name(client, const char *,const char *);
extern client cl_set_address(client, address);
extern client cl_set_cf(client, char cf[]);
extern void   cl_print(client);

#endif
