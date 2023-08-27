<!DOCTYPE html>
<html>
<head>
    <title>Truck Details</title>
</head>
<body>
<h2>Truck Details</h2>
<p>
    <strong>Truck ID:</strong> <span th:text="${truck.id}"></span><br>
    <strong>Truck Model:</strong> <span th:text="${truck.truckModel}"></span><br>
    <strong>Truck Plates:</strong> <span th:text="${truck.truckPlates}"></span><br>
    <strong>VIN Number:</strong> <span th:text="${truck.vinNumber}"></span><br>
    <strong>Service Date:</strong> <span th:text="${truck.serviceDate}"></span><br>
    <strong>Insurance Date:</strong> <span th:text="${truck.insuranceDate}"></span><br>
    <strong>Actual Saldo Pallets:</strong> <span th:text="${truck.acctualSaldoPallets}"></span><br>
</p>
<p>
    <a href="/truck/list">Back to Truck List</a>
</p>
</body>
</html>
