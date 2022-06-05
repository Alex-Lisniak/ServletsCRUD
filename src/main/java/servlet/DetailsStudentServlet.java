package servlet;

import dao.implementation.DaoImpl;
import dao.source.CustomDataSource;
import exceptions.StudentNotFoundException;
import model.Student;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DetailsStudentServlet", value = "/detailsStudent")
public class DetailsStudentServlet extends HttpServlet {
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
            Student student = dao.findById(dao.getDataSource().getConnection(),id);
            if (student != null) {
                request.setAttribute("student", student);
                request.getRequestDispatcher("detailsStudent.jsp").forward(request,response);
            }
        }
        catch (Exception e) {
            try {
                throw new StudentNotFoundException();
            } catch (StudentNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
