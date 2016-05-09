# Chaos function

prompt = "Enter a number between 0 and 1:\n> "
next = "\n"

def main():
	x = input(prompt)
	print(next)
	for i  in range(10):
		x = 3.9 * x * (1 - x)
		print(x)

main()