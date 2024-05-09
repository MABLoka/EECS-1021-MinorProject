INTRODUCTION:
The system I have designed is an automated plant watering system for the EECS 1021 minor project. The 
system was designed using tools and knowledge provided on the course. The system pumps water when 
the soil is dry and stops when it is wet.
CONTEXT:
The system is designed to sense the moisture levels of the soil to pump water whenever the moisture 
levels are higher from the specified threshold and stop whenever it is lower. The automated system 
allows for a more controlled delivery of water, it reduces the probability of over or underwatering a plant 
and reduces the worry of forgetting to water your plant.
TECHNICAL REQUIREMENTS / SPECIFICATIONS
The system should be able to accurately measure the moisture values using the moisture sensor, then
when the condition for concluding that the soil is dry, it should switch on the pump using the MOSFET 
and switch it off when the program concludes that the soil is wet from the moisture values. The system 
should also be able to draw an accurate graph of the machine state. To perform these tasks I used the
Firmata4j library to connect to the board and get the moisture using the getvalue() method, and using
the setvalue() method the system switched the MOSFET on and off, activating the MOSFET.
I used HashMap to store the moisture levels with the corresponding time in second since the start of the 
program, then plotting the values on the graph, x values being the time in secs and y values being the
moisture levels.
COMPONENTS LIST:
1. Arduino Board + OLED Display: The board is responsible for receiving commands and sending 
moisture value to a laptop using java and the display is used to show the state of the system.
2. MOSFET: It is responsible for powering the pump on and off.
3. Moisture Sensor: It is used to sense the moisture levels of the soil.
4. Water Output: The point where the water exits.
5. Water pump and water intake: The point where water enters and is pumped.
6. Batteries: It is responsible for powering the pump.
7. The plant and soil container: The project subjects.
PROCEDURE:
I started by writing the base program from labs I have previously then adding the necessary parts to 
achieve the project, getting the moisture, MOSFET, and button pins. After I have confirmed that the 
system is functioning, I start with importing the library that I will use to draw the graph and wrote the 
necessary parts to graph.
At the start my project had all the parts in the same class, but after some experimenting, I decided that 
putting each task I want to perform in separate classes would better and using timer task to perform 
them is better than for-while loops. There are two timed tasks in my program, one for drawing the graph 
and the other for activating the pump, while the shutdown task was called whenever the button was 
pressed using the firmata4j addeventlistener method. All of these changes allowed for a more accurate 
graph and stable system.
TEST:
I started by taking the values of the moisture sensor in different states, the values when it is put in a cup 
of water, outside the cup of water, in dry soil, and in wet soil. After noting the values I get, I water the 
soil to the necessary amount of water, took the value at that point and used as a threshold. After doing 
all of that I would replicate the environment that will turn on and off the pump multiple times to confirm 
that it is functioning properly.
LEARNING OUTCOMES:
CLO 1[Demonstrate the ability to test and debug a given program and reason about its
correctness.]: With careful planning and multiple tests I have verify that the system is working, as visible 
in the video. I have also looked at previous labs to at some of the libraries we used, which gave the idea 
to timer task to solve the graphing problem I had with time.
CLO 2[Given a problem specification and a suitable API, build an application that meets the given 
requirement]: I used the Firmata4j library establish a connection to the board and initializing the 
components I need, moisture sensor, OLED display, button, and MOSFETI. I have also used the Stdlib
library to draw the moisture level vs time graph and plotting the points.
CLO 3[Use ready-made collections to solve problems involving aggregations of typed data]: I used 
HashMap to store the moisture value reading and corresponding time in secs since start.
CLO 4[Build an event-driven application that controls sensors and actuators in order to connect events to 
physical actions.]: I have used if-else statements to change the pump state by comparing the moisture 
value to threshold I set. I have also used an event listener to shut down the system when the button is 
pressed.
CLO 5[Program common applications from a variety of engineering disciplines using an object-oriented 
language and solve them on the compute]: I initially started the program in one class using for-while 
loops, then changed to multiple classes each with their own function called using time schedule and 
event listeners to get accurate time reading, stabilize the program, and gracefully shutting down.
During the making of this project I learned to use the grove board and java to make DIY automated 
watering system, that will save me water and give me ease of mind. The system used the moisture 
sensor, MOSFET and board to create a system that reads the moisture value of the soil and pump water 
when appropriate
