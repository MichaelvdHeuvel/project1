/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib;

import com.controller.PDFController;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.*;
import static com.itextpdf.text.Annotation.URL;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.User;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author David
 */
public class PDF {
    private Document pdfdoc = new Document();
    private User user;
    private HttpServletRequest request;
    
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    
    
    public PDF(User user, HttpServletRequest request){
        this.user = user;
        this.request = request;
    }
    
    public void createPDF() throws DocumentException, IOException{
        String SAVE_DIR = "resources/userfiles/" + user.getEmailAddress() + "/";
         
        
        Random rand = new Random();
        int randomNum = rand.nextInt(9) + 1;

        pdfdoc = new Document();
        
        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;
        
        String RESULT = savePath + user.getFirstName() + user.getLastName() + randomNum + ".pdf";

            PdfWriter.getInstance(pdfdoc, byteArrayOutputStream);
            
        pdfdoc.open();
        
        buildPdfDocument(request, user);
        pdfdoc.close();

        try{
            FileOutputStream fos = new FileOutputStream(RESULT);
            fos.write(byteArrayOutputStream.toByteArray());
            fos.flush();
            fos.close();
        }catch(FileNotFoundException e){
            e.getMessage();
        }catch(IOException e){
            e.getMessage();
        }

        if (RESULT.endsWith(".pdf")) {
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + RESULT);
            } catch (IOException ex) {
                Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            //For cross platform use
            File file = new File(RESULT);
            Desktop desktop = Desktop.getDesktop();
            try{
                desktop.open(file);
            }catch(IOException e){
            }
            
        }
    }
    public void buildPdfDocument(HttpServletRequest request, User userList) throws DocumentException, IOException {
        
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = Calendar.getInstance().getTime();
        String todaysDate = dateFormat.format(date);

//        File file = new File("resources/img/logo.jpg");
//       String path = file.getAbsoluteFile().getAbsolutePath();
//       
//        System.out.println("path1: " + path);
//      String fullPath =  request.getSession().getServletContext().getRealPath("/resources/img/logo.jpg");
//      System.out.println("appp: " + fullPath);

        PdfPTable table1 = new PdfPTable(2);
        table1.setWidthPercentage(100);
        table1.getDefaultCell().setBorder(0);
        table1.getDefaultCell().setPadding(3);
        table1.setWidths(new float[]{20f, 5f});
        
//URL url = this.getClass().getClassLoader().getResource("application.properties");
//System.out.println(url.getPath());
//File file = new File(url.getFile());
//System.out.println("fils" + file.getPath());
//        
//        String contextPath = request.getContextPath();
//        System.out.println("padenn" + contextPath);
//        String userDirectory = System.getProperty("user.home");
//        
        Image logo1 = Image.getInstance("http://localhost:8080/LoginTesten/resources/img/logo.jpg");
        logo1.scalePercent(45f, 45f);
        PdfPCell cell3 = new PdfPCell(logo1);
        cell3.setBorderWidth(0);
        table1.addCell(cell3);

        String str = "http://localhost:8080/LoginTesten/resources/userfiles/" + user.getEmailAddress()+ "/" +user.getProfileImage();
        System.out.println("8989" + str);
        try {
            Image foto = Image.getInstance(str);
            foto.scaleAbsolute(100f, 100f);
            PdfPCell cell = new PdfPCell(foto);
            cell.setBorderWidth(0);
            table1.addCell(cell);   
            table1.addCell("");
            table1.addCell("Aangemaakt op: " + todaysDate);
            cell.setPaddingBottom(70f);
            
        } catch (BadElementException ex) {
            Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        }
         pdfdoc.add(table1);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{1.5f, 3.0f});
        table.setSpacingBefore(10.0f);
        table.getDefaultCell().setBorder(0);
        table.getDefaultCell().setPadding(3);

        pdfdoc.add(new Paragraph("\n"));
        Phrase title = new Phrase("Personalia", boldFont);
        table.addCell(title);
        table.addCell("");

        table.addCell("Naam: ");
        table.addCell(userList.getFirstName() + " " + userList.getLastName());

        table.addCell("Adres: ");
        table.addCell(userList.getAddress() + " " + userList.getAddressNumber());

        table.addCell("Postcode: ");
        table.addCell(userList.getZipcode());

        table.addCell("Woonplaats: ");
        table.addCell(userList.getCity());

        table.addCell("Email: ");
        table.addCell(userList.getEmailAddress());

        table.addCell("Telefoon nummer: ");
        table.addCell(userList.getPhoneNumber());

        pdfdoc.add(table);
    }
}