<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.FileSystems"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.io.IOUtils"%>

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
<%@page import="br.cefetmg.projeto4.javaweb.CompressionHelper"%>

<%
    String user = request.getParameter("u");
    String status = request.getParameter("status");
    String error = request.getParameter("e");

    if ((session == null || session.getAttribute("usuario") == null) && user == null) {
        response.sendRedirect("login.jsp?p=perfil.jsp");
        return;
    }

    UsuarioDTO usuario;
    String base64Image = "";
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.6.1/cropper.css">
    <title>Perfil</title>
</head>
<body>
    <header></header>

    <main>
<%
    try {
        if (user == null)
            usuario = (UsuarioDTO) session.getAttribute("usuario");
        else {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            usuario = usuarioDAO.selecionar(user).orElseThrow();
        }

        if (usuario.getFoto() != null) {
            byte[] compressedPhotoBytes = usuario.getFoto();
        
            byte[] decompressedPhotoBytes = CompressionHelper.decompressFile(compressedPhotoBytes);
        
            base64Image = Base64.getEncoder().encodeToString(decompressedPhotoBytes);
        } else {
            try (InputStream defaultImageStream = Files.newInputStream(FileSystems.getDefault().getPath(request.getServletContext().getRealPath("/img/avatar.png")))) {
                byte[] defaultImageBytes = IOUtils.toByteArray(defaultImageStream);
                base64Image = Base64.getEncoder().encodeToString(defaultImageBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }        
%>
        <section class="profile">
            <section class="profile-header">

                <img id="profile-picture" src="data:image/png;base64,<%= base64Image %>" alt="Foto de perfil">
                
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
            } else if (error != null && error.equals("size")) {
%>
                <p class="fail">Arquivo muito grande</p>
<%
            }
%>                              
                <form action="updatePic" method="post" id="update" enctype="multipart/form-data">
                    <label>
                        <input type="file" name="foto" id="foto" accept="image/*" required>
                        <a id="update">Mudar foto de perfil</a>
                    </label>
                </form>
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
            else {
                DonatarioDAO donatarioDAO = new DonatarioDAO();

                donatario = (DonatarioDTO) donatarioDAO.selecionar(user).orElseThrow();
            }
%>
            <p class="info"><span class="title">Escola:</span> <%=donatario.getEscola()%></p>
            <p class="info"><span class="title">Série:</span> <%=donatario.getSerie()%></p>
<%
        } else if (usuario.getTipo().equals("PROFESSOR")) {
            ProfessorDTO professor;

            if (user == null)
                professor = (ProfessorDTO) usuario;
            else {
                ProfessorDAO professorDAO = new ProfessorDAO();

                professor = (ProfessorDTO) professorDAO.selecionar(user).orElseThrow();
            }
%>
            <p class="info"><span class="title">Departamento:</span> <%=professor.getDepartamento()%></p>
<%
        } else if (usuario.getTipo().equals("ESTAGIARIO")) {
            EstagiarioDTO estagiario;

            if (user == null)
                estagiario = (EstagiarioDTO) usuario;
            else {
                EstagiarioDAO estagiarioDAO = new EstagiarioDAO();

                estagiario = (EstagiarioDTO) estagiarioDAO.selecionar(user).orElseThrow();
            }
%>
            <p class="info"><span class="title">Data de entrada:</span> <%=estagiario.getDataEntrada()%></p>
            <p class="info"><span class="title">Data de saida:</span> <%=estagiario.getDataSaida()%></p>
<%
        } else {
            DoadorDTO doador;

            if (user == null)
                doador = (DoadorDTO) usuario;
            else {
                DoadorDAO doadorDAO = new DoadorDAO();

                doador = (DoadorDTO) doadorDAO.selecionar(user).orElseThrow();
            }
%>
            <p class="info"><span class="title">Computadores doados:</span> <%=doador.getComputadoresDoados()%></p>
<%
            if (doador.getTipoDoador().equals("JURIDICO")) {
                DoadorJuridicoDTO doadorJuridico;

                if (user == null)
                    doadorJuridico = (DoadorJuridicoDTO) doador;
                else {
                    DoadorJuridicoDAO doadorJuridicoDAO = new DoadorJuridicoDAO();

                    doadorJuridico = (DoadorJuridicoDTO) doadorJuridicoDAO.selecionar(user).orElseThrow();
                }
%>
            <p class="info"><span class="title">Endereço:</span> <%=doadorJuridico.getEndereco()%></p>
<%
            }
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
    <script src="https://cdnjs.cloudflare.com/ajax/libs/cropperjs/1.6.1/cropper.min.js"></script>
<%
    }
%>

    <script src="code/header.js"></script>
</body>
</html>