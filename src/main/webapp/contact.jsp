<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>About Us</title>
 <script src="https://kit.fontawesome.com/c32adfdcda.js" crossorigin="anonymous"></script>
    <style>
        @import url('https://fonts.googleapis.com/css2?family=Poppins:wght@400;600;700&display=swap');
        
section.cont {
  position: relative;
  z-index: 0;
  padding-top: 50px;
  padding-bottom: 100px;
  background-color: grey;
  font-family: 'Poppins', sans-serif;
  background-image: url(https://images.pexels.com/photos/325185/pexels-photo-325185.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940) !important;
  background-size: cover;
  background-position: center;
}

section.cont::after{
	  content: "";
  position: absolute;
  top: 0;
  left: 0;
  height: 100%;
  width: 100%;
  background-color: rgba(0,0,0,0.8);
}

.container {
  max-width: 1080px;
  margin-left: auto;
  margin-right: auto;
  padding-left: 20px;
  padding-right: 20px;
}

.section-header {
  margin-bottom: 50px;
  text-align: center;
}

.section-header h2 {
  color: #FFF;
  font-weight: bold;
  font-size: 3em;
  margin-bottom: 20px;
}

.section-header p {
  color: #FFF;
}

.row  {
  display: flex;
  flwx-wrap: wrap;
  align-items: center;
  justify-content: space-between;
}

.contact-info {
  width: 50%;
}

.contact-info-item {
  display: flex;
  margin-bottom: 30px;
}

.contact-info-icon {
  height: 70px;
  width: 70px;
  background-color: #fff;
  text-align: center;
  border-radius: 50%;
}

.contact-info-icon i {
  font-size: 30px;
  line-height: 70px;
}

.contact-info-content {
  margin-left: 20px;
}

.contact-info-content h4 {
  color: rgb(26, 183, 157);
  font-size: 1.4em;
  margin-bottom: 5px;
}

.contact-info-content p {
  color: #FFF;
  font-size: 1em;
}

.contact-form {
  background-color: #fff;
  padding: 40px;
  width: 45%;
  padding-bottom: 20px;
  padding-top: 20px;
}

.contact-form h2 {
  font-weight: bold;
  font-size: 2em;
  margin-bottom: 10px;
  color: #333;
}

.contact-form .input-box {
  position: relative;
  width: 100%;
  margin-top: 10px;
}

.contact-form .input-box input,
.contact-form .input-box textarea{
  width: 100%;
  padding: 5px 0;
  font-size: 16px;
  margin: 10px 0;
  border: none;
  border-bottom: 2px solid #333;
  outline: none;
  resize: none;
}

.contact-form .input-box span {
  position: absolute;
  left: 0;
  padding: 5px 0;
  font-size: 16px;
  margin: 10px 0;
  pointer-events: none;
  transition: 0.5s;
  color: #666;
}

.contact-form .input-box input:focus ~ span,
.contact-form .input-box textarea:focus ~ span{
  color: #e91e63;
  font-size: 12px;
  transform: translateY(-20px);
}

.contact-form .input-box input[type="submit"]
{
  width: 100%;
  background: rgb(26, 183, 157);
  color: #FFF;
  border: none;
  cursor: pointer;
  padding: 10px;
  font-size: 18px;
  border: 1px solid rgb(26, 183, 157);
  transition: 0.5s;
}

.contact-form .input-box input[type="submit"]:hover
{
  background: #FFF;
  color: rgb(26, 183, 157);
}

@media (max-width: 991px) {
  section {
    padding-top: 50px;
    padding-bottom: 50px;
  }
  
  .row {
    flex-direction: column;
  }
  
  .contact-info {
    margin-bottom: 40px;
    width: 100%;
  }
  
  .contact-form {
    width: 100%;
  }
}
    </style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<section class="cont">
    
        <div class="section-header">
          <div class="container">
            <h2 style="z-index: 2; position: relative">About Us</h2>
            <p style="z-index: 2; position: relative">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book.</p>
          </div>
        </div>
        
        <div class="container" style="z-index: 2; position: relative">
          <div class="row">
            
            <div class="contact-info">
              <div class="contact-info-item">
                <div class="contact-info-icon">
                  <i class="fas fa-home"></i>
                </div>
                
                <div class="contact-info-content">
                  <h4>Address</h4>
                  <p>4671 Sugar Camp Road,
     Owatonna, Minnesota, 
    55060</p>
                </div>
              </div>
              
              <div class="contact-info-item">
                <div class="contact-info-icon">
                  <i class="fas fa-phone"></i>
                </div>
                
                <div class="contact-info-content">
                  <h4>Phone</h4>
                  <p>571-457-2321</p>
                </div>
              </div>
              
              <div class="contact-info-item">
                <div class="contact-info-icon">
                  <i class="fas fa-envelope"></i>
                </div>
                
                <div class="contact-info-content">
                  <h4>Email</h4>
                 <p>ntamerrwael@mfano.ga</p>
                </div>
              </div>
            </div>
            
            <div class="contact-form">
              <form action="https://api.web3forms.com/submit" method="POST" id="contact-form">
              	<input type="hidden" name="access_key" value="c1ebbdcf-2889-46a7-9bd6-074ba7911f5e">
                <h2>Send Message</h2>
                <div class="input-box">
                  <input type="text" required="true" name="name">
                  <span>Full Name</span>
                </div>
                
                <div class="input-box">
                  <input type="email" required="true" name="email">
                  <span>Email</span>
                </div>
                
                <div class="input-box">
                  <textarea required="true" name="message"></textarea>
                  <span>Type your Message...</span>
                </div>
                
                <div class="input-box">
                  <input type="submit" value="Send">
                </div>
              </form>
            </div>
            
          </div>
        </div>
      </section>
      <jsp:include page="footer.jsp" />
      <script src="https://web3forms.com/client/script.js" async defer></script>
</body>
</html>