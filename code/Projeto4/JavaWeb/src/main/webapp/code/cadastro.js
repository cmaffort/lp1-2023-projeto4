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