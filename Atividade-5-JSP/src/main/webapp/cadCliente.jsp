<!DOCTYPE html>
<html>
<head>
    <title>Cadastro de Cliente</title>
</head>
<body>
<h1>Cadastro de Cliente</h1>
<form action="AddCliente" method="post">
    <label for="nome">Nome:</label>
    <input type="text" name="nome" id="nome" required><br>

    <label for="sobrenome">Sobrenome:</label>
    <input type="text" name="sobrenome" id="sobrenome" required><br>

    <label for="dataNascimento">Data de Nascimento:</label>
    <input type="date" id="dataNascimento" name="dataNascimento" required><br>

    <label for="cpf">CPF:</label>
    <input type="text" name="cpf" id="cpf" required><br>

    <label for="email">Email:</label>
    <input type="text" name="email" id="email" required><br>

    <input type="submit" value="Cadastrar">
</form>
</body>
</html>