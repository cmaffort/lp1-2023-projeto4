<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.cefetmg.projeto4.dao.UsuarioDAO"%>
<%@page import="br.cefetmg.projeto4.dao.DonatarioDAO"%>
<%@page import="br.cefetmg.projeto4.dao.ProfessorDAO"%>
<%@page import="br.cefetmg.projeto4.dao.DoadorDAO"%>
<%@page import="br.cefetmg.projeto4.dao.DoadorJuridicoDAO"%>
<%@page import="br.cefetmg.projeto4.dao.EstagiarioDAO"%>
<%@page import="br.cefetmg.projeto4.dto.UsuarioDTO"%>
<%@page import="br.cefetmg.projeto4.dto.DonatarioDTO"%>
<%@page import="br.cefetmg.projeto4.dto.ProfessorDTO"%>
<%@page import="br.cefetmg.projeto4.dto.DoadorDTO"%>
<%@page import="br.cefetmg.projeto4.dto.DoadorJuridicoDTO"%>
<%@page import="br.cefetmg.projeto4.dto.EstagiarioDTO"%>

<%
    String user = request.getParameter("u");
    String status = request.getParameter("status");

    if (user != null)
        user.replace("%40", "@");
    if ((session == null || session.getAttribute("usuario") == null) && user == null) {
        response.sendRedirect("login.jsp?p=perfil.jsp");
        return;
    } else if (session != null && session.getAttribute("usuario") != null && user != null) {
        UsuarioDTO aux = (UsuarioDTO) session.getAttribute("usuario");

        if (aux.getEmail().equals(user)) {
            response.sendRedirect("perfil.jsp");
            return;
        }
    }

    UsuarioDTO usuario;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style/header.css">
    <link rel="stylesheet" href="style/main.css">
    <link rel="stylesheet" href="style/perfil.css">
    <link rel="stylesheet" href="style/exception.css">
<%
    if (user == null) {
%>
    <link rel="stylesheet" href="style/cropper.css">
<%
    }
%>
    <title>Perfil</title>
</head>
<body>
    <header></header>

    <main>
<%
    try (
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        DonatarioDAO donatarioDAO = new DonatarioDAO();
        DoadorDAO doadorDAO = new DoadorDAO();
        ProfessorDAO professorDAO = new ProfessorDAO();
        DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();
        EstagiarioDAO estagiarioDAO = new EstagiarioDAO()
    ) {
        if (user == null)
            usuario = (UsuarioDTO) session.getAttribute("usuario");
        else
            usuario = usuarioDAO.selecionar(user).orElseThrow();     
%>
        <section class="profile hideable hidden">
            <section class="profile-header">

                <img id="profile-picture" src="<%=usuario.getFoto()%>" alt="Foto de perfil">
                
<%
        if (user == null) {
            if (status != null && status.equals("fail")) {
%>
                <p class="fail">Tente novamente</p>
<%
            } else if (status != null && status.equals("success")) {
%>
                <p class="success">Perfil atualizado!</p>  
<%
            }
%>                              
                <form action="updatePic" method="post" id="update" enctype="multipart/form-data">
                    <label>
                        <input type="file" name="foto" id="foto" accept="image/*" required>
                        <a id="update">Mudar foto de perfil</a>
                    </label>
                </form>

                <a href="deletarFoto" class="danger" id="remove">Remover foto de perfil</a>
<%
        }
%>                
                <div class="profile-info">
                    <h1 class="info"><%=usuario.getNome()%> <span id="email"><%=usuario.getEmail()%></span></h1>
                </div>
            </section>
    
            <section class="profile-body">
                <p class="info"><span class="title"><%=usuario.getTipoCodigo()%></span>: <%=usuario.getCodigo()%></p>
    
<%
        if (usuario.getTipo().equals("DONATARIO")) {
            DonatarioDTO donatario;

            if (user == null)
                donatario = (DonatarioDTO) usuario;
            else 
                donatario = (DonatarioDTO) donatarioDAO.selecionar(user).orElseThrow();
%>
            <p class="info"><span class="title">Escola:</span> <%=donatario.getEscola()%></p>
            <p class="info"><span class="title">Série:</span> <%=donatario.getSerie()%></p>
<%
        } else if (usuario.getTipo().equals("PROFESSOR")) {
            ProfessorDTO professor;

            if (user == null)
                professor = (ProfessorDTO) usuario;
            else 
                professor = (ProfessorDTO) professorDAO.selecionar(user).orElseThrow();
%>
            <p class="info"><span class="title">Departamento:</span> <%=professor.getDepartamento()%></p>
<%
        } else if (usuario.getTipo().equals("ESTAGIARIO")) {
            EstagiarioDTO estagiario;

            if (user == null)
                estagiario = (EstagiarioDTO) usuario;
            else 
                estagiario = (EstagiarioDTO) estagiarioDAO.selecionar(user).orElseThrow();
%>
            <p class="info"><span class="title">Data de entrada:</span> <%=estagiario.getDataEntrada()%></p>
            <p class="info"><span class="title">Data de saida:</span> <%=estagiario.getDataSaida()%></p>
<%
        } else {
            DoadorDTO doador;

            if (user == null)
                doador = (DoadorDTO) usuario;
            else 
                doador = (DoadorDTO) doadorDAO.selecionar(user).orElseThrow();
%>
            <p class="info"><span class="title">Computadores doados:</span> <%=doador.getComputadoresDoados()%></p>
<%
            if (doador.getTipoDoador().equals("JURIDICO")) {
                DoadorJuridicoDTO doadorJuridico;

                if (user == null)
                    doadorJuridico = (DoadorJuridicoDTO) doador;
                else 
                    doadorJuridico = (DoadorJuridicoDTO) doadorJuridicoDAO.selecionar(user).orElseThrow();
%>
            <p class="info"><span class="title">Endereço:</span> <%=doadorJuridico.getEndereco()%></p>
<%
            }
        } 

        if (user == null) {
%>
            <a href="deletarConta.jsp" class="danger">Deletar conta</a>
<%
        }
%>
            </section>
        </section>
<%
    } catch (Exception e) {
%>
        <div id="exception">
            <h2>Erro ao carregar perfil</h2>
            <p>Descrição: <%=e.getMessage()%></p>
        </div>
<%        
    }
%>     
    </main>

<%
    if (user == null) {
%>
    <section id="popup">
        <div id="popup-content">
            <img alt="Crop preview" id="crop-preview">

            <div id="submit">
                <input type="submit" value="Enviar">
            </div>
        </div>
    </section>

    <script src="code/perfil.js"></script>
    <script src="code/cropper.min.js"></script>
    <script src="code/refresh.js"></script>
<%
    }
%>

    <script src="code/header.js"></script>
    <script src="code/exception.js"></script>
</body>
</html>