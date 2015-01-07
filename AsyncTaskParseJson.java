package com.esp.screwesp;

import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import com.pkmmte.view.CircularImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hp on 02-Jan-15.
 */

public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

    private Context mContext;
    private View rootView;
    private CircularImageView cView;

    public AsyncTaskParseJson(CircularImageView circularImageView){
        //this.mContext = context;
        //this.rootView = rootView;
        this.cView = circularImageView;

    }

    static String version = "1.0.0";
    final String TAG = "AsyncTaskParseJson.java";

    // set your json string url here
    String Url = "http://techfest13.co.nf/version_control.json";

    // contacts JSONArray
    JSONArray dataJsonArr = null;

    @Override
    protected void onPreExecute() {}

    @Override
    protected String doInBackground(String... arg0) {

        try {

            // instantiate our json parser
            JsonParser jParser = new JsonParser();

            // get json string from url
            JSONObject json = jParser.getJSONFromUrl(Url);

            // get the array of users
            dataJsonArr = json.getJSONArray("Users");

            // loop through all users
            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);

                // Storing each json item in variable
                version = c.getString("version");
                //version = version.toString();

                // show the values in our logcat
                Log.e(TAG, "version: " + version);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {

        String current_version = "1.0.0";
        String server_version = AsyncTaskParseJson.return_version();
        boolean result = current_version.equals(server_version);
        Log.d("Result", "Result = " + result + " server version= " + server_version + " local version =" + current_version);

        if (!result) {
            //CircularImageView circularImageView = (CircularImageView) rootView.findViewById(R.id.circularview);
            cView.setImageResource(R.drawable.update);
        }
    }

    public static String return_version()
    {
        return version;
    }
}
