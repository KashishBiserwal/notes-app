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
import java.util.Date;

@WebServlet(name = "UpdateServlet", value = "/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String title = request.getParameter("title");
            String content = request.getParameter("content");
            int noteId = Integer.parseInt(request.getParameter("noteId").trim());

            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();
            Notes note = s.get(Notes.class, noteId);
            note.setTitle(title);
            note.setContent(content);
            note.setAddedDate(new Date());

            tx.commit();
            s.close();
            response.sendRedirect("view_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
