import edu.escuelaing.arep.app.APIConnection;

import java.io.IOException;

public class ThreadTest extends Thread{

    private final String title;
    private String response;
    public ThreadTest(String title){
        super();
        this.title = title;
    }

    @Override
    public void run(){
        try {
            response = APIConnection.requestTitle(title);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getResponse(){
        return response;
    }

    public String getTitle(){
        return title;
    }
}
