#include <stdio.h>

int average(int array[], int size);

int main(){
  int array[] = {1,2,3,4};
  int avg = average(array, 4);
  printf("%d", avg);
  return 0;
}

int average(int array[], int size){
  int i;
  int avg = 0;
  for(i=0;i<size;i++){
    avg+= array[i];
  }
  return avg;
}
