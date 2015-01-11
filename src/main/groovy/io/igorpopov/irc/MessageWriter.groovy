package io.igorpopov.irc

class MessageWriter implements Runnable {
    private Socket socket
    private PrintStream stream;

    MessageWriter(Socket socket) {
        this.socket = socket
        this.stream = new PrintStream(socket.outputStream)
    }

    @Override
    void run() {
        def scanner = new Scanner(System.in)
        while (scanner.hasNextLine())
            stream.println(scanner.nextLine())
    }
}
