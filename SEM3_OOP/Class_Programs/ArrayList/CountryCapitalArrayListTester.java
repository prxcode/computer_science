import java.util.ArrayList;
import java.util.Scanner;

public class CountryCapital {
    private String country;
    private String capital;

    public CountryCapital(String c1, String c2) {
        country = c1;
        capital = c2;
    }

    public String getCountry() {
        return country;
    }

    public String getCapital() {
        return capital;
    }
}

class CountryCapitalList {
    private ArrayList<CountryCapital> ccList;

    public CountryCapitalList() {
        ccList = new ArrayList<CountryCapital>();
    }

    public void add(String c1, String c2) {
        CountryCapital cc = new CountryCapital(c1, c2);
        ccList.add(cc);
    }

    public String searchCapital(String country) {
        for (CountryCapital cc : ccList) {
            if (cc.getCountry().equals(country)) {
                return cc.getCapital();
            }
        }
        return "";
    }

    public void display() {
        for (CountryCapital cc : ccList) {
            System.out.println("Country: " + cc.getCountry() + ", Capital: " + cc.getCapital());
        }
    }
}

public class CountryCapitalArrayListTester {
    public static void main(String[] args) {
        CountryCapitalList alist = new CountryCapitalList();
        alist.add("UAE", "Abu Dhabi");
        alist.add("India", "New Delhi");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a country name: ");
        String inputCountry = sc.nextLine();

        String result = alist.searchCapital(inputCountry);
        if (!result.equals("")) {
            System.out.println("The capital of " + inputCountry + " is: " + result);
        } else {
            System.out.println("Country not found.");
        }

        System.out.println("\nAll country-capital entries:");
        alist.display();
    }
}
