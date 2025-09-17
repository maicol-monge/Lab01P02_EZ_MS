<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Reservación</title>
</head>
<body>
    <h2>${reservacion != null ? "Editar Reservación" : "Nueva Reservación"}</h2>
    <form action="ReservacionServlet" method="post">
        <input type="hidden" name="id" value="${reservacion != null ? reservacion.id : ''}">

        <label>Fecha:</label>
        <input type="date" name="fecha" value="${reservacion != null ? reservacion.fecha : ''}" required><br>

        <label>Pasajero:</label>
        <select name="pasajeroId" required>
            <c:forEach var="p" items="${listaPasajeros}">
                <option value="${p.id}" ${reservacion != null && reservacion.pasajeroId == p.id ? 'selected' : ''}>
                    ${p.nombre} ${p.apellido}
                </option>
            </c:forEach>
        </select><br>

        <button type="submit">Guardar</button>
    </form>
</body>
</html>
