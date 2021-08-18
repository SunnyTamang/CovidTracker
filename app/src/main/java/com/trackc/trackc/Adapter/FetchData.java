package com.trackc.trackc.Adapter;

import android.os.AsyncTask;
import android.util.Log;

import com.trackc.trackc.State_Wise_Filter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FetchData extends AsyncTask<Void, Void, Void> {

    String data ="";
    String dataParsed = "";
    String singleParsed ="";
    List<Date> keys = new ArrayList();
    List values = new ArrayList();
    DateFormat formatter = new SimpleDateFormat("M/d/yy");
    Map finalData = new HashMap();
    Map confirmedFinalData = new HashMap();
    Map deceasedfinalData = new HashMap();
    Map<Date, Integer> sortedMap= new LinkedHashMap<>();
    Map<Date, Integer> confirmedSortedMap= new LinkedHashMap<>();
    Map<Date, Integer> deceasedSortedMap= new LinkedHashMap<>();
    Map confirmedMap = new HashMap();
    Map deceasedMap = new HashMap();
    public static String locationSelected;

    //@RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected Void doInBackground(Void... voids) {
        try {
            //locationSelected = State_Wise_Filter.cName;

            Log.d("locationse",locationSelected);
            URL url = new URL("https://disease.sh/v3/covid-19/historical/" + locationSelected +"?lastdays=7");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while(line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONObject jsonObject = new JSONObject(data);
            //JSONArray JA = jsonObject.getJSONArray("mainland");
//            for(int i =0 ;i < JA.length(); i++){
//                JSONObject JO = (JSONObject) JA.get(i);
//                singleParsed =  "Country:" + JO.get("country") + "\n"+
//                        "Province:" + JO.get("province") + "\n"+
//                        "timeline:" + JO.get("timeline") + "\n";
////                        "Country:" + JO.get("country") + "\n";
//
//                dataParsed = dataParsed + singleParsed +"\n" ;
//
//
//            }
            JSONObject cases = jsonObject.getJSONObject("timeline");
            JSONArray casesArray = new JSONArray();
            casesArray.put(cases.get("cases"));





            for(int i = 0; i<casesArray.length();i++){
                JSONObject JO = (JSONObject) casesArray.get(i);
                //Log.d("Printing after", JO.keys().next());
            }

            Map datas = getMap(cases);


//            Map<String, String> second= new HashMap<>();
//            second.putAll(getMap(cases));
//
//            Map<String, Integer> third = new HashMap<>();
//            third.putAll((Map<? extends String, ? extends Integer>) second.values());
//
//            Log.d("third", String.valueOf(third));

            ArrayList<String> keyList = new ArrayList<String>(datas.keySet());
            ArrayList<Map> valueList = new ArrayList<>(datas.values());

            ArrayList<String> actualValue = new ArrayList<>();
            Map d = new HashMap();


//            for (int i = 0; i<valueList.size();i++){
//                d.put(valueList.get(i).keySet(), valueList.get(i).values());
//
//            }
//            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
//            d.put(new java.sql.Date(dateFormat.parse(valueList.get(0).keySet().toString()).getTime()),valueList.get(0).values());
            d.putAll(valueList.get(0));
            confirmedMap.putAll(valueList.get(1));
            deceasedMap.putAll(valueList.get(2));
            //d.entrySet();
            Log.d("value of ", String.valueOf(d.keySet()));

            ArrayList<String> newList = new ArrayList<String>(d.keySet());
            ArrayList<Integer> newDataList =  new ArrayList<>(d.values());

            ArrayList<String> confirmedNewList = new ArrayList<String>(confirmedMap.keySet());
            ArrayList<Long> confirmedNewDataList =  new ArrayList<>(confirmedMap.values());

            ArrayList<String> deceasedNewList = new ArrayList<String>(deceasedMap.keySet());
            ArrayList<Long> deceasedNewDataList =  new ArrayList<>(deceasedMap.values());


            for(int i = 0; i < newList.size(); i++){

                String sDate=newList.get(i);
                Date date1=new SimpleDateFormat("M/d/yy").parse(sDate);
                //LocalDate date2 =  LocalDate.parse(sDate1);
                //Log.d("date", String.valueOf(date1));

                DateFormat formatter = new SimpleDateFormat("M/d/yy");
                Date date3 = formatter.parse(sDate);
                finalData.put(date1, newDataList.get(i));
                confirmedFinalData.put(date1, confirmedNewDataList.get(i));
                deceasedfinalData.put(date1, deceasedNewDataList.get(i));

            }

//            Log.d("checking", String.valueOf(finalData));
//
//            TreeMap<String, Integer> toSort = new TreeMap<>();
//            TreeMap<String, Integer> toSortagain = new TreeMap<>();
//            toSort.putAll(finalData);
//            Set set = toSort.entrySet();
//            //finalData.clear();
//            //finalData.putAll(toSort);
//
//            //Log.d("toSort", String.valueOf(toSort.get(0)));
//
////            for(Map.Entry<Date, Integer> map : toSort.entrySet()){
////                finalData.clear();
////                Log.d("afterchecking", String.valueOf(map.getKey()) + String.valueOf(map.getValue()));
////                finalData.put(map.getKey(),map.getValue());
////            }
//
//            Iterator it = set.iterator();
//
//            while(it.hasNext()){
//                Map.Entry me = (Map.Entry)it.next();
//                //String key = (String) it.next();
//                //finalAgain.put(me.getKey(),me.getValue());
//                toSortagain.put(me.getKey().toString(),(Integer)me.getValue());
//                Log.d("fi", String.valueOf(me.getKey()));
//
//            }
//            finalAgain.putAll(toSort);
//            Log.d("reFinaal", String.valueOf(finalAgain));
//            Log.d("reFinaal", String.valueOf(toSort.clone()));
//
//            Set set1 = toSortagain.entrySet();
//            Log.d("reFinaal", String.valueOf(set1));
//
//
//
////            for(int j =0 ;j<newList.size();j++) {
////                Log.d("new", String.valueOf(newList.get(j)));
////            }
//
//
//
//
//
//
//
//            //This is for date format in array
//            List dateSort = new ArrayList();
//            List<String> sorted = new ArrayList();
//            for(int p =0 ;p<newList.size();p++){
//                String sDate1=newList.get(p).toString();
//                Date date1=new SimpleDateFormat("d/M/yy").parse(sDate1);
//                //LocalDate date2 =  LocalDate.parse(sDate1);
//                //Log.d("date", String.valueOf(date1));
//
//                DateFormat formatter = new SimpleDateFormat("M/d/yy");
//                Date date3 = formatter.parse(sDate1);
//                dateSort.add(date1);
//
//
//
//                //Log.d("date3", String.valueOf(formatter.format(date3)));
//                //Log.d("class", date3.getClass().toString());
//
//
//            }
//
//                DateFormat formatter = new SimpleDateFormat("M/d/yy");
//                Collections.sort(dateSort);
//            for(int p =0 ;p<newList.size();p++) {
//                sorted.add(formatter.format(dateSort.get(p)));
//
//
//            }
//            Log.d("sorted", String.valueOf(sorted));




            //Without treemap

            keys = new ArrayList(finalData.keySet());
            Collections.sort(keys, new Comparator<Date>() {
                @Override
                public int compare(Date o1, Date o2) {
                    return o1.compareTo(o2);
                }

//                @Override
//                public int compare(Integer o1, Integer o2) {
//                    return o1-o2;
//                }

            });
            //Map<Date, Integer>
            sortedMap= new LinkedHashMap<>();
            for(Date date: keys){
                sortedMap.put(date, (Integer)finalData.get(date));
                confirmedSortedMap.put(date, (Integer) confirmedFinalData.get(date));
                deceasedSortedMap.put(date, (Integer) deceasedfinalData.get(date));
            }


            Log.d("withtree", sortedMap.keySet().toString());








//            Map<Date, Integer> treeMAp = new TreeMap(d);
////            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
////            for(Map.Entry<Date, Integer> entry : treeMAp.entrySet()){
////                Log.d("tree", df.format(entry.getKey()));
////            }
//
//            //Map d= datas.values();
//            for(int j =0 ;j<keyList.size();j++){
//                Log.d("Keys", keyList.get(j));
//            }
//
//            for (int i = 0; i<valueList.size();i++){
//                actualValue.add(valueList.get(i).keySet().toString());
//                Log.d("Loop", valueList.get(i).keySet().toString());
//                Log.d("valueLoop", valueList.get(i).values().toString());
//            }
//            for (int k =0 ;k<actualValue.size();k++){
//
//                Log.d("Actual", actualValue.get(k));
//            }
//           String dates = actualValue.get(0);
//            Log.d("value of dates", String.valueOf(valueList));
////            for (ArrayList : valueList){
////                String value = entry.keySet().toString();
////            }
//
//            //Log.d("vales", valueList.keySet().toString());
//
//
////            List customerNames = (List) datas.values().stream().collect(Collectors.toList());
////            Log.d("vales", String.valueOf(customerNames.size()));



//{"country":"India","province":["mainland"],"timeline":{"cases":{"5\/11\/21":23340938},"deaths":{"5\/11\/21":254197},"recovered":{"5\/11\/21":19382642}}}
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        locationSelected=null;
        //for(int i=0; i < finalData.size();i++){
        //State_Wise_Filter..append(this.finalData.keySet().toString() + " " + this.finalData.values().toString());
        //}

        ArrayList<Integer> countData =  new ArrayList<>(sortedMap.values());
        ArrayList<Date> histDates = new ArrayList<>(sortedMap.keySet());

        ArrayList<Integer> confirmedCountData =  new ArrayList(confirmedSortedMap.values());
        //ArrayList<Date> confirmedHistDates = new ArrayList<>(confirmedSortedMap.keySet());

        ArrayList<Integer> deceasedCountData =  new ArrayList(deceasedSortedMap.values());

        for(int i=0; i < sortedMap.size();i++){
            State_Wise_Filter.recoveredCount.add(countData.get(i));
            State_Wise_Filter.historicDate.add(histDates.get(i));

            State_Wise_Filter.confirmedCount.add(confirmedCountData.get(i));


            State_Wise_Filter.deceasedCount.add(deceasedCountData.get(i));
        }

        finalData.clear();
        confirmedFinalData.clear();
        deceasedfinalData.clear();
        sortedMap.clear();
        confirmedSortedMap.clear();
        deceasedSortedMap.clear();
        confirmedMap.clear();
        deceasedMap.clear();
        Log.d("historic", histDates.toString());

    }

    private static Map getMap(JSONObject object) {
        Map<String, Object> map = new HashMap<String, Object>();

        Object jsonObject = null;
        String key = null;
        Object value = null;

        try {
            Iterator<String> keys = object.keys();
            while (keys.hasNext()) {

                key = null;
                value = null;

                key = keys.next();

                if (null != key && !object.isNull(key)) {
                    value = object.get(key);
                }

                if (value instanceof JSONObject) {
                    map.put(key, getMap((JSONObject) value));
                    continue;
                }

                if (value instanceof JSONArray) {
                    JSONArray array = ((JSONArray) value);
                    List list = new ArrayList();
                    for (int i = 0 ; i < array.length() ; i++) {
                        jsonObject = array.get(i);
                        if (jsonObject instanceof JSONObject) {
                            list.add(getMap((JSONObject) jsonObject));
                        } else {
                            list.add(jsonObject);
                        }
                    }
                    map.put(key, list);
                    continue;
                }

                map.put(key, value);

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        Log.d("Map",map.toString());
        return map;

    }
}
