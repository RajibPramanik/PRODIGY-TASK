import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.FileWriter;
import java.io.IOException;

public class WebScraper {
    public static void main(String[] args) {
        String url = "http://books.toscrape.com/catalogue/category/books_1/index.html";
        String csvFile = "products.csv";

        try (FileWriter writer = new FileWriter(csvFile)) {
            writer.append("Product Name,Price,Rating\n");

            Document doc = Jsoup.connect(url).get();
            Elements products = doc.select(".product_pod");

            for (Element product : products) {
                String name = product.select("h3 a").attr("title");
                String price = product.select(".price_color").text();
                String rating = product.select(".star-rating").attr("class").replace("star-rating", "").trim();

                writer.append(name + "," + price + "," + rating + "\n");
            }

            System.out.println("Scraping completed. Data saved to " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

