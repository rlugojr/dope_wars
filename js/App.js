var question = require('./question.js');
var Game = require('./Game.js');
var locationBuilder = require('./locationBuilder.js');
var Inventory = require('./Inventory.js');

function App(config){
	this.startCash = config.startCash;
	this.turns = config.turns;
	this.maxProducts = config.maxProducts;
	this.products = config.productList;
	this.places = config.placeList;
}

App.prototype.start = function(){
	var inventory = new Inventory(this.startCash);
	var locations = locationBuilder.bind(this, this.places, this.products, this.maxProducts);


	console.log('Dope Wars JS\n');
	question.ask('what is your name? : ', function(answer){
		var game = new Game(answer, locations, inventory, this.turns);

		game.day();
	}.bind(this));
};

module.exports = App;
