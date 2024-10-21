//import java.util.ArrayList;
import java.util.HashMap;

public class Assignment {
	

    static HashMap <Item, Integer> cart = new HashMap<>();
    
    //adding item to cart if not present
    public static String addToCart(Item item, Integer quantity){
        if(cart.containsKey(item)){
            return item.getName()+" already present";
        }
        cart.put(item, quantity);
        return item.getName()+" added successfully !!";
    }
    
    // displaying quantity of item present in cart
    public static String displayQty(Item item){
        return "The quantity for " + item.getName() + " is : "+cart.get(item);
    }
    
    //updating the quantity of items already present in cart
    public static String updateQty(Item item, Integer quantity){
    	if(cart.get(item)+quantity >= 0) {
        cart.put(item, cart.get(item)+quantity);
        return"Quantity for "+item.getName() +" updated successfully to "+cart.get(item)+".";
    	}else {
    		return "Invalid Quantity or Total quantity cant be negative.";
    	}
    }
    
    //deleting items from cart
    public static String deleteItem(Item item){
        if(cart.containsKey(item)){
            cart.remove(item);
            return item.getName()+" removed successfully !!";
        }
        return item.getName()+" not found";
    }
    
    // displaying the total bill amount of all items present in cart
    public static String displayBill(){
    	System.out.println("------------------------------------------Bill-------------------------------------------");
        double amount = 0.0;
        for (Item item : cart.keySet() ) {
            amount += cart.get(item)*item.getPrice();        //quantity * price
            System.out.println(item.getName() +":-   "+cart.get(item)+" * ₹"+item.getPrice()+" = ₹"+cart.get(item)*item.getPrice());
        }
        return "Your Cart total is: ₹"+amount;
    }

    public static void main(String args[]){
    	//ArrayList<Item> inventory = new ArrayList<>();
    	
    	// Creating the items
       	Item item1 = new Item(1553, "AirPods Pro 2" ,"ANC, spatial audio, 5 hours of battery backup." , 24900.00); 
       	Item item2 = new Item(3987, "Silk Shirt" ,"Silk is a lightweight, breathable fabric, which means it reduces the risk of overheating when you're going about your day." ,900.00);
       	Item item3 = new Item(1222, "Maggi" ,"2 min mai maggi tyar." , 12.00);
       	Item item4 = new Item(1553, "Apple" ,"1 kg of Kashmiri Apple." , 200.00); 
       	Item item5 = new Item(4987, "Fan" ,"A fan is a machine that moves air or other gases by using a rotating assembly of blades or vanes to create a current." , 1499.00);
       	Item item6 = new Item(7264, "Watch","A watch is a portable timepiece that can be worn on the wrist or carried in a pocket." , 2499.00);
        
//        inventory.add(item1);
//        inventory.add(item2);
//        inventory.add(item3);
//        inventory.add(item4);
//        inventory.add(item5);
//        inventory.add(item6);
        
        // loop to print all available items and their details
//        for(int items = 0; items < inventory.size(); items++) {
//        	System.out.println("----------------"+inventory.get(items).name+"----------------" );
//        	System.out.println("Description:- "+inventory.get(items).description);
//        	System.out.println("Price:- ₹"+inventory.get(items).price);
//        	System.out.println();
//        }

   
        
        
         
       System.out.println("--------------------------------------------------------------------------------------");
        
        System.out.println(addToCart(item1, 2));        
        System.out.println(displayQty(item1));
        System.out.println(addToCart(item3, 7));       
        System.out.println(updateQty(item3, -6));        
        System.out.println(deleteItem(item1));
        System.out.println(updateQty(item3, -6));
        System.out.println(deleteItem(item5));
        System.out.println(displayBill());

       
    }
    
}
