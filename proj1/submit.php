<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $fullname = $_POST['fullname'];
    $email = $_POST['email'];
    $gender = $_POST['gender'];
    $country = $_POST['country'];
    $username = $_POST['username'];
    $password = $_POST['password'];
    $interests = isset($_POST['interests']) ? implode(", ", $_POST['interests']) : "";
    $contact_method = $_POST['contact_method'];
    $comments = $_POST['comments'];
    $payment_method = $_POST['payment_method'];
    $card_number = $_POST['card_number'];
    $exp_month = $_POST['exp_month'];
    $exp_year = $_POST['exp_year'];
    $cvv = $_POST['cvv'];

    // Save data into a text file
    $data = "Full Name: $fullname\nEmail: $email\nGender: $gender\nCountry: $country\nUsername: $username\nInterests: $interests\nContact Method: $contact_method\nComments: $comments\nPayment Method: $payment_method\nCard Number: $card_number\nExpiry: $exp_month/$exp_year\nCVV: $cvv\n----------------------\n";
    
    file_put_contents("registrations.txt", $data, FILE_APPEND);

    // Show saved details
    echo "<h2>Registration Saved Successfully!</h2>";
    echo "<pre>$data</pre>";

    echo "<br><a href='registrations.txt'>View All Registrations</a>";
}
?>
