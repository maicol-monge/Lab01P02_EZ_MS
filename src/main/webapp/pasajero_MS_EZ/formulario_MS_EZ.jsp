<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Formulario Pasajero</title>
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
            width: 400px;
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

        input[type="text"] {
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

        button, .cancel-btn {
            padding: 10px 20px;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-weight: bold;
            text-decoration: none;
            text-align: center;
            line-height: normal;
        }

        .save-btn {
            background-color: #1abc9c;
            color: #fff;
        }

        .save-btn:hover {
            opacity: 0.9;
        }

        .cancel-btn {
            background-color: #e74c3c;
            color: #fff;
        }

        .cancel-btn:hover {
            background-color: #c0392b;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h2>${pasajero != null ? "Editar Pasajero" : "Nuevo Pasajero"}</h2>

    <form action="${pageContext.request.contextPath}/ControllerPasajero_MS_EZ" method="post">
            <!-- ID oculto para editar; si es nuevo, queda vacío -->
            <input type="hidden" name="id" value="${pasajero != null ? pasajero.id : ''}">

            <label>Nombre:</label>
            <input type="text" name="nombre" value="${pasajero != null ? pasajero.nombre : ''}" required>

            <label>Nacionalidad:</label>
            <input type="text" name="nacionalidad" value="${pasajero != null ? pasajero.nacionalidad : ''}" required>

            <label>Pasaporte:</label>
            <input type="text" name="pasaporte" value="${pasajero != null ? pasajero.pasaporte : ''}" required>

            <div class="buttons">
                <button type="submit" class="save-btn">Guardar</button>
                <a href="${pageContext.request.contextPath}/ControllerPasajero_MS_EZ?action=listar_MS_EZ" class="cancel-btn">Cancelar</a>
            </div>
        </form>
    </div>
</body>
</html>
