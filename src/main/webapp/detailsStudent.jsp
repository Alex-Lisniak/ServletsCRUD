<%@ page import="model.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta charset="utf-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

    </head>
<body>

<div class="container">
    <div class="row">
        <div class="col-sm-12 mx-auto">
            <%@include file="vendor/navbar.jsp"%>
        </div>
    </div>
    <div class="row">
    <div class="container md -5">
        <%
            Student student = (Student) request.getAttribute("student");
            if(student!=null) {
        %>
        <div class="jumbotron m-5" style="margin-top: 20px;">
            <h1 class="display-4"><%=student.getName()%></h1>
            <p class="lead"><%=student.getSurname()%></p>
            <hr class="my-4">
            <p>AGE: <%=student.getAge()%></p>
            <a class="btn btn-primary btn-sm" href="/editStudent?id=<%=student.getId()%>">EDIT</a>
            <button type="button" class="btn btn-danger btn-sm float-right" data-toggle="modal" data-target="#delete">
                DELETE
            </button>

    </div>
        <div class="modal fade" id="delete" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
            <div class="modal-dialog">

                <div class="modal-content">
                    <form action="/deleteStudent" method="post">
                        <input type="hidden" value="<%=student.getId()%>" name="id">
                        <div class="modal-header">
                            <h5 class="modal-title" id="staticBackdropLabel">DELETE USER</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Are you sure?
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-danger">YES</button>
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">NO</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <%
            }
        %>
    </div>
</div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>
