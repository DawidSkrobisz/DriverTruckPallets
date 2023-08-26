<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Add Truck</title>
</head>
<body>
<h2>Add a New Truck</h2>
<form action="/truck/add" method="post" th:object="${truck}">
    <label for="truckModel">Truck Model:</label>
    <input type="text" id="truckModel" name="truckModel"><br><br>

    <label for="truckPlates">Truck Plates:</label>
    <input type="text" id="truckPlates" name="truckPlates"><br><br>

    <label for="vinNumber">VIN Number:</label>
    <input type="text" id="vinNumber" name="vinNumber"><br><br>

    <label for="serviceDate">Service Date:</label>
    <input type="text" id="serviceDate" name="serviceDate"><br><br>

    <label for="insuranceDate">Insurance Date:</label>
    <input type="text" id="insuranceDate" name="insuranceDate"><br><br>

    <label for="acctualSaldoPallets">Actual Saldo Pallets:</label>
    <input type="number" id="acctualSaldoPallets" name="acctualSaldoPallets"><br><br>

    <input type="submit" value="Add Truck">
</form>
</body>
</html>
