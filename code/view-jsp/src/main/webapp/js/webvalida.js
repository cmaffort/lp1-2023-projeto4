/*---------------------------------------------------------------------
 * Funcao de validacao dos campos formLogin
 * Utilizacao:  funcao ValidaLogin() 
 *---------------------------------------------------------------------*/
function validarCamposLogin() {
    var frm = document.frmLogin;
    var nome = frm.nome.value;
    var senha = frm.senha.value;

    if (nome == "") {
        alert("Favor, preencha o campo usuario!");
        frm.nome.focus();
        return false;
    } else if (senha == "") {
        alert("Favor, preencha o campo senha!");
        frm.senha.focus();
        return false;
    } else {
        caminhourl = "/locadora/servletweb?acao=Logar";
        document.forms[0].action = caminhourl;
        window.document.forms[0].submit();
        return true;
    }
}

/*---------------------------------------------------------------------
 * Funcoes de manipulacao para tabelas
 *---------------------------------------------------------------------*/
function Excluir(chave, frm) {
    var table = frm.table.value;

    if (table == "Estado") {
        if (confirm('Deseja excluir o Estado da Sigla: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirEstado";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirEstado';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Cidade") {
        if (confirm('Deseja excluir a Cidade do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirCidade";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirCidade';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Cliente") {
        if (confirm('Deseja excluir o Cliente do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirCliente";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirCliente';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Categoria") {
        if (confirm('Deseja excluir a Categoria do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirCategoria";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirCategoria';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Veiculo") {
        if (confirm('Deseja excluir o Veiculo da Placa: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirVeiculo";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirVeiculo';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "VeiculoCliente") {
        if (confirm('Deseja excluir o VeiculoCliente do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirVeiculoCliente";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirVeiculoCliente';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Usuario") {
        if (confirm('Deseja excluir o Usuario do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirUsuario";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirUsuario';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Marca") {
        if (confirm('Deseja excluir a Marca do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirMarca";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirMarca';

            frm.cod.value = chave;
            frm.submit();
        }
    } else if (table == "Modelo") {
        if (confirm('Deseja excluir o Modelo do Código: ' + chave + '?')) {
            if (frm.acao.value == "alterar") {
                frm.acao.value = "/locadora/servletweb?acao=ExcluirModelo";
                frm.action = frm.acao.value;
            } else
                frm.acao.value = 'ExcluirModelo';

            frm.cod.value = chave;
            frm.submit();
        }
    }
}

function ValidarEstado(frm) {
    var sigla = frm.sigla.value;
    var nome = frm.nome.value;

    if (sigla == "" || sigla == null) {
        alert("Favor, preencha o campo sigla!");
        frm.sigla.focus();
        return false;
    } else if (nome == "" || nome == null) {
        alert("Favor, preencha o campo nome!");
        frm.nome.focus();
        return false;
    } else
        return true;
}

function ValidarCliente(frm) {
    if (frm.nome.value == "") {
        alert("Favor, informe o nome do cliente!");
        frm.nome.focus();
        return false;
    } else if (frm.bairro.value == "") {
        alert("Favor, informe o bairro!");
        frm.bairro.focus();
        return false;
    } else if (frm.cpf.value == "") {
        alert("Favor, informe o cpf!");
        frm.cpf.focus();
        return false;
    } else if (frm.dataNasc.value == "") {
        alert("Favor, informe a Data de Nascimento!");
        frm.dataNasc.focus();
        return false;
    } else if (frm.email.value == "") {
        alert("Favor, informe o email!");
        frm.email.focus();
        return false;
    } else if (frm.endereco.value == "") {
        alert("Favor, informe o endereóo!");
        frm.endereco.focus();
        return false;
    } else if (frm.fone.value == "") {
        alert("Favor, informe o telefone!");
        frm.fone.focus();
        return false;
    } else {
        return true;
    }
}

function ValidarVeiculo(frm) {
    if (frm.placa.value == "") {
        alert("Favor,informe a placa!");
        frm.placa.focus();
        return false;
    } else if (frm.descricao.value == "") {
        alert("Favor,informe a descrição!");
        frm.descricao.focus();
        return false;
    } else
        return true;

}

function GravarAlterarTabela(frm) {
    var table = frm.table.value;
    if (table == "Estado") {
        if (ValidarEstado(frm)) {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoEstado";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoEstado";
        }
    } else if (table == "Cidade") {
        if (frm.nome.value == "") {
            alert("Favor, informe o nome da cidade");
            frm.nome.focus();
            return false;
        }
        if (frm.acao.value == "alterar")
            caminhourl = "/locadora/servletweb?acao=GravarAlteracaoCidade";
        else if (frm.acao.value == "gravar")
            caminhourl = "/locadora/servletweb?acao=GravarInsercaoCidade";

    } else if (table == "Cliente") {
        if (ValidarCliente(frm)) {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoCliente";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoCliente";
        } 
    } else if (table == "Veiculo") {
        if (ValidarVeiculo(frm)) {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoVeiculo";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoVeiculo";
        }
    } else if (table == "Modelo") {
        if (frm.descricao.value == "") {
            alert("Favor, informe a descrição!");
            frm.descricao.focus();
            return false;
        } else {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoModelo";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoModelo";
        }
    } else if (table == "Marca") {
        if (frm.descricao.value == "") {
            alert("Favor, informe a descrição!");
            frm.descricao.focus();
            return false;
        } else {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoMarca";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoMarca";
        }
    } else if (table == "Categoria") {
        if (frm.descricao.value == "") {
            alert("Favor, informe a descrição!");
            frm.descricao.focus();
            return false;
        } else {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoCategoria";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoCategoria";
        }
    } else if (table == "Usuario") {
        if (ValidarUsuario(frm)) {
            if (frm.acao.value == "alterar")
                caminhourl = "/locadora/servletweb?acao=GravarAlteracaoUsuario";
            else if (frm.acao.value == "gravar")
                caminhourl = "/locadora/servletweb?acao=GravarInsercaoUsuario";
        }
    } else if (table == "VeiculoCliente") {
        if (frm.acao.value == "alterar")
            caminhourl = "/locadora/servletweb?acao=GravarAlteracaoVeiculoCliente";
        else if (frm.acao.value == "gravar")
            caminhourl = "/locadora/servletweb?acao=GravarInsercaoVeiculoCliente";
    }
    frm.action = caminhourl;
    frm.submit();
}

function ValidarUsuario(frm) {
    if (frm.nome.value == "") {
        alert("Favor, informe o nome!");
        frm.nome.focus();
        return false;
    } else if (frm.nomecompleto.value == "") {
        alert("Favor, informe o nome completo!");
        frm.nomecompleto.focus();
        return false;
    } else if (frm.senha.value == "") {
        alert("Favor, informe a senha!");
        frm.senha.focus();
        return false;
    } else if (frm.email.value == "") {
        alert("Favor, informe o email!");
        frm.email.focus();
        return false;
    } else {
        return true;
    }

}