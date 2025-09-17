<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario de Reservación</title>
    <style>
        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f4f7f9;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
        }
        .form-container {
            background-color: #fff;
            padding: 30px 40px;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0,0,0,0.1);
            width: 450px;
        }
        h2 {
            text-align: center;
            color: #2e59a6;
            margin-bottom: 25px;
        }
        label {
            display: block;
            margin-top: 15px;
            font-weight: bold;
            color: #333;
        }
        input[type="text"], input[type="date"], select {
            width: 100%;
            padding: 10px;
            margin-top: 5px;
            border-radius: 6px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }
        .buttons {
            display: flex;
            justify-content: space-between;
            margin-top: 25px;
        }
        button {
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
        }
        .save-btn {
            background-color: #1abc9c;
            color: #fff;
        }
        .cancel-btn {
            background-color: #e74c3c;
            color: #fff;
            text-decoration: none;
            display: inline-block;
            text-align: center;
            line-height: normal;
        }
        .cancel-btn:hover {
            background-color: #c0392b;
        }
        button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>${reservacion != null ? "Editar Reservación" : "Nueva Reservación"}</h2>

        <form action="${pageContext.request.contextPath}/ControllerReserva" method="post">
            <input type="hidden" name="id" value="${reservacion != null ? reservacion.id : ''}">

            <label>Cliente:</label>
            <select name="pasajeroId" required>
                <option value="">-- Seleccione un cliente --</option>
                <c:forEach var="p" items="${pasajeros}">
                    <option value="${p.id}" 
                        ${reservacion != null && reservacion.pasajeroId == p.id ? 'selected' : ''}>
                        ${p.nombre} (${p.nacionalidad})
                    </option>
                </c:forEach>
            </select>

            <label>Fecha de Reserva:</label>
            <input type="date" name="fecha" value="${reservacion != null ? reservacion.fecha : ''}" required>

            <div class="buttons">
                <button type="submit" class="save-btn">Guardar</button>
                <a href="${pageContext.request.contextPath}/ControllerReserva?action=listar" class="cancel-btn">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>
