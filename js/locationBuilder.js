var Location = require('./Location.js');

function getLocations(locationList, productList, maxQuantity){
	var locations = locationList.map(function(location){
		return new Location(location, getNewMarket(productList, maxQuantity));
	});

	return locations;
}

function getNewMarket(products, max){
	return products.map(function(product){
		return {
			name : product.name,
			price : getRandomPrice(product),
			quantity: getRandomQuantity(max),
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

function getRandomQuantity(max){
	return Math.round(Math.random()* max);
}

module.exports = getLocations;