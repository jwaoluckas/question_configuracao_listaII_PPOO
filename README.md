# Configuração com Singleton

Exercício de Padrões de Projeto (Lista Avaliativa II): ler o arquivo de configuração de um jogo uma única vez e deixar os dados em memória para qualquer componente consultar.

## Classes

- `ConfiguracaoJogo`: guarda os campos do `config.txt`, só com getters, e imprime tudo no `toString()`.
- `GerenciadorConfiguracao`: Singleton thread-safe (double-checked locking). Lê o arquivo só na primeira chamada de `getInstance()`.
- `Main`: simula vários componentes pedindo a configuração ao mesmo tempo, mostra que a instância é a mesma e que o arquivo foi lido uma vez.

## Como rodar

Na raiz do projeto, onde fica o `config.txt`:

```
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

O `config.txt` precisa estar na pasta de onde o comando `java` é executado.

## Histórico

Os prompts usados e os ajustes feitos em cada etapa estão no `prompt.txt`.
