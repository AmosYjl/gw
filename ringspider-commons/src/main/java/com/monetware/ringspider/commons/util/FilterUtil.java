package com.monetware.ringspider.commons.util;

import java.util.*;

public class FilterUtil {
    public static HashMap<String,Object> filter(List<HashMap<String,Object>> filterList){
        Random random = new Random();
        int i;
        int randomNumber = random.nextInt(filterList.size());
        List<String> filterEffecitiveList = new ArrayList<String>();
        List<String> filterInvalidList = new ArrayList<String>();
        for(i = 0;i < randomNumber;i++){
            String effectiveNumber = (String) filterList.get(i).get("phone_number");
            filterEffecitiveList.add(effectiveNumber);
        }
        for(;i < filterList.size();i++){
            String invalidNumber = (String) filterList.get(i).get("phone_number");
            filterInvalidList.add(invalidNumber);
        }
        HashMap<String,Object> map = new HashMap<String, Object>();
        map.put("effectiveNumber",filterEffecitiveList);
        map.put("invalidNumber",filterInvalidList);
        return map;
    }
}
