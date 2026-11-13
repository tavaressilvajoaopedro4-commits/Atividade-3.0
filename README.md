# Proffy Mobile — Recuperação de senha

Projeto Android em Kotlin com o fluxo de recuperação de senha inspirado nas referências visuais fornecidas.

**Nome:** João Pedro  
**Turma:** 6º período de Sistemas de Informação

## Fluxo implementado

A tela “Esqueceu sua senha?” valida o e-mail em tempo real com `addTextChangedListener`, seguindo o padrão de validação usado nas telas de cadastro do projeto-base. O botão inicia desabilitado e cinza, com o texto “Entrar”; quando o e-mail tem formato válido, fica habilitado e verde, com o texto “Enviar”. E-mails inválidos exibem uma mensagem de erro abaixo do campo. Ao enviar um e-mail válido, a aplicação navega por `Intent` para a `FinallyActivity`, que mostra a confirmação e permite voltar ao login limpando a pilha de navegação.

## Abrir o projeto

Abra a pasta do repositório no Android Studio e sincronize o projeto Gradle. O app usa Kotlin, View Binding, AndroidX, Material Components e ConstraintLayout.

> A validação verifica localmente o formato do e-mail; este projeto não está conectado a um serviço de autenticação ou envio de e-mail.
