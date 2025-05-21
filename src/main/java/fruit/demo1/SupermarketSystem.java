package fruit.demo1;

public class SupermarketSystem {
	 public static void main(String[] args) {
	        // 场景1：只有苹果和草莓
	        ShoppingCart cart1 = new ShoppingCart();
	        cart1.addItem(Fruit.APPLE, 5);
	        cart1.addItem(Fruit.STRAWBERRY, 3);
	        System.out.println("场景1总价: " + cart1.calculateTotal() + " 元");
	        
	        // 场景2：增加芒果
	        ShoppingCart cart2 = new ShoppingCart();
	        cart2.addItem(Fruit.APPLE, 5);
	        cart2.addItem(Fruit.STRAWBERRY, 3);
	        cart2.addItem(Fruit.MANGO, 2);
	        System.out.println("场景2总价: " + cart2.calculateTotal() + " 元");
	        
	        // 场景3：草莓打8折
	        ShoppingCart cart3 = new ShoppingCart();
	        cart3.addItem(Fruit.APPLE, 5);
	        cart3.addItem(Fruit.STRAWBERRY, 3);
	        cart3.addItem(Fruit.MANGO, 2);
	        cart3.setStrawberryDiscount(true);
	        System.out.println("场景3总价: " + cart3.calculateTotal() + " 元");
	        
	        // 场景4：满100减10
	        ShoppingCart cart4 = new ShoppingCart();
	        cart4.addItem(Fruit.APPLE, 5);
	        cart4.addItem(Fruit.STRAWBERRY, 3);
	        cart4.addItem(Fruit.MANGO, 2);
	        cart4.setStrawberryDiscount(true);
	        cart4.setOverallDiscount(true);
	        System.out.println("场景4总价: " + cart4.calculateTotal() + " 元");
	    }
}
