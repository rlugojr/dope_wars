# This Python file uses the following encoding: utf-8
class Location:
	def __init__(self, name, market):
		self.name = name
		self.market = market
	def display(self):
		for product in self.market:
			print(product['name'] + ':\t' + '£' + str(product['price']) + '\t' + str(product['quantity']))