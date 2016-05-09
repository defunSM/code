
from sys import argv 

# Perfect square root visual representation

prompt = "> "

def repeat_a(number):
		number = number + 1
		symbol = "\t*"
		token = 0
		token2 = number
		total = (number - 1) * (number - 1) + (2 * (number - 1)) + 1
		

		while number != token:
			print(symbol*token)
			token += 1
			
		while token2 != 0:
			print(symbol*token2)
			token2 -= 1

		
		print("Total: ")
		print(total)
		
		







def intro():
		print("Running ex1.py....\nPlease Enter a Number:\n")
		
intro()
number = input(prompt)
repeat_a(number)


