package TDD.discount;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;


public class DiscountApplierTest {
	
	private DiscountApplier applier;
	
		@Before
		public void setUp(){
			applier = new DiscountApplier();
			
		}

		@Test
		public void discountForMacAndIphoneTogether(){
			
			Item mac = new Item("MACBOOK", 1, 100);
			Item iphone = new Item("IPHONE", 1, 50);
			
			Basket basket = new Basket(Arrays.asList(mac, iphone));
		
			applier.apply(basket);
			
			double expected = (100 + 50) * 0.85;
			Assert.assertEquals(expected, basket.getAmount(), 0.0001);
		}
		
		@Test
		public void discountForNotebookAndWindowsPhone(){
			
			Item notebook = new Item("NOTEBOOK", 1, 100);
			Item windowsphone = new Item("WINDOWS PHONE", 1, 50);
			
			Basket basket = new Basket(Arrays.asList(notebook, windowsphone));
		
			applier.apply(basket);
			
			double expected = (100 + 50) * (1 - 0.12);
			Assert.assertEquals(expected, basket.getAmount(), 0.0001);
		}
		
		@Test
		public void discountForXBOX(){
			
			Item xbox = new Item("XBOX", 1, 100);
			
			Basket basket = new Basket(Arrays.asList(xbox));
		
			applier.apply(basket);
			
			double expected = (100) * (1 - 0.7);
			Assert.assertEquals(expected, basket.getAmount(), 0.0001);
		}
		
		@Test
		public void discountForLessThanTwoItemsLesserThanAThousand(){
			
			Item item1 = new Item("REFRIGERATOR", 1, 100);
			
			Basket basket = new Basket(Arrays.asList(item1));
		
			applier.apply(basket);
			
			double expected = (100) * (1 - 0.02);
			Assert.assertEquals(expected, basket.getAmount(), 0.0001);
		}
		
		@Test
		public void discountFor3or4Products(){
			
			Item item1 = new Item("REFRIGERATOR", 1, 2000);
			Item item2 = new Item("DISH WASHER", 1, 500);
			Item item3 = new Item("TRASH CAN", 1, 2500);
			
			Basket basket = new Basket(Arrays.asList(item1, item2, item3));
		
			applier.apply(basket);
			
			double expected = (2000 + 500 + 2500) * (1 - 0.05);
			Assert.assertEquals(expected, basket.getAmount(), 0.0001);
		}
		
		@Test
		public void discountForMoreThan5Products(){
			
			Item item1 = new Item("REFRIGERATOR", 1, 2000);
			Item item2 = new Item("DISH WASHER", 1, 500);
			Item item3 = new Item("TRASH CAN", 1, 2500);
			Item item4 = new Item("BED", 1, 400);
			Item item5 = new Item("TOILET", 1, 200);
			
			Basket basket = new Basket(Arrays.asList(item1, item2, item3, item4, item5));
		
			applier.apply(basket);
			
			double expected = (2000 + 500 + 2500 + 400 + 200) * (1 - 0.06);
			Assert.assertEquals(expected, basket.getAmount(), 0.0001);
		}
}
