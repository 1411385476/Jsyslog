/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jsyslog;

import java.net.*;
import java.io.*;
import java.util.Date;
import jsyslog.logplay;
import java.awt.*;
import javax.swing.*;
/**
 *
 * @author lizxf
 */
public class Jsyslog {

    /**
     * @param args the command line arguments
     */
    static int i = 1;

    public static void main(String[] args) throws IOException {
	DatagramSocket serverSocket = new DatagramSocket(514);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        logplay lp ;
        lp = new logplay();
        String sentence;
        while(true)
           {
              DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
              //System.out.println("RECEIVED: ");
              serverSocket.receive(receivePacket);
              sentence =  new String( receivePacket.getData());
              //System.out.println("RECEIVED: " + sentence);
              lp.jTextArea.setColumns(50); 
              lp.jTextArea.setRows(5);
              lp.jTextArea.append(sentence.toString());
              lp.jTextArea.setWrapStyleWord(true);
              lp.JscrollText.setViewportView(lp.jTextArea); 
              //lp.setVisible(true);
              /*InetAddress IPAddress = receivePacket.getAddress();
              int port = receivePacket.getPort();
              String capitalizedSentence = sentence.toUpperCase();
              sendData = capitalizedSentence.getBytes();
              DatagramPacket sendPacket =
              new DatagramPacket(sendData, sendData.length, IPAddress, port);
              serverSocket.send(sendPacket);*/
           }
    }
}
