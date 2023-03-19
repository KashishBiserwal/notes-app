package com.notes;

import com.entities.Notes;
import com.helper.FactoryProvider;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", value = "/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int noteId = Integer.parseInt(request.getParameter("note_id").trim());
            Session s = FactoryProvider.getFactory().openSession();
            Transaction tx = s.beginTransaction();
            Notes note = s.get(Notes.class, noteId);
            s.remove(note);
            tx.commit();
            s.close();
            response.sendRedirect("view_notes.jsp");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
