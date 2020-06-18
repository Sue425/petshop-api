## Web API
* pouzita Java 8+ (napr. Stream API)
* Spring Boot
* Spring Data (``CrudRepository, PagingAndSortingRepository``)
* Hibernate
* PostgreSQL (``1-init-schema.sql``)
* docker-compose.yml (lokalny vyvoj - databazovy kontajner)
* ``GET /api/products`` - strankovanie a mapovanie Product na ProductDto

### Bonusy
#### Dokerizacia
#### CI (CircleCI)
* jednoduche kroky, chyba vytvaranie Docker image (resp. 3 kroky - login, build, push)
* mozna optimalizacia (cacheovanie zavislosti aplikacie)
#### Admin rozhranie pre vytvaranie produktu
* aj s jednoduchymi validaciami
