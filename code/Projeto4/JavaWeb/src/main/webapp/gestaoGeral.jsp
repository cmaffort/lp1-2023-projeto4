<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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

        <%@page import="br.cefetmg.projeto4.dto.DoadorDTO"%>
        <%@page import="br.cefetmg.projeto4.dto.DoacaoDTO"%>
        <%@page import="br.cefetmg.projeto4.dto.DoadorJuridicoDTO"%>
        <%@page import="br.cefetmg.projeto4.dto.DonatarioDTO" %>
        <%@page import="br.cefetmg.projeto4.dto.EstagiarioDTO" %>
        <%@page import="br.cefetmg.projeto4.dto.ProfessorDTO" %>
        <%@page import="br.cefetmg.projeto4.dto.MantecaoDTO" %>
        <%@page import="br.cefetmg.projeto4.javaweb.GestaoGeralServlet" %>
        <%@page import="br.cefetmg.projeto4.javaweb.GetDoadores" %>
        <%@page import="java.util.*" %>

        <header></header>



        <main id="doadores">

            <h1>Doadores</h1>

            <div class="divMaior">
                
                <% 
                    GetDoadores doadoresFisicosGet = new GetDoadores();
                    GetDoadores doadoresJuridicosGet = new GetDoadores();
                    List<DoadorDTO> doadoresFisicos = doadoresFisicosGet.getDoadorFisico();
                    List<DoadorDTO> doadoresJuridicos = doadoresJuridicosGet.getDoadoresJuridicos();
                %>
                
                <div>
                    <% 
                    for (DoadorDTO contador: doadoresFisicos) { %>
                    
                    <p class="classe"><% out.println(contador.getNome() + "*" + contador.getCodigo() + "*" + contador.getComputadoresDoados() + "*" + contador.getEmail() + "*" + contador.getFoto()); 
                    %></p>
                    
                <%}%>
                
                <% 
                    for (DoadorDTO contador: doadoresJuridicos) { %>
                    
                    <p class="classe"><% out.println(contador.getNome() + "*" + contador.getCodigo() + "*" + contador.getComputadoresDoados() + "*" + contador.getEmail() + "*" + contador.getFoto()); 
                    %></p>
                    
                <%}%>
                    
                </div>  
                
                
            </div>


            
        </main>

        <main id="doacoes">

            <h1>Doacões</h1>

           <div class="divMaior"> 


                <div class="esquerda">

                    <h2> Marcos Rocha</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>CPF:</strong> 138.967.653-67</li>
                        <li><strong>Data de doação:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>
                <div class="meio">

                    <h2> Junior Alonso</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>CPF:</strong> 138.967.653-67</li>
                        <li><strong>Data de doação:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>
                <div class="direita">

                    <h2> Douglas Santos</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>CPF:</strong> 138.967.653-67</li>
                        <li><strong>Data de doação:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>


            </div>


        </main>
        <main id="geral">

            <h1>Relatório Geral</h1>

            <div class="esquerda">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="meio">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>
            <div class="direita">

                <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

            </div>

        </main>
        <main id="manutencoes">

            <h1> Manutencões </h1>

            <div id="divMaior"> 


                <div class="esquerda">

                    <h2> Dadá Maravilha</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>Marca:</strong> Dell</li>
                        <li><strong>Data de doação:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>
                <div class="meio">

                    <h2> Rafael Carioca</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>Marca:</strong> Dell</li>
                        <li><strong>Data de doação:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>
                <div class="direita">

                    <h2> Diego Tardelli</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>Marca:</strong> Dell</li>
                        <li><strong>Data de doação:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>


            </div>

        </main>
        <main id="funcionarios">

            <h1> Funcionários </h1>


            <div id="divMaior"> 


                <div class="esquerda">

                    <h2> Ronaldinho Gaúcho</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>Cargo:</strong> Professor</li>
                        <li><strong>Data de início:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>
                <div class="meio">

                    <h2> Leandro Donizete</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>Cargo:</strong> Professor</li>
                        <li><strong>Data de início:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>
                <div class="direita">

                    <h2> Neto Berola</h2>

                    <img  src="img/pessoa-anonima.png" id="pessoaAnonima">

                    <ul class="listaDiv"> 
                        <li><strong>Cargo:</strong> Professor</li>
                        <li><strong>Data de início:</strong> 23/05/2022</li>
                        <li><strong>Email:</strong> Roger@gmail.com</li>
                    </ul>

                </div>


            </div>

        </main>

        <div id="menuGeral">
            <ul>
                <li> <button id="botaoDoadores"> Doadores</button> </li>
                <li> <button id="botaoDoacoes"> Doações</button> </li>
                <li> <button id="botaoGeral"> Relatório geral</button> </li>
                <li> <button id="botaoManutencoes"> Manutenções</button> </li>
                <li> <button id="botaoFuncionarios"> Funcionários</button></li>
            </ul>

        </div>  


        <script src="code/gestaoGeral.js"></script>
        <script src="code/header.js"></script>
    </body>
</html>
