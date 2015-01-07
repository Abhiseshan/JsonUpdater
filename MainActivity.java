
import android.widget.ImageView;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

    //Json Node names
    private static final String TAG_VERSION = "current";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main;
        

        //This is the image view of the image you want to notify the user with when an upadate is avaliable
        final ImageView imageView = (ImageView)findViewById(R.id.imageview);
        
        //Since Json crashes the app when there is no internet connection, we use connection detector 
        //to check if there is a valid internet connection before starting the process.
      
        ConnectionDetector cd = new ConnectionDetector(getApplicationContext());
        boolean internet_status = cd.isConnectingToInternet();

        try {
            if (internet_status)
                new AsyncTaskParseJson(imageView).execute();
        }
        catch (Exception e) {
        }
    }
}
