<h1>Bus Booking Form</h1>
<form action="/usr/cbook" modelAttribute="bus">
    Enter User Id <input type="number" name="uid" required>
            <br><br>
    Enter User Name <input type="text" name="name" required>
        <br><br>
    Enter Bus Number: <input type="number" name="bno"  required>
    <br><br>
    Enter Source <input type="text" name="src" required>
    <br><br>
    Enter Destination: <input type="text" name="dest" required>
    <br><br>
    Enter Date: <input type="date" name="date" required>
    <br><br>
   Enter Time in HH:MM Format: <input type="text" name="time" pattern="(0[1-9]|1[0-2]):[0-5][0-9] (AM|PM)" required>
        <br><br>
  Enter Seat Numbers Separated by Comma: <input type="text" name="seatno" pattern="([0-9]+,)*[0-9]+" required>
    <br><br>
    <input type="submit" name="add bus">
</form>