package servlet;

import dao.implementation.DaoImpl;
import dao.source.CustomDataSource;
import model.Student;
import service.StudentService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

//author Syrym Khakimzhan servlets/UI
@WebServlet(value = "/addStudent")
public class AddStudentServlet extends HttpServlet {
    DaoImpl dao;
    public void init() {
        CustomDataSource customDataSource = null;
        try {
            customDataSource = new CustomDataSource();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        dao = new DaoImpl(customDataSource);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/addStudent.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            int age = Integer.parseInt(request.getParameter("age"));
        try {
            dao.save(dao.getDataSource().getConnection(), new Student(name, surname,age));
                response.sendRedirect("/addStudent?success");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
;}
