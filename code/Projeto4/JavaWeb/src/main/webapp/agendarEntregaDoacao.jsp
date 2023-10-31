<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/agendarEntregaDoacao.css">
        <title>Agendar Entrega da Doação</title>
    </head>
    <body>
        <header></header>
        
        <p>Agende aqui a melhor data para retirar seu pc<p> 
        
        <form action="EntregaDoacao" method="post">
            
            <input type="date" name="dataRetirada">
            <input type="time" name="horaRetirada">
            <input type="submit" name="agendar" value="Agendar">
        </form>
        <p> Documentos necessários para a retirada: identidade ou outro documento com foto</p>
        
        <script src="code/header.js"></script>
    </body>
</html>