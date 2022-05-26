<h1>Vinícius Buttini API</h1>

<h3>Simple documentation of endpoints</h3>
------------------------------------------------
<h4>This is my API link:
<a>https://vbuttini-repository.herokuapp.com</a>
</h4>
------------------------------------------------
<h2> User </h2>

_______________________________________________

<h3> Method for create a new user </h3>

_______________________________________________

<p><strong>Method:</strong> POST</p>
<strong>Path:</strong> /user

<h4>Request Headers:</h4>
<span><strong>Content-Type:</strong> application/json</span>

<h4>Body:</h3>

```
{
    "email": "emailDaEmpresa@dominio.com",
    "password": "senhaDeUsuario",
    "company": {
        "name": "Nome da Empresa",
        "cnpj": "00.000.000/0001-00",
        "agent": "Nome do Agente",
        "phone": "(xx) 99999-9999"
    }
}
```

<h4>Response:</h3>

<p>201 CREATED</p>

```
{
    "id": n,
    "email": "emailDaEmpresa@dominio.com",
    "company": {
        "id": n,
        "name": "Nome da Empresa",
        "cnpj": "00.000.000/0001-00",
        "agent": "Nome do Agente",
        "phone": "(xx) 99999-9999",
        "createdAt": "yyyy-MM-dd HH:mm:ss",
        "updatedAt": "yyyy-MM-dd HH:mm:ss"
    }
}
```

------------------------------------------------
<h2> Auth </h2>

_______________________________________________

<h3> Authentication </h3>

_______________________________________________

<p><strong>Method:</strong> POST</p>
<strong>Path:</strong> /auth

<h4>Request Headers:</h4>
<span><strong>Content-Type:</strong> application/json</span>

<h4>Body:</h3>

```
{
    "email": "emailDaEmpresa@dominio.com",
    "password": "senhaDeUsuario"
}
```

<h4>Response:</h3>

<p>200 OK</p>

```
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2YnV0dGluaS1yZXBvc2l0b3J5Iiwic3ViI
    joiMSIsImlhdCI6MTY1MzU5MjM2OSwiZXhwIjoxNjUzNTk1OTY5fQ.Lw_ivARZiReQH0jOKiyS9UbaMIvft2aXIQLUZZacrgI",
    "type": "Bearer"
}
```