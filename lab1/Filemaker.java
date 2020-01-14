import java.io.*;
import java.util.*;
import java.util.Collection;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.List;
import jdk.nashorn.internal.runtime.StoredScript;
import java.nio.charset.StandardCharsets;
import java.util.GregorianCalendar;
import java.sql.Time;

public class Filemaker {

    public static List<String> readFileInList(String fileName) {

        List<String> lines = Collections.emptyList();
        try {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }

        catch (IOException e) {

            // do something
            e.printStackTrace();
        }
        return lines;
    }

    public static void CreatePeople(int amount) throws Exception {
        Random rand = new Random();
        int rand_int1;
        File firstNames = new File("firstNames.txt");
        List<String> lNameWrite = new ArrayList<String>();
        File streets = new File("streets.txt");
        List<String> CitiesW = new ArrayList<String>();
        CitiesW = readFileInList("cities.txt");
        BufferedReader firstRead = new BufferedReader(new FileReader(firstNames));
        BufferedReader streetsread = new BufferedReader(new FileReader(streets));
        String[] fNamesWrite = convertToArray(firstRead);
        String[] streetsw = convertToArray(streetsread);
        lNameWrite = readFileInList("lastNames.txt");
        String toWrite;
        int rand_int2;

        for (int i = 1; i <= amount; i++) {
            rand_int1 = rand.nextInt((int) fNamesWrite.length);
            toWrite = Integer.toString(i);
            toWrite = toWrite.concat(", " + fNamesWrite[rand_int1]);
            rand_int1 = rand.nextInt((int) lNameWrite.size());
            toWrite = toWrite.concat(" " + lNameWrite.get(rand_int1));
            toWrite = toWrite.concat(", " + RandomDate(1900));
            rand_int1 = rand.nextInt(9999) + 1;
            toWrite = toWrite.concat(", " + rand_int1 + " ");
            rand_int1 = rand.nextInt((int) streetsw.length);
            toWrite = toWrite.concat(streetsw[rand_int1]);
            rand_int1 = rand.nextInt((int) CitiesW.size());
            toWrite = toWrite.concat(", " + CitiesW.get(rand_int1));
            rand_int1 = rand.nextInt(999 - 100) + 100;
            toWrite = toWrite.concat(" " + rand_int1 + " ");
            rand_int1 = rand.nextInt(999);
            rand_int2 = (rand.nextInt(8) + 1) * 1000;
            rand_int1 += rand_int2;
            toWrite = toWrite.concat(rand_int1 + "");
            System.out.println(toWrite);

        }

    }

    public static void CreateStores(int amount) throws Exception {
        Random rand = new Random();

        File stores = new File("storenames.txt");
        File streets = new File("streets.txt");
        File cities = new File("cities.txt");
        int rand_int1 = 0;
        int rand_int2 = 0;
        BufferedReader streetsread = new BufferedReader(new FileReader(streets));
        BufferedReader storesread = new BufferedReader(new FileReader(stores));

        String Holder = new String();
        List<String> CitiesW = new ArrayList<String>();
        CitiesW = readFileInList("cities.txt");
        String[] Storesw = convertToArray(storesread);
        String toWrite = new String();
        String[] streetsw = convertToArray(streetsread);

        for (int i = 1; i <= amount; i++) {
            rand_int1 = rand.nextInt((int) Storesw.length);
            toWrite = Integer.toString(i);
            toWrite = toWrite.concat(", " + Storesw[rand_int1]);
            rand_int1 = rand.nextInt(9999);
            toWrite = toWrite.concat(", " + rand_int1 + " ");
            rand_int1 = rand.nextInt((int) streetsw.length);
            toWrite = toWrite.concat(streetsw[rand_int1]);
            rand_int1 = rand.nextInt((int) CitiesW.size());
            toWrite = toWrite.concat(", " + CitiesW.get(rand_int1));
            rand_int1 = rand.nextInt(999 - 100) + 100;
            toWrite = toWrite.concat(" " + rand_int1 + " ");
            rand_int1 = rand.nextInt(999);
            rand_int2 = (rand.nextInt(8) + 1) * 1000;
            rand_int1 += rand_int2;
            toWrite = toWrite.concat(rand_int1 + "");
            System.out.println(toWrite);

        }
        storesread.close();
        streetsread.close();

    }

    public static String[] convertToArray(BufferedReader converted) throws Exception {
        String Holder = converted.readLine();
        String[] arrayReturn = Holder.split(", ");
        return arrayReturn;
    }

    public static void SaleMaker(int amount) {
        String holder;
        Random rand = new Random();
        int rand_int1;
        // contain ID, date, time, storeID, customerID.
        for (int i = 1, j = 1000; i <= amount; i++, j--) {
            holder = Integer.toString(i);
            holder = holder.concat(", " + RandomDate(1980));
            holder = holder.concat(", " + randomTime());
            if (i > 100) {
                rand_int1 = rand.nextInt(99) + 1;
                holder = holder.concat(", " + rand_int1);
                if (j <= 0) {
                    rand_int1 = rand.nextInt(999) + 1;
                    holder = holder.concat(", " + rand_int1);
                } else {
                    holder = holder.concat(", " + j);
                }
            } else {
                holder = holder.concat(", " + i);
                holder = holder.concat(", " + j);

            }
            System.out.println(holder);
        }

    }

    public static void ProductMaker() {
        // ID, description, price.
        String holder;
        Random rand = new Random();
        int rand_int1;
        List<String> items = new ArrayList<String>();
        items = readFileInList("items.txt");

        for (int i = 1; i <= items.size(); i++) {
            holder = Integer.toString(i);
            holder = holder.concat(", " + items.get(i - 1));
            rand_int1 = rand.nextInt(100);
            holder = holder.concat(", " + rand_int1);
            rand_int1 = rand.nextInt(99);
            holder = holder.concat("." + rand_int1);
            System.out.println(holder);
        }

    }

    public static void LineItems(int amount) {
        // contain ID, salesID, productID, quantity.
        String holder;
        Random rand = new Random();
        int rand_int1;

        for (int i = 1, j = 2000; i <= amount; i++, j--) {
            holder = Integer.toString(i);
            if (i > 100) {
                if (j <= 0) {
                    rand_int1 = rand.nextInt(1999) + 1;
                    holder = holder.concat(", " + rand_int1);
                } else {
                    holder = holder.concat(", " + j);
                }
                rand_int1 = rand.nextInt(99) + 1;
                holder = holder.concat(", " + rand_int1);
            } else {
                holder = holder.concat(", " + j);
                holder = holder.concat(", " + i);

            }
            System.out.println(holder);
        }
    }

    public static String RandomDate(int min) {

        GregorianCalendar gc = new GregorianCalendar();
        String toReturn;

        int year = randBetween(min, 2020);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);

        toReturn = (gc.get(gc.YEAR) + "-" + (gc.get(gc.MONTH) + 1) + "-" + gc.get(gc.DAY_OF_MONTH));
        return toReturn;

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }

    public static Time randomTime() {
        final Random random = new Random();
        final int millisInDay = 24 * 60 * 60 * 1000;
        Time time = new Time((long) random.nextInt(millisInDay));
        return time;
    }

    public static void main(String[] args) {
        try {
            // CreateStores(100);
            // CreatePeople(1000);
            // SaleMaker(2000);
            //ProductMaker();
            LineItems(4000);

        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}