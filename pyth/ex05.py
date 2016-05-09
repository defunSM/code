#!/usr/bin/env python
import math, sys, os

class Particle():

    def __init__(self, distance, time, location):
		self.location = location
		self.time = time
		self.distance = distance
		self.velocity = (distance/time)

	def getVelocity(self):
		return self.velocity

	def setVelocity(self, velocity):
		self.velocity = velocity

	def setMotion(self, time, degree):
		self.time = time
		self.location = [(self.location[0]+self.velocity)*math.sin(degree), (self.location[1]+self.velocity)*math.cos(degree)]

	def getMotion(self):
		return self.location

d = 100
v = 10
location = [0,0]
degree = 2.5*math.pi

print(math.cos(2*math.pi))	

obj = Particle(d, v, location)
obj.setMotion(5, degree)
print(obj.getMotion())


