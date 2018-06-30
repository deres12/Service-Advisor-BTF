package it.btf.prove;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.*;

public class TestLuogo {

    public static void main(String[] args)
    {
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println(result);

        Map<String, String> vars2 = new HashMap<>();

        vars2.put("address", "277 Bedford Avenue, Brooklyn, NY 11211, USA");
        vars2.put("sensor", "false");
        vars2.put("key","AIzaSyCO86P-aWvq0wCdj6rSwVYF7jdbqAV3F4s");
        String result2 = restTemplate
                .getForObject(
                        "https://maps.googleapis.com/maps/api/geocode/json?address={address}&sensor={sensor}&key={key}",
                        String.class, vars2);
        //System.out.println(result2);
        ObjectMapper mapper = new ObjectMapper();
        Map<String,Object> map=null;
        try {
            map = mapper.readValue(result2, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if(map.get("status").equals("OK")){
            //System.err.println("RULTATO OK...");
            LinkedHashMap prova2=(LinkedHashMap)((LinkedHashMap)((LinkedHashMap)((ArrayList) map.get("results")).get(0)).get((Object) "geometry")).get((Object)"location");
            Double latit;
            Double longit;
            latit=(Double) prova2.get("lat");
            longit=(Double) prova2.get("lng");
            //System.err.println("LATITUDINE=====>"+latit);
            //System.err.println("LONGITUDINE=====>"+longit);

        }


    }
}
