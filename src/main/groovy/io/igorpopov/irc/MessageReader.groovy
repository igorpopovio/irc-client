package io.igorpopov.irc

class MessageReader implements Runnable {
    private Socket socket
    private PrintStream stream

    MessageReader(Socket socket) {
        this.socket = socket
        this.stream = new PrintStream(socket.outputStream)
    }

    @Override
    void run() {
        def scanner = new Scanner(socket.inputStream)
        while (scanner.hasNext()) {
            def message = scanner.nextLine()
            println message
            keepConnectionAlive(message)
        }
    }

    def keepConnectionAlive(String message) {
        if (!message.startsWith("PING")) return

        def pongReply = message.replace("PING", "PONG")
        stream.println(pongReply)
        println(pongReply)
    }
}
