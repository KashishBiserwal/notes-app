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

            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1 style='text-align:center'>Note is added successfully</h1>");
            out.println("<h1 style='text-align:center'><a href='view_notes.jsp'>View all notes</a></h1>");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
