package itpu.uz.alibek;

import itpu.uz.alibek.controller.*;
import itpu.uz.alibek.criteria.*;
import itpu.uz.alibek.entity.Apparel;
import itpu.uz.alibek.entity.Footwear;

import java.util.List;

/**
 * Main application demonstrating the Clothes and Footwear Warehouse System.
 * This system manages inventory of apparel and footwear with search capabilities.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("  Clothes & Footwear Warehouse System");
        System.out.println("========================================\n");

        try {
            demonstrateApparelWarehouse();
            
            System.out.println("\n" + "=".repeat(40) + "\n");
            
            demonstrateFootwearWarehouse();
            
        } catch (ControllerException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Demonstrates apparel warehouse operations: listing all items,
     * searching by criteria, and calculating total cost.
     */
    private static void demonstrateApparelWarehouse() throws ControllerException {
        System.out.println(">>> APPAREL WAREHOUSE <<<\n");
        
        ProductController<Apparel> controller = ControllerFactory.createController(Apparel.class);

        System.out.println("1. All Apparel Items:");
        System.out.println("-".repeat(40));
        List<Apparel> allApparel = controller.listAll();
        allApparel.forEach(System.out::println);
        System.out.println("\nTotal items: " + allApparel.size());

        System.out.println("\n2. Search: Large Hoodies");
        System.out.println("-".repeat(40));
        SearchCriteria hoodieCriteria = new ApparelCriteria("L", "hoodie", null);
        List<Apparel> hoodies = controller.find(hoodieCriteria);
        hoodies.forEach(System.out::println);
        System.out.println("\nFound: " + hoodies.size() + " item(s)");

        System.out.println("\n3. Search: Items priced $20-$80");
        System.out.println("-".repeat(40));
        SearchCriteria priceRangeCriteria = new PriceRange(20.0, 80.0);
        List<Apparel> midRange = controller.find(priceRangeCriteria);
        midRange.forEach(System.out::println);
        System.out.println("\nFound: " + midRange.size() + " item(s)");

        System.out.println("\n4. Complex Search: Blue L Hoodies ($50-$60)");
        System.out.println("-".repeat(40));
        SearchCriteria complexCriteria = AllCriteria.of(
                new ApparelCriteria("L", "hoodie", null),
                new ColorEquals("Blue"),
                new PriceRange(50.0, 60.0)
        );
        List<Apparel> specific = controller.find(complexCriteria);
        specific.forEach(System.out::println);
        System.out.println("\nFound: " + specific.size() + " item(s)");

        System.out.println("\n5. Total Apparel Inventory Cost:");
        System.out.println("-".repeat(40));
        double totalCost = controller.totalCost(null);
        System.out.printf("Total: $%.2f%n", totalCost);
    }

    /**
     * Demonstrates footwear warehouse operations: listing all items,
     * searching by criteria, and calculating total cost.
     */
    private static void demonstrateFootwearWarehouse() throws ControllerException {
        System.out.println(">>> FOOTWEAR WAREHOUSE <<<\n");
        
        ProductController<Footwear> controller = ControllerFactory.createController(Footwear.class);

        System.out.println("1. All Footwear Items:");
        System.out.println("-".repeat(40));
        List<Footwear> allFootwear = controller.listAll();
        allFootwear.forEach(System.out::println);
        System.out.println("\nTotal items: " + allFootwear.size());

        System.out.println("\n2. Search: Sneakers");
        System.out.println("-".repeat(40));
        SearchCriteria sneakersCriteria = new FootwearCriteria(null, "sneakers");
        List<Footwear> sneakers = controller.find(sneakersCriteria);
        sneakers.forEach(System.out::println);
        System.out.println("\nFound: " + sneakers.size() + " item(s)");

        System.out.println("\n3. Search: EU Size 42");
        System.out.println("-".repeat(40));
        SearchCriteria sizeCriteria = new FootwearCriteria(42, null);
        List<Footwear> size42 = controller.find(sizeCriteria);
        size42.forEach(System.out::println);
        System.out.println("\nFound: " + size42.size() + " item(s)");

        System.out.println("\n4. Complex Search: White Sneakers EU42 ($100-$130)");
        System.out.println("-".repeat(40));
        SearchCriteria complexCriteria = AllCriteria.of(
                new FootwearCriteria(42, "sneakers"),
                new ColorEquals("White"),
                new PriceRange(100.0, 130.0)
        );
        List<Footwear> specific = controller.find(complexCriteria);
        specific.forEach(System.out::println);
        System.out.println("\nFound: " + specific.size() + " item(s)");

        System.out.println("\n5. Total Footwear Inventory Cost:");
        System.out.println("-".repeat(40));
        double totalCost = controller.totalCost(null);
        System.out.printf("Total: $%.2f%n", totalCost);

        // p.s. I kinda could make this code better, maybe diversify smth, but for now it's okay
        System.out.println("\n6. Total Cost of Sneakers Only:");
        System.out.println("-".repeat(40));
        double sneakersCost = controller.totalCost(sneakersCriteria);
        System.out.printf("Sneakers Total: $%.2f%n", sneakersCost);
    }
}