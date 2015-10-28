package ru.kpfu.servlets;

import ru.kpfu.entities.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.http.HttpSession;

import ru.kpfu.execptions.DataBaseEx;
import ru.kpfu.execptions.NoUserEx;
import ru.kpfu.repo.Repo;

public class Authentication extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession ses = req.getSession();
        try {
            User user = Repo.userAuthentication(req.getParameter("soap"),req.getParameter("password"));
            ses.setAttribute("authentication",user);
            resp.sendRedirect("/profile");
        }catch (NoUserEx e){
            req.setAttribute("message","No such user");
            getServletContext().getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(req,resp);
        }catch (DataBaseEx e){
            getServletContext().getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(req,resp);
            req.setAttribute("message","Data base not work well");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("authentication") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/views/authentication.jsp").forward(req, resp);
        }else {
            resp.sendRedirect("/profile");
        }
    }
}
