x = 1
i = .1
v = .1
while x < 15:
	v = (i + v)/(1 + v * i)
	print(v)
	x += 1
	