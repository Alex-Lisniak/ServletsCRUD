package servlet;

import dao.implementation.DaoImpl;
import dao.source.CustomDataSource;
import exceptions.StudentNotFoundException;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "EditStudentServlet", value = "/deleteStudent")
public class DeleteStudentServlet extends HttpServlet {
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
                request.getRequestDispatcher("/editStudent.jsp").forward(request,response);
            }
        }catch (Throwable e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Long id = 0L;
        try {
            id = Long.parseLong(request.getParameter("id"));
            Student student = dao.findById(dao.getDataSource().getConnection(), id);

            dao.deleteById(dao.getDataSource().getConnection(), student.getId());
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
