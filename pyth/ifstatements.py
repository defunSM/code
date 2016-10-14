def main():

    if (True):
        print("I am printing because I am True!")

    if (False):
        print("I am not going to print because I am False!")


    age = 19

    if (age > 10):
        print("I am older than 10 years.")

    if (age > 20):
        print("I am older than 20 years.")
    else:
        print("I am younger than 20 years.")


    grade = 81

    if (grade > 90):
        print("I got over 90.")
    elif (grade > 80):
        print("I got over 80")
    elif (grade > 70):
        print("I got over 70.")
    else:
        print("I got under 70.")


    if (grade > 90 and age > 20):
        print("I got over a 90 and I am over 20 years old.")
    elif (grade > 70 and age > 20):
        print("I got over a 70 and am over 20 years old.")
    else:
        print("I got a", grade, "and am over", age, "years old.")

main()
