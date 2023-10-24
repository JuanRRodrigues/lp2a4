<!DOCTYPE html>
<html>
<head>
    <title>Detalhes do Cliente</title>
</head>
<body>
<h1>Detalhes do Cliente</h1>
<c:if test="${not empty cliente}">
    <table>
        <tr>
            <th>Nome</th>
            <th>Sobrenome</th>
            <th>Data de Nascimento</th>
            <th>CPF</th>
            <th>Email</th>
        </tr>
        <tr>
            <td>${cliente.nome}</td>
            <td>${cliente.sobrenome}</td>
            <td>${cliente.dataDeNascimento}</td>
            <td>${cliente.cpf}</td>
            <td>${cliente.email}</td>
        </tr>
    </table>
</c:if>
</body>
</html>