
#include "../commun/td3.h"

extern Handler HANDLER_TABLE[PALETTE_SIZE];
extern char ALPHABET_PALETTE[PALETTE_SIZE];
extern char* NOM_FICHIERS[PALETTE_SIZE];



//choix de la palette a utiliser
char* palette_courante = ALPHABET_PALETTE;

int get_index_for_char(char) ;

static unsigned int _seed = 0;
void init_secret(int seed)
{
    _seed = seed;
}
int next_number(int n){
    return (8253729 * n + 2396403);
}

int get_decalage(){
    _seed = next_number(_seed); 
    return (_seed%32767);
}




void codage(int in)
{

}

void decodage(int out)
{


}
