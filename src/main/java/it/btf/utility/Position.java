package it.btf.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Position {
    private static Map<String, String> vars2 = new HashMap<>();
    private static String key = "AIzaSyCO86P-aWvq0wCdj6rSwVYF7jdbqAV3F4s";

    /************************
     *
     * TYPE= "lat"/"lng"
     *
     *
     *
     * **********************/
    public static Double getDoubleFromAddress(String address, String type) {
        RestTemplate restTemplate = new RestTemplate();
        //System.out.println(result);
        vars2.put("address", address);
        vars2.put("sensor", "false");
        vars2.put("key", key);
        String result2 = restTemplate
                .getForObject(
                        "https://maps.googleapis.com/maps/api/geocode/json?address={address}&sensor={sensor}&key={key}",
                        String.class, vars2);
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = null;
        try {
            map = mapper.readValue(result2, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (map != null) {
            //System.err.println(map.get("status").getClass().getName());

            if (map.get("status").equals("OK")) {
                LinkedHashMap prova2 = (LinkedHashMap) ((LinkedHashMap) ((LinkedHashMap) (((ArrayList)map.get("results")).get(0))).get("geometry")).get("location");
                //latit=(Double) prova2.get("lat");
                //longit=(Double) prova2.get("lng");
                return (Double) prova2.get(type);

            }

        }

        return 0.0;
    }

    public static void main (String[] args) throws java.lang.Exception
    {
        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "M") + " Miles\n");
        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "K") + " Kilometers\n");
        System.out.println(distance(32.9697, -96.80322, 29.46786, -98.53506, "N") + " Nautical Miles\n");
    }

    public static double distance(double lat1, double lon1, double lat2, double lon2, String unit) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2)) + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        if (unit == "K") {
            dist = dist * 1.609344;
        } else if (unit == "N") {
            dist = dist * 0.8684;
        }

        return (dist);
    }

    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }





}
