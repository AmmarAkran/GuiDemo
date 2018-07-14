/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package code;

import java.io.FileReader;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.namespace.QName;

/**
 *
 * @author AMMAR
 */
@XmlRootElement(name = "settings")
public class Settings implements java.io.Serializable {
    private String inputFilePath;
    
    @XmlElement(required=true)
    public void setInputFilePath(String value) {
        this.inputFilePath = value;
    }
    
    public String getInputFilePath(){
        return this.inputFilePath;
    }
    
    public static final Settings loadSettings(String filename) {
        if (filename == null) {
            filename = "settings.cfg";
        }
        try {
            JAXBContext context = JAXBContext.newInstance(Settings.class);
            Unmarshaller u = context.createUnmarshaller();
            Settings starter = (Settings) u.unmarshal(new FileReader(filename));
            return starter;
        } catch (Exception e) {
            System.err.println(filename);
            System.exit(-1);
        }
        return null;
    }
    
    public static void storeSettings(Settings settings, String filename) {
        try {
            JAXBElement<Settings> jaxbElement = new JAXBElement(
                    new QName(Settings.class.getSimpleName()), Settings.class, settings);
            StringWriter writer = new StringWriter();
            JAXBContext context = JAXBContext.newInstance(Settings.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
            marshaller.marshal(jaxbElement, writer);
            try {
                PrintWriter out = new PrintWriter(filename, "UTF-8");
                out.println(writer.toString());
                out.close();
            } catch (Exception e) {
                System.err.println("Could not create file '" + filename + "'.");
                System.out.println(writer.toString());
            }

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
