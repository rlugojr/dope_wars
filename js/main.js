var App = require('./App.js');


var MAXIMUM_PRODUCT_QUANTITY = 100;
var NUMBER_OF_TURNS = 30;
var START_CASH = 2000;

var products = [
	{name:'Cannabis', min:10, max:50},
	{name:'Ecstasy', min:5, max:30},
	{name:'Heroin', min:20, max:120},
	{name:'Cocaine', min:20, max:200},
	{name:'Ketamine', min:7, max:70},
	{name:'Mushrooms', min:2, max:12},
	{name:'LSD', min:8, max:23},
	{name:'MKat', min:3, max:15}
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