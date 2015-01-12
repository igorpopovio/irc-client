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
        joinChannelsAfterSeconds(5)
        readMessagesFromKeyboardAndSendThemToTheServer()
    }

    def joinChannelsAfterSeconds(int seconds) {
        println("DEBUG - Will join channels in " + seconds + " seconds...")
        Thread.sleep(seconds * 1000)
        println("DEBUG - Joining...")
        stream.println("JOIN #torrents.ro")
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
