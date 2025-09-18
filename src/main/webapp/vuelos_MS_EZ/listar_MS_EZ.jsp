<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Lista de Vuelos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <h2 class="text-center mb-4">Listado de Vuelos</h2>

    <div class="d-flex justify-content-end mb-3">
        <a href="${pageContext.request.contextPath}/ControllerVuelo?action=nuevo" class="btn btn-primary">
            <i class="bi bi-plus-circle"></i> Nuevo Vuelo
        </a>
    </div>

    <div class="table-responsive shadow rounded">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID</th>
                    <th>Número Vuelo</th>
                    <th>Aerolínea</th>
                    <th>Origen</th>
                    <th>Destino</th>
                    <th>Fecha Salida</th>
                    <th>Hora Salida</th>
                    <th>Fecha Llegada</th>
                    <th>Hora Llegada</th>
                    <th>Avión</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody class="text-center">
                <c:forEach var="vuelo" items="${listaVuelos}">
                    <tr>
                        <td>${vuelo.idVuelo}</td>
                        <td>${vuelo.numeroVuelo}</td>
                        <td>${vuelo.aerolinea}</td>
                        <td>${vuelo.origen}</td>
                        <td>${vuelo.destino}</td>
                        <td>${vuelo.fechaSalida}</td>
                        <td>${vuelo.horaSalida}</td>
                        <td>${vuelo.fechaLlegada}</td>
                        <td>${vuelo.horaLlegada}</td>
                        <td>${vuelo.avion}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ControllerVuelo?action=editar&id=${vuelo.idVuelo}" 
                               class="btn btn-sm btn-warning">Editar</a>
                            <a href="${pageContext.request.contextPath}/ControllerVuelo?action=eliminar&id=${vuelo.idVuelo}" 
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('¿Deseas eliminar este vuelo?')">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
