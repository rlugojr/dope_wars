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
		quantity = 10;
	}
}