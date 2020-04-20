package controller;

import domain.Person;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class GetStatus extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String status = person.getStatus();
        status = toJSON(status);
        response.setContentType("text/json");
        response.getWriter().write(status);
    }

    private String toJSON (String stat) {
        StringBuffer json = new StringBuffer();

        json.append("{ \"stat\" : \"");
        json.append(stat);
        json.append("\"}");

        return json.toString();
    }
}
