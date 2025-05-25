import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import java.util.List;
import java.util.ArrayList;

public class SILab2Test {

    @Test
    public void testEveryStatementCriterion() {
        try {
            SILab2.checkCart(null, "1111111111111111");
            Assertions.fail("Expected RuntimeException for null list");
        } catch (RuntimeException e) {
            Assertions.assertEquals("allItems list can't be null!", e.getMessage());
        }

        List<Item> invalidNameItems = new ArrayList<>();
        invalidNameItems.add(new Item(null, 5, 100, 0.0));
        try {
            SILab2.checkCart(invalidNameItems, "1111111111111111");
            Assertions.fail("Expected RuntimeException for invalid item");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Invalid item!", e.getMessage());
        }

        List<Item> discountItems = new ArrayList<>();
        discountItems.add(new Item("ValidItem", 5, 350, 0.1));
        double result = SILab2.checkCart(discountItems, "1111111111111111");
        Assertions.assertEquals(1545.0, result, 0.01);

        List<Item> validItems1 = new ArrayList<>();
        validItems1.add(new Item("ValidItem", 5, 100, 0.0));
        try {
            SILab2.checkCart(validItems1, "11111111111111112");
            Assertions.fail("Expected RuntimeException for invalid card number length");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Invalid card number!", e.getMessage());
        }

        List<Item> validItems2 = new ArrayList<>();
        validItems2.add(new Item("ValidItem", 5, 100, 0.0));
        try {
            SILab2.checkCart(validItems2, "11111111111111a1");
            Assertions.fail("Expected RuntimeException for invalid card character");
        } catch (RuntimeException e) {
            Assertions.assertEquals("Invalid character in card number!", e.getMessage());
        }
    }

    @Test
    public void testMultipleConditionCriterion() {
        String validCard = "1111111111111111";

        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("Test", 5, 200, 0.0));
        double result1 = SILab2.checkCart(items1, validCard);
        Assertions.assertEquals(1000.0, result1, 0.01);

        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("Test", 15, 200, 0.0));
        double result2 = SILab2.checkCart(items2, validCard);
        Assertions.assertEquals(2970.0, result2, 0.01);

        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("Test", 5, 200, 0.1));
        double result3 = SILab2.checkCart(items3, validCard);
        Assertions.assertEquals(870.0, result3, 0.01);

        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("Test", 15, 200, 0.1));
        double result4 = SILab2.checkCart(items4, validCard);
        Assertions.assertEquals(2670.0, result4, 0.01);

        List<Item> items5 = new ArrayList<>();
        items5.add(new Item("Test", 5, 350, 0.0));
        double result5 = SILab2.checkCart(items5, validCard);
        Assertions.assertEquals(1720.0, result5, 0.01);

        List<Item> items6 = new ArrayList<>();
        items6.add(new Item("Test", 15, 350, 0.0));
        double result6 = SILab2.checkCart(items6, validCard);
        Assertions.assertEquals(5220.0, result6, 0.01);

        List<Item> items7 = new ArrayList<>();
        items7.add(new Item("Test", 5, 350, 0.1));
        double result7 = SILab2.checkCart(items7, validCard);
        Assertions.assertEquals(1545.0, result7, 0.01);

        List<Item> items8 = new ArrayList<>();
        items8.add(new Item("Test", 15, 350, 0.1));
        double result8 = SILab2.checkCart(items8, validCard);
        Assertions.assertEquals(4695.0, result8, 0.01);
    }
}
