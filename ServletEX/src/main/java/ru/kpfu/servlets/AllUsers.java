package ru.kpfu.servlets;
import ru.kpfu.execptions.DataBaseEx;
import ru.kpfu.repo.Repo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllUsers extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("userList", Repo.getAllAr("data"));
        } catch (DataBaseEx dataBaseEx) {
            req.setAttribute("message","dataBaseEx");
        }
        getServletContext().getRequestDispatcher("/WEB-INF/views/allUsers.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
