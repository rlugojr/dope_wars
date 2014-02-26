# This Python file uses the following encoding: utf-8

from random import randrange

class Location:
	def __init__(self, name, market):
		self.name = name
		self.marketDef = market
		self.update()
	def display(self):
		for product in self.market:
			print '{0}:\t£{1}\t{2}'.format(product['name'], product['price'], product['quantity'])

	def update(self):
		self.market = self.setupProducts(self.marketDef)

	def setupProducts(self, productDefs):
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
	return randrange(product['min'], product['max'], 1)

def getQuantity():
	MAX_QTY = 100
	return randrange(0, 100, 1)