var question = require('./question.js');
var Game = require('./Game.js');
var Location = require('./Location.js');
var Inventory = require('./Inventory.js');


var MAXIMUM_QUANTITY = 100;

var products = [
	{name:'Cannabis', min:10, max:50},
	{name:'Ecstasy', min:5, max:30}
];

function getNewMarket(){
	return products.map(function(product){
		return {
			name : product.name,
			price : getRandomPrice(product),
			quantity: getRandomQuantity(),
			min: product.min,
			max: product.max
		};
	});
}

function getRandomPrice(product){
	var suggestedPrice = Math.round(product.max * Math.random());
	var price = Math.max(product.min, suggestedPrice);

	return price;
}

function getRandomQuantity(){
	return Math.round(Math.random()* MAXIMUM_QUANTITY);
}




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