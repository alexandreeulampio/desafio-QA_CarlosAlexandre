package codeKata;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCheckout {
	List<Pricing_rules> rules = new ArrayList<>();
	
	    @Before
	    public void setUp() {
	        rules.clear();
	
	        rules.add(new Pricing_rules("A", 50, 3, 130));
	        rules.add(new Pricing_rules("B", 30, 2, 45));
	        rules.add(new Pricing_rules("C", 20));
	        rules.add(new Pricing_rules("D", 15));
	    }
	
	    @Test
	    public void testTotal() throws Exception {
	
	        Checkout checkout = new Checkout(rules);
	        checkout.scan("A");
	        checkout.scan("A");
	        checkout.scan("A");
	        checkout.scan("A");
	
	        assertEquals(180, checkout.CalculateTotal());
	
	    }
	
	    @Test(expected = Exception.class)
	    public void testTotalProductWithoutPrice() throws Exception {
	
	        Checkout checkout = new Checkout(rules);
	        checkout.scan("A");
	        checkout.scan("B");
	        checkout.scan("C");
	        checkout.scan("D");
	       checkout.scan("E");
	
	       assertEquals(115, checkout.CalculateTotal());
	
	    }
}
