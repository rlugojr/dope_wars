function Inventory(cash){
	this.cash = cash;
	this.items = [];
}

Inventory.prototype.add = function(name, quantity){
	if(!this.items.some(function(item){return item.name === name})){
		this.items.push({name:name, quantity:quantity});
	}else{
		this.items.forEach(function(item){ if(item.name === name) item.quantity += quantity;});
	}
};

Inventory.prototype.remove = function(name, quantity){
	this.items.forEach(function(item){ if(item.name === name) item.quantity -= quantity;});
};

Inventory.prototype.display = function(){
	var output = 'cash : £' + this.cash + '\n';
	this.items.forEach(function(item){
		output += item.name + ' : ' + item.quantity + '\n';
	});

	return output;

};

module.exports = Inventory;