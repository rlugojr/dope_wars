function Location(name, market){
	this.name = name;
	this.market = market;
}

Location.prototype.display = function(){
	var output = 'Location : ' + this.name + '\n';

	this.market.forEach(function(item){
		output += item.name + ' :\t £' + item.price + '\t' + item.quantity + '\n';
	});

	return output;
};

Location.prototype.getItems = function(){
	return this.market;
};

Location.prototype.sell = function(name, qty){
	this.market.forEach(function(item){
		if(item.name === name){
			item.quantity -= qty;
		}
	});
};

Location.prototype.buy = function(name, qty) {
	var marketItem = null;
	var price = 0;
	this.market.forEach(function(item){
		if(item.name === name){
			item.quantity += qty;
			marketItem = item;
		}
	});

	if(marketItem !== null){
		price = qty * marketItem.price;
	}
	
	return price;
};

module.exports = Location;