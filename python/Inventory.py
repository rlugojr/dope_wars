# This Python file uses the following encoding: utf-8
class Inventory:
	def __init__(self, cash):
		self.cash = cash
		self.items = []
	def display(self):
		print 'Cash: £' + str(self.cash)
		for item in self.items:
			print item['name'] + ':\t' + str(item['quantity'])
	def add(self, product, qty):
		exists = False
		for item in self.items:
			if item['name'] == product:
				item['quantity'] += qty
				exists = True
		if exists == False:
			self.items.append({'name': product, 'quantity': qty})