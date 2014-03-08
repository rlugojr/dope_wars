package dopewars;

public class Product{
	
	public String name;
	public int price;
	public int quantity;

	private final int min;
	private final int max;

	public Product(String name, int min, int max){
		this.name = name;
		this.min = min;
		this.max = max;
		price = min;
		quantity = 0;
	}

	public void update(){
		quantity = (int)(Math.random() * 120);
		if(Math.random() < 0.2){
			quantity = 0;
		}

		price = (int)(Math.random() * max);
		if(price < min){
			price = min;
		}
	}
}