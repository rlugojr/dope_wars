package dopewars;

import dopewars.Product;

public class Location{

	public String name;
	public Product[] market;

	public Location(String name, Product[] market){
		this.name = name;
		this.market = market;
		update();
	}

	public void update(){
		for(int i = 0; i < market.length; i++){
			market[i].update();
		}
	}
	
}