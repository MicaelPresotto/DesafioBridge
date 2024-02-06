# Desafio Bridge Web Full Stack

Projeto realizado para uma vaga de bolsista.

![antes](https://user-images.githubusercontent.com/50453035/183793318-f42ab27d-e953-4c66-8c77-d463cd61678a.png)
![apos](https://user-images.githubusercontent.com/50453035/183793332-2bca98a5-b1b3-4672-aa53-5e19a4f2a326.png)


## Sobre o projeto
O projeto foi um tanto quanto desafiador, foi a minha primeira experiência realizando um projeto full stack dessa forma, gostei muito das tecnologias e das bibliotecas 
utilizadas.

O intuito do projeto foi realizar uma aplicação full stack onde o back-end ficou responsável por toda lógica e por todos os cálculos, enquanto o front-end ficou responsável
por receber a entrada do usuário e enviar isso para o back-end. Para gerar o resultado, foi utilizado a seguinte lógica, o número que o usuário colocou na entrada é colocado em uma variável e, ele pega todo número menor que ele
e, se algum número e o seu próximo na sequência tiverem a mesma quantidade de divisores, então é adicionado 1 no resultado.

Com isso, para funcionamento do projeto, quando o usuário
coloca um número na entrada do input, ele envia uma requisição para o back-end, onde foi utilizado a biblioteca axios, e assim ele retorna o valor e o tempo de execução do mesmo.

Além disso, foram realizadas algumas verificações. O input no front-end não aceita qualquer coisa que seja diferente de um número,ou seja, strings, etc.
Porém, se por algum acaso acontecer, realizei uma verificação que irá retornar um erro. Também realizei outra verificação que, se acaso o número digitado pelo usuário não for maior que 1,
ele retorna então uma mensagem dizendo que é necessário que o usuário coloque um número maior que 1 no input.

## Construído com
### Tecnologias
  * Java 8
  * HTML
  * CSS
  * JavaScript

### Bibliotecas
  * React
  * SpringBoot
  * Axios

## Como usar

Como a aplicação foi dividida em duas partes, front-end e back-end e ambas estão neste mesmo repositório, então apenas é necessário clonar e instalar o seguinte:

### Requisitos
  * Git
  * NodeJS
  
 Para começar, é necessário clonar o repositório:
 ```
git clone https://github.com/MicaelPresotto/desafiofullstack.git
```

Além disso, será necessário também instalar uma biblioteca externa ao react, a biblioteca axios,entre no diretório desafiobridge_frontend com o primeiro comando e depois instale o axios:
 ```
cd desafiobridge_frontend
npm install axios
```

Com isso, execute o projeto dessa forma:
 ```
npm start
```

Por fim, para abrir o projeto em ambiente de desenvolvimento local basta acessar localhost:3000 

## Um pouco mais sobre a lógica
Por início, comecei criando uma função com HashMap, pois eu tenho que retornar dois valores: o resultado, e o tempo de resposta, isso é retornado em um dicionário.
Após isso, há uma string entrada que recebe um request que está recebendo o número digitado pelo usuário, após isso é feito uma verificação com try/except para ver do caso
se o usuário não digitar um número, e sim uma string ou qualquer outra coisa.( para deixar claro meu input está como type="number")

![entrada](https://user-images.githubusercontent.com/50453035/183785453-e604388c-f009-435a-a78a-2f6a564bba09.png)

Na lógica do tempo de execução, utilizei o método System.currentTimeMillis(), onde no começo do código igualei a uma variável para pegar o tempo inicial
e no final peguei a diferença entre eles, retornando assim o tempo de execução em milisegundos.

Além disso também criei uma função que calcula os divisores dos números, de forma a deixar o código menor e mais organizado

![calculaDivisores](https://user-images.githubusercontent.com/50453035/183785722-8279faee-db28-4468-8faf-761b39ceeb1c.png)

Essa função tem como parâmetro apenas um número inteiro, que é recebido e na função é calculado os seus divisores que serão armazenados em uma lista.

Para pegar todos os valores menores que o que foi digitado no input, eu realizei esse código de forma decrescente, por exemplo, se o usuário digita 5, eu pego os divisores do 5, depois do 4, do 3 e do 2, o que funciona
da mesma forma se fosse ao contrário, e para armazenar a lista de divisores do número atual com a lista de divisores do número anterior eu apenas igualei uma lista que primeiramente está vazia
a outra lista que está recebendo essa lista de divisores, e com isso eu verifico se o tamanho das duas listas são iguais, e assim eu conto + 1 no resultado.

![decrescente](https://user-images.githubusercontent.com/50453035/183786395-0339ed85-ee47-4609-aa72-bda5f79c2a08.png)

Por fim eu retorno o dicionário hashmap, para que, com isso, seja mostrado no back-end e o front-end consiga pegar.

_Micael Angelo Sabadin Presotto, 2022_
