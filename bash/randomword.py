#!/usr/bin/env python
import subprocess, random, sys, os

def generateword():
    f = open('/usr/share/dict/words', 'r')
    lines = f.readlines()

    x = random.randint(1, len(lines))

    if "'" in lines[x]:
        generateword()
    else:
        return lines[x]
        
    f.close()

word = generateword()
os.system("dict " + str(word) + " > dict")
f = open('dict', 'r')
lines  = f.readlines()

print(lines[5])


