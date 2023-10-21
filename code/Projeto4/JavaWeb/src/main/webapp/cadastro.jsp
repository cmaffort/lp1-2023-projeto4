<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>AJAX JSP Example</title>
</head>
<body>
    <button id="donatario">Donatario</button>
    <button id="professor">Professor</button>
    <button id="estagiario">Estagiario</button>
    <button id="doadorF">Doador Pessoa Fisica</button>
    <button id="doadorJ">Doador Pessoa Juridica</button>

     <div id="dynamicContent">Selecione o modo de cadastro</div>


    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            $("#donatario").click(function() {
                $.ajax({
                    type: "GET",
                    url: "cadastro/cadastroDonatario.jsp", // The URL to the JSP page that will return new content
                    success: function(response) {
                        $("#dynamicContent").html(response); // Update the content with the response from the server
                    },
                    error: function() {
                        alert("Failed to update content.");
                    }
                });
            });
            
             $("#professor").click(function() {
                $.ajax({
                    type: "GET",
                    url: "cadastro/cadastroProfessor.jsp", // The URL to the JSP page that will return new content
                    success: function(response) {
                        $("#dynamicContent").html(response); // Update the content with the response from the server
                    },
                    error: function() {
                        alert("Failed to update content.");
                    }
                });
            });
             $("#estagiario").click(function() {
                $.ajax({
                    type: "GET",
                    url: "cadastro/cadastroEstagiario.jsp", // The URL to the JSP page that will return new content
                    success: function(response) {
                        $("#dynamicContent").html(response); // Update the content with the response from the server
                    },
                    error: function() {
                        alert("Failed to update content.");
                    }
                });
            });
            $("#doadorJ").click(function() {
                $.ajax({
                    type: "GET",
                    url: "cadastro/doador/cadastroPessoaJuridica.jsp", // The URL to the JSP page that will return new content
                    success: function(response) {
                        $("#dynamicContent").html(response); // Update the content with the response from the server
                    },
                    error: function() {
                        alert("Failed to update content.");
                    }
                });
            });

            $("#doadorF").click(function() {
                $.ajax({
                    type: "GET",
                    url: "cadastro/doador/cadastroPessoaFisica.jsp", // The URL to the JSP page that will return new content
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
