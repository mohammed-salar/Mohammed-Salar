<html>
    <head>
        <title>Book Store</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <style>
             body, html {
  height: 100%;
  font-family: Arial, Helvetica, sans-serif;
}

* {
  box-sizing: border-box;
}

.bg-img {
  /* The image used */
  background-image: url("images/book3.jpg");

  min-height: 100%;

  /* Center and scale the image nicely */
  background-position: center;
  background-repeat: no-repeat;
  background-size: cover;
  position: relative;
}
.container {
  position: absolute;
  left: 425;
  margin: 0px;
  max-width: 500px;
  padding: 20px;
  background-color: yellowgreen;
}
.h1{
   
    font-size: 35px;
	font-weight: 500;
	color:#fff;
}
.btn1 {
  background-color:pink;
  color: red;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn1:hover 
{
  opacity: 1;
}
        </style>
    </head>
    
    <body class="bg-img">
        
         <div align="right">
           <jsp:include page="logout.html" />   
        </div>
       
        <form action="ShowBook_User" class="container">
            <table align="center">
                <h1 style="color: red" align="center" class="h1">Select the Category of Book which you want to read</h1>
                <tr>
                    <td ><input type="submit" name="book" value="Novel" class="btn1"></td>
                    
                </tr>
                <tr>
                    <td ><input type="submit" name="book" value="Computer Languages" class="btn1"></td>
                    
                </tr>
                <tr>
                    <td ><input type="submit" name="book" value="History" class="btn1"></td>
                    
                </tr>
                <tr>
                    <td ><input type="submit" name="book" value="Politics" class="btn1"></td>
                    
                </tr>
                <tr>
                    <td ><input type="submit" name="book" value="Commerce" class="btn1"></td>
                    
                </tr>
                <tr>
                    <td ><input type="submit" name="book" value="Engineering" class="btn1"></td>
                    
                </tr>
                <tr>
                    <td ><input type="submit" name="book" value="Management" class="btn1"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
