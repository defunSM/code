#include <iostream>
#include <ctime>
using namespace std;

int main()
{
  clock_t start_time , finish_time;
  
  start_time = clock();
  finish_time = clock();
  double delay_time = (double)(finish_time - start_time);

  cout<<"Delay time:"<<(double)delay_time<<" seconds."<<endl;

  start_time = clock();

  for (int i = 0; i < 100000; i++)
    {
      cout <<"In:"<<i<<" loop" <<endl;
    }

  finish_time = clock();

  double elapsed_iter_time = (double) (finish_time - start_time);
  elapsed_iter_time -= delay_time;

  double elapsed_time = elapsed_iter_time / CLOCKS_PER_SEC;

  cout<<"Elasped time:"<<(double)elapsed_time<<" seconds."<< endl;

  start_time = clock();
  finish_time = clock();
  delay_time = (double)(finish_time - start_time);

  cout<<"Delay time:"<<(double)delay_time<<" seconds."<<endl;

  start_time = clock();

  for (int i = 0; i < 500000; i++)
    {
      cout <<"In:"<<i<<" loop" << endl;
    }

  finish_time = clock();

  elapsed_iter_time = (double)(finish_time - start_time);
  elapsed_iter_time -= delay_time;
  
  elapsed_time = elapsed_iter_time / CLOCKS_PER_SEC;

  cout<<"Elapsed time:"<<(double)elapsed_time<<" seconds."<<endl;

  return 0;

}
