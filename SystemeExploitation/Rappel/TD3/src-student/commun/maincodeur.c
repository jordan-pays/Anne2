
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>


void codage(int in);
void print_usage();

int main(int argc, char **argv){
    if(argc != 2){
        print_usage();
    }

    int input = open(argv[1],O_RDONLY);
    if(input != -1){
    codage(input);
    }
    else{
        perror("erreur d ouverture de fichier");
    }
}

void print_usage()
{
    printf("codage <nom fichier>\n");
};