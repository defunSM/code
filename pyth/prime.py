#!/usr/bin/env python
import sys, os

def prime(num):  # Determines if a number is prime or composite.
    if num == 2:
        return True
    x = 1
    i = 0
    while x != num:
        if num % x == 0:
            i += 1
        else:
            pass

        x+= 1

    if i < 2:   # Changing this will determine if the number is composite
        return True
    else:
        return False

def composite(num): #Determines if a number is composite or not 
    if num == 2:
        return True
    x = 1
    i = 0
    while x != num:
        if num % x == 0:
            i += 1
        else:
            pass

        x+= 1

    if i < 2:   # Changing this will determine if the number is prime
        return False
    else:
        return True
    

def main(num):
    result = prime(int(num))

    if result == True:

        print("%r is prime") % (num)
        f = open('dict', 'a')
        f.write(str(num))
        f.write(",")
        f.close()
        
    else:
        print("%r is not prime") % (num)

numbers = 1
while numbers < 10000:
    main(numbers)
    numbers+=1
    
