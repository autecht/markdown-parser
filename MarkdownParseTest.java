import static org.junit.Assert.*;
import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
public class MarkdownParseTest {
    // helper method to test getLinks on file
    public static ArrayList<String> getLinksResult(String filePath) throws IOException{
        Path path = Path.of(filePath);
        String contents = Files.readString(path);
        return MarkdownParse.getLinks(contents); 
    }

    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void testGetLinksOnOriginal() throws IOException{
        assertEquals(List.of("https://something.com", "some-thing.html"),
                 getLinksResult("test-file.md"));    
    }

    @Test
    public void testGetLinksMy2() throws IOException{
        assertEquals(List.of("https://ucsd.edu"),
                 getLinksResult("my-test-file2.md"));    
    }

    @Test
    public void testGetLinksMy3() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("my-test-file3.md"));    
    }

    @Test
    public void testGetLinksMy4() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("my-test-file4.md"));    
    }

    @Test
    public void testGetLinks2() throws IOException{
        assertEquals(List.of("https://something.com", "some-page.html"),
                 getLinksResult("test-file2.md"));    
    }

    @Test
    public void testGetLinks3() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file3.md"));    
    }

    @Test
    public void testGetLinks4() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file4.md"));    
    }

    @Test
    public void testGetLinks5() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file5.md"));    
    }

    @Test
    public void testGetLinks6() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file6.md"));    
    }

    @Test
    public void testGetLinks7() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file7.md"));    
    }

    @Test
    public void testGetLinks8() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file8.md"));    
    }

    @Test
    public void testGetLinks8fail() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file8.md"));    
    }

    @Test
    public void testGetLinks9() throws IOException{
        assertEquals(List.of(),
                 getLinksResult("test-file9.md"));    
    }

    // Lab report 4 tests
    @Test
    public void getLinksSnippet1Test() throws IOException{
        Path path = Path.of("Snippet1.md");
        String contents = Files.readString(path);
        ArrayList<String> result = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("`google.com", "google.com", "ucsd.edu");
        assertEquals(expected, result);
    }

    public void getLinksSnippet2Test() throws IOException{
        Path path = Path.of("Snippet2.md");
        String contents = Files.readString(path);
        ArrayList<String> result = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("a.com", "a.com(())", "example.com");
        assertEquals(expected, result);
    }

    public void getLinksSnippet3Test() throws IOException{
        Path path = Path.of("Snippet3.md");
        String contents = Files.readString(path);
        ArrayList<String> result = MarkdownParse.getLinks(contents);
        List<String> expected = List.of("https://sites.google.com/eng.ucsd.edu/cse-15l-spring-2022/schedule");
        assertEquals(expected, result);
    }

}