package io.igorpopov.irc

class MessageReader implements Runnable {
    private Socket socket

    MessageReader(Socket socket) {
        this.socket = socket
    }

    @Override
    void run() {
        def scanner = new Scanner(socket.inputStream)
        while (scanner.hasNext())
            println scanner.nextLine()
    }
}
