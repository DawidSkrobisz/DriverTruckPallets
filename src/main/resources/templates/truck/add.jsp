<html>
<head>
     <title>Dodaj ciężarówkę</title>
</head>
<body>
<h2>Dodaj nową ciężarówkę</h2>
<form action="/truck/add" method="post" th:object="${truck}">
    <label for="truckModel">Model ciężarówki:</label>
    <input type="text" id="truckModel" name="truckModel" th:modelAttribute="truck"><br><br>

    <label for="truckPlates">Numery rejestracyjne:</label>
    <input type="text" id="truckPlates" name="truckPlates"><br><br>

    <label for="vinNumber">Numer VIN:</label>
    <input type="text" id="vinNumber" name="vinNumber"><br><br>

    <label for="serviceDate">Data następnego przeglądu:</label>
    <input type="date" id="serviceDate" name="serviceDateStr"><br><br>

    <label for="insuranceDate">Data końca ubezpieczenia:</label>
    <input type="date" id="insuranceDate" name="insuranceDateStr"><br><br>

    <label for="acctualSaldoPallets">Aktualne saldo palet:</label>
    <input type="number" id="acctualSaldoPallets" name="acctualSaldoPallets"><br><br>

    <input type="submit" value="Add Truck">
</form>
</body>
</html>
