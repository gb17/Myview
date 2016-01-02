package com.ryanbrooks.expandablerecyclerviewsample;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by ${GB} on 1/2/16.
 */
public class Sync {


    String PLANDATE = "";
    String BU = "";
    String TERRITORY_CODE = "";
    String TRCODE = "";
    String PATCHCODE = "";
    String PATCHNAME = "";
    String SYNCFLAG = "";
    String PCODE = "";
    String PNAME = "";
    String PTYPE = "";
    String SPCLCODE = "";
    String SPCLNAME = "";
    String CLASSCODE = "";
    String CLASSNAME = "";
    String NCACODE = "";
    String NCATYPE = "";
    String LEAVECODE = "";
    String LEAVE = "";

    String responsejs = "[{\"PLANDATE\":\"01-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124272,\"PATCHCODE\":11,\"PATCHNAME\":\"JaslokHospital\",\"SYNCFLAG\":\"N\",\"PCODE\":121576,\"PNAME\":\"Usha  Kheramani\",\"PTYPE\":\"D\",\"SPCLCODE\":124193.0,\"SPCLNAME\":\"Dermat\"},{\"PLANDATE\":\"01-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124272,\"PATCHCODE\":11,\"PATCHNAME\":\"JaslokHospital\",\"SYNCFLAG\":\"N\",\"PCODE\":121601,\"PNAME\":\"Archana  Dharan\",\"PTYPE\":\"D\",\"SPCLCODE\":124192.0,\"SPCLNAME\":\"Others\"},{\"PLANDATE\":\"01-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124272,\"PATCHCODE\":11,\"PATCHNAME\":\"Colaba\",\"SYNCFLAG\":\"N\",\"PCODE\":223955,\"PNAME\":\"New Deluxe Medi\",\"PTYPE\":\"C\",\"CLASSCODE\":124187.0,\"CLASSNAME\":\"B\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":121475,\"PNAME\":\"Ranjana  Mitra\",\"PTYPE\":\"D\",\"SPCLCODE\":124193.0,\"SPCLNAME\":\"Dermat\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":121563,\"PNAME\":\"Ashwini  Padmaw\",\"PTYPE\":\"D\",\"SPCLCODE\":124193.0,\"SPCLNAME\":\"Dermat\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":121568,\"PNAME\":\"Farhat N Mehta\",\"PTYPE\":\"D\",\"SPCLCODE\":124200.0,\"SPCLNAME\":\"Gp\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":121570,\"PNAME\":\"Sunitra D Saple\",\"PTYPE\":\"D\",\"SPCLCODE\":124193.0,\"SPCLNAME\":\"Dermat\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":121610,\"PNAME\":\"Mansukh  Ghala\",\"PTYPE\":\"D\",\"SPCLCODE\":124193.0,\"SPCLNAME\":\"Dermat\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":122131,\"PNAME\":\"D G Saple\",\"PTYPE\":\"D\",\"SPCLCODE\":124193.0,\"SPCLNAME\":\"Dermat\"},{\"PLANDATE\":\"02-12-2015\",\"BU\":2,\"TERRITORY_CODE\":124177,\"TRCODE\":124241,\"PATCHCODE\":6,\"PATCHNAME\":\"Ghatkopar\",\"SYNCFLAG\":\"N\",\"PCODE\":207528,\"PNAME\":\"United Stockist\",\"PTYPE\":\"S\"}]";

    public Sync() {


    }

    public HashMap<String, String> executeRequestforjson(final boolean DelimitersFlag) {

        // Thread t = new Thread() {
        // public void run() {
        HashMap<String, String> hashMap = null;

        JSONArray jSONArray = null;
        JSONObject jsonObject = null;


        try {
            if (DelimitersFlag) {
                jsonObject = new JSONObject(responsejs);
            } else {
                jSONArray = new JSONArray(responsejs);
//                jsonObject = jSONArray.getJSONObject(0);
            }

            try {
                for (int i = 0; i < jSONArray.length(); i++) {
                    jsonObject = jSONArray.getJSONObject(i);

                    if (!jsonObject.isNull("PLANDATE"))
                        PLANDATE = jsonObject.getString("PLANDATE");
                    if (!jsonObject.isNull("BU"))
                        BU = jsonObject.getString("BU");
                    if (!jsonObject.isNull("TERRITORY_CODE"))
                        TERRITORY_CODE = jsonObject.getString("TERRITORY_CODE");
                    if (!jsonObject.isNull("TRCODE"))
                        TRCODE = jsonObject.getString("TRCODE");
                    if (!jsonObject.isNull("PATCHCODE"))
                        PATCHCODE = jsonObject.getString("PATCHCODE");
                    if (!jsonObject.isNull("PATCHNAME"))
                        PATCHNAME = jsonObject.getString("PATCHNAME");
                    if (!jsonObject.isNull("SYNCFLAG"))
                        SYNCFLAG = jsonObject.getString("SYNCFLAG");
                    if (!jsonObject.isNull("PCODE"))
                        PCODE = jsonObject.getString("PCODE");
                    if (!jsonObject.isNull("PNAME"))
                        PNAME = jsonObject.getString("PNAME");
                    if (!jsonObject.isNull("PTYPE"))
                        PTYPE = jsonObject.getString("PTYPE");
                    if (!jsonObject.isNull("SPCLCODE"))
                        SPCLCODE = jsonObject.getString("SPCLCODE");
                    if (!jsonObject.isNull("SPCLNAME"))
                        SPCLNAME = jsonObject.getString("SPCLNAME");
                    if (!jsonObject.isNull("CLASSCODE"))
                        CLASSCODE = jsonObject.getString("CLASSCODE");
                    if (!jsonObject.isNull("CLASSNAME"))
                        CLASSNAME = jsonObject.getString("CLASSNAME");
                    if (!jsonObject.isNull("NCACODE"))
                        NCACODE = jsonObject.getString("NCACODE");
                    if (!jsonObject.isNull("NCATYPE"))
                        NCATYPE = jsonObject.getString("NCATYPE");
                    if (!jsonObject.isNull("LEAVECODE"))
                        LEAVECODE = jsonObject.getString("LEAVECODE");
                    if (!jsonObject.isNull("LEAVE"))
                        LEAVE = jsonObject.getString("LEAVE");

                    PLANDATA plandata = new PLANDATA(PLANDATE,
                            BU,
                            TERRITORY_CODE,
                            TRCODE,
                            PATCHCODE,
                            PATCHNAME,
                            SYNCFLAG,
                            PCODE,
                            PNAME,
                            PTYPE,
                            SPCLCODE,
                            SPCLNAME,
                            CLASSCODE,
                            CLASSNAME,
                            NCACODE,
                            NCATYPE,
                            LEAVECODE,
                            LEAVE);

                    plandata.save();


                }
            } catch (Exception e) {
                e.printStackTrace();
            }


            hashMap = new HashMap<String, String>();
            Iterator<String> iter = jsonObject.keys();
            while (iter.hasNext()) {
                String key = iter.next();

                Object value = jsonObject.get(key);
                hashMap.put(key, value.toString());
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


        return hashMap;
    }

}




