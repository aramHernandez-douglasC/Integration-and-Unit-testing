package com.csis3275.test.model;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model.MiniBar;
import com.csis3275.model.MiniBarItem;

class MiniBarIntegrationTest {
	MiniBar myBar;
	List<MiniBarItem> testItems;

	@BeforeEach()
	void init() {
		myBar = new MiniBar("208", 12);
		testItems = new ArrayList<>();
		testItems.add(new MiniBarItem("Cookie", 19, new Date(2020, 03, 12)));
		testItems.add(new MiniBarItem("Water", 20, new Date(2021, 03, 12)));
		testItems.add(new MiniBarItem("Coke", 21, new Date(2020, 12, 12)));
		testItems.add(new MiniBarItem("Munchies", 23, new Date(2022, 03, 12)));
		testItems.add(new MiniBarItem("Weed", 27, new Date(2019, 03, 12)));
		testItems.add(new MiniBarItem("Beer", 19, new Date(2020, 11, 12)));

		for (MiniBarItem b : this.testItems) {
			myBar.addItem(b);
		}

	}

//	@Test
//	void addItems() {
//		
//		testItems = new ArrayList<>();
//		testItems.add(new MiniBarItem("Cookie", 19, new Date(2020, 03, 12)));
//		testItems.add(new MiniBarItem("Water", 20, new Date(2021, 03, 12)));
//		testItems.add(new MiniBarItem("Coke", 21, new Date(2020, 12, 12)));
//		testItems.add(new MiniBarItem("Munchies", 23, new Date(2022, 03, 12)));
//		testItems.add(new MiniBarItem("Weed", 27, new Date(2019, 03, 12)));
//		testItems.add(new MiniBarItem("Beer", 19, new Date(2020, 11, 12)));
//		
//		for(MiniBarItem b : this.testItems ) {
//			myBar.addItem(b);
//		}
//		
//		assertTrue(!myBar.expiredItems().isEmpty()) ;
//	}

	@Test
	void testExpiredItems() {
		assertFalse(myBar.expiredItems().isEmpty());
	}

	@Test
	void testAddItemsToFullList() {
		List<MiniBarItem> testItems1 = new ArrayList<>();

		testItems1.add(new MiniBarItem("6", 19, new Date(2020, 03, 12)));
		testItems1.add(new MiniBarItem("7", 20, new Date(2021, 03, 12)));
		testItems1.add(new MiniBarItem("8", 21, new Date(2020, 12, 12)));
		testItems1.add(new MiniBarItem("9", 21, new Date(2020, 12, 12)));
		testItems1.add(new MiniBarItem("10", 21, new Date(2020, 12, 12)));
		testItems1.add(new MiniBarItem("11", 21, new Date(2020, 12, 12)));

		for (MiniBarItem b : testItems1) {
			myBar.addItem(b);
		}

		// Adding the exception item

		try {
			myBar.addItem(new MiniBarItem("123", 27, new Date(2019, 03, 12)));
			myBar.addItem(new MiniBarItem("23", 27, new Date(2019, 03, 12)));
		} catch (Exception e) {
			fail("fuck");
		}

	}

}
