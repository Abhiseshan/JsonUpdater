public class MainActivity extends Activity {

    //Json Node names
    private static final String TAG_VERSION = "current";

    // URL to get version_control JSON - replace with web address
    private static String url = "http://x.com/version_control.json";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main;
        
        LayoutInflater inflater = (LayoutInflater)context.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);

        View myFragmentView = inflater.inflate(R.layout.activity_main, null);

        Context cont = MainActivity.this;
        
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
