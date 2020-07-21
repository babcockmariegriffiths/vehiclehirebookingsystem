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

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import uk.co.mariegriffiths.vhbs.model.Hire;
import uk.co.mariegriffiths.vhbs.model.Vehicle;

public class HireData {
    private static List<Hire> hires = new ArrayList<>();
    private static OffsetDateTime now = OffsetDateTime.now();
    static {
        hires.add(createHire(0, 1, now, now
        		  .plusDays(1),1));
        hires.add(createHire(1, 1, now, now.plusDays(2), 2));
        hires.add(createHire(2, 1, now, now.plusDays(3), 3));
    }

    public Hire getHireById(final long hireId) {
        for (final Hire hire : hires) {
            if (hire.getId() == hireId) {
                return hire;
            }
        }
        return null;

    }

    public void addHire(final Hire hire) {
        if (hires.size() > 0) {
            hires.removeIf(hireN -> hireN.getId() == hire.getId());
        }
        hires.add(hire);
    }

    public void deleteHireById(final Long hireId) {
        hires.removeIf(hire -> hire.getId() == hireId);
    }

    public static Hire createHire(final long id, final long vehicleId, final OffsetDateTime hireDate, final OffsetDateTime finishDate,
                                     final long customerId) {
        final Hire hire = new Hire();
        hire.setId(id);
        hire.setVehicleId(vehicleId);
//        hire.setHireDate(hireDate);
//        hire.setFinishDate(finishDate);
        hire.setCustomerId(customerId);
        return hire;
    }
    
	public static List<Vehicle> getToHireToday() {
		List<Vehicle> vehiclesToHireToday = VehicleData.getTestVehicles();
		hires.forEach(hire -> vehiclesToHireToday.removeIf(v -> v.getId() == hire.getId()));
		return vehiclesToHireToday;
	}
}
