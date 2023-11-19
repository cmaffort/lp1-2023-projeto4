<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.util.Base64"%>
<%@page import="java.nio.file.Path"%>
<%@page import="java.nio.file.Files"%>
<%@page import="java.nio.file.FileSystems"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Arrays"%>
<%@page import="org.apache.commons.io.FilenameUtils"%>
<%@page import="org.apache.commons.io.IOUtils"%>

<%@page import="br.cefetmg.projeto4.dao.FeedbackDAO"%>
<%@page import="br.cefetmg.projeto4.dto.FeedbackDTO"%>
<%@page import="br.cefetmg.projeto4.dto.DonatarioDTO"%>
<%@page import="br.cefetmg.projeto4.javaweb.CompressionHelper"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/header.css">
        <link rel="stylesheet" href="style/main.css">
        <link rel="stylesheet" href="style/mostraFeedback.css">
        <title>Avaliações</title>
    </head>
    <body>
        <header></header> 

        <div id="redirect">
            <button onclick="redirect('feedback.jsp')">Avalie você também!</button>
        </div>

        <main>
<%  try {
        FeedbackDAO feedbackDAO = new FeedbackDAO();
        List<FeedbackDTO> feedbacks = feedbackDAO.listar();
%>
            <section id="feed">
<%
        for (FeedbackDTO feedback : feedbacks) {
            DonatarioDTO donatario = feedback.getDonatario();
            String base64Image = "";

            if (donatario.getFoto() != null) {
                byte[] compressedPhotoBytes = donatario.getFoto();
            
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
                <div class="post">
                    <figure class="user-info">
                        <div class="username"><%=donatario.getNome()%></div>
                        <img class="profile-picture" src="data:image/png;base64,<%= base64Image %>" alt="Foto de perfil">
                    </figure>

                    <div class="content">
                        <div class="rating">
<%
            int estrelas = feedback.getEstrelas();
            int i;

            for (i = 0; i < estrelas; i++) {
%>
                            <i class="fa-solid fa-star star selected"></i>
<%
            }

            for (i = estrelas; i < 5; i++) {
%>
                            <i class="fa-solid fa-star star"></i>
<%
            }
%>                                        
                        </div>

                        <div class="model"><%=feedback.getModeloPC()%></div>
                        <div class="feedback"><%=feedback.getDescricao()%></div>
                    </div>
                </div>
<%
        }
%>
            </section>
<%
    } catch (Exception e) {
%>
        <div id="exception">
            <h2>Erro ao carregar agenda</h2>
            <p>Descrição: <%=e.getMessage()%></p>
        </div>
<%        
    }
%>       
        </main>

        <script src="code/header.js"></script>
        <script src="https://kit.fontawesome.com/5e2c2b2fc2.js" crossorigin="anonymous"></script>
    </body>
</html>