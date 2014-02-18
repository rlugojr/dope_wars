# This Python file uses the following encoding: utf-8
import os
from multiChoice import ask
from Location import Location
from Inventory import Inventory


class Game:
	maxDays = 30
	currentDay = 0
	currentLocation = 0
	def __init__(self, name, locations, cash, products):
		self.locations = getLocations(locations, products)
		self.name = name;
		self.inventory = Inventory(cash)

	def start(self):
		self.currentDay += 1
		location = self.getLocation()
		print 'Oh hai {0}!'.format(self.name)
		print '{0} days left!'.format(self.maxDays - self.currentDay)
		print 'Location: {0}'.format(location.name)
		self.mainLoop()

	def mainLoop(self):
		self.inventory.display() 
		self.getLocation().display()
		self.getTradeOptions()

	def getLocation(self):
		return self.locations[self.currentLocation]

	def getTradeOptions(self):
		code = 0
		options = []
		location = self.getLocation()
		for product in location.market:
			option = {'code': str(code), 'description':product['name'], 'callback':self.getPurchaseClosure(product)}
			options.append(option)
			code += 1
		options.append({'code':'m', 'description':'check out a different area', 'callback':self.travel})
		options.append({'code':'q', 'description':'quit', 'callback':self.exit})
		ask('Would you like to trade?', options)
	def getPurchaseClosure(self, product):
		def cb():
			qty = raw_input('how many?\n')
			self.purchase(product, int(qty))
		return cb
	def exit(self):
		print 'goodbye!'
		os._exit(0)	
	def travel(self):
		code = 0
		options = []
		for location in self.locations:
			option = {'code': str(code), 'description':location.name, 'callback':self.getMovementClosure(location)}
			options.append(option)
			code += 1
		options.append({'code':'q', 'description':'quit', 'callback':self.exit})
		ask('Where would you like to go?', options)
	def getMovementClosure(self, location):
		def cb():
			self.moveTo(location)
		return cb
	def moveTo(self, location):
		self.currentLocation = self.locations.index(location)
		self.start()
	def purchase(self, product, qty):
		price = product['price'] * qty
		if(self.inventory.cash >= price and product['quantity'] >= qty):
			self.inventory.cash -= price
			self.inventory.add(product['name'], qty)
			product['quantity'] -= qty
		elif(self.inventory.cash < price):
			print 'insufficient funds'
			print 'you only have £{0}, but transaction costs £{1}'.format(self.inventory.cash, price)
		else:
			print 'not that many available'
			print 'you want {0}, but there are only {1} units'.format(qty, product['quantity'])
		self.mainLoop()
		


""" location builder functions """

def getLocations(locationNames, products):	
	locationList = []
	for location in locationNames:
		productList = setupProducts(products)
		locationList.append(Location(location, productList))
	return locationList

def setupProducts(productDefs):
	products = []
	for product in productDefs:
		products.append({
				'name': product['name'],
				'price': getPrice(product),
				'quantity':getQuantity(),
				'min':product['min'],
				'max':product['max']
			})
	return products


def getPrice(product):
	return 10

def getQuantity():
	return 10