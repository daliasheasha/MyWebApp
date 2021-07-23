package com.jetbrains.MyWebApp;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/myServlet")
public class MyServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>Thanks!</title></head>");
        out.write("<body>");

        // Demo purposes only - don't do this in production!
        String name = request.getParameter("name");
        String favFruit = request.getParameter("favFruit");
        String validationRegex = "^[a-zA-Z\\s]+";
        if(name.matches(validationRegex) && favFruit.matches(validationRegex)) {
            Person person = new Person();
            person.setName(name);
            person.setFavFruit(favFruit);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();

            out.write("<h1>Saved!</h1>");

            out.write("<table border ='1'>");
            out.write("<tr>");
            out.write("<th>Name          </th>");
            out.write("<th>Favorite Fruit</th>");
            out.write("</tr>");

            List<Person> people = em
                    .createQuery("Select p from Person p", Person.class)
                    .getResultList();
            for (Person p: people) {
                out.write("<tr>");
                out.write("<td>" + p.getName() +"</td>");
                out.write("<td>" + p.getFavFruit() +"</td>");
                out.write("</tr>");
            }

            out.write("</table>");
        } else {
            out.write("<h1>Sorry! I only accept letters!</h1>");
        }

        out.write("<br><a href=\"index.jsp\">Back to Form</a>");
        out.write("</body></html>");
    }

    public void destroy() {
    }
}