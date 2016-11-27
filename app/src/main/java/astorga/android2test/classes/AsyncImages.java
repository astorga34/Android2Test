package astorga.android2test.classes;

import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import astorga.android2test.activities.MainActivity;

/**
 * Created by ASTORGA on 27/11/2016.
 */

public class AsyncImages extends AsyncTask<Void,Integer,Void> {
    private List<Integer> gallery;
    private ImageSwitcher imageSwitcher;
    private MainActivity activity;
    private static final String TAG = "AsyncImages";

    public AsyncImages(List<Integer> gallery,MainActivity activity,ImageSwitcher imageSwitcher)
    {
        this.gallery = new ArrayList<Integer>();
        for(Integer c: gallery)
        {
            this.gallery.add(new Integer(c));
        }
        this.activity = activity;
        this.imageSwitcher = imageSwitcher;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(activity,"El proceso termino", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        //super.onProgressUpdate(values);
        this.imageSwitcher.setImageResource(values[0]);

    }

    @Override
    protected void onCancelled(Void aVoid) {
        super.onCancelled(aVoid);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected Void doInBackground(Void... lists) {
        for(Integer i:this.gallery)
        {
            Log.i(TAG,"Mostrando imagen con id: "+ i);
            publishProgress(i);
            try{
                Thread.sleep(3000);
            }
            catch (Exception e)
            {
                Log.e(TAG,"Ocurrio un error dentro del AsyncClass",e);
            }

        }
        return null;
    }
}
