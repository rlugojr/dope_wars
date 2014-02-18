# This Python file uses the following encoding: utf-8
class Location:
	def __init__(self, name, market):
		self.name = name
		self.market = market
	def display(self):
		for product in self.market:
			print '{0}:\t£{1}\t{2}'.format(product['name'], product['price'], product['quantity'])