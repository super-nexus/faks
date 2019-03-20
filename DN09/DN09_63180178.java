import java.util.Scanner;
import java.util.ArrayList;

public class DN09_63180178 {

    private static final String hashtag = "#";
    private static final String undo = "<";
    private static final String redo = ">";
    private static final String add = "+";
    private static final String remove = "-";
    private static final String slash = "/";

    private static ArrayList<ArrayList<String>> docs;
    private static ArrayList<Integer> prices;
    private static ArrayList<String> doc;
    private static ArrayList<Znak> listOFCommands;
    private static int currentIndex = -1;
    private static int znakIndex = -1;
    private static boolean reload = false;

    private static int price = 0;

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        listOFCommands = new ArrayList<Znak>();
        docs = new ArrayList<>();
        prices = new ArrayList<>();
        doc = new ArrayList<String>();
        Znak znakHolder = null;

        while (sc.hasNext()) {

            String currentCommand = sc.next();
            // System.out.println("Current command:" + currentCommand);

            if (reload) {
                znakIndex = listOFCommands.size() - 1;
                reload = false;
            }

            switch (currentCommand) {

            case hashtag:
                String text = sc.next();
                // System.out.println(text);

                if (reload) {
                    znakIndex = listOFCommands.size() - 1;
                    reload = false;
                }

                znakHolder = new Znak(currentCommand, text);
                execHashtag(znakHolder.text, doc);
                listOFCommands.add(znakHolder);
                znakIndex++;
                break;

            case add:

                if (reload) {
                    znakIndex = listOFCommands.size() - 1;
                    reload = false;
                }

                znakHolder = new Znak(currentCommand, sc.nextInt(), sc.next());
                execAdd(znakHolder.index, znakHolder.text, doc);
                listOFCommands.add(znakHolder);
                znakIndex++;
                break;

            case remove:

                if (reload) {
                    znakIndex = listOFCommands.size() - 1;
                    reload = false;
                }

                znakHolder = new Znak(currentCommand, sc.nextInt());
                execRemove(znakHolder, doc);
                // System.out.println("Hello: --> " + znakHolder.text);
                listOFCommands.add(znakHolder);
                znakIndex++;
                
                break;

            case undo:
                znakHolder = new Znak(currentCommand);
                execUndo(listOFCommands);
                break;

            case redo:
                execRedo();
                break;

            }

        }

    }

    private static void addDoc(int index, ArrayList<String> doc) {
        ArrayList<String> holder = new ArrayList<>(doc);
        docs.add(index, holder);
    }

    private static void printDoc(ArrayList<String> doc) {
        String toPrint = String.format("%d | ", price);
        boolean first = true;

        for (String s : doc) {

            if (first) {
                first = false;
            } else {
                toPrint += slash;
            }

            toPrint += s;
        }

        System.out.println(toPrint);
    }

    private static void printAList(ArrayList<String> list) {
        String toPrint = "";

        for (String s : list) {
            toPrint += s + ", ";
        }
        System.out.println(toPrint);
    }

    private static void execHashtag(String text, ArrayList<String> doc) {
        int charge = text.length();
        price += charge;
        doc.add(text);
        addDoc(currentIndex + 1, doc);
        prices.add(currentIndex + 1, charge);

        currentIndex++;
        printDoc(doc);
    }

    private static void execAdd(int index, String text, ArrayList<String> doc) {
        int charge = text.length() + 2 * ((doc.size()) - index);
        price += charge;

        doc.add(index, text);
        addDoc(currentIndex + 1, doc);

        prices.add(currentIndex + 1, charge);
        currentIndex++;
        printDoc(doc);
    }

    private static void execRemove(Znak znak, ArrayList<String> doc) {

        String word = doc.get(znak.index);

        int charge = word.length() * 2 + ((doc.size() - 1) - znak.index) * 3;
        price += charge;

        znak.text = word;
        // System.out.println("Word: " + word);

        doc.remove(znak.index);

        addDoc(currentIndex + 1, doc);
        prices.add(currentIndex + 1, charge);

        currentIndex++;
        printDoc(doc);
    }

    private static void execUndo(ArrayList<Znak> commands) {

        reload = true;
        Znak currentZnak = commands.get(znakIndex);
        // System.out.println(Integer.toString(commands.size()) + " : " +
        // Integer.toString(currentIndex));
        ArrayList<String> prevDoc = docs.get(currentIndex - 1);

        // System.out.println(currentZnak.toString());
        // printAList(commands);

        switch (currentZnak.type) {

        case hashtag:
            price += currentZnak.text.length();
            break;

        case add:
            price += currentZnak.text.length() * 2 + ((doc.size() - 1) - currentZnak.index) * 3;
            break;

        case remove:
            //System.out.println(currentZnak.text);
            price += currentZnak.text.length() + ((doc.size()) - currentZnak.index) * 2 - 1;
            break;
        }

        znakIndex--;
        currentIndex--;
        if (currentIndex == -1) {
            doc = new ArrayList<>();
        } else {
            doc = new ArrayList<>(docs.get(currentIndex));
        }
        printDoc(docs.get(currentIndex));
    }

    private static void execRedo() {
        currentIndex++;
        price += prices.get(currentIndex);
        printDoc(docs.get(currentIndex));
    }

}

class Znak {

    public int index = -1;
    public String type;
    public String text = null;

    public Znak(String type, int index, String text) {
        this.type = type;
        this.index = index;
        this.text = text;
    }

    public Znak(String type, int index) {
        this.type = type;
        this.index = index;
    }

    public Znak(String type, String text) {
        this.text = text;
        this.type = type;
    }

    public Znak(String type) {
        this.type = type;
    }

    public String toString() {

        String toReturn = "Type: " + type;
        if (index != -1) {
            toReturn += "\nIndex: " + Integer.toString(index);
        }
        if (text != null) {
            toReturn += "\nText: " + text;
        }
        return toReturn;
    }
}