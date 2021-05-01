

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Scholar Supervision</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <link rel="stylesheet" href="person.css">

    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
                <div></div>
                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">SCHOLAR SUPERVISIONt</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="row">
            <div class="container">
                <h3 class="text-center">List of Students</h3>
                <hr>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Student Number</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Email </th>
                            <th>Address </th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="product" items="${listProducts}">
                            <tr>
                                <td>
                                    <c:out value="${product.id}" />
                                </td>
                                <td>
                                    <c:out value="${product.fname}" />
                                </td>
                                <td>
                                    <c:out value="${product.lname}" />
                                </td>
                                <td>
                                    <c:out value="${product.email}" />
                                </td>
                                <td>
                                    <c:out value="${product.address}" />
                                </td>
                                <td><a href="edit?id=<c:out value='${product.id}' />">Update    </a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${product.id}' />">Delete</a></td>
                            </tr>
                        </c:forEach>
                        <!-- } -->
                    </tbody>

                </table>
                <div class="container text-left">
                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add New Student</a>
                </div>
                <br>


                <div class="container text-left">
                    <a href="<%=request.getContextPath()%>/listmarks" class="btn btn-success">View Marksheets</a>
                </div>
            </div>
        </div>
    </body>
</html>