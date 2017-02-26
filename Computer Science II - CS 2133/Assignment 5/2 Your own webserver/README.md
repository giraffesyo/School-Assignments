
# 2 -	Your own webserver (35 points)

In Assignment 4, you wrote a simple web browser client. This time around, you will write a multithreaded webserver which will serve HTML les from the lesystem to a browser client. 

Write a program called Webserver.java that creates a ServerSocket object and then enters an in nite loop. 
The program should take the Socket returned by the ServerSocket's `accept()` method, create a Runnable object that uses the Socket, pass this object to a Thread, start the Thread running, and go back to waiting for another client connection.

The Runnable object will handle establishing the connection and serving the le. You already know what the client's handshake string looks like:

> GET <filename> HTTP/1.1

Your server should receive this string and extract the name of the le. If the request is empty (ie the name of the le is simply /), then by convention the server should load a le called \index.html".

You will need to look for the requested le on the lesystem and load it into memory. You will then respond to the client's request using the simplest possible HTTP response:

>HTTP/1.1 200 OK\r\n  
>Content-type: text/html\r\n\r\n

Backslash-r and backslash-n here correspond to the carriage return and newline characters, respectively. After you send these lines, you should send the text file.

If the browser asks for a	file that does not exist, you should instead send the response

>HTTP/1.1 404 Not Found\r\n\r\n

If anything else goes wrong you can try to send

>HTTP/1.1 500 Internal Server Error\r\n\r\n

Important: This server is extremely insecure, and will allow a malicious user to access any text file on your machine. You should implement a check so that the server will only send files that are located inside a particular directory designated by you. If the user tries to navigate outside of that directory (by using the parent-directory symbol \.."), the server should not permit it.

Note: By convention, webservers should run on port 80. However, many operating systems protect 2- and 3-digit port numbers for security reasons, and running a Java webserver on port 80 would require running the program with administrative permissions. For that reason, it is common to choose port 8000 or 8080 for running webservers in development (like yours are). 
If you are running your server on port 8080, you can access it with any standard browser (Safari, Firefox, Chrome, etc.) by pointing it to \http://localhost:8080".

Extra credit: Allow the server to serve images as well as HTML files. Check the lename, and if it ends with \.jpg", change the HTTP content-type from \text/html" to \image/jpeg", and load and transmit as a binary le rather than a text file.
