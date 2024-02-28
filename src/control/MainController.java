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
        List<Person> newList = new List<>();
        while (!allPersons.isEmpty()) {
            allPersons.toFirst();
            Person min = allPersons.getContent();
            while (allPersons.hasAccess()) {
                if (allPersons.getContent().getName().compareTo(min.getName()) < 0) {
                    min = allPersons.getContent();
                }
                allPersons.next();
            }

            allPersons.toFirst();
            while (allPersons.hasAccess() && !allPersons.getContent().getName().equals(min.getName())) {
                allPersons.next();
            }
            newList.append(min);
            allPersons.remove();
        }

        allPersons = newList;
    }

    public void sortList(){
        //TODO 02: Schreibe einen Sortieralgorithmus
        List<Person> newList = new List<>();

        allPersons.toFirst();
        while (!allPersons.isEmpty()) { //This would also work: (allPersons.hasAccess)
            Person current = allPersons.getContent();
            newList.toFirst();
            while (newList.hasAccess() && newList.getContent().getName().compareTo(current.getName()) < 0) {
                newList.next();
            }
            if (newList.hasAccess()) {
                newList.insert(current);
            } else {
                newList.append(current);
            }

            allPersons.remove(); //allPersons.next()
        }

        allPersons = newList;
    }



}
