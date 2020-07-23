package controllers;

import beans.User;
import daos.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String plansFor = request.getParameter("planFor");
        System.out.println("plan for:" + plansFor);
          HttpSession session = request.getSession();
        switch (plansFor) {
            case "self":
                session.setAttribute("plan", plansFor);
                 response.sendRedirect("selfForm.jsp");
                break;
            case "parents":
                 session = request.getSession();
                 session.setAttribute("plan", plansFor);
                response.sendRedirect("parentsForm.jsp");
                break;
            case "couple":
                    session.setAttribute("plan", plansFor);
                response.sendRedirect("couple.jsp");
                break;
            case "family1":
                    session.setAttribute("plan", plansFor);
               response.sendRedirect("family1Form.jsp");
                break;
            case "family2":
                session.setAttribute("plan", plansFor);
                response.sendRedirect("family2Form.jsp");
                break;
        case "others":
                response.sendRedirect("othersForm.jsp");
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String op = request.getParameter("op");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String contact = request.getParameter("contact");
        String password = request.getParameter("password");

        if (op != null && op.equalsIgnoreCase("add")) {

            HttpSession session = request.getSession();

            User user =  new User();
            user.setName(name);
            user.setEmail(email);
            user.setContact(contact);
            user.setPassword(password);
            session.setAttribute("user", user);
            
            UserDao ud = new UserDao();
            if (ud.addUser(user)) {
                response.sendRedirect("myPolicies.jsp");
                System.out.println("added!");
            }
        }
    }

}
