
import android.app.Fragment;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;

import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by hp on 02-Jan-15.
 */

public class AsyncTaskParseJson extends AsyncTask<String, String, String> {

    private ImageView iView;

    public AsyncTaskParseJson(ImageView imageView){
        //this.mContext = context;
        //this.rootView = rootView;
        this.iView = imageView;

    }

    //Default value for server version
    static String server_version = "1.0.0";
    
    final String TAG = "AsyncTaskParseJson.java";

    // URL to get version_control JSON - replace with web address
    String url = "http://x.com/version_control.json";


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
            dataJsonArr = json.getJSONArray("Version");

            // loop through all users
            for (int i = 0; i < dataJsonArr.length(); i++) {

                JSONObject c = dataJsonArr.getJSONObject(i);

                // Storing each json item in variable
                server_version = c.getString("current");

                // show the values in our logcat
                Log.e(TAG, "version: " + server_version);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String strFromDoInBg) {

        //Local app version
        String current_version = "1.0.0";
        
        //Compare version - Local version and server version
        boolean result = current_version.equals(server_version);
        
        Log.d("Result", "Result = " + result + " server version= " + server_version + " local version =" + current_version);

        //If the versions dont match, put your code to notify user about the update
        //In my app this shows an image
        if (!result) {
            iView.setImageResource(R.drawable.update);
        }
    }
}
