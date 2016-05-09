#!/usr/bin/env python
import sys, os

def paradigm(num):
    num = str(num)
    length = len(num)
    if length == 1:
        return True
    elif length == 2:
        if num[0] == num[1]:
            return True
        else:
            return False
    elif length == 3:
        if num[0] == num[2]:
            return True
        else:
            return False
    elif length == 4:
        if num[0] == num[3] and num[1] == num[2]:
            return True
        else:
            return False
    elif length % 2 != 0:
        x = 0
        while x < length/2:
            if num[0+x] == num[(length-1)-x]:
                pass

            else:
                return False
            x+=1

        return True
    elif length % 2 == 0:
        x=0
        while x < length/2:
            if num[0+x] == num[(length-1)-x]:
                pass
            else:
                return False
            x+=1

        return True
        
        

def main():
    allnum = 0
    while allnum < 10000:
        ans = paradigm(str(allnum))

        if ans == True:
            print("%r is a paradigm") % (allnum)

            f = open('dict', 'a')
            f.write(str(allnum))
            f.write(",")
            f.close()
            
        else:
            print("%r is NOT a paradigm") % (allnum)
    	allnum+=1

main()
