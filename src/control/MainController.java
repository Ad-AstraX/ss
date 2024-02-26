package control;

import model.List;
import model.Person;

public class MainController {

    private List<Person> allPersons;
    private String[] names = {"Alsbach", "Bachmann", "Cyrus", "Davidoff", "Eregon", "Füller","Giesehau","Halidsch","Irimoff","Zylla","Yilderim","Lupp","Schein","Xenomo","Iwan","Ali","Kötter","Kleinhans","Diablo","Overwatch","Starcraft","Warcraft","Minecraft","Krunker","Command","And","Conquer","Path","Exile","Valheim"};

    public MainController(int amount){
        allPersons = new List<>();
        for(int i = 0; i < amount; i++){
            allPersons.append(createPerson());
        }
    }

    private Person createPerson(){
        Person p = new Person(getRandomName());
        return p;
    }

    public String getRandomName(){
        return names[(int)(Math.random()*names.length)];
    }

    public String showList(){
        String output = "Ausgabe: ";
        allPersons.toFirst();
        while(allPersons.hasAccess()){
            output = output + allPersons.getContent().getName()+" ("+allPersons.getContent().getBirthdate()+"), ";
            allPersons.next();
        }
        return output;
    }

    /**
     * Schreibe einen Algorithmus zum Suchen einer Person innerhalb einer Liste. Falls die Person gefunden wurde, gib ihren Namen samt Geburtsdatum aus.
     * @param name
     * @return
     */
    public String searchList(String name){
        String output = "Nicht gefunden.";
        //TODO 01: Schreibe einen Suchalgorithmus
        allPersons.toFirst();
        while (allPersons.hasAccess()) {
            if (allPersons.getContent().getName().equals(name)) {
                return "Name: " + allPersons.getContent().getName() + ", Birthdate: " + allPersons.getContent().getBirthdate();
            }
            allPersons.next();
        }
        return output;
    }

    /**
     * Stortiere die Liste nach Namen (nicht nach Geburtsdatum!). Entscheide dich hierzu für einen Sortieralgorithmus.
     * Gib an, ob deine Umsetzung stabil ist und ob sie in-place ist.
     */
    public void sortListSelectionSort(){
        //TODO 02: Schreibe einen Sortieralgorithmus
        while (!allPersons.isEmpty()) {
            allPersons.toFirst();
            Person min = allPersons.getContent();
            while (allPersons.hasAccess()) {
                if (allPersons.getContent().getName().compareTo(min.getName()) > 0) {
                    allPersons.insert(min);
                    while (allPersons.hasAccess() && !allPersons.getContent().getName().equals(min.getName())) {
                        allPersons.next();
                    }
                    allPersons.remove();
                }
                allPersons.next();
            }
        }
    }

    public void sortListBubbleSort(){
        //TODO 02: Schreibe einen Sortieralgorithmus
        int count = 0;
        allPersons.toFirst();
        while (allPersons.hasAccess()) {
            allPersons.next();
            count++;
        }

        for (int i = 0; i < count; i++) {
            allPersons.toFirst();
            Person max = allPersons.getContent();
            Person idkMan;
            while (allPersons.hasAccess()) {
                if (allPersons.getContent().getName().compareTo(max.getName()) < 0) {
                    allPersons.next();
                    allPersons.next();
                    allPersons.setContent(max);
                }
                allPersons.next();
            }
            while (allPersons.hasAccess()) {
                if (allPersons.getContent().getName().compareTo(max.getName()) < 0) {
                    allPersons.setContent(max);
                }
                allPersons.next();
            }
        }
    }



}
