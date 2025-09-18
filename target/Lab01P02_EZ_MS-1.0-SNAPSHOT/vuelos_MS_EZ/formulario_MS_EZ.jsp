<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Formulario Vuelo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">
<div class="container py-4">
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">${vuelo != null ? "Editar Vuelo" : "Nuevo Vuelo"}</h4>
        </div>
        <div class="card-body">
            <form action="${pageContext.request.contextPath}/ControllerVuelo" method="post">
                <input type="hidden" name="idVuelo" value="${vuelo != null ? vuelo.idVuelo : ''}">

                <div class="row g-3">
                    <div class="col-md-6">
                        <label class="form-label">Número Vuelo</label>
                        <input type="text" name="numeroVuelo" class="form-control" value="${vuelo != null ? vuelo.numeroVuelo : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Aerolínea</label>
                        <input type="text" name="aerolinea" class="form-control" value="${vuelo != null ? vuelo.aerolinea : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Origen</label>
                        <input type="text" name="origen" class="form-control" value="${vuelo != null ? vuelo.origen : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Destino</label>
                        <input type="text" name="destino" class="form-control" value="${vuelo != null ? vuelo.destino : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Fecha Salida</label>
                        <input type="date" name="fechaSalida" class="form-control" value="${vuelo != null ? vuelo.fechaSalida : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Hora Salida</label>
                        <input type="time" name="horaSalida" class="form-control" value="${vuelo != null ? vuelo.horaSalida : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Fecha Llegada</label>
                        <input type="date" name="fechaLlegada" class="form-control" value="${vuelo != null ? vuelo.fechaLlegada : ''}" required>
                    </div>

                    <div class="col-md-6">
                        <label class="form-label">Hora Llegada</label>
                        <input type="time" name="horaLlegada" class="form-control" value="${vuelo != null ? vuelo.horaLlegada : ''}" required>
                    </div>

                    <div class="col-md-12">
                        <label class="form-label">Avión</label>
                        <input type="text" name="avion" class="form-control" value="${vuelo != null ? vuelo.avion : ''}">
                    </div>
                </div>

                <div class="d-flex justify-content-between mt-4">
                    <button type="submit" class="btn btn-success">Guardar</button>
                    <a href="${pageContext.request.contextPath}/ControllerVuelo?action=listar" class="btn btn-secondary">Cancelar</a>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
