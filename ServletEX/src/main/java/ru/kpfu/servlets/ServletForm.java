package ru.kpfu.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.kpfu.entities.User;
import ru.kpfu.execptions.AlredyExistEx;
import ru.kpfu.execptions.DataBaseEx;
import ru.kpfu.repo.Repo;

public class ServletForm extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getParameter("status") != null){
            if(req.getParameter("status").equals("1")){
                req.setAttribute("message", "User has been created.");
            }
        }

       getServletContext().getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if((req.getParameter("soap") != null)&&
                (req.getParameter("password") != null) &&
                (req.getParameter("man") != null)
                ){
            boolean man = false;
            boolean subscribe = false;
            if (req.getParameter("man").equals("true")){
                man = true;
            }
            if (req.getParameter("subscribe") != null) {
                if (req.getParameter("subscribe").equals("true")) {
                    subscribe = true;
                }
            }
            try {
                Repo.add(new User(req.getParameter("soap"),req.getParameter("password"),man,subscribe));
            } catch (DataBaseEx dataBaseEx) {
                req.setAttribute("message","data base ex");
                getServletContext().getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(req,resp);
            } catch (AlredyExistEx alredyExistEx) {
                req.setAttribute("message","User is already exists");
                getServletContext().getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(req,resp);
            }
            resp.sendRedirect(req.getRequestURI()+"?status=1");
        }
        else{
            req.setAttribute("message","DENIED");
            getServletContext().getRequestDispatcher("/WEB-INF/views/reg.jsp").forward(req,resp);
        }


    }

}
