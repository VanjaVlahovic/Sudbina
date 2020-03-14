/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vanja Vlahović
 */
public class ServerskaNit extends Thread {

    private final ServerSocket serverSocket;
    private final List<KlijentskaNit> klijenti;

    public ServerskaNit() throws IOException {
        serverSocket = new ServerSocket(9000);
        System.out.println("Podignut server");
        klijenti = new ArrayList<>();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    @Override
    public void run() {
        while (!serverSocket.isClosed()) {
            try {
                Socket socket = serverSocket.accept();
                KlijentskaNit nit = new KlijentskaNit(socket);
                klijenti.add(nit);
                nit.start();

                System.out.println("Konektovan klijent");
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        zaustaviSveNiti();
    }

    private void zaustaviSveNiti() {
        for (KlijentskaNit klijent : klijenti) {
            try {
                klijent.getSocket().close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
