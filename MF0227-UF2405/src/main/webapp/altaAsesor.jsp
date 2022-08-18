<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alta asesor</title>
</head>
<body>

	<h1>Alta de asesor de seguros</h1>
    <form action="AltaAsesor" method="post">
        <div>
            <label for="nombre">Nombre *:</label>
            <input type="text" name="nombre" id="nombre" required>
        </div>
        <div>
            <label for="apellidos">Apellidos *:</label>
            <input type="text" name="apellidos" id="apellidos" required>
        </div>
        <div>
            <label for="dni">DNI *:</label>
            <input type="text" name="dni" id="dni" pattern="[0-9]{8}[A-Za-z]{1}" required>
        </div>
        <div>
            <label for="contrato">Relación Contractual:</label>
            <select name="contrato" id="contrato">
                <option value="autonomo">Autónomo</option>
                <option value="fijo">Asalariado fijo</option>
                <option value="comision">Asalariado a Comisión</option>
            </select>
        </div>
        <div>
            <label for="seguro">Tipo de Seguros que vende:</label>
            <input type="radio" name="seguro" id="seguro" value="Automóvil" checked>Automóvil
            <input type="radio" name="seguro" id="seguro" value="Hogar">Hogar
            <input type="radio" name="seguro" id="seguro" value="Decesos">Decesos
        </div>
        <div>
            <label for="promedio">Num Ventas Promedio:</label>
            <input type="number" name="promedio" id="promedio" step="1" min="15" value="15">
        </div>
        <div>
            <input type="submit" value="Confirmar">
        </div>
    </form>

</body>
</html>