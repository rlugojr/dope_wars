from multiChoice import ask
from Location import Location

def x():
	print 'yo'

options = [
	{'code': '1', 'description':'hello', 'callback': x}
]



class Game:
	currentLocation = 0
	def __init__(self, name, locations):
		self.locations = getLocations(locations)
		self.name = name;

	def start(self):
		print 'hi ' + self.name
		print 'you are at ' + self.locations[self.currentLocation].name
		#ask('would you like?', options)



def getLocations(locationNames):	
	locationList = []
	for location in locationNames:
		locationList.append(Location(location))
	return locationList