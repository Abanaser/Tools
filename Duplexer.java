/**
 * A shortcut to create PrinterWriter, BufferedReader for a socket.
 * file: Duplexer.java
 * Author: Abdulmalik Banaser
 */

import java.io.*;
import java.net.Socket;

public class Duplexer implements AutoCloseable {

    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    /**
     * constructor to creat a printerWriter and BufferedReader for a given socket.
     * @param socket socket connection
     * @throws IOException
     */
    public Duplexer(Socket socket) throws IOException {
        this.socket = socket;
        InputStream input = socket.getInputStream();
        InputStreamReader iReader = new InputStreamReader(input);
        reader = new BufferedReader(iReader);
        OutputStream output = socket.getOutputStream();
        writer = new PrintWriter(output);
    }

    /**
     * A method to send the given string to the other end of the socket connection
     * @param message the message to send
     */
    public void send(String message) {
        writer.println(message);
        writer.flush();
    }

    /**
     * A method that return the string received
     * @return the received message form the other side of the connection
     * @throws IOException
     */
    public String receive() throws IOException {
        return reader.readLine();
    }

    @Override
    public void close() throws Exception {
        socket.close();
    }

    /**
     * return the socket that the duplexer was built on
     * @return
     */
    public Socket getSocket() {
        return socket;
    }
}
