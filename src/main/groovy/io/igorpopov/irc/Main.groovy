package io.igorpopov.irc

class Main {
    public static void main(String[] args) {
        def socket = new Socket("irc.freenode.org", 6667);
        new Thread(new MessageReader(socket)).start();
        new Thread(new MessageWriter(socket)).start();
    }
}
