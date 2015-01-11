package io.igorpopov.irc

class MessageListener implements Runnable {
    private Socket socket

    MessageListener(Socket socket) {
        this.socket = socket
    }

    @Override
    void run() {
        def scanner = new Scanner(socket.inputStream)
        while (scanner.hasNext())
            println scanner.nextLine()
    }
}
