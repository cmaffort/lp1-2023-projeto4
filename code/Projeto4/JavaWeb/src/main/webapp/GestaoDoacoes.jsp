<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/CadastrarDoacao.css">
        <link rel="stylesheet" href="style/header.css">
        <title>Gestão de Doação</title>
    </head>
    <body>
        <header></header>
        <%@ page import="br.cefetmg.projeto4.dto.Doacao"%>
        <%@ page import="br.cefetmg.projeto4.dto.Computador"%>
        
        
        <%
            Computador computador = null;
            
              Doacao arr[] =  {  new Doacao(5,computador),
                                 new Doacao(5,computador),  
                                 new Doacao(5,computador),        
                                 new Doacao(5,computador)
        
        };



        %>    
        
        
        <h1>Gestão de Doação</h1>
        
        <div id="doacoes">
            
            <div>
            
                <p class="quadradoDoacao"> <% System.out.println("algo"); %>  
            
            
        </div>
            
        </div>
        
        
        <script src="code/GestaoDoacoes.js"></script>
        <script src="code/header.js"></script>
    </body>
</html>
