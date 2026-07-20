public class CartValidatorBVC{
    
    //check item count valid from 1 to 10
    public static boolean isValidCartItems(int items){
        return items >= 1 && items <= 10;
    }

    //check discount valid from 0 to 50
    public static boolean isValidDiscount(int discount){
        return discount >= 0 && discount <= 50;
    }

    //combined check
    public static boolean isValidOrder(int items, int discount){
        return isValidCartItems(items) && isValidDiscount(discount);
    }

    public static void main(String[] args) {
        
        //boundary value analysis - items
        System.out.println("item 1: " +isValidCartItems(1));
        System.out.println("item 2: " +isValidCartItems(2));
        System.out.println("item 9: " +isValidCartItems(9));
        System.out.println("item 10: " +isValidCartItems(10));

        System.out.println("discount 0: " +isValidDiscount(0));
        System.out.println("discount 1: " +isValidDiscount(1));
        System.out.println("discount 49: " +isValidDiscount(49));
        System.out.println("discount 50: " +isValidDiscount(50));

        //robustness testing (invalid)
        System.out.println("item 0: " +isValidCartItems(0));
        System.out.println("item 11: " +isValidCartItems(11));
        System.out.println("discount -1: " +isValidDiscount(-1));
        System.out.println("discount 51: " +isValidDiscount(51));

        //worst case testing 
        int [] itemValues = {1, 2, 9, 10};
        int [] discountValues = {0, 1, 49, 50};

        for(int item : itemValues){
            for(int discount : discountValues){
                System.out.println("items = " +item+ "discount: " +discount+ isValidOrder(item, discount));
            }
        }
    }
}