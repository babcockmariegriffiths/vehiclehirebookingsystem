package uk.co.mariegriffiths.vhbs.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import uk.co.mariegriffiths.vhbs.model.Hire;

class HireDataTest {

	HireData hireData = new HireData();
	
	/**
	 * Test get vehicles for hire today. 3 of the 8 vehicles are hired out
	 */
	@Test
	void testGetVehiclesForHireToday() {
		assertEquals(5,HireData.getToHireToday().size());
	}
	
	@Test
	void testGetHireById() {
		Hire hire = hireData.getHireById(0);
		assertEquals(1,hire.getCustomerId());
//		assertNotNull(hire.getFinishDate());
//		assertNotNull(hire.getHireDate());
	}
}
