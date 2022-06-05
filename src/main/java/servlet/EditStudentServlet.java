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

@WebServlet(value = "/editStudent")
public class EditStudentServlet extends HttpServlet {
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
        Long id = 0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
            Student student = dao.findById(dao.getDataSource().getConnection(), id);
            if (student!=null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("editStudent.jsp").forward(request,response);
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        int age = Integer.parseInt(request.getParameter("age"));
        Long id = 0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
            Student student = dao.findById(dao.getDataSource().getConnection(), id);

            student.setAge(age);
            student.setName(name);
            student.setSurname(surname);
            dao.update(dao.getDataSource().getConnection(), student);
            List<Student> studentList = dao.findAll(dao.getDataSource().getConnection());
            request.setAttribute("students",studentList);
            request.getRequestDispatcher("students.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (StudentNotFoundException e) {
            e.printStackTrace();
        }
    }
    }
