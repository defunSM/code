#include <stdio.h>
#include <string.h>

struct Book{

  char title[50];
  char author[50];
  int booknumber;
  
};

void printbook(struct Book book);

int main(){

  struct Book Book1;

  strcpy(Book1.title, "Your Mom");
  strcpy(Book1.author, "Salman Hossain");
  Book1.booknumber = 111102;

  printbook(Book1);

  return 0;
}

void printbook(struct Book book){
  printf("%s\n", book.title);
  printf("%s\n", book.author);
  printf("%d\n", book.booknumber);
}


