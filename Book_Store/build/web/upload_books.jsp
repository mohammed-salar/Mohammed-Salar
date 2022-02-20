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
  left: 460;
  margin: 0px;
  max-width: 500px;
  padding: 20px;
  background-color: invisible;
}
input[type=text], input[type=file] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=file]:focus {
  background-color: #ddd;
  outline: none;
}
#type
{
    width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  border: none;
  background: #f1f1f1;
}
#type:focus
{
    background-color: #ddd;
    outline: none;
}
.btn3 {
  background-color:blue;
  color: white;
  padding: 16px 20px;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.btn3:hover 
{
  opacity: 1;
}
        </style>
    </head>
    <body class="bg-img">
         <div align="right">
           <jsp:include page="AdminLogout.html" />   
        </div>
        <h1 align="center" style="color:blueviolet">Upload File</h1>
        <form action="UploadBook" method="post" class="container">
            <h3 align="center" style="color:blueviolet">Enter the Following Details</h3>
            <table align="center">
                <tr>
                    <td style="color:blueviolet">Category</td>
                    <td>
                        <select name="type" id="type">
                            <option value="Novel">Novel</option>
                            <option value="Computer Languages">Computer Languages</option>
                            <option value="History">History</option>
                            <option value="Politics">Politics</option>
                            <option value="Commerce">Commerce</option>
                            <option value="Engineering">Engineering</option>
                            <option value="Management">Management</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td style="color:blueviolet">Author Name</td>
                    <td><input type="text" name="author_name" placeholder="Enter Author Name"></td>
                </tr>
                <tr>
                    <td style="color:blueviolet">Choose File</td>
                    <td><input type="file" name="filename"></td>
                </tr>
                <tr>
                    <td colspan="2" align="center"><input type="Submit" value="Upload" class="btn3"></td>
                </tr>
            </table>
        </form>
    </body>
</html>
