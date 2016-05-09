#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>

struct Person {
  char *name;
  int age;
  int height;
  int weight;
};

struct Person *Person_create(char *name, int age, int height, int weight)
{
  struct Person *who = malloc(sizeof(struct Person));
  assert(who != NULL);

  who->name = strdup(name);
  who->age = age;
  who->height = height;
  who->weight = weight;

  return who;
}

void Person_destroy(struct Person *who)
{
  assert(who != NULL);
  
  free(who->name);
  free(who);
  
}

void Person_print(struct Person *who)
{
  printf("Name: %s\n", who->name);
  printf("\tAge: %d\n", who->age);
  printf("\tHeight: %d\n", who->height);
  printf("\tWeight: %d\n", who->weight);
}

int main(int argc, char *argv[])
{
  struct Person *salman = Person_create("Salman Hossain", 18, 64, 118);
  struct Person *fahim = Person_create("Fahim Shariar", 18, 64, 118);

  printf("Salman is at memory location %p \n", salman);
  Person_print(salman);

  printf("Fahim is at memory location %p \n", fahim);
  Person_print(fahim);

  salman->age += 20;
  salman->height -= 2;
  salman->weight += 20;
  Person_print(salman);

  fahim->age += 20;
  fahim->weight += 40;
  Person_print(fahim);
  
  Person_destroy(salman);
  Person_destroy(fahim);
  
  return 0;

}
