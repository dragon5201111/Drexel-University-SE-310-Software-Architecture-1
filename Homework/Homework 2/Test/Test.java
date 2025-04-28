import Menu.Survey.SurveyMenu;
import Question.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Response r1 = new Response();
        r1.addResponse("foo");
        r1.addResponse("foo2");

        Response r2 = new Response();
        r2.addResponse("foo2");
        r2.addResponse("foo");

        System.out.println(r1.compare(r2.getResponseList()));
    }
}
