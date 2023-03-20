package com.notes;

import com.entities.Notes;
import com.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "SaveNoteServlet", value = "/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            Notes note = new Notes(title, content, new Date());

            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();
            s.persist(note);
            tx.commit();
            s.close();
            response.sendRedirect("view_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
