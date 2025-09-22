import java.util.Scanner;

class Article {
    String name;
    float costPrice;
    float sellingPrice;
    float lossPer;

    
    void calc_loss_per() {
        if (costPrice > 0) {
            lossPer = ((costPrice - sellingPrice) / costPrice) * 100;
        } else {
            lossPer = 0;
        }
    }

    void display() {
        System.out.println("Article Name: " + name);
        System.out.println("Cost Price: " + costPrice);
        System.out.println("Selling Price: " + sellingPrice);
        System.out.println("Loss Percentage: " + lossPer + "%");
    }


    static void find_high_loss(Article[] articles) {
        int index = 0;
        float maxLoss = articles[0].lossPer;

        for (int i = 1; i < articles.length; i++) {
            if (articles[i].lossPer > maxLoss) {
                maxLoss = articles[i].lossPer;
                index = i;
            }
        }

        System.out.println("\nArticle with Highest Loss Percentage:");
        articles[index].display();
    }
}

public class Showroom {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter number of articles: ");
        int n = sc.nextInt();
        sc.nextLine();

        Article[] articles = new Article[n];

        for (int i = 0; i < n; i++) {
            articles[i] = new Article();

            System.out.println("\nEnter details for Article " + (i + 1) + ":");
            System.out.print("Name: ");
            articles[i].name = sc.nextLine();
            System.out.print("Cost Price: ");
            articles[i].costPrice = sc.nextFloat();
            System.out.print("Selling Price: ");
            articles[i].sellingPrice = sc.nextFloat();
            sc.nextLine();

            articles[i].calc_loss_per();
        }

        
        Article.find_high_loss(articles);

        sc.close();
    }
}
