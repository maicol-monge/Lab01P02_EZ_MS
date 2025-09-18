<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Detalle de Reservación</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">${detalle != null ? "Editar Detalle de Reservación" : "Nuevo Detalle de Reservación"}</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/ControllerDetalleReservacion" method="post">

                <input type="hidden" name="idDetalle" value="${detalle != null ? detalle.idDetalle : ''}">

                <div class="mb-3">
                    <label class="form-label">ID Reservación</label>
                    <input type="number" name="idReservacion" class="form-control" 
                           value="${detalle != null ? detalle.idReservacion : ''}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">ID Vuelo</label>
                    <input type="number" name="idVuelo" class="form-control" 
                           value="${detalle != null ? detalle.idVuelo : ''}" required>
                </div>

                <div class="mb-3">
                    <label class="form-label">Asiento</label>
                    <input type="text" name="asiento" class="form-control" 
                           value="${detalle != null ? detalle.asiento : ''}" maxlength="10">
                </div>

                <div class="mb-3">
                    <label class="form-label">Clase</label>
                    <select name="clase" class="form-select">
                        <option value="Economica" ${detalle != null && detalle.clase == 'Economica' ? 'selected' : ''}>Económica</option>
                        <option value="Business" ${detalle != null && detalle.clase == 'Business' ? 'selected' : ''}>Business</option>
                        <option value="Primera" ${detalle != null && detalle.clase == 'Primera' ? 'selected' : ''}>Primera</option>
                    </select>
                </div>

                <div class="d-flex justify-content-between">
                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="${pageContext.request.contextPath}/ControllerDetalleReservacion?action=listar" class="btn btn-secondary">Cancelar</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
