#include "td3.h"

char ALPHABET_PALETTE[PALETTE_SIZE] = {'a',
'b',
'c',
'd',
'e',
'f',
'g',
'h',
'i',
'j',
'k',
'l',
'm',
'n',
'o',
'p',
'q',
'r',
's',
't',
'u',
'v',
'w',
'x',
'y',
'z',
' ',
',',
';',
'!',
'?',
'.'    
};

char* NOM_FICHIERS[PALETTE_SIZE] = 
{
"a.in",
"b.in",
"c.in",
"d.in",
"e.in",
"f.in",
"g.in",
"h.in",
"i.in",
"j.in",
"k.in",
"l.in",
"m.in",
"n.in",
"o.in",
"p.in",
"q.in",
"r.in",
"s.in",
"t.in",
"u.in",
"v.in",
"w.in",
"x.in",
"y.in",
"z.in",
"space.in",
"comma.in",
"semicolon.in",
"exclamation.in",
"interrogation.in",
"dot.in"
};


int get_index_for_char(char c){
    if(c >= 'a' && c <= 'z')
    {
        return c - 'a';
    }
    else {
        switch (c)
        {
        case ' ':
        return 26;
        case ',':
        return 27;
        case ';':
        return 28;
        case '!':
        return 29;
        case '?':
        return 30;
        case '.':
        return 31;
        default:
            return -1;
        }
    }
}


char* get_filename_for_char(char c){
    int i = get_index_for_char(c);
    if(i < 0){
        return NULL;
    } else
    {
        return NOM_FICHIERS[get_index_for_char(c)];
    }
}
