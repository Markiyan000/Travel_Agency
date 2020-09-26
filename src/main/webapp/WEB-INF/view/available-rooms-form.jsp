<%--
  Created by IntelliJ IDEA.
  User: marki
  Date: 26.09.2020
  Time: 22:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Available Rooms Form</title>
</head>
<body>
<div id="message"></div>
<label>
    <input type="date" id="arrivalDate"/>
</label>
<label>
    <input type="date" id="departureDate"/>
</label>
<button type="submit" onclick="sendRequest()">Check</button>
<script>

    const positiveMessage = 'There is available rooms on this date. Book it now!';
    const negativeMessage = 'There is no available rooms on this date :(';

    let sendRequest = async () => {
        const arrivalDate = document.getElementById('arrivalDate').value;
        const departureDate = document.getElementById('departureDate').value;

        const response = await fetch(`http://localhost:8080/bookings/room/${roomId}/available?arrivalDate=` + arrivalDate + "&departureDate=" + departureDate);
        insertMessage(await response.json());
    };

    let insertMessage = (result) => {
        const messageDiv = document.getElementById('message');
        if(result) {
            messageDiv.innerHTML = positiveMessage;
            messageDiv.style.color = 'green';
        } else {
            messageDiv.innerHTML = negativeMessage;
            messageDiv.style.color = 'red';
        }
    };
</script>
</body>
</html>
