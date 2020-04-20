/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rezini.crono.Utilidades;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author ivan rezini
 */
public class EmailWrapper {
     private Properties propriedades;
    private Session sessao;

    
public EmailWrapper(){
    this.setPropridades();
}
    private void setPropridades() {
        this.propriedades = new Properties();
        this.propriedades.put("mail.smtp.host", "mail.dextak.com");
        this.propriedades.put("mail.smtp.socketFactory.port", "465");
        this.propriedades.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        this.propriedades.put("mail.smtp.auth", "true");
        this.propriedades.put("mail.smtp.port", "465");
    }
   private void autenticar() {
        this.sessao = Session.getDefaultInstance(this.propriedades,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("senai.test@dextak.com", "(senai)");
            }
        });
   }
    public boolean enviar(String remetente, String destinatario, String assunto, String msg){
        try{
        
        this.autenticar();
        Message message =new MimeMessage(this.sessao);
        message.setFrom(new InternetAddress(remetente));
        message.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destinatario));
        message.setSubject(assunto);
        message.setText(msg);
        Transport.send(message);
        return true;
        }catch(MessagingException e){
            return false;
        }
    }
    }










