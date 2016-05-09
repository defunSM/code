#include <stdio.h>
#include <ctype.h>
#include <string.h>

int can_print_it(char ch);
void print_letters(char arg[]);

void print_arguments(int argc, char *argv[])
{
  int i=1;
  
  for(i=1;i<argc;i++) {
    print_letters(argv[i]);
  }
}

void print_letters(char arg[])
{
  int i =0;

  for(i = 0;arg[i]!='\0';i++) {
    char ch = arg[i];

    if(isalpha(ch) || isdigit(ch)) {
      printf("%c:%d\n", ch, ch);
    }
  }


}

int main(int argc, char *argv[])
{
  print_arguments(argc, argv);
  return 0;
}


