/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logic;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Sistemas
 */
public class EmailSender {

      public static void enviarCorreo(String destinatario, String asunto, String cuerpoHtml)
            throws UnsupportedEncodingException, MessagingException, IOException {
        final String remitente = "angelemanuelpelico@gmail.com";
        final String clave = "igyg wrcg amhj mozj";

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(remitente, clave);
            }
        });

       // Crear mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(remitente, "Vista Verde Administración"));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject(asunto, "UTF-8");

        // Multipart para HTML + imagen
        MimeMultipart multipart = new MimeMultipart("related");

        // Parte HTML
        MimeBodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent(cuerpoHtml, "text/html; charset=utf-8");
        multipart.addBodyPart(htmlPart);

        // Parte Imagen (logo embebido)
        MimeBodyPart imagePart = new MimeBodyPart();
        File logoFile = new File("src/main/resources/Iconos/VistaVerde.jpeg"); // ruta de tu logo
        imagePart.attachFile(logoFile);
        imagePart.setContentID("<logoVistaVerde>");
        imagePart.setDisposition(MimeBodyPart.INLINE);
        multipart.addBodyPart(imagePart);

        // Asignar contenido al mensaje
        message.setContent(multipart);

        // Enviar
        Transport.send(message);
        System.out.println("Correo enviado a " + destinatario);
    }
}
