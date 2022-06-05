<%@ page import="model.Student" %>
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
    <%
        String success = request.getParameter("success");
        String error = request.getParameter("error");
        if(success != null) {
    %>
    <div class="alert alert-success alert-dismissible fade show" role="alert">
        Succesfully movies added!
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <%
        } else if(error != null) {
    %>

    <div class="alert alert-danger alert-dismissible fade show" role="alert">
        Something went wrong!
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <%
        }
    %>

    <h1 class="text-primary text-center">EDIT STUDENT</h1>
    <div class="row mt-5">
        <form action="/editStudent" method="post">
            <%
                Student student = (Student)request.getAttribute("student");
                if (student!=null) {
            %>
            <input type="hidden" value="<%=student.getId()%>" name="id">
        <div class="form-group">
            <label for="">NAME OF STUDENT</label>
            <input type="text" class="form-control" name="name"  value="<%=student.getName()%>">
        </div>
        <div class="form-group">
            <label for="">SURNAME OF STUDENT</label>
            <input type="text" class="form-control" name="surname" value="<%=student.getSurname()%>">
        </div>
        <div class="form-group">
            <label for="">AGE OF STUDENT</label>
            <input type="number" class="form-control" name="age" value="<%=student.getAge()%>">
        </div>
            <div class="form-group">
                <button class="btn btn-primary btn-sm">SAVE</button>
            </div>
        </form>
        <%
            }
        %>
    </div>
</div>
</body>
</html>
