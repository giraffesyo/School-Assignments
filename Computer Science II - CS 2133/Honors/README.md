#HONOR CONTRACT Michael McQuade

**FALL 2016**

This project involves creating an application which when ran, will provide the application user with feedback on the current day’s weather.  

The application will obtain its weather data from a free weather API I’ve found on the internet, OpenWeatherMap.
This API requires an API key to be included in requests sent, and it responds with weather data based off of parameters sent in the URL Data returned is in JSON format.
API documentation is available at: http://openweathermap.org/current

The feedback that the user receives will be in the form of a picture placed on the screen. 
This picture represents the application’s recommendation for that day’s weather. 
The API responds with various information that could be used to produce a variety of different pictures.
These will have precedence to display in an order I choose within the programs code. 

For instance, if it rained in the last 3 hours (or is raining), the application will show an umbrella. 
If there is snow, it would show a snowflake. If it is hot, shorts and sunglasses, etc. 

The application will consist of a single window which will need to be run each time a request for information is needed.
On first start it will search for a file in the local directory containing the user’s zip code.
When it does not find the file, it will ask the user for their zip code, and it will store it within a file in the directory the program is stored in.
On later runs, it will find the file and download and process the weather data for that zip code without further user interaction.



