package com.csis3275.test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.csis3275.model.MiniBarItem;

class MiniBarItemUnitTest {
	
	MiniBarItem myItem;
	
	@BeforeEach
	void init() {
		myItem = new MiniBarItem("Cookie", 19, new Date(2020, 03, 12));
	}
	
	@Test
	void testGetName() {
			assertTrue(myItem.getName() == "Cookie");
	}

}
