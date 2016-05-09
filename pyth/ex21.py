#!/usr/bin/env python 
import subprocess, sys, os

try:
    filename = open(sys.argv[1], 'w+')
    nameofargv = str(sys.argv[1])
except IndexError:
    filename = open('testfile', 'w+')
    nameofargv = 'testfile'



ls = 'ls'
output = subprocess.Popen(ls)
print(output)
    
lines = filename.readlines()

for line in lines:
    print(line)
    
filename.close()
