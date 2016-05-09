#!/usr/bin/env python
import math, sys, os

def main():  # The main method being called
	myArray = promptArray()
	insertArray(myArray)
	newArray = displayArray()
	a = [1, 2, 3, 4]
	b = set(tuples(a))
	print(b)


def tuples(A):
    try: return tuple(tuples(a) for a in A)
    except TypeError: return A




def removeduplicates(newArray):
	
	x = 0
	while x < len(newArray):
		i = newArray[x]
		newArray.pop(newArray.index(i))
	
		try:
			print(newArray.index(1))
		except ValueError:
			pass

		x+= 1
	print(newArray)	


def insertArray(myArray):
	if myArray == 'delete':
		f = open('generatedfile', 'w')
		f.truncate()
		f.close()
	else:
		f = open('generatedfile', 'a')
		f.write(myArray)
		f.write(',')
		f.close()


def promptArray(): # Allowing the user to put in an element
	print("Typing 'delete' will remove the array")
	print("Give me an Array")
	myArray = raw_input("> ")
	return myArray

def displayArray(): # Prints the Array
	f = open('generatedfile', 'r')
	for i in f.readlines():
		myArray = (i.split(","))
	myArray.pop()
	return myArray

main()	