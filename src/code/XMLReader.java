/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author AMMAR
 */
public class XMLReader {
    public List<Element> sentences = new ArrayList<Element>();
    public XMLReader(String filename) throws IOException {
        String xml = "";
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            xml += scanner.nextLine();
        }
        Document doc = Jsoup.parse(xml);
        System.out.println(doc.title());
        Elements newsHeadlines = doc.select("sentence");
        for (Element element : newsHeadlines) {
            sentences.add(element);
        }
    }
}
