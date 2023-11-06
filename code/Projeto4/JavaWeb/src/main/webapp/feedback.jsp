<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/form.css">
        <link rel="stylesheet" href="style/feedback.css">
        <title>Dê seu feedback!</title>
    </head>
    <body>
        <header></header>

        <main>
            <h2>Feedback</h2>

            <form>
                <figure id="logo">
                    <img src="img/logo-cefet.png">
                </figure>
                <textarea name="comments" rows="4" cols="50" placeholder="Descreva a sua experiência"></textarea>

                <div id="submit">
                    <input type="submit" value="Enviar">
                </div>
            </form>
        </main>

        <script src="code/header.js"></script>
    </body>
</html>