import sys, os

def encryption(string):

	a = list(range(ord('a'), ord('z')+1)) # Range a to z
	alphabet = []
	sArray = []
	eArray = ''
	x = 0

	for i in a:
		alphabet.append(chr(i))

	for i in string:  # Creates the prompt into array
		sArray.append(i) 
		x += 1

	for i in sArray:
		
		if i in alphabet:  # If input is found in string
			eArray += (alphabet[alphabet.index(i)-15])

	print(eArray)

def decryption(string):

	a = list(range(ord('a'), ord('z')+1)) # Range a to z
	alphabet = []
	sArray = []
	eArray = ''
	x = 0

	for i in a:
		alphabet.append(chr(i))

	for i in string:  # Creates the prompt into array
		sArray.append(i) 
		x += 1

	for i in sArray:
		
		if i in alphabet:  # If input is found in string
			eArray += (alphabet[alphabet.index(i)-11])

	print(eArray)


if sys.argv[1] = '-e':
	encryption(sys.argv[2])
elif sys.argv[1] = '-d':
	encryption(sys.argv[2])
else:
	print(Argument NOT understood.)