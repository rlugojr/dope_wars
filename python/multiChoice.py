def ask(question, options):
	fullQ = question + '\n'
	for item in options:
		fullQ += item['code'] + ': ' + item['description'] + '\n'
	answer = raw_input(fullQ)
	for item in options:
		if answer == item['code']:
			item['callback']()
