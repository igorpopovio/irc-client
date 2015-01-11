package io.igorpopov.irc

class MessageWriter implements Runnable {
    private Socket socket
    private PrintStream stream
    private Scanner scanner

    MessageWriter(Socket socket) {
        this.socket = socket
        this.stream = new PrintStream(socket.outputStream)
        this.scanner = new Scanner(System.in)
    }

    @Override
    void run() {
        setIdentity()
        readMessagesFromKeyboardAndSendThemToTheServer()
    }

    def readMessagesFromKeyboardAndSendThemToTheServer() {
        while (scanner.hasNextLine())
            stream.println(scanner.nextLine())
    }

    def setIdentity() {
        stream.println("NICK groovyIrcClient")
        stream.println("USER groovyIrcClient 8 * :A Groovy Command Line Client")
    }
}
