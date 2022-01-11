<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
    </head>
    <body>
        
        <form action="login">
           
        <H2 align="center">Login</H2>
        <table border="0" align = "center">
            <tr>
                <th> Username</th>
                <td> <input type="text" name="user" required="required" autofocus="autofocus"></td> 
            </tr> 
            <tr>
                <th> Password </th>
                <td> <input type="text" name = "pass" required="required"></td>
            </tr>   
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value = "Login"> 
                    <a href="toRegistration">Register</a>
                </td>
            </tr>
        </table>
    
    </form>

    </body>
</html>
