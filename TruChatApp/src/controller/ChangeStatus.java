package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangeStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String status = request.getParameter("stat");
        HttpSession session = request.getSession();
        Person person =(Person) session.getAttribute("user");
        person.setStatus(status);
        session.setAttribute("user", person);
    }
}
