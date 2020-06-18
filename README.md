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


### Spustenie aplikacie lokalne
1. v adresari projektu treba vykonat v prikazovom riadku prikaz: ``docker-compose up`` (treba mat spusteny Docker predtym)
2. v IntelliJ treba otvorit cely adresar ako projekt a nasledne spustit server