
 ![logo](https://github.com/aluiziomonteiro/sys-vendas/blob/master/fotos-sisvendas/logo.png?raw=true)


##### Sistema de controle de vendas, estoque e pagamentos
___

___

## 🚀 Começando
#### Se você trabalha com vendas certamente sabe da importância de manter os estoques sempre bem organizados.
#### É através dessa organização que podemos observar quais são os produtos que mais venderam, que estão acabando ou simplesmente se estão disponíveis para venda.
#### A organização das vendas é tão importante quanto a do estoque, ambos quando combinados possibilitam ao gerente do negócio visualizar se o dinheiro presente em caixa bate com a quantidade e valores vendidos durante o dia, semana, mês etc.
#### Se você busca por uma forma de gerenciar o seu negócio, um software que realize essas funções é realmente importante, até indispensável.


![N|Solid](https://github.com/aluiziomonteiro/sys-vendas/blob/master/fotos-sisvendas/tela-dashboard01.png?raw=true)

___

## 🛠️ Funcionalidades

-	Cadastros Gerais
-	O valor que o usuário já investiu em compras de Produtos 
-	Gráficos com cruzamento de informações
-	Lucros Total
-	Parcelas em Atraso
-	Parcelas à Receber
-	Lucro Total Bruto e Líquido
-	Lucro Estimado Bruto e Líquido
-	Total de contas a receber no dia, no mês, no ano e em geral
-	Quando um determinado produto entrou na reserva
-	Quais produtos são mais e menos vendido
-	Quantidade dos Produtos em estoque
-	Previsão de lucros baseados no estoque
-	Controle de Orçamento
-	Venda em até 12x
-	Controle de quantidade de produtos em estoque



___

## 📦 Tecnologias de produção

- JDK 8x;
- Eclipse;
- Apache Tomcat 8;
- Maven;
- Mysql Server;
- Git;
- BootStrap;
- JavaScript.

> Testado no Firefox, Chrome e Edge

___


## 🔧 Instalação para desenvolvimento

1. Crie uma conexão no Worckbench tendo como user e pass: root, root;
2. Baixe o schema em: https://github.com/aluiziomonteiro/sys-vendas/blob/dev/docs/schema_sys_vendas.sql;
3. Importe-o para o Worchbench;
4. Execute: INSERT INT USUARIOS VALUES('admin','admin','admin'); para setar uma senha de acesso ao sistema;
4. Faça o download do .zip sysvendas na branch dev ou por este link: https://github.com/aluiziomonteiro/sys-vendas;
5. Importe para o eclipse como um Maven Project;
6. Use o TomCat 8;
7. Starte o Servidor;
8. Acesse o URL no navegador: localhost:8080/sys-vendas/;
9. Faça login com usuário e senha aluizio, aluizio.
<br /><br />
![N|Solid](https://github.com/aluiziomonteiro/sys-vendas/blob/master/fotos-sisvendas/tela-login.png?raw=true) 

___

## ⚙️ Execução
### Input de informações no sistema

> Após efetuar o login no sistema faça

1. Realize o cadastro de uma Categoria pelo menu: "Cadastrar/Categoria";
2. Realize o cadastro de um Fornecedor pelo menu: "Cadastrar/Fornecedor";
3. Realize o cadastro de um Produto pelo menu: "Cadastrar/Produto";
4. Associe a Categoria e o Fornecedor ao Produto;
5. Realize o cadastro de uma Cliente pelo menu: "Cadastrar/Cliente".
<br /><br />
![N|Solid](https://github.com/aluiziomonteiro/sys-vendas/blob/master/fotos-sisvendas/tela-menu-cadastro01.png?raw=true) 


### Realização de uma venda
1. Realize uma venda pelo menu: "Orçamento/Novo Orçamento"
2. Selecione um Cliente" com o botão + da guia Cliente;
3. Selecione o(s) produto(s)" com o botão + da guia Produtos;
4. Preencha os campos de valores obrigatórios;
5. Selecione a forma de pagamento;
6. Confirme a venda.
<br /><br />
![N|Solid](https://github.com/aluiziomonteiro/sys-vendas/blob/master/fotos-sisvendas/tela-orcamento04.png?raw=true) 



<br /><br />


