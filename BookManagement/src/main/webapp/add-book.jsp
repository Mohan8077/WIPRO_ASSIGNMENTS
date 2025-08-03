<!DOCTYPE html>
<html>
<head>
    <title>Add New Book</title>
</head>
<body>
    <h1 style="color:black; font-size:28px; font-weight:bold;">Book Management</h1>

    <a href="book?action=new"><button>Add New Book</button></a>
    <a href="book?action=list"><button>List All Books</button></a>

    <h3>Add New Book</h3>
    <form action="book" method="post">
        <input type="hidden" name="action" value="save" />
        Title: <input type="text" name="title" required /><br/><br/>
        Author: <input type="text" name="author" required /><br/><br/>
        Price: <input type="text" name="price" required /><br/><br/>
        <input type="submit" value="Save" />
    </form>

    

</body>
</html>
