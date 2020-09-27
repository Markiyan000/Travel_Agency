const positiveMessage = 'There is available rooms on this date. Book it now!';
const negativeMessage = 'There is no available rooms on this date :(';

let sendAjaxCall = async (roomId) => {
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