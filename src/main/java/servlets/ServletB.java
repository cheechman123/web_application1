package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class ServletB extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("b");
        Enumeration<String> initParametes = getServletConfig().getInitParameterNames();
        while (initParametes.hasMoreElements()){
            String s = initParametes.nextElement();
            System.out.println(s + " = " + getServletConfig().getInitParameter(s));
        }
    }
}
