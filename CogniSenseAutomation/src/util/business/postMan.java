package util.business;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

import org.apache.commons.lang3.StringUtils;

import util.staticData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class postMan {
                public static boolean sendMail(String directoryToZip,String enviorment,String portalusertype)
                {
   final String host = "D50P-SMTP01.TEO.EARTH";;
                        final int port = 25;
                        final String username = "donotreply@teoco.com";
                        final String password = "khabardar";

                        Properties props = new Properties();

                        props.put("mail.smtp.auth", "false");

                        Session session = Session.getInstance(props,
                            new javax.mail.Authenticator() {
                                protected PasswordAuthentication getPasswordAuthentication() {
                                    return new PasswordAuthentication(username, password);
                                }
                            });
                        session.setDebug(true);

                        try {
                                String statTableString = ReportParser.statSender();
                                int countofErrors = StringUtils.countMatches(statTableString, ">failed<"); 
                                String colour = null;
                                if (countofErrors > 0)
                                                colour = "FAIL";
                                else
                                                colour = "PASS";
                            Message message = new MimeMessage(session);
                            message.setFrom(new InternetAddress(username));
  /******************************************************************************/
                    //        message.addRecipient(Message.RecipientType.TO, new InternetAddress(util.excelDataProvider.getCellValueByFieldName("Log Receivers Address",staticData.suitDataSheetName)));
                                
                                String allReciversAddress = util.excelDataProvider.getCellValueByFieldName("Log Receivers Address",staticData.suitDataSheetName);
                                String[] logRecieversAddress = allReciversAddress.split(",");
                                for (int i=0;i<logRecieversAddress.length;i++)
                                   message.addRecipient(Message.RecipientType.TO, new InternetAddress(logRecieversAddress[i]));
                                
  /******************************************************************************/
                                message.setSubject( " Automation " + staticData.suitToRun +" Result For :   " + enviorment + " Status : " + colour);                                                               
                              
                            
  /********************************** By Abhijit for zipping a folder contents **************************************/
                            
                            // Getting the current timestamp in required format
                            Date date = new Date();
                            SimpleDateFormat myDate = new SimpleDateFormat("YYYYMMDD_HHMMSS");
                            String formattedDate = myDate.format(date);
                            
                            String zipFilePath = util.excelDataProvider.getCellValueByFieldName("LogPath",staticData.suitDataSheetName)+"ZipFileFolder_"+formattedDate+".zip";
                            String attachedFileName = "Sanity_"+enviorment+"_"+formattedDate+".zip";
                            
                            //Zipping the required folder in the required path
                           try {
                                  zipFolder(directoryToZip, zipFilePath);
                                           } catch (Exception e) {
                                           // TODO Auto-generated catch block
                                           e.printStackTrace();
                                           }
                            
   /************************************Attaching the zip file in mail and send the same - By Abhijit *******************************************/
                            
                            // Create the message part
                            BodyPart messageBodyPart = new MimeBodyPart();
                            BodyPart messageEndPart = new MimeBodyPart();
                            
                            
                           
                            // Fill the message
                            messageBodyPart.setText(statTableString);
                            messageBodyPart.setContent(statTableString,"text/html");
                            
                            
                            
                            // Create a multipar message
                            Multipart multipart = new MimeMultipart();
                            
                            // Set text message part
                            multipart.addBodyPart(messageBodyPart);
                                            
                            // Part two is attachment
                            messageBodyPart = new MimeBodyPart();
                            DataSource source = new FileDataSource(zipFilePath);
                            messageBodyPart.setDataHandler(new DataHandler(source));
                            messageBodyPart.setFileName(attachedFileName);
                            multipart.addBodyPart(messageBodyPart);
                            

                            // Send the complete message parts
                            message.setContent(multipart);
                            
            if ((util.excelDataProvider
               .getCellValueByFieldName("Will send logs via e-Mail if Fail", staticData.suitDataSheetName)
               .equalsIgnoreCase("Yes"))&& colour.equalsIgnoreCase("FAIL")){

                        Transport transport = session.getTransport("smtp");
                        transport.connect (host, port, username, password);
                        transport.sendMessage(message, message.getAllRecipients());
                        transport.close();  

                            
                            System.out.println("Mail is sent with attachment");
                            
                                   return true;
                      } else if(util.excelDataProvider
                              .getCellValueByFieldName("Will send logs via e-Mail if Fail", staticData.suitDataSheetName)
                              .equalsIgnoreCase("No")) {
                    	  Transport transport = session.getTransport("smtp");
                          transport.connect (host, port, username, password);
                          transport.sendMessage(message, message.getAllRecipients());
                          transport.close();  

                              
                              System.out.println("Mail is sent with attachment");
                              
                                     return true;
                      }else {
                    	  return false;
                      }
                        } catch (MessagingException e) {
                                                                return false;
                        }    
                    }
  static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;
        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);
        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
      }
      static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFile);
        if (folder.isDirectory()) {
          addFolderToZip(path, srcFile, zip);
        } else {
          byte[] buf = new byte[1024];
          int len;
          FileInputStream in = new FileInputStream(srcFile);
          zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
          while ((len = in.read(buf)) > 0) {
            zip.write(buf, 0, len);
          }
        }
      }

      static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
          if (path.equals("")) {
            addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
          } else {
            addFileToZip(path + "/" + folder.getName(), srcFolder + "/" +   fileName, zip);
          }
        }
      }
    
      

}
