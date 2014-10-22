package com.springmvc.controller;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.springmvc.model.User;
import com.springmvc.service.UserService;
import java.awt.Desktop;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PDFController {

    @Autowired
    private UserService userService;

    private Document pdfdoc = new Document();
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @RequestMapping(value = "/createPdf/{id}", method = RequestMethod.GET)
    public ModelAndView showPdf(@PathVariable int id) throws DocumentException, IOException {
        pdfdoc = new Document();
        User userList = userService.getUser(id);
        String RESULT = "D:\\curriculum_vitae_" + userList.getName() + ".pdf";

        PdfWriter.getInstance(pdfdoc, byteArrayOutputStream);
        pdfdoc.open();
        this.buildPdfDocument(userList);
        pdfdoc.close();

        FileOutputStream fos = new FileOutputStream(RESULT);
        fos.write(byteArrayOutputStream.toByteArray());
        fos.flush();
        fos.close();

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
            desktop.open(file);

        }

        ModelAndView userListView = new ModelAndView("userList");
        userListView.addObject("userList", userService.getUsers());
        String message = "PDF is succesvol aangemaakt.";
        userListView.addObject("message", message);
        return userListView;

    }

    public void buildPdfDocument(User userList) throws DocumentException {

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(BaseColor.BLACK);

        try {
            Image image = Image.getInstance("C:\\Users\\Tim\\Desktop\\11 SpringMVCHibernate\\src\\main\\webapp\\resources\\img\\logo_blue.bmp");
            image.scalePercent(10f, 10f);
            pdfdoc.add(image);
        } catch (BadElementException ex) {
            Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
        }

//        pdfdoc.add(new Paragraph("Naam: " + userList.getName()));
//        pdfdoc.add(new Paragraph("Adres: " + userList.getStreetAddress()));
//        pdfdoc.add(new Paragraph("Huisnummer: " + userList.getHouseNumber()));
//        pdfdoc.add(new Paragraph("Woonplaats: " + userList.getCity()));
//        pdfdoc.add(new Paragraph("id: " + userList.getUserId()));
//        pdfdoc.add(new Paragraph("rol: " + userList.getRole().getName())); 
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = Calendar.getInstance().getTime();
        String todaysDate = dateFormat.format(date);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(100.0f);
        table.setWidths(new float[]{1.5f, 3.0f});
        table.setSpacingBefore(10.0f);
        table.getDefaultCell().setBorder(0);
        table.getDefaultCell().setPadding(5);

        pdfdoc.add(new Paragraph("\n"));

        table.addCell("ID: ");
        table.addCell("" + userList.getUserId());

        table.addCell("Naam: ");
        table.addCell(userList.getName());

        table.addCell("Adres: ");
        table.addCell(userList.getStreetAddress() + " " + userList.getHouseNumber());

        table.addCell("Woonplaats: ");
        table.addCell(userList.getCity());

        table.addCell("rol: ");
        table.addCell(userList.getRole().getName());

        table.addCell("Aangemaakt op: ");
        table.addCell(todaysDate);

        pdfdoc.add(table);
    }

}
