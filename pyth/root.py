#!/usr/bin/env python
import sys, os

def mark(sections):
    x = 1
    while x < 5:
        try:
            print(sections[x])
            sections.insert(x,"+")
        except IndexError:
            pass
        x+=1
    return sections


def section(quad):
    sections = quad.split("+")
    sections = mark(sections)
    return sections
    

def quadroot(quad):
    length = len(quad)
    x=0

    sections = section(quad)
    print sections
    
    
def main(quad):
    quadroot(quad)
    
main(sys.argv[1])
