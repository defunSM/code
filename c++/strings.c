#include <stdio.h>
#include <string.h>

int main(){
  char greeting[6] = {'H','e','l','l','o','\0'};
  printf("Greeting message: %s\n", greeting);
  printf("Length: %ld", strlen(greeting));
  return 0;
}
