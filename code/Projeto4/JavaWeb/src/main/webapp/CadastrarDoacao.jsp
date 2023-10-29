<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style/CadastrarDoacao.css">
        <link rel="stylesheet" href="style/header.css">
    <title>Cadastrar Doação</title>
</head>

<body>
    <header></header>
    <h1>Cadastrar Doação</h1>

    <form action="DonatarioCadastro" method="post">
        
        <label for="nome">Quantidade:</label>
        <input type="text" id="quantidade" name="quantidade" required>
        <br><br>

        <label for="status">Estado do Produto:</label>
        <select id="opcoes" name="opcoes" form="opcoes">
        <option value="status">Status</option>    
        <option value="funcionando">Funcionando</option>
        <option value="quebrados">Quebrado</option>
        <option value="faltandoPeca">Faltando Peça</option>
        <option value="algunsDefeitos">Alguns defeitos</option>
        </select>
        <br><br>
        <label for="nome">Especificações:</label>
        <br><br>
        <textarea id="especificacoes" name="especificacoes">Escreva aqui</textarea>
         <br><br>
        <label for="formaEntrega">Como deseja fornecer o produto:</label>
        
        <input type="radio" name="entrega" value="op1"> Entrega
        <input type="radio" name="busca" value="op2"> Busca
        <input type="date" name="data">
        <br><br>
         
        <input type="submit" value="Cadastrar"> 
        
    <script src="code/header.js"></script>
</body>
</html>
