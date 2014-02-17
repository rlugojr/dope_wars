import os
from Game import Game

locationNames = ['Downtown', 'Uptown', 'Suburbs', 'Docks']


def start():
	os.system('clear');
	print 'dope wars py'
	name = raw_input('what\'s your name?\n')
	game = Game(name, locationNames)
	game.start()

start()