<h1>Bus Registration Form</h1>
<form action="/adn/regbus" modelAttribute="bus">
    Enter Bus Number: <input type="number" name="bno"  required>
    <br><br>
    Enter Source <input type="text" name="src" required>
    <br><br>
    Enter Destination: <input type="text" name="dest" required>
    <br><br>
    Enter Date: <input type="date" name="date" required>
    <br><br>
   Enter Time In HH:MM Format: <input type="text" name="time" pattern="(0[1-9]|1[0-2]):[0-5][0-9] (AM|PM)" required>
        <br><br>
    Enter Number Of Seats: <input type="number" name="seats" required>
    <br><br>
    <input type="submit" name="add bus">
</form>