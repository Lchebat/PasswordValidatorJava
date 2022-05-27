# PasswordValidatorJava
Validador de senhas. (Java 17, Spring Boot 2.7.0, jUnit)

# Como Utilizar
- Faça uma requisição POST para a url: https://chebat-password-java.azurewebsites.net/password
- No corpo da requisição enviar a senha em  formato JSON
```
{
    "password": "AbTp9!fok"
}
```
- A API retornará como resposta TRUE caso a senha for válida e FALSE caso for inválida.

# Atualizações
- Primeiro foram criados 2 projetos em uma solução. Um para realização dos testes unitários com xUnit e outro a API de validação de senhas. 
- A classe PasswordService foi criada fazer as verificações nessecárias, ou seja, realizará as validações da senha. Também foi adicionado a injeção de depêndencia para diminuir o acoplamento entre o controller e as validações que serão feitas na senha. 
- Foi criado a classe StringVerifier para extender a classe string e assim a classe PasswordService apenas chamará os métodos de extensão criados na classe StringVerifier.
- Foi adicionada uma classe CharVerifier que extende o objeto char para poder filtrar os caracteres especiais permitidos: !@#$%^&*()-+.
- Foi implementado duas classes de testes unitários utilizando xUnit. A primeira testando todos os métodos da classe StringVerifier e a segunda testando as senhas sugeridas. 
- Interface IPasswordService implementada para reduzir o acomplamento entre o controlador PasswordController e a classe PasswordService.

# Meu Raciocínio
Criei os 2 projetos para realizar a solução com o objetivo de seguir a prática TDD, porém conforme eu fui criando as classes e mudando o projeto acabei não seguindo a prática.
Minha ideia inicial era fazer as verificações na classe PasswordService, implementando um método público (o qual o construtor chamaria) e vários métodos privados que seriam chamados pelo método público, porém como a classe acabou ficando com muitos métodos, eu decidi criar uma classe para abrigar esses métodos. Então, eu fiz com que esses métodos extendessem a classe string pois achei que o método VerifyPassword ficaria mais legível. 

Após a API estar completa, comecei a trabalhar na classe de teste. Escolhi ter duas classes de teste, uma para verificar apenas os métodos de extensão e outra para verificar diversas possibilidades de senha. Durante os testes me surgiu uma dúvida: Na restrição de caracteres repetidos, maiúsculos e minúsculos deveriam valer como repetidos? Eu decidi deixar um teste falhando (TestWrongPasswordServiceRepetition3()), nesse teste a senha possui 'A' e 'a', eu implementei que deveria retornar falso, porém ele retorna true. No método de extensão que verifica a repetição de caracteres, deixei comentado qual seria a minha solução para esse problema (caso os caracteres maiúsculos e minúsculos contem como caracteres repetidos).

O método HasCharRepetitionVerifier tem um problema de otimização, pois ele verifica a mesma combinação duas vezes. Ex: i=0,j=1 // i=1,j=0. Ainda não pensei em uma forma de solucionar esse problema.
Por fim, decidi adicionar a interface IPasswordService, pois como já havia sido implementada a injeção de depêndencia, iria reduzir ainda mais o acomplamento entre o controlador e a classe de verificação.