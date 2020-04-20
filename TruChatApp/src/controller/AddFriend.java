package controller;

import domain.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AddFriend extends RequestHandler {
    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Person current = (Person)session.getAttribute("user");
        List<Person> friendlist = current.getFriends();
        String name = request.getParameter("username");

        for (Person person :getPersonService().getPersons()){
            if (person.getUserId().equals(name)){
                if (!friendlist.contains(person)) {
                    friendlist.add(person);
                    person.getFriends().add(current);
                }
            }
        }
    }
}
