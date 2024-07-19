<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Java Mail</title>
</head>

<body>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
        <td align="center" valign="top" bgcolor="#838383"
            style="background-color: #838383;"><br> <br>
            <table width="600" border="0" cellspacing="0" cellpadding="0">
                <tr>
                    <td align="center" valign="top" bgcolor="#d3be6c"
                        style="background-color: #d3be6c; font-family: Arial, Helvetica, sans-serif; font-size: 13px; color: #000000; padding: 0px 15px 10px 15px;">

                        <div style="font-size: 24px; color: #555100;">
                            <br> Olá ${nome}, <br>
                            <br> Seu endereço foi ${modificacao} com sucesso: <br>
                            <br>
                            <table style="font-size: 16px;">
                                <tr>
                                    <td><strong>Logradouro:</strong></td>
                                    <td>${logradouro}</td>
                                </tr>
                                <tr>
                                    <td><strong>Número:</strong></td>
                                    <td>${numero}</td>
                                </tr>
                                <tr>
                                    <td><strong>Complemento:</strong></td>
                                    <td>${complemento}</td>
                                </tr>
                                <tr>
                                    <td><strong>CEP:</strong></td>
                                    <td>${cep}</td>
                                </tr>
                                <tr>
                                    <td><strong>Cidade:</strong></td>
                                    <td>${cidade}</td>
                                </tr>
                                <tr>
                                    <td><strong>Estado:</strong></td>
                                    <td>${estado}</td>
                                </tr>
                                <tr>
                                    <td><strong>País:</strong></td>
                                    <td>${pais}</td>
                                </tr>
                            </table>
                            <br><br>Qualquer dúvida é só contatar o suporte pelo e-mail ${email}.<br><br>
                            Att,<br>
                            Sistema.
                        </div>
                    </td>
                </tr>
            </table> <br> <br></td>
    </tr>
</table>
</body>
</html>