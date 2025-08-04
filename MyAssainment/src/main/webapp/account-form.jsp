<!DOCTYPE html>
<html>
<head><title>Bank Account Form</title></head>
<body>
    <h2>Enter Account Details</h2>
    <form action="account-details.jsp" method="post">
        Account No: <input type="text" name="accNo" required><br><br>
        Name: <input type="text" name="name" required><br><br>
        Balance: <input type="text" name="balance" required><br><br>
        Account Type:
        <select name="accountType">
            <option value="Savings">Savings</option>
            <option value="Current">Current</option>
        </select><br><br>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
