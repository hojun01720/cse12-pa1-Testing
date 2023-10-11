package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}

	@Test
	public void addedDup(){
		Basket btt = makeBasket();

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);
		assertEquals(2, btt.count());
	}

	@Test
	public void totCostCheck(){
		Basket btt = makeBasket();

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);
		assertEquals(2000, btt.totalCost());
	}

	@Test
	public void manyItems(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);

		assertEquals(2008, btt.totalCost());
	}

	@Test
	public void manyItemsRemove(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		

		assertEquals(false, btt.removeFromBasket(i3));
	}

	@Test
	public void manyItemsRemove2(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);

		assertEquals(true, btt.removeFromBasket(i3));
	}

	@Test
	public void manyItemsRemoveAll(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);

		assertEquals(true, btt.removeAllFromBasket(i1));
	}

	@Test
	public void countSpecific(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);


		assertEquals(4, btt.countItem(i3));
	}

	@Test
	public void everythingCount(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);

		btt.removeFromBasket(i3);
		btt.removeAllFromBasket(i1);
		
		assertEquals(5, btt.count());
	}

	@Test
	public void everythingCountItem(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);

		btt.removeFromBasket(i3);
		btt.removeAllFromBasket(i1);
		
		assertEquals(3, btt.countItem(i3));
	}

	@Test
	public void everythingEmpty(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);

		btt.removeFromBasket(i3);
		btt.removeAllFromBasket(i1);

		btt.empty();
		
		assertEquals(0, btt.count());
	}

	@Test
	public void everythingDiffObjCountItem(){
		Basket btt = makeBasket();

		Item i = new Item("Shampoo", 5);
		btt.addToBasket(i);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);
		btt.addToBasket(i3);

		Item i4 = new Item("b", 2);
		btt.addToBasket(i4);

		btt.removeFromBasket(i3);
		btt.removeAllFromBasket(i1);
		
		assertEquals(4, btt.countItem(i3));
	}

	@Test
	public void everythingDiffObjCountItemOver1000(){
		Basket btt = makeBasket();

		Item i0 = new Item("Shampoo", 5);
		btt.addToBasket(i0);

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		Item i2 = new Item("a", 1);
		btt.addToBasket(i2);

		Item i3 = new Item("b", 2);
		for(int i = 0; i <= 1010; i++){
			btt.addToBasket(i3);
		}
		
		Item i4 = new Item("b", 2);
		btt.addToBasket(i4);

		btt.removeFromBasket(i3);
		btt.removeAllFromBasket(i1);


		
		assertEquals(1010, btt.countItem(i3));
	}

	@Test
	public void overDelete() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(i);

		assertEquals(0, basketToTest.count());
	}
	
	@Test
	public void countNothing() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(i);

		Item i1 = new Item("Phone", 1000);

		assertEquals(0, basketToTest.countItem(i1));
	}

	@Test
	public void countNull() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(i);

		Item i1 = new Item(null, 0);
		basketToTest.addToBasket(i1);

		assertEquals(0, basketToTest.countItem(i1));
	}


	public void emptyCost(){
		Basket btt = makeBasket();

		Item i1 = new Item("Phone", 1000);
		btt.addToBasket(i1);
		btt.addToBasket(i1);

		
		btt.empty();

		Item i3 = new Item("b", 2);
		for(int i = 0; i <= 1010; i++){
			btt.addToBasket(i3);
		}

		assertEquals(2020, btt.totalCost());
	}

	@Test
	public void removeNull() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(i);

		Item i1 = new Item(null, 0);
		basketToTest.addToBasket(i1);
		basketToTest.addToBasket(i1);
		basketToTest.addToBasket(i1);

		basketToTest.removeFromBasket(i1);


		assertEquals(0, basketToTest.countItem(i1));
	}

	@Test
	public void emptyString() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		basketToTest.removeFromBasket(i);

		Item i1 = new Item(null, 0);
		basketToTest.addToBasket(i1);
		basketToTest.addToBasket(i1);
		basketToTest.addToBasket(i1);

		basketToTest.removeFromBasket(i1);


		assertEquals(0, basketToTest.countItem(i1));
	}


	public void emptyListCount(){
		Basket btt = makeBasket();

		Item i1 = new Item("Phone", 1000);
		

		assertEquals(0, btt.count());
	}

	public void emptyListCount2(){
		Basket btt = makeBasket();

		Item i1 = new Item("Phone", 1000);
		

		assertEquals(0, btt.countItem(i1));
	}
}
