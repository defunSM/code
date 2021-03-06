#!/usr/bin/env python
import sys, os

def happynumber(num):
    
    numbers = str(num)
    length = len(numbers)
    i = 0
    sum = 0

    while i != length:
        sum += int(numbers[i])*int(numbers[i])     
		i += 1
        
    if sum != 1:
    	happynumber(sum)
    else:
        return True
    

def check(num):
    
    num = int(num)
    try:
        value = happynumber(num)
        return value
    except RuntimeError:
    	return False

x = 0
while x < 10000:    
    try:
    
        determine = check(str(x))
        if determine == True:
            print("%r is a happy number!") % (x)
            f = open('dict', 'a')
            f.write(str(x))
            f.write(",")
            f.close()
        
        else:
            print("%r This is not a happy number!") % (x)

        x+= 1
    except ValueError:
        pass
