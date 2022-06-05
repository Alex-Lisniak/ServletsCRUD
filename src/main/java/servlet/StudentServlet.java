package servlet;
import service.StudentService;


import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/")
public class StudentServlet extends HttpServlet {

    private StudentService service;

    public void init() {
        service = new StudentService();
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    }

}

