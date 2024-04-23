<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="SignIn.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=League+Spartan:wght@400;500;600;700;800&family=Poppins:wght@400;500&display=swap" rel="stylesheet">
    <title>Register</title>
    <style>
        button {
        color: #ffffff;
        background-color: var(--light-green-2);
        font-size: 20px;
        border: 0px solid #2d63c8;
        border-radius: 5px;
        padding: 10px 158px;
        cursor: pointer;
}
    </style>
</head>
<body>
 <main>
        <section class="first" style="position: relative; top:35px;height: 750px;">
            <div style="position: relative; top: 15px; background-color: white;">
                <div style="display: inline-flex; justify-content: space-around;background-color: white;">
                    <img class="logo" src="img/logo.png" alt="logo">
                    <h1 class="first_h1">Origin Tech</h1>
                </div>
                <p class="first_p" style="margin-left: 0;">Register a &#160;Origin Tech Account</p>  
            </div>
            <form action="" style="background-color: white; padding: 0 35px 20px;">
                    <input class="inputs" type="text" placeholder="Full Name">
                    <input class="inputs" type="email" placeholder="Email Address">
                    <input class="inputs" id="date" type="text" placeholder="Date of Birth" onfocus="this.type='date'" onblur="this.type='text'">
                    <input class="inputs" type="number" placeholder="Phone Number">
                    <input class="inputs" type="text" placeholder="Address">
                    <input class="inputs" type="password" placeholder="Password">
                    <input class="inputs" type="password" placeholder="Confirm Password">
                    <button type="button" name="myButton">Register</button>
                    <p class="register">Existing Customer? <a id="register" href="#">Sign In</a></p>
            </form>
        </section>
    </main>
    <script>
        var today = new Date().toISOString().split('T')[0];
        document.getElementById("date").setAttribute("max",today);
    </script>
</body>
</html>