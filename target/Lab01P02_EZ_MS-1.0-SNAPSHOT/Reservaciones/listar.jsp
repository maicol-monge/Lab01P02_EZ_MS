<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Reservaciones</title>
</head>
<body>
    <h2>Lista de Reservaciones</h2>
    <a href="ReservacionServlet?action=nuevo">Nueva Reservación</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Fecha</th>
                <th>Pasajero</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="r" items="${listaReservaciones}">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.fecha}</td>
                    <td>${r.pasajeroNombre}</td>
                    <td>
                        <a href="ReservacionServlet?action=editar&id=${r.id}">Editar</a>
                        <a href="ReservacionServlet?action=eliminar&id=${r.id}" onclick="return confirm('¿Eliminar reservación?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
