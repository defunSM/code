import sys, math

def hypothenuse(a, b):

    return math.sqrt(float(a) ** 2 + float(b) ** 2)

def main():

    print(hypothenuse(sys.argv[1], sys.argv[2], 3))

main()
