# This Python file uses the following encoding: utf-8
class Inventory:
	def __init__(self, cash):
		self.cash = cash
		self.items = []
	def display(self):
		print 'Cash: £{0}'.format(self.cash)
		for item in self.items:
			print '{0}:\t{1}'.format(item['name'], item['quantity'])
	def add(self, product, qty):
		exists = False
		for item in self.items:
			if item['name'] == product:
				item['quantity'] += qty
				exists = True
		if exists == False:
			self.items.append({'name': product, 'quantity': qty})