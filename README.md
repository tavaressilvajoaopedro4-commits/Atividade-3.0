# Proffy Mobile — Recuperação de senha

Projeto Android Kotlin com o fluxo de recuperação de senha inspirado nas referências visuais fornecidas.

**Nome completo:** [João Pedro]  
**Turma:** [6 periodo SI]

## Fluxo implementado

A tela “Esqueceu sua senha?” valida o e-mail em tempo real com `addTextChangedListener`. O botão inicia desabilitado e cinza (“Entrar”); quando o endereço tem formato válido, passa a ficar verde e habilitado (“Enviar”). Ao enviar, a aplicação navega por `Intent` para a tela `FinallyActivity`, que confirma o envio e oferece retorno ao login.

## Abrir o projeto

Abra a pasta do repositório no Android Studio e sincronize o projeto Gradle. O app usa Kotlin, View Binding, AndroidX, Material Components e ConstraintLayout.

> A validação verifica o formato do e-mail localmente; o projeto não está conectado a um serviço de autenticação ou envio de e-mail.
