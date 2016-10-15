class Person:

    population = 0

    def __init__(self, name, money):
        self.name = name
        self.money = money


    def getname(self):
        print(self.name)

    def getmoney(self):
        print(self.money)

    def getpopulation(self):
        print(self.population)


def main():

    a = Person("Batman", 999999999)
    k = Person("Superman", 100000)

    print("Batman info:")
    a.getname()
    a.getmoney()
    a.getpopulation()

    print("Superman info:")
    k.getname()
    k.getmoney()
    k.getpopulation()

    print(type(a))


main()
