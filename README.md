# Tech Challenge - Fase 3: Sistema de Agendamento Hospitalar
## 🏥 Sobre o Projeto

Este projeto foi desenvolvido como parte da Fase 3 da Pós Tech em Arquitetura e Desenvolvimento Java. O objetivo é criar um backend modular e seguro para o ambiente hospitalar, focando em comunicação assíncrona e segurança robusta.

O sistema permite o agendamento de consultas, gerenciamento de histórico médico e o envio automático de lembretes para pacientes, garantindo a organização e a presença nas consultas.

## 🛠️ Tecnologias Utilizadas

<ul>
    <li>Java & Spring Boot: Framework principal para construção dos microsserviços.</li>
    <li>Spring Security: Implementação de autenticação básica e controle de acesso por perfis.</li>
    <li>GraphQL: Utilizado para consultas flexíveis e dinâmicas de históricos médicos.</li>
    <li>RabbitMQ ou Kafka: Mensageria para comunicação assíncrona entre os serviços de agendamento e notificações.</li>
    <li>Postman: Coleções inclusas para teste dos endpoints.</li>
</ul>

## 🏗️ Arquitetura do Sistema

A solução é dividida em serviços independentes para garantir a escalabilidade:
<ol>
<li> <dt> Serviço de Agendamento: Gerencia a criação e edição de consultas. Ao realizar uma alteração, dispara uma mensagem para o broker.</dt> </li>
<li> <dt> Serviço de Notificações: Consome as mensagens e processa o envio de lembretes aos pacientes.</dt> </li>
<li> <dt> Serviço de Histórico (Opcional): Centraliza os dados passados e disponibiliza a interface GraphQL.</dt> </li>
</ol>

## 🔐 Níveis de Acesso

A segurança é segmentada para garantir que cada usuário acesse apenas o necessário:
<ul>
    <li>Médicos: Visualização e edição total do histórico de consultas.</li>
    <li>Enfermeiros: Registro de novas consultas e acesso ao histórico.</li>
    <li>Pacientes: Acesso restrito apenas às suas próprias consultas.</li>
</ul>

## 🚀 Como Executar

    Dica: Detalhe aqui os passos para rodar o Docker Compose (se usar), como configurar o RabbitMQ/Kafka e os comandos ```mvn spring-boot:run```. 

## 🧪 Testes

Para validar as funcionalidades, utilize a collection do Postman disponível na pasta /docs ou no diretório raiz do projeto. Os endpoints cobrem:
<ul>
    <li>Autenticação e Login.</li>
    <li>Agendamento e Edição de Consultas.</li>
    <li>Consultas via GraphQL.</li>
</ul>