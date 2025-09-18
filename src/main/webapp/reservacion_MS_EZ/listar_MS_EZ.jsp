<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Reservaciones</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f9;
            margin: 0;
            padding: 0;
        }
        .container {
            width: 90%;
            max-width: 900px;
            margin: 50px auto;
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
        }
        h2 {
            text-align: center;
            color: #2e59a6;
            margin-bottom: 25px;
        }
        a.add-btn {
            display: inline-block;
            margin-bottom: 20px;
            padding: 10px 20px;
            background-color: #1abc9c;
            color: #fff;
            text-decoration: none;
            border-radius: 6px;
        }
        a.add-btn:hover { opacity: 0.9; }
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            padding: 12px 15px;
            text-align: left;
            border-bottom: 1px solid #ddd;
        }
        th { background-color: #2e59a6; color: #fff; }
        tr:hover { background-color: #f1f1f1; }
        a.action-btn {
            margin-right: 10px;
            text-decoration: none;
            padding: 6px 12px;
            border-radius: 6px;
            color: #fff;
        }
        a.edit-btn { background-color: #1abc9c; }
        a.delete-btn { background-color: #e74c3c; }
        a.edit-btn:hover, a.delete-btn:hover { opacity: 0.9; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Lista de Reservaciones</h2>
    <a href="${pageContext.request.contextPath}/ControllerReserva_MS_EZ?action=nuevo" class="add-btn">Nueva Reservación</a>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Cliente</th>
                    <th>Fecha</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="r" items="${lista}">
                    <tr>
                        <td>${r.id}</td>
                        <td>${r.nombrePasajero}</td>
                        <td>${r.fecha}</td>
                        <td>
                                     <a href="${pageContext.request.contextPath}/ControllerReserva_MS_EZ?action=editar&id=${r.id}" class="action-btn edit-btn">Editar</a>
                                     <a href="${pageContext.request.contextPath}/ControllerReserva_MS_EZ?action=eliminar&id=${r.id}" 
                                         class="action-btn delete-btn"
                                         onclick="return confirm('¿Eliminar reservación?')">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
