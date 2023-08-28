<!DOCTYPE html>
<html>
<head>
    <title>Truck List</title>
</head>
<body>
<h2>Truck List</h2>
<ul>
    <c:forEach items="${trucks}" var="truck">
        <li><a href="/truck/details/<c:out value='${truck.id}'/>"><c:out value='${truck.truckModel}'/></a></li>
    </c:forEach>
</ul>
</body>
</html>
