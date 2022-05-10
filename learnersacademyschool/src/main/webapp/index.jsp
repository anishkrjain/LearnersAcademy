<!DOCTYPE html>
<html>
<head>
<style>
.text1 {
  background-color: white;
  border: none;
  color: black;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
}
.button-73 {
  appearance: none;
  background-color: #FFFFFF;
  border-radius: 40em;
  border-style: none;
  box-shadow: #ADCFFF 0 -12px 6px inset;
  box-sizing: border-box;
  color: #000000;
  cursor: pointer;
  display: inline-block;
  font-family: -apple-system,sans-serif;
  font-size: 1.2rem;
  font-weight: 700;
  letter-spacing: -.24px;
  margin: 0;
  outline: none;
  padding: 1rem 1.3rem;
  quotes: auto;
  text-align: center;
  text-decoration: none;
  transition: all .15s;
  user-select: none;
  -webkit-user-select: none;
  touch-action: manipulation;
}

.button-73:hover {
  background-color: #FFC229;
  box-shadow: #FF6314 0 -6px 8px inset;
  transform: scale(1.125);
}

.button-73:active {
  transform: scale(1.025);
}

@media (min-width: 768px) {
  .button-73 {
    font-size: 1rem;
  }
}
</style>
</head>
<body bgcolor="#7FFFD4">
<center> <h1>Learner's Academy Administrative Portal</h1> </center>
<br/>
<br/>
<center> <h2> Admin Login </h2> </center>  
<center> 
    <form action="AdminLoginServlet" method="GET"> 
    
        <div class="container">   
            <label>Username : </label>   
            <br/>
            <input type="text" class="text1" name="username" required>  
            <br/>
            <label>Password : </label>   
            <br/>
            <input type="password" class="text1" name="password" required>  
            <br/>
            <br/>
            <button type="submit" class="button-73" role="button">Login</button>   
             
        </div>   
        
    </form>     
 </center> 
</body>
</html>
