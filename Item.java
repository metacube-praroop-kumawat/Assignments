

public class Item {
	private int itemId;
    String name;
    String description;
    double price;

    public Item(int id, String name, String desc, double price){
        this.itemId = id;
        this.name= name;
        this.description = desc;
        this.price = price;
    }
    
    public int getItemId() {
    	return itemId;
    }
    
    public String getName() {
    	return name;
    }
    
    public double getPrice() {
    	return price;
    }
}
