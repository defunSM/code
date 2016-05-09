#include <stdio.h>
#include <string.h>

int main(int argc, char *argv[])
{
  
  int ages[] = {23, 43, 12, 89, 2};
  char *names[] = {
    "Salman", "Shihab",
    "David", "Shaisob", "Fahim"
  };

  int count = sizeof(ages) / sizeof(int);
  int size = sizeof(int);
  int i = 0;

  printf("Size of ages: %d", size);

  for(i = 0; i < count; i++) {
    printf("%s has %d years alive.\n",
	   names[i], ages[i]);
  }

  printf("---\n");

  int *cur_ages = ages;
  char **cur_names = names;

  for(i = 0; i < count; i++) {
    printf("%s is %d years old.\n", *(cur_names+i), *(cur_ages+i));
  }

  printf("---\n");

  for(i = 0; i < count; i++) {
    printf("%s is %d years old again.\n", cur_names[i], cur_ages[i]);
  }

  printf("---\n");
  
  for(cur_names = names, cur_ages = ages;
      (cur_ages - ages) < count;
      cur_names++, cur_ages++) 
  {
    
    printf("%s lived %d years so far.\n",
	   *cur_names, *cur_ages);

  }

  
  return 0;

}
