<!DOCTYPE html>
<html>
<head><title>User Registration</title></head>
<body>
    <h2>Registration Form</h2>
    <form method="post" action="register">
        Name: <input type="text" name="name"><br><br>
        Email: <input type="email" name="email"><br><br>
        Password: <input type="password" name="password"><br><br>
        Birthday: <input type="date" name="birthday"><br><br>
        Gender:
        <input type="radio" name="gender" value="Male">Male
        <input type="radio" name="gender" value="Female">Female<br><br>
        Profession:
        <select name="profession">
            <option>Student</option>
            <option>Engineer</option>
            <option>Other</option>
        </select><br><br>
        Married: <input type="checkbox" name="married"><br><br>
        Note:<br>
        <textarea name="note"></textarea><br><br>
        <input type="submit" value="Register">
    </form>
</body>
</html>
