#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <ctype.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

typedef void (*Handler)(int fd);

int get_index_for_char(char c);
char* get_filename_for_char(char c);

#define PALETTE_SIZE 32

#define SECRET 1234


extern char ALPHABET_PALETTE[PALETTE_SIZE];

void print_a(int fd);
void print_b(int fd);
void print_c(int fd);
void print_d(int fd);
void print_e(int fd);
void print_f(int fd);
void print_g(int fd);
void print_h(int fd);
void print_i(int fd);
void print_j(int fd);
void print_k(int fd);
void print_l(int fd);
void print_m(int fd);
void print_n(int fd);
void print_o(int fd);
void print_p(int fd);
void print_q(int fd);
void print_r(int fd);
void print_s(int fd);
void print_t(int fd);
void print_u(int fd);
void print_v(int fd);
void print_w(int fd);
void print_x(int fd);
void print_y(int fd);
void print_z(int fd);
void print_space(int fd);
void print_comma(int fd);
void print_semicolon(int fd);
void print_exclamation(int fd);
void print_interrogation(int fd);
void print_dot(int fd);
