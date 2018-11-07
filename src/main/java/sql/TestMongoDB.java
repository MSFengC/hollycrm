package sql;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

import static java.util.Arrays.asList;

public class TestMongoDB {
    public static void main(String[] args){
        MongoClient mc = new MongoClient();

        MongoDatabase md = mc.getDatabase("Feng");

        MongoCollection<Document> mcl = md.getCollection("Collections");

        System.out.println(mcl);
        List<Document> documents = asList(
                new Document("name", "Sun Bakery Trattoria")
                        .append("stars", 4)
                        .append("categories", asList("Pizza", "Pasta", "Italian", "Coffee", "Sandwiches")),
                new Document("name", "Blue Bagels Grill")
                        .append("stars", 3)
                        .append("categories", asList("Bagels", "Cookies", "Sandwiches")),
                new Document("name", "Hot Bakery Cafe")
                        .append("stars", 4)
                        .append("categories", asList("Bakery", "Cafe", "Coffee", "Dessert")),
                new Document("name", "XYZ Coffee Bar")
                        .append("stars", 5)
                        .append("categories", asList("Coffee", "Cafe", "Bakery", "Chocolates")),
                new Document("name", "456 Cookies Shop")
                        .append("stars", 4)
                        .append("categories", asList("Bakery", "Cookies", "Cake", "Coffee")));

        mcl.insertMany(documents);
    }
}
