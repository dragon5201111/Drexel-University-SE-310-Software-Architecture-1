import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Response implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> responseList = new ArrayList<>();

    public void addResponse(String response){
        this.responseList.add(response);
    }

    public List<String> getResponseList() {
        return this.responseList;
    }

    public String getFirstResponse(){
        if(responseList.isEmpty()){
            return "";
        }
        return this.responseList.get(0);
    }
}
