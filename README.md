# Pokédex
Pokédex erstellt im Rahmen der Lehrveranstaltung "Internettechnologien".

Wichtig: branch "master" ist für die lokale Ausführung gedacht, während "frontend" den öffentlichen Zugriff.

## Inhaltsverzeichnis

- [Überblick](#überblick)
- [Technologien](#technologien)
- [Verwendung](#verwendung)
- [API-Dokumentation](#api-dokumentation)

## Überblick

Es werden Pokémons dargestellt und ihre Eigenschaften. Es besteht die Möglichkeit nach einem bestimmten Pokémon zu suchen sowie die Möglichkeit den Besitz des Pokémons abzuspeichern. Außerdem können die Namen der Pokémons in verschiedene Sprachen ausgegeben werden.

## Technologien

Liste der verwendeten Technologien und Frameworks:
- Frontend: React, Bootstrap
- Backend: Java, Spring
- Datenbank: MySql
- Weitere Tools: Postman, MySql Workbench

## Verwendung

Anwendung starten und verwenden:
https://astonishing-manatee-fd2785.netlify.app/

Hinweis:
- Die Cloud DB ist über AWS verwaltet.
- Spring Boot Applikation über Railway.
- Frontend ist auf Netflify öffentlich zugänglich.

### Lokale Entwicklung

Um die Anwendung lokal auszuführen:
1. Datenbank vorbereiten
   - MySql aufsetzen
   - Variablen entsprechend setzen: ~\pokedex\src\main\resources\application.properties
   - @SpringBootApplication unter JsonDBApplication entkommentieren und ausführen
   - Prüfe, ob alle Daten in der DB erfolgreich persistiert wurden
   - Kommentiere @SpringBootApplication aus JsonDBApplication weg
2. Backend lokal deployen:
   - PokedexApplication ausführen (dafür müssten die Variablen der application.properties bereits gesetzt werden)
3. Frontend lokal deployen:
   - Wechsel in den Ordner "frontend" und führe mit "npm start" aus (ggf. davor noch npm build)

## API-Dokumentation

- GET "/pokedata" - gibt gebündelt alle erforderlichen Informationen zu allen Pokémons wider
- POST "/owner" - setzt "is_owned" auf true oder false
