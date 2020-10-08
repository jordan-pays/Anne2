
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>


void decodage(int in);
void print_usage();

int main(int argc, char **argv){


    if(argc != 2){
        print_usage();
    }

    int output = open(argv[1],O_RDWR|O_CREAT);
    decodage(output);
}

void print_usage()
{
    printf("decodage <nom fichier resultat>\n");
};