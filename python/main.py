import os
from Game import Game

locationNames = ['Downtown', 'Uptown', 'Suburbs', 'Docks']
cash = 2000
products = [
	{'name':'Cannabis', 'min':10, 'max':50},
	{'name':'Ecstacy', 'min':3, 'max':30}
]


def start():
	os.system('clear');
	print 'dope wars py'
	name = raw_input('what\'s your name?\n')
	game = Game(name, locationNames, cash, products)
	game.start()

start()