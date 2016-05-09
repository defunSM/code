import pygame
import os, sys
import random 
import time


def display_image(image_name, x , y):
	img = pygame.image.load(image_name)
	screen.blit(img, (x, y))

def moving_image(image_name, x, y, dx, dy, token):

	"""if x < 400 and y < 300 and token == 0:
		img = pygame.image.load(image_name)
		screen.blit(img, (x, y))
		token += 1"""
		 
	img = pygame.image.load(image_name)
	screen.blit(img, (x + dx, y + dy))
	x += dx
	y += dy







def random_rec(m):

	color1 = (random.randrange(0,225),random.randrange(0,225),random.randrange(0,225))
	left = 0
	top = random.randrange(17,75)
	width = 400
	height = random.randrange(1,5)

	pygame.draw.rect(screen, color1, pygame.Rect(left, top, width, height))
		

def random_line(m):
	color1 = random.randrange(0,225)
	startx = random.randrange(0,400)
	starty = random.randrange(0,300)
	endx = random.randrange(0,400)
	endy = random.randrange(0,300)
	width = random.randrange(1,5)

	pygame.draw.line(screen, color1, (startx, starty), (endx, endy), width)

def random_circle(m):
	color1 = random.randrange(0,225)
	color2 = random.randrange(0,225)
	color3 = random.randrange(0,225)
	
	if m[1] - 10 > 0 and m[0] - 10 > 0:
		location_x = (m[0])
 		location_y = (m[1])
 	else:
 		location_x = random.randrange(20, 300)
 		location_y = random.randrange(90, 300)

	radius = random.randrange(2,5)
	pygame.draw.circle(screen, (color1,color2,color3), (location_x, location_y), radius)


pygame.init()

display_width = 400
display_height = 300
screen = pygame.display.set_mode((display_width, display_height))
clock = pygame.time.Clock()
token = 0

done = False 

while not done:

	mouse = pygame.mouse.get_pos()
	print mouse # remove when done using


	for event in pygame.event.get():
		if event.type == pygame.QUIT:
			done = True 





	screen.fill((255,255,255))
	display_image('onemorelinetitle.png', 0, 0)
	random_circle(mouse)
	moving_image('blueline.png', 0, 40, 20, 0, token)
	display_image('onemoreline.png', 20, 20) 

	pygame.display.flip()
	clock.tick(3)