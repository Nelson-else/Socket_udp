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
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author larga
 */
public class Cliente {

    public static void main(String[] args) {

        final int PUERTO_SERVIDOR = 5001;
        byte[] buffer = new byte[1024];

        try {
            DatagramSocket SocketUDP = new DatagramSocket();

            InetAddress direccionServidor = InetAddress.getByName("localhost");

            String mensaje = "Hola world, desde el cliente";

            DatagramPacket solicitud_cl = new DatagramPacket(buffer, buffer.length, direccionServidor, PUERTO_SERVIDOR);

            System.out.println("Envio de datagrama");
            SocketUDP.send(solicitud_cl);

            DatagramPacket peticion = new DatagramPacket(buffer, buffer.length);

            SocketUDP.receive(peticion);
            System.out.println("recibo ptcin");
            mensaje = new String(peticion.getData());
            System.out.println(mensaje);

            SocketUDP.close();

        } catch (SocketException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
