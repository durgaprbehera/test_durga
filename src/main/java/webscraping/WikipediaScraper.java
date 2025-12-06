package webscraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.FileWriter;

public class WikipediaScraper {

    private static final List<String> blacklist = new ArrayList<>();
    private static final Pattern spamPattern = Pattern.compile("(?i)\\b(viagra|cialis|cheap drugs)\\b");

    static {
        blacklist.add("example.com"); // Add more domains to the blacklist
    }

    public static void main(String[] args) {
        String url = "https://en.wikipedia.org/wiki/Java_(programming_language)";

        try {
            Document doc = Jsoup.connect(url).get();

            // Extract the title
            String title = doc.title();
            System.out.println("Title: " + title);

            // Extract the lead paragraph
            Element leadParagraph = doc.selectFirst("p");
            System.out.println("Lead Paragraph: " + leadParagraph.text());

            // Extract links to other articles
            Elements links = doc.select("a[href]");
            System.out.println("Links:");

            // Save links to a CSV file
            saveLinksToCSV(links);

            // Save paragraph data to a CSV file
            saveParagraphToCSV(leadParagraph);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void saveLinksToCSV(Elements links) throws IOException {
        FileWriter csvWriter = new FileWriter("links.csv");
        csvWriter.append("Link\n");

        for (Element link : links) {
            String href = link.attr("href");
            if (!isBlacklisted(href) && !isSpam(link.text())) {
                csvWriter.append(href + "\n");
            }
        }

        csvWriter.flush();
        csvWriter.close();
    }

    private static void saveParagraphToCSV(Element paragraph) throws IOException {
        FileWriter csvWriter = new FileWriter("paragraph.csv");
        csvWriter.append("Paragraph\n");
        csvWriter.append(paragraph.text() + "\n");
        csvWriter.flush();
        csvWriter.close();
    }

    private static boolean isBlacklisted(String url) {
        for (String blacklistedDomain : blacklist) {
            if (url.contains(blacklistedDomain)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isSpam(String text) {
        Matcher matcher = spamPattern.matcher(text);
        return matcher.find();
    }
}