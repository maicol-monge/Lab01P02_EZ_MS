<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Gestión de Vuelos</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">

    <style>
        body {
            background: #f4f7fb;
            font-family: Arial, sans-serif;
        }
        .container {
            margin-top: 60px;
        }
        .card {
            border-radius: 15px;
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .card-title {
            color: #2e59a6;
            font-weight: bold;
        }
        footer {
            margin-top: 50px;
            text-align: center;
            color: #777;
        }
    </style>
</head>
<body>
<div class="container text-center">
    <h1 class="mb-4 text-primary">✈ Sistema de Reservación de Vuelos</h1>
    
    <div class="row justify-content-center">
        <!-- Tarjeta para Reservaciones -->
        <div class="col-md-4">
            <div class="card p-3">
                <h5 class="card-title">Gestión de Reservaciones</h5>
                <p class="card-text">Administra todas las reservaciones de vuelos.</p>
                <a href="ControllerReserva_MS_EZ?action=listar_MS_EZ" class="btn btn-primary">Ir a Reservaciones</a>
            </div>
        </div>

        <!-- Tarjeta para Pasajeros (opcional) -->
        <div class="col-md-4">
            <div class="card p-3">
                <h5 class="card-title">Gestión de Pasajeros</h5>
                <p class="card-text">Administra la información de los pasajeros.</p>
                <a href="ControllerPasajero_MS_EZ?action=listar_MS_EZ" class="btn btn-success">Ir a Pasajeros</a>
            </div>
        </div>
    </div>

    <footer>
        <p>&copy; 2025 - Sistema de Reservaciones</p>
        <p>&copy; 2022-MS-651 - Maicol Monge</p>
        <p>&copy; 2022-ZR-650 - Ever Zamora</p>
    </footer>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
