package Question;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

public class Response implements Serializable{
    private final static long serialVersionUID = 7L;

    private final String RESPONSE_DEFAULT = "-";
    private List<String> responseList = new ArrayList<>();

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

    public void setResponseList(List<String> responseList) {
        this.responseList = responseList;
    }

    public void clearResponseList(){
        this.responseList.clear();
    }

    private Map<String, Integer> getFrequencyMap(List<String> responseList){
        Map<String, Integer> frequencyMap = new HashMap<>();
        responseList.forEach(response->{
            frequencyMap.put(response, frequencyMap.getOrDefault(response, 0) + 1);
        });
        return frequencyMap;
    }

    public boolean compare(List<String> otherResponseList){
        return this.getFrequencyMap(this.responseList).equals(this.getFrequencyMap(otherResponseList));
    }
}
