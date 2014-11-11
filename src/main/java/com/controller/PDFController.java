package com.controller;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.lib.PDF;
import com.model.User;
import com.service.UserService;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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

    @RequestMapping(value = "/createPdf/{id}", method = RequestMethod.GET)
    public ModelAndView showPdf(HttpSession session, @PathVariable int id, HttpServletRequest request) 
            throws DocumentException, IOException {
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        //if a user object is found, redirect to the intended page
        if(loggedInUser != null){
            User user = userService.getUser(id);
        
            //check if the user exists.
            if(user != null && user.getId() == loggedInUser.getId()){
                ModelAndView profileView = new ModelAndView("/profile/profile");

                PDF pdf = new PDF(userService.getUser(id), request);
                pdf.createPDF();
                
                profileView.addObject("message", "pdf is uitgeprint");
                
                profileView.addObject("user", userService.getUser(id));

                return profileView;
            }else{
                ModelAndView profileViewNot = new ModelAndView("/index/index");
                profileViewNot.addObject("error", "U mag deze cv niet printen");
                return profileViewNot;
            }
    }  else{
            ModelAndView loginView = new ModelAndView("/login/login");
        
            loginView.addObject("user", new User());
            return loginView;
        }
}

//    public void buildPdfDocument(User userList) throws DocumentException {
//       
//        Font font = FontFactory.getFont(FontFactory.HELVETICA);
//        font.setColor(BaseColor.BLACK);
//
//        try {
//            Image image = Image.getInstance("plaatje ................");
//            image.scalePercent(10f, 10f);
//            pdfdoc.add(image);
//        } catch (BadElementException ex) {
//            Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IOException ex) {
//            Logger.getLogger(PDFController.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
//        Date date = Calendar.getInstance().getTime();
//        String todaysDate = dateFormat.format(date);
//
//        PdfPTable table = new PdfPTable(2);
//        table.setWidthPercentage(100.0f);
//        table.setWidths(new float[]{1.5f, 3.0f});
//        table.setSpacingBefore(10.0f);
//        table.getDefaultCell().setBorder(0);
//        table.getDefaultCell().setPadding(5);
//
//        pdfdoc.add(new Paragraph("\n"));
//
//        table.addCell("Naam: ");
//        table.addCell(userList.getFirstName() + " " + userList.getLastName());
//
//        table.addCell("Adres: ");
//        table.addCell(userList.getAddress() + " " + userList.getAddressNumber());
//
//        table.addCell("Postcode: ");
//        table.addCell(userList.getZipcode());
//
//        table.addCell("Woonplaats: ");
//        table.addCell(userList.getCity());
//
//        table.addCell("Email: ");
//        table.addCell(userList.getEmailAddress());
//
//        table.addCell("Telefoon nummer: ");
//        table.addCell(userList.getPhoneNumber());
//
//        table.addCell("rol: ");
//        table.addCell(userList.getRole().getName());
//
//        table.addCell("Aangemaakt op: ");
//        table.addCell(todaysDate);
//
//        pdfdoc.add(table);
//    }
}
