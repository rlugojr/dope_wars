import os
from Game import Game

locationNames = ['Downtown', 'Uptown', 'Suburbs', 'Docks']
cash = 100
days = 30
products = [
	{'name':'Cannabis', 'min':10, 'max':50},
	{'name':'Ecstacy', 'min':3, 'max':30},
	{'name':'Heroin', 'min':20, 'max':120},
	{'name':'Cocaine', 'min':20, 'max':200},
	{'name':'Ketamine', 'min':7, 'max':70},
	{'name':'Mushrooms', 'min':2, 'max':12},
	{'name':'LSD', 'min':8, 'max':23},
	{'name':'MKat', 'min':3, 'max':15}
]


def start():
	os.system('clear');
	print 'dope wars py'
	name = raw_input('what\'s your name?\n')
	game = Game(name, locationNames, cash, products, days)
	game.start()

start()