/**
 * Copyright 2018 SmartBear Software
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.co.mariegriffiths.vhbs.data;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.money.MonetaryAmount;

import uk.co.mariegriffiths.vhbs.model.Category;
import uk.co.mariegriffiths.vhbs.model.Cost;
import uk.co.mariegriffiths.vhbs.model.FuelType;
import uk.co.mariegriffiths.vhbs.model.Make;
import uk.co.mariegriffiths.vhbs.model.Model;
import uk.co.mariegriffiths.vhbs.model.Vehicle;

public class VehicleData {

	private static List<Category> categories = new ArrayList<>();

	private static List<Make> makes = new ArrayList<>();

	private static List<Model> models = new ArrayList<>();

	private static List<FuelType> fuelTypes = new ArrayList<>();
	private static List<Vehicle> vehicles = new ArrayList<>();

	static {
			categories.add(
					createCategory(1, "Small Car", createCost(25.0, "GBP")));
			categories.add(
					createCategory(2, "Estate Car", createCost(35.00, "GBP")));
			categories.add(createCategory(3, "Van", createCost(50.00, "GBP")));
		makes.add(createMake(1, "Ford"));
		makes.add(createMake(2, "VW"));
		models.add(createModel(1, makes.get(0), "Fiesta", categories.get(0)));
		models.add(createModel(2, makes.get(0), "Galaxy", categories.get(1)));
		models.add(createModel(3, makes.get(1), "Transit", categories.get(1)));
		models.add(createModel(4, makes.get(1), "Polo", categories.get(1)));
		
		fuelTypes.add(createFuelType(1, "Petrol"));
		fuelTypes.add(createFuelType(2, "Diesel"));
		vehicles.add(createVehicle(3, "VAN 1P", models.get(2), fuelTypes.get(0)));
		vehicles.add(createVehicle(4, "CAR 2P", models.get(3), fuelTypes.get(0)));
		vehicles.add(createVehicle(5, "CAR 1D", models.get(0), fuelTypes.get(0)));
		vehicles.add(createVehicle(6, "EST 1D", models.get(1), fuelTypes.get(1)));
		vehicles.add(createVehicle(7, "VAN 1D", models.get(2), fuelTypes.get(1)));
		vehicles.add(createVehicle(8, "CAR 2D", models.get(3), fuelTypes.get(1)));
		vehicles.add(createVehicle(1, "CAR 2P", models.get(0), fuelTypes.get(0)));
	}

	public Vehicle getVehicleById(final long vehicleId) {
		for (final Vehicle vehicle : vehicles) {
			if (vehicle.getId() == vehicleId) {

				return vehicle;
			}
		}
		return null;
	}


	
	/**
	 * Gets the cost of hiring a vehicle between two given dates rounded up to the day
	 *
	 * @param vehicleId the vehicle id
	 * @param startDate the start date
	 * @param finishDate the finish date
	 * @return the cost
	 */
	public MonetaryAmount getCost(final Long vehicleId, final OffsetDateTime startDate,
			final OffsetDateTime finishDate) {
		Vehicle vehicle = vehicles.stream().filter(v -> v.getId() == vehicleId).iterator().next();
		MonetaryAmount costPerDay = vehicle.getModel().getCategory().extractCurrentPricePerDay();
		double daysbetween = Math.ceil(Duration.between(startDate, finishDate).toDays());
		return costPerDay.multiply(daysbetween);
	}

	public void addVehicle(final Vehicle vehicle) {
		if (vehicles.size() > 0) {
			for (int i = vehicles.size() - 1; i >= 0; i--) {
				if (vehicles.get(i).getId() == vehicle.getId()) {
					vehicles.remove(i);
				}
			}
		}
		vehicles.add(vehicle);
	}

	public void deleteVehicleById(final Long vehicleId) {
		vehicles.removeIf(vehicle -> vehicle.getId() == vehicleId);
	}

	public static Vehicle createVehicle(final long id, final String registration, final Model model,
			final FuelType fuelType) {
		final Vehicle vehicle = new Vehicle();
		vehicle.setId(id);
		vehicle.setRegistration(registration);
		vehicle.setModel(model);
		vehicle.setFuelType(fuelType);
		return vehicle;
	}

	private static FuelType createFuelType(final long id, final String name) {
		final FuelType fuelType = new FuelType();
		fuelType.setId(id);
		fuelType.setName(name);

		return fuelType;
	}

	private static Make createMake(final long id, final String name) {
		final Make make = new Make();
		make.setId(id);
		make.setName(name);
		return make;
	}

	private static Model createModel(final long id, final Make make, final String name, final Category category) {
		final Model model = new Model();
		model.setId(id);
		model.setMake(make);
		model.setName(name);
		model.setCategory(category);
		return model;
	}

	private static Category createCategory(final long id, final String name, MonetaryAmount currentPricePerDay) {
		final Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.applyCurrentPricePerDay(currentPricePerDay);
		return category;
	}
	
	private static Category createCategory(final long id, final String name, final Cost currentPricePerDay) {
		final Category category = new Category();
		category.setId(id);
		category.setName(name);
		category.setCurrentPrice(currentPricePerDay);
		return category;
	}

	private static Cost createCost(final double price, String currencyCode) {
		final Cost cost = new Cost();
		cost.setCurrencyCode(currencyCode);
		cost.setPrice(price);
		return cost;
	}

	public static List<Vehicle> getTestVehicles() {
		return vehicles;
	}
}