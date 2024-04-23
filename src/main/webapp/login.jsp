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
    <title>Sign In</title>
</head>
<body>
<main>
        <section class="first" style="position: relative; top: 150px;">
            <div style="position: relative; top: 15px; background-color: white;">
                <div style="display: inline-flex; justify-content: space-around;background-color: white;">
                    <img class="logo" src="img/logo.png" alt="logo">
                    <h1 class="first_h1">Origin Tech</h1>
                </div>
                <p class="first_p">Sign In your Account</p>  
            </div>
            <form action="" style="background-color: white; padding: 0 35px 20px;">
                    <input class="inputs" type="email" placeholder="Email Address">
                    <input class="inputs" type="email" placeholder="Password">
                    <button type="button" name="myButton">Sign In</button>
                    <p class="register">New Customer? <a id="register" href="#">Register</a></p>
            </form>
        </section>
    </main>
</body>
</html>