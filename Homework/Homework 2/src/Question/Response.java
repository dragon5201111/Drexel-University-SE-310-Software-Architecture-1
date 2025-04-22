package Question;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Response implements Serializable {
    private final static long serialVersionUID = 7L;

    private final String RESPONSE_DEFAULT = "-";
    private final List<String> responseList = new ArrayList<>();

    public void addResponse(String response){
        this.responseList.add(response);
    }

    public List<String> getResponseList() {
        if (responseList.isEmpty()) {
            return Collections.singletonList(RESPONSE_DEFAULT);
        }
        return responseList;
    }

    public String getFirstResponse(){
        if(responseList.isEmpty()){
            return RESPONSE_DEFAULT;
        }
        return this.responseList.get(0);
    }

    public void clearResponseList(){
        this.responseList.clear();
    }
}
