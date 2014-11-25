/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lib;

import com.controller.PDFController;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.User;
import com.model.WorkExperience;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Tim
 */
public class PDF {

    private Document pdfdoc = new Document();
    private User user;
    private List<WorkExperience> workExpList;
    private HttpServletRequest request;

    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    public PDF(User user, List<WorkExperience> workExpList, HttpServletRequest request) {
        this.user = user;
        this.request = request;
        this.workExpList = workExpList;
    }

    public void createPDF() throws DocumentException, IOException {
        String SAVE_DIR = "resources/userfiles/" + user.getEmailAddress() + "/";

        Random rand = new Random();
        int randomNum = rand.nextInt(9) + 1;

        pdfdoc = new Document();

        String appPath = request.getServletContext().getRealPath("");
        String savePath = appPath + File.separator + SAVE_DIR;

        String RESULT = savePath + user.getFirstName() + user.getLastName() + randomNum + ".pdf";

        PdfWriter.getInstance(pdfdoc, byteArrayOutputStream);

        pdfdoc.open();

        buildPdfDocument(request, user, workExpList);
        pdfdoc.close();

        try {
            FileOutputStream fos = new FileOutputStream(RESULT);
            fos.write(byteArrayOutputStream.toByteArray());
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.getMessage();
        } catch (IOException e) {
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
            try {
                desktop.open(file);
            } catch (IOException e) {
            }

        }
    }

    public void buildPdfDocument(HttpServletRequest request, User userList, List<WorkExperience> workExpList) throws DocumentException, IOException {

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);
        Font boldFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = Calendar.getInstance().getTime();
        String todaysDate = dateFormat.format(date);

        PdfPTable table1 = new PdfPTable(2);
        table1.setWidthPercentage(100);
        table1.getDefaultCell().setBorder(0);
        table1.getDefaultCell().setPadding(3);
        table1.setWidths(new float[]{20f, 5f});

        Image logo1 = Image.getInstance("http://localhost:8084/LoginTesten/resources/img/logo.jpg");
        logo1.scalePercent(45f, 45f);
        PdfPCell cell3 = new PdfPCell(logo1);
        cell3.setBorderWidth(0);
        table1.addCell(cell3);

        String str = "http://localhost:8084/LoginTesten/resources/userfiles/" + user.getEmailAddress() + "/" + user.getProfileImage();
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

        PdfPTable tableContact = new PdfPTable(2);
        tableContact.setWidthPercentage(100.0f);
        tableContact.setWidths(new float[]{1.5f, 3.0f});
        tableContact.setSpacingBefore(10.0f);
        tableContact.getDefaultCell().setBorder(0);
        tableContact.getDefaultCell().setPadding(3);

        pdfdoc.add(new Paragraph("\n"));
        Phrase title = new Phrase("Personalia", boldFont);
        tableContact.addCell(title);
        tableContact.addCell("");

        tableContact.addCell("Naam: ");
        tableContact.addCell(userList.getFirstName() + " " + userList.getLastName());

        tableContact.addCell("Adres: ");
        tableContact.addCell(userList.getAddress() + " " + userList.getAddressNumber());

        tableContact.addCell("Postcode: ");
        tableContact.addCell(userList.getZipcode());

        tableContact.addCell("Woonplaats: ");
        tableContact.addCell(userList.getCity());

        tableContact.addCell("Email: ");
        tableContact.addCell(userList.getEmailAddress());

        tableContact.addCell("Telefoon nummer: ");
        tableContact.addCell(userList.getPhoneNumber());
        pdfdoc.add(tableContact);

        PdfPTable tableWork = new PdfPTable(2);
        tableWork.setWidthPercentage(100.0f);
        tableWork.setWidths(new float[]{1.5f, 3.0f});
        tableWork.setSpacingBefore(10.0f);
        tableWork.getDefaultCell().setBorder(0);
        tableWork.getDefaultCell().setPadding(3);

        pdfdoc.add(new Paragraph("\n"));
        Phrase titleWork = new Phrase("Werkervaring", boldFont);
        tableWork.addCell(titleWork);
        tableWork.addCell("");

        for (WorkExperience workList : workExpList) {
            tableWork.addCell(workList.getStartDate().toString().substring(0, 7) + " - " + workList.getEndDate().toString().substring(0, 7));
            tableWork.addCell("");
            tableWork.addCell("Bedrijf: ");
            tableWork.addCell(workList.getCompany());
            tableWork.addCell("Functie: ");
            tableWork.addCell(workList.getFunction());
            tableWork.addCell("Omschrijving: ");
            tableWork.addCell(workList.getDescription());
            tableWork.addCell(" ");
            tableWork.addCell(" ");
        }

        pdfdoc.add(tableWork);

    }
}
