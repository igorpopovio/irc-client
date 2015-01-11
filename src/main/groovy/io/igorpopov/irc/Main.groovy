package io.igorpopov.irc

class Main {
    public static void main(String[] args) {
        def socket = new Socket("irc.freenode.org", 6667);
        def scanner = new Scanner(socket.inputStream)
        while (scanner.hasNext())
            println scanner.nextLine()
    }
}
