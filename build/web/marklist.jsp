<%-- 
    Document   : marks
    Created on : 29 Apr, 2021, 9:13:16 PM
    Author     : shelc
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Student Inventory Application</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: blue">
                <div></div>
                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/listmarks" class="nav-link">Student Available</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="row">
            <div class="container">
                <h3 class="text-center">Midterm Grades</h3>
                <hr>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th> SL N0:</th>
                            <th>Course Number </th>
                            <th>Course Name </th>
                            <th>Tutor  </th>
                            <th>Total  </th>
                            <th>Scored  </th>
                            <th>Result  </th>
                            <th>GPA   </th>
                           
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="product" items="${listMarks}">
                            <tr>
                                <td>
                                    <c:out value="${product.slno}" />
                                </td>
                                <td>
                                    <c:out value="${product.subcode}" />
                                </td>
                                <td>
                                    <c:out value="${product.subject}" />
                                </td>
                                <td>
                                    <c:out value="${product.tutor}" />
                                </td>
                                <td>
                                    <c:out value="${product.total}" />
                                </td>
                                <td>
                                    <c:out value="${product.scored}" />
                                </td>
                                <td>
                                    <c:out value="${product.result}" />
                                </td>
                                <td>
                                    <c:out value="${product.gpa }" />
                                </td>

                            </tr>
                        </c:forEach>
                        <!-- } -->
                    </tbody>

                </table>

            </div>
        </div>
    </body>
</html>