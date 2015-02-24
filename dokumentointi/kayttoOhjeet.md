# Käyttöohjeet

Tervetuloa käyttämään jTODO tehtävälistaa, joka on kokonaan toteutettu Javalla.

## Käynnistys

### Windows
Voit käynnistää ohjelman helposti klikkaamalla jar-tiedostoa.

### Linux
Mikäli olet Linuxilla saatat joutua antamaan tiedostolle suoritusoikeudet.
Tämä toimii helpoti painamalla tiedosta oikealla hiiren näppäimellä ja valitsemalla "Properties", sitten avaa "Permissions" välilehti ja varmista, että olet ruksittanut kohdan "Execute: Allow executing file as a program." kohdan.

Tämä voidaan myäs suorittaa komentoriviltä komennolla:
```
sudo chmod +x /polku/tiedostoon/jTODO.jar
```

## Ensimmäinen tehtävä

Kun olet käynnistänyt sovelluksen pääset lisäämään ensimmäisen tehtävän tietokantaan. Paina vasemmasta alareunasta nappia, jossa on + merkki ja teksti "New Task". Uudessa juuri avautuneessa ikkunassa voit asettaa tehtävälle nimen, kuvauksen, prioriteetin ja määräajan. Kun olet valmis paina "Save Task" ja tehtävä ilmestyy pääikkunaan.

## Tehävän muokkaus ja poisto

Voit muokata tehtävää tai poistaa sen painamalla sitä pääikkunan listasta oikealla hiiden näppäimellä ja valitsemalla joko "Edit..." tai "Delete...".

Mikäli valitsit "Edit...", niin sinulle aukeaa uuden tehtävän luonnin kaltainen ikkuna, jossa voit muokata tehtävää. Kun olet valmis, paina vain "Save Task".

## Kategorian lisääminen, muokkaaminen ja poistaminen

Voit lisätä uusia kategorioita joko pääikkunan "Categories" -välilehden alta painamalla "New Category" tai menemällä kategorioiden hallintaan painamalla "View Categories" ja valitsemalla sieltä "Add Category". Kun uuden kategorian luonti ikkuna on avautunut voit  antaa siinä sille nimen, kuvauksen ja värin (joka näkyy pääikkunan listassa).

Voi muokata juuri lisättyä kategoriaa valitsemalla sen "View Categories" -ikkunan listasta ja painamalla nappia, jossa lukee "Edit Category". Sinulle avautuu uusi ikkuna, joka muistuttaa uuden kategorian luontiin käytettyä ikkunaa. Käytä muokkaus -ikkunaa samalla lailla kuin luonti -ikkunaa ja paina "Save Category", nappia kun olet valmis.

Voit poistaa juuri lisätyn kategorian valitsemalla sen "View Categories" -ikkunan listasta ja painamalla nappia, jossa on punainen ruksi.

## Kategorian liittäminen tehtävään

Kun olet luonut tehtävän ja kategorian voit lisätä tehtävän kategoriaan menemällä pääikkunaan, painamalla tehtävää jonka halua lisätä kategoriaan oikealla näppäimellä ja valitsemalla "Set Category" listan alta haluamasi kategoria.

Voit myös valita samaisen kategorialistan alta kohdan "Default", joka valitsee tehtävälle tyhjän oletuskategorian.

## Tietokannan luonti, tallennus ja lataus

Voit luoda uuden tietokannan (poistaa kaikki tallentamattomat muutokset!) valitsemalla pääikkunasta löytyvän "File" -menun alta kohdan "New Tasklist". Klikattuasi sitä sinulle tulee uusi ikkuna, jossa sinun tulee valita tai luoda uusi tiedosto, johon haluat tallentaa tietokantasi. Paina vain "Open", niin ohjelma avaa tiedoston ja tekee siitä uuden tietokannan.

Voit tallentaa nykyisen tietokannan valitsemmalla edellämainitun "File" -menun alta kohdan "Save Tasklist". Mikäli olet jo luonut, ladannut tai tallentanut tämän istunnon aikana tiedoston, niin ohjelma muistaa sen ja pika-tallentaaa sen kyseiseen tiedostoon. Muutoin sinulle tulee samanlainen ikkuna kuin tietokannan luonti osiossa ja joudut valitsemaan mihin haluat tietokannan tallentaa.

Voit ladata tietokannan valitsemmalla edellämainitun "File" -menun alta kohdan "Load Tasklist". Sinulle tulee ikkuna, jossa sinun tulee valita tiedosto, johon olet tietokantasi tallentanut ja kun olet valinnut sen ja painanut "Open" avaa sovellus sen tietokannan muokattavaksi.

## Filtteröinti

Kun tehtäviä kertyy paljon alkaa niiden järjestely olla vaikeaa. Siksi ohjelmassa on filtteröinti ominaisuus. Se löytyy kätevästi pääikkunan oikeasta alareunasta sanan "Filter..." kohdalta. Paina vain sitä kohtaa ja sinulle ilmestyy kirjoitusalue johon voit kirjoittaa hakukriteerit.

Etsiessään tehtäviä filter ottaa huomioon nimen, kategorian, prioriteetin, ja määräajan päiväyksen. Eli voit hakea esimerkiksi seuraavia asioita: "12.1", "high" ja "a".

Huomaa, että filtteröinti ei ole merkkikokoriippuvainen!

## Asetukset

Sovellus on yksinkertainen ja siinä on vain kaksi asetusta: Always on top ja Autosave. Molemmat näistä löytyy pääikkunasta "Edit" välilehden alta.

Always on Top: kun tämä on aktiivinen jTODO ikkuna on aina kaikkien muiden ikkunoiden päällä, jotta et hukkaa sitä.

Autosave: kun tämä on päällä, jTODO tallentaa puolestasi aina kun jokin aiheuttaa listan päivittymisen, esimerkiksi uuden tehtävän lisäys, muokkaus jne...

Välilehden alta löytyy myös kohta "Refresh". Tällä voit pakottaa tehtävälistan päivittymisen, jos ohjelma ei sitä muuten suostu/osaa tehdä.
