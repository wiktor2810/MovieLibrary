package com.szymanowski;

import com.fasterxml.jackson.xml.XmlMapper;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;

public class FirstTest {

    File file2;
    XmlMapper mapper2;
    Movie[] myObjects;

    @BeforeClass
    public void setUp(){
        file2 = new File("src\\main\\java\\com\\szymanowski\\movies.xml\\");
        mapper2 = new XmlMapper();
        myObjects = null;

        try {
            myObjects = mapper2.readValue(file2, Movie[].class);
        } catch (java.io.IOException f) {
            f.printStackTrace();
        }

    }
    @Test
    public void shouldReadObject(){

        Movie movie = myObjects[1];
        Assert.assertNotNull(movie);
    }

    @Test
    public void shouldShowActors(){

        MenuMethods menuMethods = new MenuMethods();
        menuMethods.showTitles(myObjects);

    }
}
