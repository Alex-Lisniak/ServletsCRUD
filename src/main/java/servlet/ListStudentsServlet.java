package servlet;

import dao.implementation.DaoImpl;
import dao.source.CustomDataSource;
import exceptions.StudentNotFoundException;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ListStudents", value = "/listStudents")
public class ListStudentsServlet extends HttpServlet {
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
        try {
            List<Student> studentList = dao.findAll(dao.getDataSource().getConnection());
            request.setAttribute("students", studentList);
            request.getRequestDispatcher("students.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
