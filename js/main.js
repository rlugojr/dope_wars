var question = require('./question.js');
var Game = require('./Game.js');
var Location = require('./Location.js');
var Inventory = require('./Inventory.js');

console.log('Dope Wars JS\n');

var downtown = new Location('Downtown', getNewMarket());
var uptown = new Location('Uptown', getNewMarket());
var suburbs = new Location('Suburbs', getNewMarket());
var docks = new Location('Docks', getNewMarket());

var locations = [downtown, uptown, suburbs, docks];
var inventory = new Inventory(2000);


question.ask('what is your name? : ', function(answer){
	var game = new Game(answer, locations, inventory);

	game.day();
});

function getNewMarket(){
	return [
		{name:'Cannabis', quantity: 10, price: 20},
		{name: 'Ecstasy', quantity: 20, price: 10}
	];
}


