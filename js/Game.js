var question = require('./question.js');

function Game(playerName, locations, inventory){
	this.playerName = playerName;
	this.location = 0;
	this.locations = locations;
	this.inventory = inventory;
}

Game.prototype.day = function(){
	console.log('\n\n-----------------------------------');
	console.log('Oh hai, ' + this.playerName + '!');
	this.status();
};

Game.prototype.status = function(){
	var currentLocation = this.getLocation();
	console.log('\nInventory:');
	console.log(this.inventory.display());
	console.log(currentLocation.display());

	this.outputTradeOptions();
};

Game.prototype.outputTradeOptions = function(){

	var purchaseOptions = this.getLocationItems(0);
	purchaseOptions = purchaseOptions.concat(this.getInventoryItems(purchaseOptions.length - 1));
	purchaseOptions.push(this.getTravelAction('m'));
	purchaseOptions.push(this.getQuitAction('q'));

	question.multi('Would you like to trade? ', purchaseOptions);

};

Game.prototype.buyQuantity = function(item){
	question.ask('how many? ', function(answer){
		try{
			this.getLocation().sell(item.name, answer);
			this.inventory.add(item.name, parseInt(answer, 10));
			this.inventory.cash -= item.price * answer;
		}catch(e){
			console.log('there are not that many units available!\n');
		}

		this.status();
	}.bind(this));
};

Game.prototype.sellQuantity = function(item){
	question.ask('how many? ', function(answer){

		try{
			this.inventory.remove(item.name, answer);
			var receipt = this.getLocation().buy(item.name, parseInt(answer, 10));

			this.inventory.cash += receipt;
		}catch(e){
			console.log('there are not that many units available!\n');
		}

		this.status();
	}.bind(this));
};

Game.prototype.outputMovementOptions = function(){

	var otherLocations = this.locations.filter(function(item){
		return item !== this.getLocation();
	}.bind(this));

	var options = otherLocations.map(function(location, index){
		return {
			code: index,
			description: location.name,
			callback: this.updateLocation.bind(this, location)
		};
	}.bind(this));

	options.push(this.getQuitAction());

	question.multi('Where would you like to go? ', options);
};

Game.prototype.updateLocation = function(location){
	this.location = this.locations.indexOf(location);
	this.day();
};

Game.prototype.getLocation = function(){
	return this.locations[this.location];
};

Game.prototype.getLocationItems = function(startCode){
	var availableItems = this.getLocation().getItems()
	var options = availableItems.map(function(item){
		return {
			code: startCode++,
			description: 'buy ' + item.name,
			callback:this.buyQuantity.bind(this, item)
		};
	}.bind(this));

	return options;
};

Game.prototype.getInventoryItems = function(startCode){
	var options = this.inventory.items.map(function(item){
			return {
				code: startCode++,
				description:'sell ' + item.name,
				callback: this.sellQuantity.bind(this, item)
			};
	}.bind(this));

	return options;
};

Game.prototype.getTravelAction = function(code){
	return {
		code: code,
		description: 'move location',
		callback: this.outputMovementOptions.bind(this)
	};
};

Game.prototype.getQuitAction = function(code){
	return {
		code: code,
		description: 'quit',
		callback: function(){
			console.log('goodbye!');
			process.exit();
		}
	};
};


module.exports = Game;