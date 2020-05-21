# Microservice Example With Spring 

If you are looking for a simple example of microservice using the spring framework I created this example. The intent is to have a playground to play and try new technologies along the way. 

This project groups a set of small applications related to cities of world information with a dataset from [simplemaps.com](https://simplemaps.com/data/world-cities)

Some os the projects uses the postgresSQL database others just load the data in memory to keep the simplicity of the code. 

Follow you can find a diagram with the relationship between the services. Check the _README.md_ file on each project to see a list of technology used. 

```
                +-----------+       +----------------------+
   +----------->+ ms.cities +------>+  ms.world.population |
   |            +-----------+       +----------------------+
+--+--+
| BFF |
+-----+         +---------------------+
   +----------->+    ms.geolocation   |
                +---------------------+

```
_Diagram made with [asciiflow.com](http://asciiflow.com/)._

# ms-cities
Retrieve cities.

# ms-geolocation
Retrieve latitude and longitude from cities.

# ms-world-population
Retrieve the number of people from cities.


