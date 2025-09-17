<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Pasajeros</title>
</head>
<body>
    <h2>Lista de Pasajeros</h2>
    <a href="PasajeroServlet?action=nuevo">Agregar Pasajero</a>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>Teléfono</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${listaPasajeros}">
                <tr>
                    <td>${p.id}</td>
                    <td>${p.nombre}</td>
                    <td>${p.apellido}</td>
                    <td>${p.telefono}</td>
                    <td>
                        <a href="PasajeroServlet?action=editar&id=${p.id}">Editar</a>
                        <a href="PasajeroServlet?action=eliminar&id=${p.id}" onclick="return confirm('¿Eliminar pasajero?')">Eliminar</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
