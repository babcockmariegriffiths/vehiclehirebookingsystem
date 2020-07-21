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

import java.time.OffsetDateTime;
import java.util.List;

import javax.ws.rs.core.Response;

import io.swagger.oas.inflector.models.RequestContext;
import io.swagger.oas.inflector.models.ResponseContext;
import uk.co.mariegriffiths.vhbs.data.HireData;
import uk.co.mariegriffiths.vhbs.model.Hire;
import uk.co.mariegriffiths.vhbs.model.Vehicle;
import uk.co.mariegriffiths.vhbs.utils.Util;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaInflectorServerCodegen", date = "2017-04-08T15:48:56.501Z")
public class HireController {

    private static HireData hireData = new HireData();

    final List<Vehicle> vehicleToHireToday = HireData.getToHireToday();

    
    public ResponseContext getHireById(final RequestContext request, final Long hireId) {
        if (hireId == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No hireId provided. Try again?");
        }

        final Hire hire = hireData.getHireById(hireId);

        if (hire != null) {
            return new ResponseContext()
                    .contentType(Util.getMediaType(request))
                    .entity(hire);
        }

        return new ResponseContext().status(Response.Status.NOT_FOUND).entity("Hire not found");
    }

    public ResponseContext placeHire(final RequestContext request, final Hire hire) {
        if (hire == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No Hire provided. Try again?");
        }

        hireData.addHire(hire);
        return new ResponseContext()
                .contentType(Util.getMediaType(request))
                .entity(hire);
    }

    public ResponseContext placeHire(final RequestContext request, final Long id, final Long vehicleId, final OffsetDateTime hireDate,final OffsetDateTime finishDate,
                                      final long customerId) {
        final Hire hire = HireData.createHire(id, vehicleId, hireDate, finishDate, customerId);
        return placeHire(request,hire);
    }

    public ResponseContext deleteHire(final RequestContext request, final Long hireId) {
        if (hireId == null) {
            return new ResponseContext()
                    .status(Response.Status.BAD_REQUEST)
                    .entity("No hireId provided. Try again?");
        }

        hireData.deleteHireById(hireId);

        final Hire hire = hireData.getHireById(hireId);

        if (null == hire) {
            return new ResponseContext()
                    .contentType(Util.getMediaType(request))
                    .entity(hire);
        } else {
            return new ResponseContext().status(Response.Status.NOT_MODIFIED).entity("Hire couldn't be deleted.");
        }
    }
    
    public ResponseContext getToHireToday(final RequestContext request) {


        return new ResponseContext()
                .contentType(Util.getMediaType(request))
                .entity(vehicleToHireToday);
    }
}