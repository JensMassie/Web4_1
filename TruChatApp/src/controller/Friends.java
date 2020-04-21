package controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

public class Friends extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Person person = (Person) session.getAttribute("user");
        String friendslist = toJson(person.getFriends());
        response.setContentType("text/json");
        response.getWriter().write(friendslist);
    }


    private String toJson(List<Person> friends) {
        JsonObject json = new JsonObject();
        for (Person person : friends) {
            JsonObject user = new JsonObject();
            user.addProperty("status", person.getStatus());
            user.addProperty("name", person.getFirstName());
            json.add(person.getUserId(), user);
        }
        return json.toString();
    }
}
