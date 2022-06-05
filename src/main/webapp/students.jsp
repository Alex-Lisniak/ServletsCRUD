<%@ page import="model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="servlet.ListStudentsServlet" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

    </head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12 mx-auto">
            <%@include file="vendor/navbar.jsp"%>
        </div>
    </div>
    <div class="row mt-5">
        <div class="container mt-5" style="background-color: white;">
            <table class="table">
            <thead>
            <tr>
                <th>
                    ID
                </th>
                <th>
                    NAME
                </th>
                <th>
                    SURNAME
                </th>
                <th>
                    AGE
                </th>
                <th>
                    EDIT
                </th>
            </tr>
            </thead>
            <tbody>
                <%
               List<Student> students = (List<Student>)request.getAttribute("students");
                if(students != null) {
                    for(Student s : students) {
                %>
            <tr>
                <td><%=s.getId()%></td>
                <td><%=s.getName()%></td>
                <td><%=s.getSurname()%></td>
                <td><%=s.getAge()%></td>
                <td><a href="/detailsStudent?id=<%=s.getId()%>" class="btn btn-primary btn-sm">EDIT</a></td>
            </tr>
                <%
                        }
                    }
                %>
            </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
