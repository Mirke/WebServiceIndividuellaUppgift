## Mikael Eriksson Loggbok 

## Juni 8:e. 
Jag börjar med att skapa en Trellos Kanban board, så att jag kan komma ihåg var jag är i projektet. Då kan jag använda backloggen samt se var jag är och vad jag har gjort. HackMD använde jag för att koka ner specifikationerna från kravspecen så att jag inte missar något i dem.
Alternativt skulle man kunna använda andra program som Jira, men de här funka för mig.

## Juni 17:e.
Nästa utmaning var att skapa projektet i Intellij, sätta in Postman Endpoints och att skapa en grundlig struktur. Lade till dependencies ut efter kursens material, samt se så jag har en koppling till MySQL databasen.

## Juni 19:e.
Fyllde ut User och Address klasserna, samt lade till Member Types som en enum. Samt skrev jag en påminnelse i Trello att ENUM kan bli ett problem senare. Varför jag tänkte det var för att ENUM kanske blir behandlade annorlunda i Spring Boots jämfört med ren Java-kod.

Sedan skapade jag Controller klasser, Admin och User, lade till fem adresser i databasen. För tillfället finns det ingen koppling eller relation mellan klasserna eftersom jag från tidigare projekt kommer ihåg att sådant kan komma som problem senare. Det blir lättare att stegvis gå igenom problemen då eftersom ackumulerade problem kan bli förvirrande. Ett alternativ skulle kunna vara att skapa tester och köra dem, men eftersom jag är själv i projektet så känns det överflödigt för den projektstorlek jag handskas med.

## Juni 22:e
Dagen började jag att skapa relationer mellan klasserna och använd 'ManyToOne' till adresser. Började lägga till adress, blog, användare och poster i databasen som alltid finns där. Kravspecen tog inte upp helt vad blogposten skulle ha för egenskaper,så användare och innehåll fick bli egenskaperna. Här skulle man kunnat göra det mera förstorat och gått med datum också men det fanns inget i kravspecen så fokus blev på produktion. Repos blev också skapade i det här skedet till varje entitet.

Första riktiga utmaning och problem uppstod, Postman gav inte all information om sina egenskaper. All information var null men jag fick objekten? Jag började döpa om filer och fick det någorlunda att fungera. Men då blev det ett problem istället för andra entiteter. Hursom, efter att läst stacktrace tillräckligt många gånger, och sökt information om problemet så upptäckte jag att det dog vid MemberTypes enum typen.  Så jag testade att ändra till String-type och allt började fungera. Här skulle man kunnat hålla sig i och envisa om att använda ENUM och kolla på nätet på material, eller så kunde man ha skapat en liten klass med bara de tre alternativen. Jag valde det snabbaste att låta det vara String, eftersom det fungerar och så slösar jag inte tid på saker som kanske inte kommer fungera i slutändan. Hursom, så lärde jag mig mer om hur data.sql och schema.sql var kopplat med systemet.

Till sist för dagen gjorde jag Endpoints GET för admin och skapade service klasserna. 

## Jun 23:e
Endpoints för Admin och User kontrollerna är satta och Tomcat serverns portnummer ändras till port 8080 så det inte krockar med Keycloak.

## Jun 24-26:e

Nu blir det mycket nytt för mig, Keycloak ska mergas in i projektet och då behöver man en config fil och sätta in korrekt "settings". Det här var definitivt ett moment som var svårare än jag trodde, men enkelt när man fått det fungera. Jag valde att göra så att allt fungerade utan Keycloak först, eftersom jag tänkte att "om Keycloak är bråkar så kan jag sätta fullt fokus på den delen.

Började med dependencies och sedan med security config. Basic authentication fungerade inte som tänkt, så det blev mycket att söka runt. Sedan kollade jag på den nyare filmen om Keycloak som använde sig av OAuth2.0. Det såg svårare ut, men enklare att använda när man väl har fått converter och sådant på plats. Det mest långdragna felet och felsökning hände i det här stadiet. Om man inte riktigt vet varför det blir 403 Forbidden genom tidigare kunskap eller erfarenhet med Keycloak, så kan jag förstå att det tar tid. Eftersom jag försökte leta efter fel i koden, istället för Keycloaks lokala 8080 platform. Rollerna jag trodde att jag satte för användare och admin var egentligen för realm och inte client. Det här tog mig ett tag och förstå, eftersom logiskt sätt för mig är att man visar alla alternativ man har att välja mellan först, och sedan filtrera bort det man inte behöver. Men här har de bestämt att filtrera alternativen mellan antingen realm eller client, och då självklart filtrera bort client i första hand. 

Nu när rollerna fungerar som tänkt så kan jag påbörja att testa och köra i Postman samt se om något är trasigt.

Men, från ingenstans, bestämmer sig Keycloak för att dö och ge upp. Hur än jag startar, så får den en error och Stack Trace hjälper inte. Det finns inte mycket information online om problemet heller. Även om jag tar bort, och sedan börjar om från nytt så fungerar det inte. Lösningen, Om det är fel på min dator, då kanske jag kan köra det på en annan dator. Men sådant tar för lång tid och blir väldigt omständligt, så det får bli Docker. Det fanns en Image man kunde använda sig av online från Keycloaks webbplats. Och efter lite settings och sådant så fungerar det nu.

Nu hade jag alla delar, och jag började refaktorisera det jag kände var slarvigt eller osymmetriskt uppsatt. Så vad kan alternativa lösningen vara? Fråga om hjälp antar jag, men sådant kan ta dyrbar tid, någon måste sätta sig in i ens egna projekt och det kan både vara hit and miss. Istället förlita jag på att jag kunde hitta det och det gjorde jag. Ett annat alternativ var att köra det super enkelt utan OAuth2.0 och fortsatt med BasicAuth, men varför lära sig något som inte är lika säkert när alla vill i slutändan ha det "bästa säkerheten"? 

Hursom, så är det färdigt nu, och det fungerar som tänkt och enligt kravspecen. Dock kan det finnas något jag missat, det är svagheten med att jobba själv. Två extra par ögon brukar kunna hjälpa att upptäcka tankevurpor.

Då skickar jag in det och önskar dig som läser en trevlig dag/natt!

