import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.ArrayList;
import java.util.HashMap;

public class TestHttpServer extends TestCase {

    public TestHttpServer(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( TestHttpServer.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        HashMap<String, String> responses = new HashMap<>();

        ArrayList<ThreadTest> threadTests = new ArrayList<>();
        threadTests.add(new ThreadTest("The Avengers"));
        threadTests.add(new ThreadTest("Jhon"));
        threadTests.add(new ThreadTest("Spider"));
        threadTests.add(new ThreadTest("Spider Man"));
        threadTests.add(new ThreadTest("Guardians"));
        threadTests.add(new ThreadTest("Guardians of the galaxi"));
        threadTests.add(new ThreadTest("Thor"));
        threadTests.add(new ThreadTest("Blade Runner"));
        threadTests.add(new ThreadTest("Harry"));
        threadTests.add(new ThreadTest("Yesid"));
        threadTests.add(new ThreadTest("H"));

        for(ThreadTest threadTest: threadTests){
            threadTest.run();
        }
        for(ThreadTest threadTest: threadTests){
            try {
                threadTest.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        for(ThreadTest threadTest: threadTests){
            assertEquals(responses.get(threadTest.getTitle()), threadTest.getResponse());
        }
    }

    public void testApp2(){
        assertTrue(true);
    }
}
