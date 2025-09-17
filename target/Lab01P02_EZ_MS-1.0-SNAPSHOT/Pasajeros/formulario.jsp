<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Pasajero</title>
</head>
<body>
    <h2>${pasajero != null ? "Editar Pasajero" : "Nuevo Pasajero"}</h2>
    <form action="PasajeroServlet" method="post">
        <input type="hidden" name="id" value="${pasajero != null ? pasajero.id : ''}">

        <label>Nombre:</label>
        <input type="text" name="nombre" value="${pasajero != null ? pasajero.nombre : ''}" required><br>

        <label>Apellido:</label>
        <input type="text" name="apellido" value="${pasajero != null ? pasajero.apellido : ''}" required><br>

        <label>Teléfono:</label>
        <input type="text" name="telefono" value="${pasajero != null ? pasajero.telefono : ''}" required><br>

        <button type="submit">Guardar</button>
    </form>
</body>
</html>
