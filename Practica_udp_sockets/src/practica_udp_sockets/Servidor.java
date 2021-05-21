/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_udp_sockets;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author larga
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        final int PUERTO = 5001;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("SERVIDOR UDP INICIADO");
            DatagramSocket SocketUDP = new DatagramSocket(PUERTO);

            while (true) {

                DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

                SocketUDP.receive(peticion);
                System.out.println("server recibe la informacion del cliente");

                String mensaje = new String(peticion.getData());
                System.out.println(mensaje);

                int puertoCliente = peticion.getPort();
                InetAddress direccion = peticion.getAddress();

                mensaje = "Hola mundo desde el servidor!";
                buffer = mensaje.getBytes();
                DatagramPacket answer = new DatagramPacket(buffer, buffer.length, direccion, puertoCliente);
                System.out.println("server envia mensaje-respuesta a cliente");
                SocketUDP.send(answer);

            }

        } catch (SocketException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
