# Pratica Individual SQL - 20/07/2021

**1.) Explique o conceito de normalização e para que é usado.**

Normalização é um conjunto de regras que tem como objtivo de a organizar um projeto de banco de dados com o intuito de aumentar o desempenho, a integridado dos dados e também de diminuir a redundância de dados.

**2.) Adicione um filme à tabela de filmes.**

```sql
INSERT INTO movies (title, rating, awards, release_date, length)
VALUES ('Bacurau', 7.4, 1, '2019-08-23', 130);
```

**3.) Adicione um gênero à tabela de gêneros.**

```sql
INSERT INTO genres (created_at, name, ranking, active)
VALUES (NOW(), 'Misterio', 13, 1);
```

**4.) Associe o filme do Ex 2. ao gênero criado no Ex. 3.**

```sql
UPDATE movies
SET genre_id = (SELECT id FROM genres WHERE name = 'Misterio')
WHERE title = 'Bacurau';
```

**5.) Modifique a tabela de atores para que pelo menos um ator adicione como favorito o filme adicionado no Ex. 2**

```sql
UPDATE actors
SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'Bacurau')
WHERE id = 47;
```

**6.) Crie uma cópia temporária da tabela de filmes.**

```sql
CREATE TEMPORARY TABLE IF NOT EXISTS movies_temp AS (SELECT * FROM movies);
```

**7.) Elimine desta tabela temporária todos os filmes que ganharam menos de 5 prêmios.**

```sql
DELETE FROM movies_temp WHERE awards < 5;
```

**8.) Obtenha a lista de todos os gêneros que possuem pelo menos um filme.**


```sql
SELECT g.name, count(m.genre_id) as total_movies FROM (genres g, movies m)
WHERE g.id = m.genre_id
GROUP BY g.name
HAVING total_movies >= 1;
```

**9.) Obtenha a lista de atores cujo filme favorito ganhou mais de 3 prêmios**


```sql
SELECT CONCAT(a.first_name, ' ', a.last_name) as actor, m.title, m.awards
FROM actors a
INNER JOIN movies m
ON a.favorite_movie_id = m.id
HAVING m.awards > 3;
```

**10.) Use o plano de explicação para analisar as consultas nos Ex. 6 e 7.**

Entrada 01:
```sql
EXPLAIN ANALYZE SELECT g.name, count(m.genre_id) as total_movies FROM (genres g, movies m)
WHERE g.id = m.genre_id
GROUP BY g.name
HAVING total_movies >= 1;
```

Saida 01:
```
-> Filter: (total_movies >= 1)  (actual time=0.164..0.166 rows=8 loops=1)
    -> Table scan on <temporary>  (actual time=0.001..0.001 rows=8 loops=1)
        -> Aggregate using temporary table  (actual time=0.163..0.164 rows=8 loops=1)
            -> Nested loop inner join  (cost=10.15 rows=22) (actual time=0.035..0.060 rows=20 loops=1)
                -> Filter: (m.genre_id is not null)  (cost=2.45 rows=22) (actual time=0.026..0.032 rows=20 loops=1)
                    -> Index scan on m using movies_genre_id_foreign  (cost=2.45 rows=22) (actual time=0.023..0.030 rows=22 loops=1)
                -> Single-row index lookup on g using PRIMARY (id=m.genre_id)  (cost=0.25 rows=1) (actual time=0.001..0.001 rows=1 loops=20)
```

Entrada 02:
```sql
EXPLAIN ANALYZE SELECT CONCAT(a.first_name, ' ', a.last_name) as actor, m.title, m.awards
FROM actors a
INNER JOIN movies m
ON a.favorite_movie_id = m.id
HAVING m.awards > 3
```

Saida 02:
```
-> Filter: (m.awards > 3)  (cost=19.60 rows=49) (actual time=0.077..0.188 rows=15 loops=1)
    -> Nested loop inner join  (cost=19.60 rows=49) (actual time=0.057..0.179 rows=45 loops=1)
        -> Table scan on m  (cost=2.45 rows=22) (actual time=0.024..0.031 rows=22 loops=1)
        -> Index lookup on a using actors_favorite_movie_id_foreign (favorite_movie_id=m.id)  (cost=0.57 rows=2) (actual time=0.005..0.006 rows=2 loops=22)

```

**11.) O que são os índices? Para que servem?**

Os índices elementos são usados para localizar _rows_ com valores de coluna específicos rapidamente. 

Sem um índice, um banco de dados deve começar a leitura sequencial com a primeira _row_ e, em seguida, ler toda a tabela para encontrar as _rows_ relevantes, portanto, quanto maior a tabela, maior será o custo. Se a tabela tiver um índice para as colunas em questão, um banco de dados pode determinar rapidamente a posição a ser buscada no meio do arquivo de dados, sem ter que examinar todos os dados. Tudo isso devido a estrutura dos indices serem uma Btree e derivadas de acordo com o banco de dados em questão.


**12.) Crie um índice sobre o nome na tabela de filmes**

```sql
CREATE INDEX idx_title
ON movies (title);
```

**13.) Verifique se o índice foi criado corretamente**

```sql
SHOW INDEX FROM movies
```

Saida
| Table  | Non_unique | Key_name                | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null  | Index_type | Comment | Index_comment | Visible | Expression |
|--------|------------|-------------------------|--------------|-------------|-----------|-------------|----------|--------|-------|------------|---------|---------------|---------|------------|
| movies | 0          | PRIMARY                 | 1            | id          | A         | 21          | NULL     | NULL   |       | BTREE      |         |               | YES     | NULL       |
| movies | 1          | movies_genre_id_foreign | 1            | genre_id    | A         | 8           | NULL     | NULL   | YES   | BTREE      |         |               | YES     | NULL       |
| movies | 1          | idx_title               | 1            | title       | A         | 22          | NULL     | NULL   |       | BTREE      |         |               | YES     | NULL       |
