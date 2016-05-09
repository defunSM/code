#include <stdio.h>
#include <string.h>

int main() {
  int c;

  printf( "Enter a Value:" );
  c = getchar();

  printf( "\nYou entered: ");
  putchar(c);

  return 0;
  
}
