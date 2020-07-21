# Vehicle Hire Booking System
Babcock Technical Test - Vehicle Hire Booking System
This is based upon the Swagger Petstore example at the moment is has fixed static data not a DAO.
Check out the code from git.
Provided you have docker and Java 8 available.
The run this runs application rest service:-
% mvn clean package jetty:run

To get the details of a vehicle by id use this.
curl -X GET "http://localhost:8080/api/v3/vehicle/3" -H 1"accept: application/xml
returns:-
{"id":3,"registration":"VAN 1P","model":{"id":3,"name":"Transit","make":{"id":2,"name":"VW"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":1,"name":"Petrol"}}

This is just the daily charge.
VehicleDataTest.testGetCost()

I am working on the calculation but the Junkt test is there for this.

To get a list of vehicle available to hire today.
returns:-
curl -X GET "http://localhost:8080/api/v3/vehicle/3" -H 1"accept: application/xml"
{"id":3,"registration":"VAN 1P","model":{"id":3,"name":"Transit","make":{"id":2,"name":"VW"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":1,"name":"Petrol"}}marie@snuggly:~/git0/api/v3/store/getToHireToday" -H  "accept: application/json"0
[{"id":3,"registration":"VAN 1P","model":{"id":3,"name":"Transit","make":{"id":2,"name":"VW"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":1,"name":"Petrol"}},{"id":4,"registration":"CAR 2P","model":{"id":4,"name":"Polo","make":{"id":2,"name":"VW"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":1,"name":"Petrol"}},{"id":5,"registration":"CAR 1D","model":{"id":1,"name":"Fiesta","make":{"id":1,"name":"Ford"},"category":{"id":1,"name":"Small Car","currentPrice":{"price":25.0,"currencyCode":"GBP"}}},"fuelType":{"id":1,"name":"Petrol"}},{"id":6,"registration":"EST 1D","model":{"id":2,"name":"Galaxy","make":{"id":1,"name":"Ford"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":2,"name":"Diesel"}},{"id":7,"registration":"VAN 1D","model":{"id":3,"name":"Transit","make":{"id":2,"name":"VW"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":2,"name":"Diesel"}},{"id":8,"registration":"CAR 2D","model":{"id":4,"name":"Polo","make":{"id":2,"name":"VW"},"category":{"id":2,"name":"Estate Car","currentPrice":{"price":35.0,"currencyCode":"GBP"}}},"fuelType":{"id":2,"name":"Diesel"}}]

The interface is described in yaml and so a client can be generated for it.

http://localhost:8080/
