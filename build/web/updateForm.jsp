<%-- 
    Document   : updateForm.jsp
    Created on : 18 Feb, 2021, 2:44:42 PM
    Author     : shelc
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

    <head>
        <title>Student Inventory Management</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blanchedalmond">
                <div>
                    <a href="https://www.javaguides.net" class="navbar-brand"> Student Management </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${product != null}">
                        <form action="update" method="post">
                        </c:if>
                        <c:if test="${product == null}">
                            <form action="insert" method="post">
                            </c:if>

                            <caption>
                                <h2>
                                    <c:if test="${product != null}">
                                        Update Student details
                                    </c:if>
                                </h2>
                            </caption>

                            <c:if test="${product != null}">
                                <input type="hidden" name="id" value="<c:out value='${product.id}' />" />
                            </c:if>
                            <fieldset class="form-group">
                                <label>First Name</label> <input type="text" value="<c:out value='${product.fname}' />" class="form-control" name="fname">
                            </fieldset>
                                                        <fieldset class="form-group">
                                <label>Last Name </label> <input type="text" value="<c:out value='${product.lname}' />" class="form-control" name="lname">
                            </fieldset>


                            <fieldset class="form-group">
                                <label>Email</label> <input type="text" value="<c:out value='${product.email}' />" class="form-control" name="email">
                            </fieldset>

                            <fieldset class="form-group">
                                <label>Address</label> <input type="text" value="<c:out value='${product.address}' />" class="form-control" name="address">
                            </fieldset>
                            <button type="submit" class="btn btn-success">Save</button>
                        </form>
                </div>
            </div>
        </div>
    </body>

</html>
