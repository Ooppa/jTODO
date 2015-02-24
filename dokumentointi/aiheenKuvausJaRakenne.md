#  Aihemäärittely

**Aihe:** TODO-Lista. Toteutetaan järjestelmä johon käyttäjä lisää itselleen tehtäviä. Jokainen tehtävä voidaan assosioida tiettyyn kategoriaan ja tehtävän kategoria ilmenee sen väristä pääikkunan listalla. Tehtävillä on nimi, kuvaus, prioriteetti ja määräaika. Kategorioilla on nimi, kuvaus ja väri. Kun tehtävän määräaika umpeutuu sen voi nähdä suoraan listasta.

**Käyttäjät**: Pääkäyttäjä

**Pääkäyttäjän Toiminnot: **

Kategoriat:

 - Lisää uusi kategoria
 - Muokkaa kategoriaa
 - Poista kategoria

Tehtävät:

 - Lisää uusi tehtävä
 - Muokaa tehtävää
 - Assosioi tehtävä kategoriaan
 - Poista tehtävä

Järjestelmä:

 - Luo uusi tietokanta
 - Tallenna nykyinen tietokanta
 - Lataa toinen tietokanta

# Ohjelman rakenne

Ohjelman suoritus aloitetaan pakkauksesta application luokasta Application, jossa luodaan uusi TaskViewWindow (pääasiallinen UI ikkuna) ja DatabaseManager. Database manager on luokka, joka ylläpitää Database oliota, jonka DatabaseManager osaa tallentaa tiedostoon ja lukea sen sieltä. DatabaseManager myös muistaa mihin tiedostoon nykyinen tietokanta on tallennettu, joten se osaa ylikirjoittaa sen jos muutoksia tapahtuu. Lisäksi DatabaseManager osaa myös luoda tietokannasta TaskTableModel -esityksen, jota UI voi käyttää hyödykseen.

Tehtävälistan tehtävät koostuvat Task -olioista. Task olio laajentaa AbstracatListItem luokan toiminnallisuutta. AbstractListItem sisältää (String) nimen,  (string) kuvauksen, listan ali-elementeistä ja (ListItemColor) värin. Task oliolla on tämän lisäksi (Priority) Prioriteetti, (Deadline) määräaika ja (Category) kategoria. (Category) Kategoria on myös laajennettu luokasta AbstractListItem.
