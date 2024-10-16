HOW TO RUN:

Import this Version Control GitHub page into a Java IDE and run the DemoApplication.java file (located in: \demo\src\main\java\com\example\demo).

Open your Command Line and run various POST and GET REST requests. View the outcome of these in your localhost:8080/passengers and localhost:8080/flights page.

Find sample REST requests below, suitable for Windows CMD.


DESCRIPTION OF THE CLASSES AND ATTRIBUTES:

Passenger:	id, firstName, lastName, email
Flight:		id, date, time, start, destination
Payment:	id, bank, number, expiry, date


TEST REST REQUESTS:

CREATE Passengers:
curl -X POST -H "Content-Type: application/json" -d "{\"firstName\": \"John\", \"lastName\": \"Smith\", \"email\": \"john.smith@hotmail.com\"}" http://localhost:8080/passengers
curl -X POST -H "Content-Type: application/json" -d "{\"firstName\": \"Samuel\", \"lastName\": \"Brown\", \"email\": \"samuel.brown@gmail.com.au\"}" http://localhost:8080/passengers
curl -X POST -H "Content-Type: application/json" -d "{\"firstName\": \"Jack\", \"lastName\": \"McDonald\", \"email\": \"jack.mcdonald@outlook.com\"}" http://localhost:8080/passengers

UPDATE Passengers:
curl -X PUT -H "Content-Type: application/json" -d "{\"firstName\": \"Johnny\", \"lastName\": \"Smithy\", \"email\": \"johnny.smithy@hotmail.com\"}" http://localhost:8080/passengers/1
curl -X PUT -H "Content-Type: application/json" -d "{\"firstName\": \"Sammy\", \"lastName\": \"Browny\", \"email\": \"sammy.browny@gmail.com.au\"}" http://localhost:8080/passengers/2
curl -X PUT -H "Content-Type: application/json" -d "{\"firstName\": \"Jackie\", \"lastName\": \"McDonalds\", \"email\": \"jacky.mcdonalds@outlook.com\"}" http://localhost:8080/passengers/3

READ Passengers:
curl -X GET http://localhost:8080/passengers

CREATE Flights: 
curl -X POST -H "Content-Type: application/json" -d "{\"date\": \"14.08.2024\", \"time\": \"16:45\", \"start\": \"Sydney International Airport (SYD)\", \"destination\": \"Tokyo Haneda Airport (HND)\"}" http://localhost:8080/flights
curl -X POST -H "Content-Type: application/json" -d "{\"date\": \"15.10.2024\", \"time\": \"10:15\", \"start\": \"Melbourne Airport (MEL)\", \"destination\": \"Los Angeles International Airport (LAX)\"}" http://localhost:8080/flights
curl -X POST -H "Content-Type: application/json" -d "{\"date\": \"02.01.2025\", \"time\": \"20:55\", \"start\": \"Hobart International Airport (HBA)\", \"destination\": \"John F. Kennedy International Airport (JFK)\"}" http://localhost:8080/flights

UPDATE Flights:
curl -X PUT -H "Content-Type: application/json" -d "{\"date\": \"15.09.2025\", \"time\": \"21:00\", \"start\": \"New Sydney International Airport (SYD)\", \"destination\": \"New Tokyo Haneda Airport (HND)\"}" http://localhost:8080/flights/1
curl -X PUT -H "Content-Type: application/json" -d "{\"date\": \"01.03.2026\", \"time\": \"23:55\", \"start\": \"New Melbourne Airport (MEL)\", \"destination\": \"New Los Angeles International Airport (LAX)\"}" http://localhost:8080/flights/2
curl -X PUT -H "Content-Type: application/json" -d "{\"date\": \"16.08.2024\", \"time\": \"13:05\", \"start\": \"New Hobart International Airport (HBA)\", \"destination\": \"New John F. Kennedy International Airport (JFK)\"}" http://localhost:8080/flights/3

READ Flights:
curl -X GET http://localhost:8080/flights

CREATE Payment:
curl -X POST -H "Content-Type: application/json" -d "{\"bank\": \"St George\", \"number\": \"32739284\", \"expiry\": \"03/28\", \"cvv\": \"324\"}" http://localhost:8080/payments
curl -X POST -H "Content-Type: application/json" -d "{\"bank\": \"CommBank\", \"number\": \"37482057\", \"expiry\": \"09/25\", \"cvv\": \"332\"}" http://localhost:8080/payments
curl -X POST -H "Content-Type: application/json" -d "{\"bank\": \"ING\", \"number\": \"99835344\", \"expiry\": \"05/25\", \"cvv\": \"102\"}" http://localhost:8080/payments

UPDATE Payment:
curl -X PUT -H "Content-Type: application/json" -d "{\"bank\": \"New St George\", \"number\": \"00327392\", \"expiry\": \"03/29\", \"CVV\": \"024\"}" http://localhost:8080/payments/1
curl -X PUT -H "Content-Type: application/json" -d "{\"bank\": \"New CommBank\", \"number\": \"00374820\", \"expiry\": \"09/26\", \"CVV\": \"032\"}" http://localhost:8080/payments/2
curl -X PUT -H "Content-Type: application/json" -d "{\"bank\": \"New ING\", \"number\": \"00998353\", \"expiry\": \"05/26\", \"CVV\": \"002\"}" http://localhost:8080/payments/3

READ Payment:
curl -X GET http://localhost:8080/payments
