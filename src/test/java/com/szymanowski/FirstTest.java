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


        //then
        Movie movie = myObjects[1];
        Assert.assertNotNull(movie);
    }

    @Test
    public void shouldShowActors(){

        //given
        MenuMethods menuMethods = new MenuMethods();

        //when
        menuMethods.showTitles(myObjects);

    }
}
