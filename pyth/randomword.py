#!/usr/bin/env python
import subprocess, random, sys, os

def randomrange():
	try:
		value1 = int(sys.argv[1])
		value2 = int(sys.argv[2])

		randvalue = random.randint(value1, value2)
		return randvalue

	except IndexError:
		
		randvalue = random.randint(0,10000000)
		return randvalue

def main():

	value = randomrange()
	print(value)


main()
