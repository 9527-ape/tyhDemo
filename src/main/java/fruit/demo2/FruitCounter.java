package fruit.demo2;

/**
 *水果价格计算
 */
public class FruitCounter {

    // 基础价格常量
    private static final int APPLE_PRICE = 8;
    private static final int STRAWBERRY_PRICE = 13;
    private static final int MANGO_PRICE = 20;

    /**
     * 场景1：计算苹果和草莓的总价
     * @param appleWeight 苹果斤数
     * @param strawberryWeight 草莓斤数
     * @return 总价格
     */
    public static int calculateScenario1(int appleWeight, int strawberryWeight) {
        if (appleWeight < 0 || strawberryWeight < 0) {
            throw new IllegalArgumentException("重量不能为负数");
        }
        return appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE;
    }

    /**
     * 场景2：计算苹果、草莓和芒果的总价
     * @param appleWeight 苹果斤数
     * @param strawberryWeight 草莓斤数
     * @param mangoWeight 芒果斤数
     * @return 总价格
     */
    public static int calculateScenario2(int appleWeight, int strawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || strawberryWeight < 0 || mangoWeight < 0) {
            throw new IllegalArgumentException("重量不能为负数");
        }
        return appleWeight * APPLE_PRICE + strawberryWeight * STRAWBERRY_PRICE + mangoWeight * MANGO_PRICE;
    }

    /**
     * 场景3：计算苹果、草莓(8折)和芒果的总价
     * @param appleWeight 苹果斤数
     * @param strawberryWeight 草莓斤数
     * @param mangoWeight 芒果斤数
     * @return 总价格
     */
    public static double calculateScenario3(int appleWeight, int strawberryWeight, int mangoWeight) {
        if (appleWeight < 0 || strawberryWeight < 0 || mangoWeight < 0) {
            throw new IllegalArgumentException("重量不能为负数");
        }
        double strawberryTotal = strawberryWeight * STRAWBERRY_PRICE * 0.8;
        return appleWeight * APPLE_PRICE + strawberryTotal + mangoWeight * MANGO_PRICE;
    }

    /**
     * 场景4：计算苹果、草莓(8折)和芒果的总价，满100减10
     * @param appleWeight 苹果斤数
     * @param strawberryWeight 草莓斤数
     * @param mangoWeight 芒果斤数
     * @return 总价格
     */
    public static double calculateScenario4(int appleWeight, int strawberryWeight, int mangoWeight) {
        double total = calculateScenario3(appleWeight, strawberryWeight, mangoWeight);
        int discount = (int) (total / 100) * 10;
        return total - discount;
    }

    /**
     * 测试验证方法
     */
    public static void testCalculations() {
        // 场景1测试
        System.out.println("场景1测试:");
        System.out.println("5斤苹果, 3斤草莓: " + calculateScenario1(5, 3) + " 元"); // 5*8 + 3*13 = 40+39=79
        System.out.println("0斤苹果, 10斤草莓: " + calculateScenario1(0, 10) + " 元"); // 0+130=130
        System.out.println("2斤苹果, 0斤草莓: " + calculateScenario1(2, 0) + " 元"); // 16+0=16
        
        // 场景2测试
        System.out.println("\n场景2测试:");
        System.out.println("5斤苹果, 3斤草莓, 2斤芒果: " + calculateScenario2(5, 3, 2) + " 元"); // 40+39+40=119
        System.out.println("1斤苹果, 1斤草莓, 1斤芒果: " + calculateScenario2(1, 1, 1) + " 元"); // 8+13+20=41
        System.out.println("0斤苹果, 0斤草莓, 5斤芒果: " + calculateScenario2(0, 0, 5) + " 元"); // 0+0+100=100
        
        // 场景3测试
        System.out.println("\n场景3测试:");
        System.out.println("5斤苹果, 3斤草莓, 2斤芒果: " + calculateScenario3(5, 3, 2) + " 元"); // 40+31.2+40=111.2
        System.out.println("0斤苹果, 10斤草莓, 0斤芒果: " + calculateScenario3(0, 10, 0) + " 元"); // 0+104+0=104
        System.out.println("3斤苹果, 0斤草莓, 4斤芒果: " + calculateScenario3(3, 0, 4) + " 元"); // 24+0+80=104
        
        // 场景4测试
        System.out.println("\n场景4测试:");
        System.out.println("5斤苹果, 3斤草莓, 2斤芒果: " + calculateScenario4(5, 3, 2) + " 元"); // 111.2-10=101.2
        System.out.println("10斤苹果, 10斤草莓, 10斤芒果: " + calculateScenario4(10, 10, 10) + " 元"); // 80+104+200=384-30=354
        System.out.println("1斤苹果, 1斤草莓, 1斤芒果: " + calculateScenario4(1, 1, 1) + " 元"); // 8+10.4+20=38.4-0=38.4
        System.out.println("0斤苹果, 0斤草莓, 6斤芒果: " + calculateScenario4(0, 0, 6) + " 元"); // 0+0+120=120-10=110
    }

    public static void main(String[] args) {
        testCalculations();
    }
}
