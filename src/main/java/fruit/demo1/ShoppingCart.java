package fruit.demo1;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

	 private Map<Fruit, Integer> items = new HashMap<Fruit, Integer>();
	    private boolean strawberryDiscount = false;
	    private boolean overallDiscount = false;

	    public void addItem(Fruit fruit, int weight) {
	        if (weight < 0) {
	            throw new IllegalArgumentException("重量不能为负数");
	        }
	        items.put(fruit, items.getOrDefault(fruit, 0) + weight);
	    }

	    public void setStrawberryDiscount(boolean discount) {
	        this.strawberryDiscount = discount;
	    }

	    public void setOverallDiscount(boolean discount) {
	        this.overallDiscount = discount;
	    }

	    public double calculateTotal() {
	        double total = 0;
	        
	        // 计算苹果价格
	        int appleWeight = items.getOrDefault(Fruit.APPLE, 0);
	        total += appleWeight * 8;
	        
	        // 计算草莓价格
	        int strawberryWeight = items.getOrDefault(Fruit.STRAWBERRY, 0);
	        if (strawberryDiscount) {
	            total += strawberryWeight * 13 * 0.8;
	        } else {
	            total += strawberryWeight * 13;
	        }
	        
	        // 计算芒果价格
	        int mangoWeight = items.getOrDefault(Fruit.MANGO, 0);
	        total += mangoWeight * 20;
	        
	        // 应用满减折扣
	        if (overallDiscount) {
	            int discount = (int) (total / 100) * 10;
	            total -= discount;
	        }
	        
	        return total;
	    }
}
