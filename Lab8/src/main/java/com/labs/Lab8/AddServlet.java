package com.labs.Lab8;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "AddServlet", value = "/add")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response)
            throws IOException {

        request.setCharacterEncoding("UTF-8");
        String login = request.getParameter("login");
        String password = request.getParameter("password");

        if (UserBase.getInstance().is_login_busy((login)))
        {
            response.sendRedirect(request.getContextPath() + "/add.html#busy");
        } else {
            User user = new User(login, password);
            UserBase.getInstance().add(user);
            response.sendRedirect(request.getContextPath() + "/index.html");
        }
    }
}
