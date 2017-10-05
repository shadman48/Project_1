# Project_1
This project, will be implementing a very simple chat client. A server will be running that you will
connect to for testing your client. 
In this project, both the server and client will communicate using UTF-8
text. 
The server will work as follows: the first line you send will be stored by the server as your user name.
If it is already in use, the server will respond “Name in use.” and close the connection.
After connecting and providing a name, any line you send to the server will be broadcast to all connected
clients with a timestamp and the sender’s username. 
