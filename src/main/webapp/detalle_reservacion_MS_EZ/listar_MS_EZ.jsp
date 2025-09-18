<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Detalle de Reservaciones</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <h2 class="text-center mb-4">Listado de Detalles de Reservaciones</h2>

    <div class="d-flex justify-content-end mb-3">
        <a href="${pageContext.request.contextPath}/ControllerDetalleReservacion?action=nuevo" class="btn btn-primary">
            <i class="bi bi-plus-circle"></i> Nuevo Detalle
        </a>
    </div>

    <div class="table-responsive shadow rounded">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark text-center">
                <tr>
                    <th>ID Detalle</th>
                    <th>ID Reservación</th>
                    <th>ID Vuelo</th>
                    <th>Asiento</th>
                    <th>Clase</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody class="text-center">
                <c:forEach var="detalle" items="${listaDetalles}">
                    <tr>
                        <td>${detalle.idDetalle}</td>
                        <td>${detalle.idReservacion}</td>
                        <td>${detalle.idVuelo}</td>
                        <td>${detalle.asiento}</td>
                        <td>${detalle.clase}</td>
                        <td>
                            <a href="${pageContext.request.contextPath}/ControllerDetalleReservacion?action=editar&id=${detalle.idDetalle}" 
                               class="btn btn-sm btn-warning">Editar</a>
                            <a href="${pageContext.request.contextPath}/ControllerDetalleReservacion?action=eliminar&id=${detalle.idDetalle}" 
                               class="btn btn-sm btn-danger"
                               onclick="return confirm('¿Deseas eliminar este registro?')">Eliminar</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
