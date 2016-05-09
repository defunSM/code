#include <stdio.h>
#include <string.h>
#include <assert.h>
#include <stdlib.h>

char *strdup (const char *s) {
  char *d = malloc (strlen (s) + 1);
  if (d == NULL) return NULL;
  strcpy (d,s);
  return d;
}
