#!/usr/bin/env python
import sys, os, math
from collections import Counter

def display_possibilities(outcomes):

    possibility = Counter(outcomes)
    total_outcomes = 0
    for i in possibility.values():
        total_outcomes += i

    print("Total Possibilities:", total_outcomes, "\n")
    print("Sum:    Percentage:   Out of", total_outcomes, ":", sep='')

    for i in sorted(Counter(outcomes)):
        print(i, "      ", round(((possibility[i]/float(total_outcomes)) * 100), 3), "%         ", possibility[i])

def main():

    highest_roll = 7
    lowest_roll = 1
    possible_outcomes = []
    sum_of_outcomes = []

    d = [[x] for x in range(lowest_roll ,highest_roll)]
    rd = [[x] for x in reversed(range(lowest_roll, highest_roll))]

    for x in d:
        for i in rd:
            possible_outcomes.append(x+i)

    for result in possible_outcomes:
        sum_of_outcomes.append(result[0]+result[1])

    print(sum_of_outcomes, "\n")

    display_possibilities(sum_of_outcomes)

if __name__=="__main__":
    main()
