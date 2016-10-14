import sys
import math

def main():

    if (sys.argv[1] == "sin"):
        answer = math.sin(math.radians(float(sys.argv[2])))
        print(answer)
    elif (sys.argv[1] == "cos"):
        answer = math.cos(math.radians(float(sys.argv[2])))
        print(answer)
    else:
        print("Don't know what to do with ", sys.argv[1])

main()
