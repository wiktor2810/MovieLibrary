package com.szymanowski;

        import com.fasterxml.jackson.xml.XmlMapper;
        import org.codehaus.jackson.JsonParseException;
        import org.codehaus.jackson.map.JsonMappingException;
        import org.codehaus.jackson.map.ObjectMapper;

        import java.io.File;
        import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args ) throws JsonParseException, JsonMappingException, java.io.IOException
    {

        Movie[] myObjects = null;
        String choose = "Witaj w bazie filmów, z jakiego pliku chcesz wgrać dane?" + '\n' +
                "0. JSON" + '\n' +
                "1. XML";

        System.out.println(choose);
        Scanner scanner = new Scanner(System.in);
        int firstChoice = scanner.nextInt();

        if(firstChoice == 0) {
            File file = new File("src\\main\\java\\com\\szymanowski\\movies.json\\");
            ObjectMapper mapper = new ObjectMapper();
            myObjects = mapper.readValue(file, Movie[].class);
        } else if(firstChoice == 1) {
            File file2 = new File("src\\main\\java\\com\\szymanowski\\movies.xml\\");
            XmlMapper mapper2 = new XmlMapper();
            myObjects = mapper2.readValue(file2, Movie[].class);
        } else {
            System.out.println("Zły wybór");
        }

        if(firstChoice == 0 || firstChoice == 1) {
            MenuMethods menuMethod = new MenuMethods();

            int choice = 0;

            menuMethod.greetingMethod();
            scanner.nextLine();

            String line = null;
            while (line == null) {
                line = scanner.nextLine();
                try {
                    choice = Integer.valueOf(line);
                    if (choice > 0 && choice < 7) {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println();
                }
            }
            menuMethod.switchMethod(choice, myObjects, scanner);
        }
    }
}
