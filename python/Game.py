from multiChoice import ask

def x():
	print 'yo'

options = [
	{'code': '1', 'description':'hello', 'callback': x}
]

class Game:
	def __init__(self, name):
		self.name = name;

	def start(self):
		print 'hi ' + self.name
		ask('would you like?', options)