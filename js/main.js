var App = require('./App.js');


var MAXIMUM_PRODUCT_QUANTITY = 100;
var NUMBER_OF_TURNS = 30;
var START_CASH = 2000;

var products = [
	{name:'Cannabis', min:10, max:50},
	{name:'Ecstasy', min:5, max:30}
];

var places = ['Downtown', 'Uptown', 'Suburbs', 'Docks'];

var app = new App({
	maxProducts: MAXIMUM_PRODUCT_QUANTITY,
	turns: NUMBER_OF_TURNS,
	startCash:START_CASH,
	productList:products,
	placeList:places
});

app.start();