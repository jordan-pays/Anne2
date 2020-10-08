#include "td3.h"
//NE PAS MODIFIER CE CODE

//
extern char* palette_courante;
int get_index_for_char(char );
//


//
Handler HANDLER_TABLE[32] = 
{
  print_a ,
  print_b ,
  print_c ,
  print_d ,
  print_e ,
  print_f ,
  print_g ,
  print_h ,
  print_i ,
  print_j ,
  print_k ,
  print_l ,
  print_m ,
  print_n ,
  print_o ,
  print_p ,
  print_q ,
  print_r ,
  print_s ,
  print_t ,
  print_u ,
  print_v ,
  print_w ,
  print_x ,
  print_y ,
  print_z ,
  print_space ,
  print_comma ,
  print_semicolon ,
  print_exclamation ,
  print_interrogation ,
  print_dot
};

void print_a(int fd){
    write(fd,&palette_courante[get_index_for_char('a')] ,sizeof(char));
}

void print_b(int fd){
    write(fd,&palette_courante[get_index_for_char('b')] ,sizeof(char));
}

void print_c(int fd){
    write(fd,&palette_courante[get_index_for_char('c')] ,sizeof(char));
}
void print_d(int fd){  
    write(fd,&palette_courante[get_index_for_char('d')] ,sizeof(char));
}
void print_e(int fd){
    
    write(fd,&palette_courante[get_index_for_char('e')] ,sizeof(char));
}
void print_f(int fd){
    
    write(fd,&palette_courante[get_index_for_char('f')] ,sizeof(char));
}
void print_g(int fd){
    
    write(fd,&palette_courante[get_index_for_char('g')] ,sizeof(char));
}
void print_h(int fd){
    
    write(fd,&palette_courante[get_index_for_char('h')] ,sizeof(char));
}
void print_i(int fd){
    
    write(fd,&palette_courante[get_index_for_char('i')] ,sizeof(char));
}
void print_j(int fd){
    
    write(fd,&palette_courante[get_index_for_char('j')] ,sizeof(char));
}
void print_k(int fd){
    
    write(fd,&palette_courante[get_index_for_char('k')] ,sizeof(char));
}
void print_l(int fd){
    
    write(fd,&palette_courante[get_index_for_char('l')] ,sizeof(char));
}
void print_m(int fd){
    
    write(fd,&palette_courante[get_index_for_char('m')] ,sizeof(char));
}
void print_n(int fd){
    
    write(fd,&palette_courante[get_index_for_char('n')] ,sizeof(char));
}
void print_o(int fd){
    
    write(fd,&palette_courante[get_index_for_char('o')] ,sizeof(char));
}


void print_p(int fd){
    
    write(fd,&palette_courante[get_index_for_char('p')] ,sizeof(char));
}
void print_q(int fd){
    
    write(fd,&palette_courante[get_index_for_char('q')] ,sizeof(char));
}
void print_r(int fd){
    
    write(fd,&palette_courante[get_index_for_char('r')] ,sizeof(char));
}
void print_s(int fd){
    
    write(fd,&palette_courante[get_index_for_char('s')] ,sizeof(char));
}
void print_t(int fd){
    
    write(fd,&palette_courante[get_index_for_char('t')] ,sizeof(char));
}
void print_u(int fd){
    
    write(fd,&palette_courante[get_index_for_char('u')] ,sizeof(char));
}
void print_v(int fd){
    
    write(fd,&palette_courante[get_index_for_char('v')] ,sizeof(char));
}
void print_w(int fd){
    
    write(fd,&palette_courante[get_index_for_char('w')] ,sizeof(char));
}
void print_x(int fd){
    
    write(fd,&palette_courante[get_index_for_char('x')] ,sizeof(char));
}
void print_y(int fd){
    
    write(fd,&palette_courante[get_index_for_char('y')] ,sizeof(char));
}
void print_z(int fd){
    
    write(fd,&palette_courante[get_index_for_char('z')] ,sizeof(char));
}

void print_space(int fd){
    
    write(fd,&palette_courante[get_index_for_char(' ')] ,sizeof(char));
}

void print_comma(int fd){
    
    write(fd,&palette_courante[get_index_for_char(',')] ,sizeof(char));
}

void print_semicolon(int fd){
    
    write(fd,&palette_courante[get_index_for_char(';')] ,sizeof(char));
}

void print_exclamation(int fd){    
    write(fd,&palette_courante[get_index_for_char('!')] ,sizeof(char));
}

void print_interrogation(int fd)
{    
    write(fd,&palette_courante[get_index_for_char('?')] ,sizeof(char));
}

void print_dot(int fd)
{    
    write(fd,&palette_courante[get_index_for_char('.')] ,sizeof(char));
}