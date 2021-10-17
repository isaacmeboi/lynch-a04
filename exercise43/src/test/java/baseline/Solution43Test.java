package baseline;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneratorTest {


    //Test to make sure createWebsite works.
    @Test
    void createWebsite_works() {

        generator ca = new generator();

        ca.path = "src/main/java/ex43/";
        ca.siteName = "testwebsite.com";
        ca.author = "Jose Valencia";

        String expected = "src/main/java/ex43/testwebsite.com";
        String actual = ca.createWeb();


        assertEquals(expected, actual);

    }

    //Test to make sure createJSFolder works.
    @Test
    void createJSFolder_works() {

        generator ca = new generator();

        ca.path = "src/main/java/ex43/";
        ca.siteName = "testwebsite.com";
        ca.author = "Jose Valencia";

        String expected = "src/main/java/ex43/testwebsite.com/js";
        String actual = ca.createJS();

        assertEquals(expected, actual);

    }

    //Test to make sure createCSFolder works.
    @Test
    void createCSSFolder_works() {

        generator ca = new generator();

        ca.path = "src/main/java/ex43/";
        ca.siteName = "testwebsite.com";
        ca.author = "Jose Valencia";

        String expected = "src/main/java/ex43/testwebsite.com/css";
        String actual = ca.createCSS();

        assertEquals(expected, actual);

    }

    //Test to make sure createHTML works.
    @Test
    void createHTMl_works() {

        generator ca = new generator();

        ca.path = "src/main/java/ex43/";
        ca.siteName = "testwebsite.com";
        ca.author = "Jose Valencia";

        String expected = "src/main/java/ex43/testwebsite.com/index.html";
        String actual = ca.createHTMl();

        assertEquals(expected, actual);

    }
}