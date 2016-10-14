class Person:

    population = 0

    def __init__(self, name, money):
        self.name = name
        self.money = money



def main():

    a = Person("Batman", 999999999)

    print(a.name)
    print(a.money)



main()
