# Conversor de Moedas

Este projeto é uma aplicação Java que converte valores entre diferentes moedas usando a API Exchangerate API. Ele permite obter a taxa de câmbio entre duas moedas e realizar a conversão com base em uma quantidade específica.

## Funcionalidades

- **Obter Taxa de Câmbio**: Recupera a taxa de câmbio entre uma moeda base e uma moeda de destino.
- **Conversão de Moedas**: Converte uma quantidade de uma moeda base para a moeda de destino com base na taxa de câmbio.

## Tecnologias Utilizadas

- **Java 17+**: Linguagem de programação principal.
- **Gson**: Biblioteca para manipulação e conversão de JSON.
- **Exchangerate API**: API de terceiros para recuperar as taxas de câmbio.

## Como Usar

1. **Configurar a API Key**: A API key está armazenada como uma constante `API_KEY` na classe `ConversorDeMoedasUtil`. Substitua `"3faaecc6fb2033f0e28af35f"` pela sua chave da API.

2. **Executar o Conversor**:
   - Acesse a taxa de câmbio entre duas moedas usando o método `obterTaxaDeCambio(String base, String destino)`.
   - Realize a conversão de moedas usando o método `converterMoeda(String base, String destino, double quantidade)`.

3. **Exemplo de Conversão**:

   ```java
   public class Main {
       public static void main(String[] args) {
           ConversorDeMoedasUtil.converterMoeda("USD", "BRL", 100);
       }
   }
