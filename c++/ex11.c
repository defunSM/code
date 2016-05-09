
#include <stdio.h>

int main(int argc, char *argv[])
{
  //go through each string in argv

  int i = 1;
    while(i-1 < argc) {
      printf("arg %d: %s\n", i, argv[argc-i]);
      i++;
    };

  // lets make our own array of strings
  char *states[] = {
    "California", "Oregon",
    "Washington", "Texas"
  };

  int num_states = 4;
  i = 0; //watch for this
  while(i < num_states) {
    printf("State %d: %s\n", i, states[i]);
    i++;
  }

  return 0;
}
