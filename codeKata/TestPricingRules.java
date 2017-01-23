package codeKata;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestPricingRules {
	List<Pricing_rules> rules = new ArrayList<>();
	
	@Before
	public void cleanRules() {
		rules.clear();
		rules.add(new Pricing_rules("A", 50, 3, 130));
		rules.add(new Pricing_rules("B", 30, 2, 45));
	    rules.add(new Pricing_rules("C", 20));
	    rules.add(new Pricing_rules("D", 15));
	}
	
	private int price(String products) throws Exception {
		Checkout checkout = new Checkout(rules);
		for (int i = 0; i < products.length(); i++) {
			checkout.scan(Character.toString(products.charAt(i)));
		}
	    return checkout.CalculateTotal();
	}
	
    @Test
    public void test_totals() throws Exception {
    	assertEquals(0, price(""));
	    assertEquals(50, price("A"));
	    assertEquals(80, price("AB"));
	    assertEquals(115, price("CDBA"));
	
	    assertEquals(100, price("AA"));
	    assertEquals(130, price("AAA"));
	    assertEquals(180, price("AAAA"));
	    assertEquals(230, price("AAAAA"));
        assertEquals(260, price("AAAAAA"));
	
        assertEquals(160, price("AAAB"));
	    assertEquals(175, price("AAABB"));
	    assertEquals(190, price("AAABBD"));
        assertEquals(190, price("DABABA"));
    }
	
    @Test
	public void test_incremental() throws Exception {
    	Checkout checkout = new Checkout(rules);	
	    assertEquals(0, checkout.CalculateTotal());
	    checkout.scan("A");
	    assertEquals(50, checkout.CalculateTotal());
	    checkout.scan("B");
	    assertEquals(80, checkout.CalculateTotal());
	    checkout.scan("A");
	    assertEquals(130, checkout.CalculateTotal());
	    checkout.scan("A");
	    assertEquals(160, checkout.CalculateTotal());
	    checkout.scan("B");
	    assertEquals(175, checkout.CalculateTotal());
	}
}