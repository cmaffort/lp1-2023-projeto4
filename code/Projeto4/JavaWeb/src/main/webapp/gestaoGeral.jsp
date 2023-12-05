<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="br.cefetmg.projeto4.dto.*" %>
<%@page import="br.cefetmg.projeto4.javaweb.*" %>
<%@page import="java.util.*" %>

<%
    if (session == null || session.getAttribute("usuario") == null) {
        response.sendRedirect("login.jsp?p=mostraManutencoes.jsp");
        return;
    }

    UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");

    if (!usuario.getTipo().equals("PROFESSOR") && !usuario.getTipo().equals("ESTAGIARIO")) {
        response.sendRedirect("negado.jsp");
        return;
    }
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/gestaoGeral.css">
        <title>Gestão Geral</title>
    </head>
    <body>

        <header></header>

        <main id="doadores">
        <h1>Doadores</h1>

        <div class="divMaior">



            <%  Teste doadoresFisicosGet = new Teste();
                List<DoadorDTO> doadoresFisicos = doadoresFisicosGet.getDoadorFisico();
                List<DoadorDTO> doadoresJuridicos = doadoresFisicosGet.getDoadoresJuridicos();
                String classeDoador = "direita";
                for (DoadorDTO contador : doadoresFisicos) { %>


            <%   if (classeDoador == "direita") {
                        out.println("<div class=\"esquerda\"> ");
                        out.println("<h2>" + contador.getNome() + "</h2>");
                        out.println("<img" + "src=\"" + contador.getFoto() + "\"  class=\"pessoaAnonima\">");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contador.getCodigo() + "</li>");
                        out.println("<li>" + "Computadores Doados: " + contador.getComputadoresDoados() + "</li>");
                        out.println("<li>" + "Email: " + contador.getEmail() + "</li>");
                        out.println("</div>");
                        classeDoador = "esquerda";
                    } else if (classeDoador == "esquerda") {
                        out.println("<div class=\"meio\"> ");
                        out.println("<h2>" + contador.getNome() + "</h2>");
                        out.println("<img" + "src=\"" + contador.getFoto() + "\"  class=\"pessoaAnonima\">");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contador.getCodigo() + "</li>");
                        out.println("<li>" + "Computadores Doados: " + contador.getComputadoresDoados() + "</li>");
                        out.println("<li>" + "Email: " + contador.getEmail() + "</li>");
                        out.println("</div>");
                        classeDoador = "meio";
                    } else if (classeDoador == "meio") {
                        out.println("<div class=\"direita\"> ");
                        out.println("<h2>" + contador.getNome() + "</h2>");
                        out.println("<img" + "src=\"" + contador.getFoto() + "\"  class=\"pessoaAnonima\">");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contador.getCodigo() + "</li>");
                        out.println("<li>" + "Computadores Doados: " + contador.getComputadoresDoados() + "</li>");
                        out.println("<li>" + "Email: " + contador.getEmail() + "</li>");
                        out.println("</div>");
                        classeDoador = "direita";
                    }
                }%>

            <%  for (DoadorDTO contador : doadoresJuridicos) {
                    if (classeDoador == "direita") {
                        out.println("<div class=\"esquerda\"> ");
                        out.println("<h2>" + contador.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contador.getCodigo() + "</li>");
                        out.println("<li>" + "Computadores Doados: " + contador.getComputadoresDoados() + "</li>");
                        out.println("<li>" + "Email: " + contador.getEmail() + "</li>");
                        out.println("</div>");
                        classeDoador = "esquerda";
                    } else if (classeDoador == "esquerda") {
                        out.println("<div class=\"meio\"> ");
                        out.println("<h2>" + contador.getNome() + "</h2>");
                        out.println("<img " + "src=\"" + contador.getFoto() + "\"  class=\"pessoaAnonima\">");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contador.getCodigo() + "</li>");
                        out.println("<li>" + "Computadores Doados: " + contador.getComputadoresDoados() + "</li>");
                        out.println("<li>" + "Email: " + contador.getEmail() + "</li>");
                        out.println("</div>");
                        classeDoador = "meio";
                    } else if (classeDoador == "meio") {
                        out.println("<div class=\"direita\"> ");
                        out.println("<h2>" + contador.getNome() + "</h2>");
                        out.println("<img " + "src=\"" + contador.getFoto() + "\"  class=\"pessoaAnonima\">");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contador.getCodigo() + "</li>");
                        out.println("<li>" + "Computadores Doados: " + contador.getComputadoresDoados() + "</li>");
                        out.println("<li>" + "Email: " + contador.getEmail() + "</li>");
                        out.println("</div>");
                        classeDoador = "direita";
                    }
                }%>

        </div>
    </main>

    <main id="doacoes">

        <h1>Doacões</h1>

        <div class="divMaior">

            <%
                TesteDois doacoesGet = new TesteDois();
                List<DoacaoDTO> doacoes = doacoesGet.getDoacoes();
                String classeDoacao = "direita";
            %>

            <%
                for (DoacaoDTO contadorDoacoes : doacoes) {
                    if (classeDoacao == "direita") {
                        out.println("<div class=\"esquerda\"> ");
                        out.println("<h2>" + contadorDoacoes.getDoador() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "Marca: " + contadorDoacoes.getMarcaComputador() + "</li>");
                        out.println("<li>" + "Computadores Recebidos: " + contadorDoacoes.getQuantidade() + "</li>");
                        out.println("<li>" + "Data de chegada: " + "23/07" + "</li>");
                        out.println("</div>");
                        classeDoacao = "esquerda";
                    } else if (classeDoacao == "esquerda") {
                        out.println("<div class=\"meio\"> ");
                        out.println("<h2>" + contadorDoacoes.getDoador() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "Marca: " + contadorDoacoes.getMarcaComputador() + "</li>");
                        out.println("<li>" + "Computadores Recebidos: " + contadorDoacoes.getQuantidade() + "</li>");
                        out.println("<li>" + "Data de chegada: " + "23/07" + "</li>");
                        out.println("</div>");
                        classeDoacao = "meio";
                    } else if (classeDoacao == "meio") {
                        out.println("<div class=\"direita\"> ");
                        out.println("<h2>" + contadorDoacoes.getDoador() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "Marca: " + contadorDoacoes.getMarcaComputador() + "</li>");
                        out.println("<li>" + "Computadores Recebidos: " + contadorDoacoes.getQuantidade() + "</li>");
                        out.println("<li>" + "Data de chegada: " + "23/07" + "</li>");
                        out.println("</div>");
                        classeDoacao = "direita";
                    }
                }%>

        </div>


    </main>

    <main id="manutencoes">

        <h1> Manutencões </h1>

        <div class="divMaior">

            <%
                GetManutencao manutencoesGet = new GetManutencao();
                List<MantecaoDTO> manutencoes = manutencoesGet.getManutencoes();
                String classeManutencao = "direita";
            %>

            <%       for (MantecaoDTO contadorManutencoes : manutencoes) {
                    if (classeManutencao == "direita") {
                        out.println("<div class=\"esquerda\"> ");
                        out.println("<h2>" + contadorManutencoes.getDonatario() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "Data: " + contadorManutencoes.getData() + "</li>");
                        out.println("<li>" + "Encarregado: " + contadorManutencoes.getArrumador() + "</li>");
                        out.println("<li>" + "Estado: " + contadorManutencoes.getEstado() + "</li>");
                        out.println("</div>");
                        classeManutencao = "esquerda";
                    } else if (classeDoador == "esquerda") {
                        out.println("<div class=\"meio\"> ");
                        out.println("<h2>" + contadorManutencoes.getDonatario() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "Data: " + contadorManutencoes.getData() + "</li>");
                        out.println("<li>" + "Encarregado: " + contadorManutencoes.getArrumador() + "</li>");
                        out.println("<li>" + "Estado: " + contadorManutencoes.getEstado() + "</li>");
                        out.println("</div>");
                        classeDoador = "meio";
                    } else if (classeManutencao == "meio") {
                        out.println("<div class=\"direita\"> ");
                        out.println("<h2>" + contadorManutencoes.getDonatario() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "Data: " + contadorManutencoes.getData() + "</li>");
                        out.println("<li>" + "Encarregado: " + contadorManutencoes.getArrumador() + "</li>");
                        out.println("<li>" + "Estado: " + contadorManutencoes.getEstado() + "</li>");
                        out.println("</div>");
                        classeManutencao = "direita";
                    }
                }%>


        </div>
    </main>
    <main id="funcionarios">            
        <h1> Funcionários </h1>


        <div class="divMaior">

            <%
                GetFuncionarios estagiariosGet = new GetFuncionarios();
                List<EstagiarioDTO> estagiarios = estagiariosGet.getEstagiario();
                List<ProfessorDTO> professores = estagiariosGet.getProfessor();
                String classeFuncionario = "direita";
            %>

            <%       for (EstagiarioDTO contadorFuncionario : estagiarios) {
                    if (classeFuncionario == "direita") {
                        out.println("<div class=\"esquerda\"> ");
                        out.println("<h2>" + contadorFuncionario.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contadorFuncionario.getCodigo() + "</li>");
                        out.println("<li>" + "Cargo: " + "Estagiário" + "</li>");
                        out.println("<li>" + "Email: " + contadorFuncionario.getEmail() + "</li>");
                        out.println("</div>");
                        classeFuncionario = "esquerda";
                    } else if (classeFuncionario == "esquerda") {
                        out.println("<div class=\"meio\"> ");
                        out.println("<h2>" + contadorFuncionario.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contadorFuncionario.getCodigo() + "</li>");
                        out.println("<li>" + "Cargo: " + "Estagiário" + "</li>");
                        out.println("<li>" + "Email: " + contadorFuncionario.getEmail() + "</li>");
                        out.println("</div>");
                        classeFuncionario = "meio";
                    } else if (classeFuncionario == "meio") {
                        out.println("<div class=\"direita\"> ");
                        out.println("<h2>" + contadorFuncionario.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contadorFuncionario.getCodigo() + "</li>");
                        out.println("<li>" + "Cargo: " + "Estagiário" + "</li>");
                        out.println("<li>" + "Email: " + contadorFuncionario.getEmail() + "</li>");
                        out.println("</div>");
                        classeFuncionario = "direita";
                    }
                }
            %>

            <%       for (ProfessorDTO contadorFuncionario2 : professores) {
                    if (classeFuncionario == "direita") {
                        out.println("<div class=\"esquerda\"> ");
                        out.println("<h2>" + contadorFuncionario2.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contadorFuncionario2.getCodigo() + "</li>");
                        out.println("<li>" + "Cargo: " + "Professor" + "</li>");
                        out.println("<li>" + "Email: " + contadorFuncionario2.getEmail() + "</li>");
                        out.println("</div>");
                        classeFuncionario = "esquerda";
                    } else if (classeFuncionario == "esquerda") {
                        out.println("<div class=\"meio\"> ");
                        out.println("<h2>" + contadorFuncionario2.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contadorFuncionario2.getCodigo() + "</li>");
                        out.println("<li>" + "Cargo: " + "Professor" + "</li>");
                        out.println("<li>" + "Email: " + contadorFuncionario2.getEmail() + "</li>");
                        out.println("</div>");
                        classeFuncionario = "meio";
                    } else if (classeFuncionario == "meio") {
                        out.println("<div class=\"direita\"> ");
                        out.println("<h2>" + contadorFuncionario2.getNome() + "</h2>");
                        out.println("<ul class=\"listaDiv\">");
                        out.println("<li>" + "CPF: " + contadorFuncionario2.getCodigo() + "</li>");
                        out.println("<li>" + "Cargo: " + "Professor" + "</li>");
                        out.println("<li>" + "Email: " + contadorFuncionario2.getEmail() + "</li>");
                        out.println("</div>");
                        classeFuncionario = "direita";
                    }
                }
            %>



        </div>

    </main>


    <div id="menuGeral">
        <ul>
            <li> <button id="botaoDoadores"> Doadores</button> </li>
            <li> <button id="botaoDoacoes"> Doações</button> </li>
            <li> <button id="botaoManutencoes"> Manutenções</button> </li>
            <li> <button id="botaoFuncionarios"> Funcionários</button></li>
        </ul>

    </div>  


    <script src="code/gestaoGeral.js"></script>
    <script src="code/header.js"></script>
</body>
</html>