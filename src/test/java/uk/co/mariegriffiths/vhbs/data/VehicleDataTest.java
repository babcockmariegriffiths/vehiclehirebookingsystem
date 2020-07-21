package uk.co.mariegriffiths.vhbs.data;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import javax.money.MonetaryAmount;

import org.junit.jupiter.api.Test;

import uk.co.mariegriffiths.vhbs.model.Vehicle;

class VehicleDataTest {

	VehicleData vehicleData = new VehicleData();
	
	@Test
	void testGetVehicleById() {
		Vehicle testVehicle = vehicleData.getVehicleById(1);
		assertEquals("CAR 2P", testVehicle.getRegistration());
		assertEquals("Ford", testVehicle.getModel().getMake().getName());
		assertEquals("Fiesta", testVehicle.getModel().getName());
		assertEquals("Small Car", testVehicle.getModel().getCategory().getName());
		assertEquals("Petrol", testVehicle.getFuelType().getName());
		assertEquals("GBP", testVehicle.getModel().getCategory().getCurrentPrice().getCurrencyCode());
	}
	
	@Test
	void testGetCost() {
		MonetaryAmount testCost = vehicleData.getCost(1L, OffsetDateTime.of(2020, 7, 19, 10, 30, 40, 0, ZoneOffset.UTC),
				OffsetDateTime.of(2020, 7, 22, 20, 30, 40, 0, ZoneOffset.UTC));
		assertEquals(75.00, testCost.getNumber().doubleValue());
		assertEquals("GBP", testCost.getCurrency().getCurrencyCode());
	}

}
