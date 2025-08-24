# Section 20: Java Networking Programming


A **Network** is a system of computers connected together so they can share resources and communicate with each other.

**Networking** refers to how the connected computers communicate.

A **Host** is what a machine is usually called when discussing networking.

Computers on a network, including the internet, communicate with each other using a **transport protocol**.

Each application that needs data from the network is assigned a **port**. When data arrives, the port number is used to route the data to the correct application.

-----

## TCP/IP

**IP** stands for **Internet Protocol**. The term **TCP/IP** refers to using the TCP protocol with IP addresses. This doesn't necessarily mean the host is on the internet; two applications on the same machine can communicate via TCP/IP. When the client and server are on the same host, the IP address `127.0.0.1` (also known as **localhost**) is used.

**TCP** (Transmission Control Protocol) establishes a reliable, two-way connection between hosts using a client/server model.

The sequence of events for TCP/IP communication is:

1.  The client opens a connection to the server.
2.  The client sends a request to the server.
3.  The server sends a response to the client.
4.  The client closes the connection.
    *Steps 2 and 3 can be repeated multiple times.*

### Sockets

When using a low-level networking API, we use **Sockets** to establish connections. A socket is one endpoint of a two-way connection. The client has a socket, and the server has a socket. Multiple clients connecting to a server will use the same port number, but each will have its own socket.

  * **Client:** `Socket` class
  * **Server:** `ServerSocket` class

#### Server Code

```java
try(ServerSocket serverSocket = new ServerSocket(5000))
{
    Socket socket = serverSocket.accept();
    System.out.println("Client Connected");
    // ...
}
```

#### Client Code

```java
try (Socket socket = new Socket("localhost", 5000))
{
    // ...
}
```

-----

## TCP vs. UDP

**TCP** requires handshaking: the client connects, and the server must accept. It's a tightly coupled, two-way connection that performs error checking and resends lost messages, making it **reliable**.

**UDP** (User Datagram Protocol) involves no handshaking. The destination host doesn't send a response. It's used when a reliable, two-way connection isn't needed, and speed is essential. UDP uses **datagrams**—self-contained messages that are not guaranteed to arrive. It's often used for time-sensitive communication where losing an occasional packet is acceptable.

-----

## URIs, URLs, and URNs

For more details, see the [W3C URI Clarification](https://www.w3.org/TR/uri-clarification/).

  * A **URI** (Uniform Resource Identifier) is an identifier that might not provide enough information to access the resource it identifies. It can have a relative path.
  * A **URL** (Uniform Resource Locator) is an identifier that *does* include information on how to access the resource. It must be an absolute path.

A **Scheme** is the part of a URI or URL before the colon (e.g., `http`, `file`, `ftp`).

### Java Networking APIs

  * **Low-Level API:** Uses classes like `Socket`, `ServerSocket`, and `DatagramSocket`.
  * **High-Level API:** Uses classes like `URI`, `URL`, `URLConnection`, and `HttpURLConnection`.

### URI Components

A URI can contain nine components:

1.  Scheme
2.  Scheme-specific part
3.  Authority
4.  User-info
5.  Host
6.  Port
7.  Path
8.  Query
9.  Fragment

The general structure is:
`Scheme:[//[user[:password]@]host[:port]][/path][?query][#fragment]`

  * **Absolute URIs** specify a scheme.
  * **Relative URIs** do not specify a scheme.

A URI object doesn't have to point to a valid resource until you convert it to a URL (e.g., `URL url = uri.toURL();`).

-----

## Helpful Links

  * **URI Wikipedia:** [https://en.wikipedia.org/wiki/Uniform\_Resource\_Identifier](https://en.wikipedia.org/wiki/Uniform_Resource_Identifier)
  * **HTTP Methods:** [https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html](https://www.w3.org/Protocols/rfc2616/rfc2616-sec9.html)
      * (GET, POST, HEAD, OPTIONS, PUT, DELETE, TRACE, CONNECT)
  * **HTTP Header Fields:** [https://en.wikipedia.org/wiki/List\_of\_HTTP\_header\_fields](https://en.wikipedia.org/wiki/List_of_HTTP_header_fields)
  * **Download Apache HttpClient:** [http://hc.apache.org/downloads.cgi](http://hc.apache.org/downloads.cgi)
