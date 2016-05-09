import sys, os

# Happy Numbers 

user_input = raw_input("> ")
print ""
user_list = user_input.split()
length_of_list = len(user_list[0])
numbers = []

list_number = length_of_list
term = 1

def happy_number(user_list, length_of_list, numbers, list_number, term):
	total = 0
	value = False
	while list_number != 0:
		number = int(user_list[0][0+list_number-1])
		number = number * number
		numbers.append(number)
		i = length_of_list - 1
		list_number -= 1
		
	for a in numbers:
		total += a

	print "Term %r: %r" % (term, total)
	if total == 1:
		print "%r is a happy number!" % (user_input)
	else:
		user_list = []
		user_list.append(str(total))
		length_of_list = len(user_list[0])
		list_number = length_of_list
		numbers = []
		term += 1
		happy_number(user_list, length_of_list, numbers, list_number, term) 
		
happy_number(user_list, length_of_list, numbers, list_number, term)
	
	
