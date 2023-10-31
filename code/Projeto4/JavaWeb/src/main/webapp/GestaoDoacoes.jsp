<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/GestaoDoacoes.css">
        <link rel="stylesheet" href="style/header.css">
        <title>Gestão de Doação</title>
    </head>
    <body>
        <header></header>
            <%@ page import="br.cefetmg.projeto4.dto.Doacao"%>
            <%@ page import="br.cefetmg.projeto4.dto.Computador"%>


        <%
            Computador computador = null;
            String str = "algo";
            

            Doacao arr[] = {new Doacao(5, computador, str, str, str, str, 8),
                new Doacao(5, computador, str, str, str, str, 8),
                new Doacao(5, computador, str, str, str, str, 8),
                new Doacao(5, computador, str, str, str, str, 8)

            };
        %>    


        <h1>Gestão de Doação</h1>

        <div id="doacoes">



            <div>

                <%
                     for (Doacao doacao : arr) { %>

                <p class="quadradoDoacao"> <% System.out.println(arr[0]);
                         System.out.println(arr[1]);
                         System.out.println(arr[2]);
                              System.out.println(arr[3]);%></p>

                    <%}%>                      
            </div>

        </div>


        <script src="code/GestaoDoacoes.js"></script>
        <script src="code/header.js"></script>
    </body>
</html>
