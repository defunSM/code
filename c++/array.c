#include <stdio.h>

int array[] = {2,3,5,20}; 

void printarray(int array[]){
  printf("The size of array: %ld\n", sizeof(array));
  printf("Number of elements in array: %ld\n", sizeof(array)/4);
  int i;
  for(i=0;i<3;i++){
    printf("Element %d: %d\n", i, array[i]);
  }
}

void avg(int array[]){
  float numberofelements = sizeof(array)/4;
  float sum = 0;
  int i;
  for(i=0;i<numberofelements;i++){
    sum += array[i];
  }
  printf("Size in bytes: %ld", sizeof(array));
  printf("Size: %f", numberofelements);
  printf("Sum: %f", sum/numberofelements);
}

int getRandom(){
  srand( (unsigned)time(NULL) );
  int r = rand();
  return r;
}

void itoa(int someinteger){
  printf("%ld\n", someinteger);
  printf("%d", someinteger);
}

int main()
{
  int a = 12345;
  itoa(a);
  return 0;
}


