#include <stdlib.h>
#include <stdio.h>
#include <iostream>
#include <string.h>
#include <time.h>
#include <algorithm>

#define DISPLAY(x) std::cout << x << std::endl;

const int col = 12;
const int row = 12;
char useranswer;
int max = 0;
int min = 890;
int myArray[col][row];
int userCol;
int userRow;
int sum = 0;
int sortArray[col];

int makeRandom();
int makeArray();
int displayArray();
int findMax();
int findMin();
int findCol();
int findRow();
int sortCol();
int ask();

int ask()
{
  printf("What would you like to find? (c/r): ");
  useranswer = getchar();

  if (useranswer == 'c')
    {
      printf("Enter the col:");
      std::cin >> userCol;
      findCol();
    }

  if (useranswer == 'r')
    {
      printf("Enter the row:");
      std::cin >> userRow;
      findRow();
    }


}

int findRow()
{
  for (int y = 0; y < row; ++y)
    {
      sum += myArray[y][userRow];
      DISPLAY(myArray[y][userRow]);
    }

  printf("\n");

  DISPLAY(sum);
}

int findCol()
{
  for (int y = 0; y < row; ++y)
    {
      sum += myArray[userCol][y];
      DISPLAY(myArray[userCol][y]);
    }

  printf("\n");

  printf("TOTAL: %i", sum);

}

int sortCol()
{

  for (int y = 0; y < row; ++y)
    {
      sortArray[y] = myArray[userCol][y];
    }

}

int displayCol()
{
  for (int y = 0; y < row; ++y)
    {

      printf("%i", sortArray[y]);
      printf("\n");
    }

}

int bubbleSort()
{

  int swapHolder;
  int i = 0;
  while (i < 12)
    {
      for (int index = 0; index < 12; index++)
        {
          if(sortArray[index] < sortArray[index+1])
            {
              swapHolder = sortArray[index+1];
              sortArray[index+1]= sortArray[index];
              sortArray[index] = swapHolder;
            }
        }
      i++;
    }
}

int main(int argc, char *argv[])
{

  makeArray();
  displayArray();
  int localmax = findMax();
  DISPLAY(localmax);
  int localmin = findMin();
  DISPLAY(localmin);
  ask();
  printf("\n");
  sortCol();
  bubbleSort();
  displayCol();

  return 0;
}

int findMin()
{

  for (int y = 0; y < row; ++y)
    {

      for(int x = 0; x < col; ++x)
        {

          if (min > myArray[x][y])
            {
              min = myArray[x][y];
            }

        }

    }

  return min;
}

int findMax()
{

  for (int y = 0; y < row; ++y)
    {

      for(int x = 0; x < col; ++x)
        {

          if (max < myArray[x][y])
            {
              max = myArray[x][y];
            }

        }

    }

  return max;
}

int displayArray()
{
  for (int y = 0; y < row; ++y)
    {

      for(int x = 0; x < col; ++x)
        {
          printf("%i ", myArray[x][y]);

        }

      DISPLAY("\n");

    }

  return 1;
}

int makeArray()
{
  for (int y = 0; y < row; ++y)
    {

      for(int x = 0; x < col; ++x)
        {
          myArray[x][y] = makeRandom();

        }

    }

  return 1;
}

int makeRandom()
{

  int r = rand() % 890;
  if (r < 150) {
    makeRandom();
  }

  return r;
}
