package ae.shjcoop.facer;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

/**
 * Created by faisalkhalid on 2/20/17.
 */


public class WearConfig extends Activity {

    private GoogleApiClient mGoogleApiClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wearconfig);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        Faces adapter = new Faces(this);
        pager.setAdapter(adapter);

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addConnectionCallbacks(new GoogleApiClient.ConnectionCallbacks() {
                    @Override
                    public void onConnected(Bundle connectionHint) {

                        Log.d("test","test");
                    }
                    @Override
                    public void onConnectionSuspended(int cause) {} })
                .addOnConnectionFailedListener(new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(ConnectionResult result) {} })
                .addApi(Wearable.API)
                .build();
    }
    public void setFace(View v){
        PutDataMapRequest putDataMapReq = PutDataMapRequest.create("/background");
        putDataMapReq.getDataMap().putInt("background", v.getId());
        PutDataRequest putDataReq = putDataMapReq.asPutDataRequest();
        Wearable.DataApi.putDataItem(mGoogleApiClient, putDataReq);

        finish();

    }
}
