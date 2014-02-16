var question = require('./question.js');

function Game(playerName, locations, inventory){
	this.playerName = playerName;
	this.location = 0;
	this.locations = locations;
	this.inventory = inventory;
}

Game.prototype.day = function(){

	var currentLocation = this.getLocation();
	console.log('\n\n-----------------------------------');
	console.log('Oh hai, ' + this.playerName + '!');
	console.log('\nInventory:');
	console.log(this.inventory.display());
	console.log(currentLocation.display());

	this.outputTradeOptions(currentLocation.getItems());
};

Game.prototype.outputTradeOptions = function(availableItems){
	var code = 0;
	var purchaseOptions = availableItems.map(function(item){
		return {
			code: code++,
			description: 'buy ' + item.name,
			callback:this.buyQuantity.bind(this, item)
		};
	}.bind(this));

	this.inventory.items.forEach(function(item){
		purchaseOptions.push( {
			code: code++,
			description:'sell ' + item.name,
			callback: this.sellQuantity.bind(this, item)
		});
	}.bind(this));

	purchaseOptions.push({
		code: 'm',
		description: 'move location',
		callback: this.outputMovementOptions.bind(this)
	});

	purchaseOptions.push({
		code: 'q',
		description: 'quit',
		callback: function(){
			console.log('goodbye!');
			process.exit();
		}
	})

	question.multi('Would you like to trade? ', purchaseOptions);

};

Game.prototype.buyQuantity = function(item){
	question.ask('how many? ', function(answer){
		this.inventory.add(item.name, parseInt(answer, 10));
		this.getLocation().sell(item.name, answer);

		this.inventory.cash -= item.price * answer;

		this.day();
	}.bind(this));
};

Game.prototype.sellQuantity = function(item){
	question.ask('how many? ', function(answer){
		this.inventory.remove(item.name, answer);
		var receipt = this.getLocation().buy(item.name, parseInt(answer, 10));

		this.inventory.cash += receipt;

		this.day();
	}.bind(this));
};

Game.prototype.outputMovementOptions = function(){

};

Game.prototype.getLocation = function(){
	return this.locations[this.location];
};


module.exports = Game;