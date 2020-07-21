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

package uk.co.mariegriffiths.vhbs.controller;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import uk.co.mariegriffiths.vhbs.data.VehicleData;
import uk.co.mariegriffiths.vhbs.model.FuelType;
import uk.co.mariegriffiths.vhbs.model.Model;
import uk.co.mariegriffiths.vhbs.model.Vehicle;
import uk.co.mariegriffiths.vhbs.utils.Util;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaInflectorServerCodegen", date = "2017-04-08T15:48:56.501Z")
public class VehicleController {

    private static VehicleData vehicleData = new VehicleData();



    public ResponseContext getVehicleById(final RequestContext request, final Long vehicleId) {
        if (vehicleId == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No vehicleId provided. Try again?");
        }

        final Vehicle vehicle = vehicleData.getVehicleById(vehicleId);

        if (vehicle != null) {
            return new ResponseContext()
                    .contentType(Util.getMediaType(request))
                    .entity(vehicle);
        }

        return new ResponseContext().status(Response.Status.NOT_FOUND).entity("Vehicle not found");
    }

    public ResponseContext updateVehicleWithForm(final RequestContext request, final Long vehicleId, final String registration, final Model model, final FuelType fuelType) {
        if (vehicleId == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No Vehicle provided. Try again?");
        }

        if (registration == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No registration provided. Try again?");
        }
        
        if (model == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No model provided. Try again?");
        }
        
        if (fuelType == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No fuelType provided. Try again?");
        }
        

        final MediaType outputType = Util.getMediaType(request);
        final Vehicle existingVehicle = vehicleData.getVehicleById(vehicleId);

        if (existingVehicle == null) {
            return new ResponseContext().status(Response.Status.NOT_FOUND).entity("Vehicle not found");
        }

        vehicleData.deleteVehicleById(existingVehicle.getId());
		existingVehicle.setRegistration(registration);
//        existingVehicle.setModel(model);
//        existingVehicle.setFuelType(fuelType);
        vehicleData.addVehicle(existingVehicle);

        return new ResponseContext()
                .contentType(outputType)
                .entity(existingVehicle);
    }

    public ResponseContext deleteVehicle(final RequestContext request, final String apiKey, final Long vehicleId) {
        if (vehicleId == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No vehicleId provided. Try again?");
        }

        vehicleData.deleteVehicleById(vehicleId);

        final MediaType outputType = Util.getMediaType(request);

        final Vehicle vehicle = vehicleData.getVehicleById(vehicleId);

        if (null == vehicle) {
            return new ResponseContext()
                    .contentType(outputType)
                    .entity("Vehicle deleted");
        } else {
            return new ResponseContext().status(Response.Status.NOT_MODIFIED).entity("Vehicle couldn't be deleted.");
        }

    }


    public ResponseContext addVehicle(final RequestContext request, final Vehicle vehicle) {
        if (vehicle == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No Vehicle provided. Try again?");
        }

        vehicleData.addVehicle(vehicle);

        return new ResponseContext()
                .contentType(Util.getMediaType(request))
                .entity(vehicle);
    }

    public ResponseContext addVehicle(final RequestContext request, final Long id, final String registration, final Model model,
                                   final FuelType fuelType) {
        final Vehicle vehicle = VehicleData.createVehicle(id, registration,model,fuelType);
        return addVehicle(request, vehicle);
    }

    public ResponseContext updateVehicle(final RequestContext request, final Vehicle vehicle) {
        if (vehicle == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No Vehicle provided. Try again?");
        }

        final Vehicle existingVehicle = vehicleData.getVehicleById(vehicle.getId());
        if (existingVehicle == null) {
            return new ResponseContext().status(Response.Status.NOT_FOUND).entity("Vehicle not found");
        }

        vehicleData.deleteVehicleById(existingVehicle.getId());
        vehicleData.addVehicle(vehicle);

        return new ResponseContext()
                .contentType(Util.getMediaType(request))
                .entity(vehicle);
    }

    public ResponseContext updateVehicle(final RequestContext request, final Long id, final String registration, final Model model,
                                  final FuelType fuelType) {
        final Vehicle vehicle = VehicleData.createVehicle(id, registration, model, fuelType);
        return updateVehicle(request, vehicle);
    }

    
}

