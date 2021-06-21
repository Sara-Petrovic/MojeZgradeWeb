<%-- 
    Document   : login
    Created on : Apr 28, 2021, 3:36:05 PM
    Author     : Sara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="/customer-web-mvc/application/login/post" method="POST">
            <input type="hidden" name="action" value="loginDo"/>
            <div>
                ${errorMessage}
            </div>
            <table>
                <tbody>
                    <tr>
                        <td>Username:</td>
                        <td>
                            <input type="text" name="username" />
                        </td>
                    </tr>
                    <tr>
                        <td>Password:</td>
                        <td>
                            <input type="password" name="password" />
                        </td>
                    </tr>
                     <tr>
                         <td><a href="/customer-web-mvc/application?action=registerDo">Register</a>
                             <br/>
                         <a href="/customer-web-mvc/application/register">Register</a>
                         </td>
                        <td>
                            <input type="submit" name="Login" value="Login"/>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </body>
</html>
