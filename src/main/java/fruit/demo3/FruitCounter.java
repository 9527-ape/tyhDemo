package fruit.demo3;

public class FruitCounter {
    
    // 基础价格常量
    private static final int APPLE_PRICE = 8;
    private static final int STRAWBERRY_PRICE = 13;
    private static final int MANGO_PRICE = 20;
    
    // 场景1: 只有苹果和草莓
    public static int calculateCustomerA(int appleWeight, int strawberryWeight) {
        if (appleWeight < 0 || strawberryWeight < 0) {
            throw new IllegalArgumentException("水果斤数不能为负数");
        }
        return appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE;
    }
    
    // 场景2: 增加芒果
    public static int calculateCustomerB(int appleWeight, int strawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || strawberryWeight < 0 || mangoWeight < 0) {
            throw new IllegalArgumentException("水果斤数不能为负数");
        }
        return appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE + mangoWeight * MANGO_PRICE;
    }
    
    // 场景3: 草莓打8折
    public static int calculateCustomerC(int appleWeight, int strawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || strawberryWeight < 0 || mangoWeight < 0) {
            throw new IllegalArgumentException("水果斤数不能为负数");
        }
        double discountedStrawberry = strawberryWeight * STRAWBERRY_PRICE * 0.8;
        return (int)Math.round(appleWeight * APPLE_PRICE + discountedStrawberry + mangoWeight * MANGO_PRICE);
    }
    
    // 场景4: 草莓打8折且满100减10
    public static int calculateCustomerD(int appleWeight, int strawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || strawberryWeight < 0 || mangoWeight < 0) {
            throw new IllegalArgumentException("水果斤数不能为负数");
        }
        
        double discountedStrawberry = strawberryWeight * STRAWBERRY_PRICE * 0.8;
        int total = (int)Math.round(appleWeight * APPLE_PRICE + discountedStrawberry + mangoWeight * MANGO_PRICE);
        
        // 满100减10
        if (total >= 100) {
            total -= (total / 100) * 10;
        }
        
        return total;
    }
    
    // 测试方法
    public static void main(String[] args) {
        // 测试场景1
        assert calculateCustomerA(0, 0) == 0;
        assert calculateCustomerA(5, 0) == 40;
        assert calculateCustomerA(0, 5) == 65;
        assert calculateCustomerA(3, 4) == 3*8 + 4*13;
        
        // 测试场景2
        assert calculateCustomerB(0, 0, 0) == 0;
        assert calculateCustomerB(1, 1, 1) == 8 + 13 + 20;
        assert calculateCustomerB(2, 3, 4) == 2*8 + 3*13 + 4*20;
        
        // 测试场景3
        assert calculateCustomerC(0, 0, 0) == 0;
        assert calculateCustomerC(0, 10, 0) == (int)Math.round(10 * 13 * 0.8);
        assert calculateCustomerC(5, 5, 5) == (int)Math.round(5*8 + 5*13*0.8 + 5*20);
        
        // 测试场景4
        assert calculateCustomerD(0, 0, 0) == 0;
        assert calculateCustomerD(0, 10, 0) == (int)Math.round(10 * 13 * 0.8) - 10; 
        assert calculateCustomerD(5, 5, 5) == (int)Math.round(5*8 + 5*13*0.8 + 5*20) - 20; 
        assert calculateCustomerD(1, 1, 1) == (int)Math.round(8 + 13*0.8 + 20); 
        
        System.out.println("所有测试通过!");
    }
}
