<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    define("DIR",__DIR__."/");
    include_once "vendor/autoload.php";
    include_once "bootstrap.php";
    
    session_start();
    if (!isset($_GET['do'])) {
        # logado ou nao, redireciona para home
        include_once DIR . 'src/view/home.php';
    }
    else{
        switch($_GET['do']){
            case "login": include_once DIR.'src/view/login.php';
                        break;
            case "main": include_once DIR.'src/view/home.php';
                        break;
            case "cadastrar": include DIR.'src/view/cadastrarUsuario.php';
                        break;
            case "validarCadastro": include DIR.'src/control/usuario/index.php';
                        break;
            case "validarLogin": include DIR.'src/control/usuario/index.php';
                        break;
            case "admin": include_once DIR.'src/control/filme/index.php';
                        break;
            case "paineladm": include_once DIR.'src/view/admin.php';
                        break;
            case "pageAlterarFilme": include_once DIR.'src/view/alterarFilme.php';
                        break;
            case "alterarFilme": include_once DIR.'src/control/filme/index.php';
                        break;
            case "pageDeletarFilme": include_once DIR.'src/view/deletarFilme.php';
                        break;
            case "deletarFilme": include_once DIR.'src/control/filme/index.php';
                        break;
            case "pageCadastrarFilme": include_once DIR.'src/view/cadastrarFilme.php';
                        break;
            case "cadastrarFilme": include_once DIR.'src/control/filme/index.php';
                        break;
            case "buscarFilme": include DIR.'src/control/filme/index.php';
                        break;
            case "resultadosBusca": include DIR.'src/view/resultadosBusca.php';
                        break;
            case "detalhesFilme": include DIR.'src/control/filme/index.php';
                        break;
            case "pageDetalhesFilme": include DIR.'src/view/detalhe.php';
                        break;
            case "pageComentar": include DIR.'src/view/comentar.php';
                        break;
            case "comentarFilme": include DIR.'src/control/comentario/index.php';
                        break;
            case "assistirFilme": include DIR.'src/control/usuario/index.php';
                        break;
            case "perfil": include DIR.'src/control/usuario/index.php';
                        break;
            case "pagePerfil": include DIR.'src/view/perfil.php';
                        break;
            case "deletarComentario": include_once DIR.'src/control/comentario/index.php';
                        break;
             case "desmarcarAssistido": include_once DIR.'src/control/usuario/index.php';
                        break;
            case "sair": include_once DIR.'src/control/usuario/index.php';
                        break;
            default: echo "Ação inválida <a href='?'>Voltar</a>";
        }
    }
        
?>