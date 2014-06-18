CS542 Design Patterns
Spring 2014
PROJECT 2 README FILE

Due Date: Thursday, March 13 , 2014
Submission Date: Friday, March 13, 2014
Author(s): Bhavin D Desai 
e-mail(s): bdesai1 dot binghamton dot edu


PURPOSE:

[
  Multi threaded client-server chat application using singleton threadpool.
  Messages of client are dumped to a file.
]


PARTS THAT ARE NOT COMPLETE:
[
   I handling only single client with a server 
]

BUGS:
[
  "None".
]

FILES:
[
  Included with this project are 5 files:

	client
	1. ClientDriver.java
 	
	server
	1. ServerDriver.java
	2. ServerHandler.java
	
	util
	1. logger.java
	2. threadPool.java
	
	README, the text file you are presently reading
]

SAMPLE OUTPUT:
[
	
	1. Send message to a client
	2. Print Messages from a client
	3. Quit
	
	>>> 
]

TO COMPILE:
[
 	ant 
]

TO RUN:

[
  ./run.sh server <port_number>
  ./run.sh client <serverName-Localhost> <port_number>
]


BIBLIOGRAPHY:
[
	tutorialspoint.com
	oracle java docs 
]
