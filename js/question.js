var readline = require('readline');

var getRL = function(){
	return readline.createInterface({
	  input: process.stdin,
	  output: process.stdout
	});
}
;
var multi = function(string, options){

	var rl = getRL();

	var question = string + '\n';

	var callbackMap = {};

	options.forEach(function(option){
		question += option.code;
		question += ' - ';
		question += option.description;
		question += '\n';

		callbackMap[option.code] = option.callback;
	});

	question += '\n';

	rl.question(question, function(answer) {
		rl.close();
	  	if(typeof callbackMap[answer] === 'undefined'){
	  		console.log('sorry, unrecognised response');
	  		multi(string, options);
	  		return;
	  	}

	  	callbackMap[answer]();
	});
};



var ask = function(string, callback){
	var rl = getRL();

	rl.question(string, function(answer){
		rl.close();
		callback(answer);
	});
};

exports.multi = multi;
exports.ask = ask;


