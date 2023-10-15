
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Doador</h1>
            <button id="fisica">Pessoa Física</button>
            <button id="juridica">Pessoa Jurídica</button>
     <div id="dynamicContent">Selecione o modo de cadastro</div>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#juridica").click(function() {
                $.ajax({
                    type: "GET",
                    url: "doador/cadastroPessoaJuridica.jsp", // The URL to the JSP page that will return new content
                    success: function(response) {
                        $("#dynamicContent").html(response); // Update the content with the response from the server
                    },
                    error: function() {
                        alert("Failed to update content.");
                    }
                });
            });
            
             $("#fisica").click(function() {
                $.ajax({
                    type: "GET",
                    url: "cadastro/cadastroPessoaFisica.jsp", // The URL to the JSP page that will return new content
                    success: function(response) {
                        $("#dynamicContent").html(response); // Update the content with the response from the server
                    },
                    error: function() {
                        alert("Failed to update content.");
                    }
                });
            });



        });
    </script>

    </body>
</html>
