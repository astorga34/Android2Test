package astorga.android2test.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import astorga.android2test.R;
import astorga.android2test.classes.AsyncImages;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;
    private List<Integer> gallery ;
    private MainActivity activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = new ArrayList<Integer>();
        gallery.add(R.drawable.a1);
        gallery.add(R.drawable.a2);
        gallery.add(R.drawable.a3);
        gallery.add(R.drawable.a4);
        gallery.add(R.drawable.a5);
        gallery.add(R.drawable.a6);


        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher1);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                return new ImageView(MainActivity.this);
            }
        });
        activity= this;
        Button btn = (Button)findViewById(R.id.btn_empezar);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AsyncImages timer = new AsyncImages(activity.gallery,activity,imageSwitcher);
                timer.execute();
            }
        });
        // Set animations

        // https://danielme.com/2013/08/18/diseno-android-transiciones-entre-activities/
        //Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        //Animation fadeOut = AnimationUtils.loadAnimation(this, R.anim.fade_out);
        //imageSwitcher.setInAnimation(fadeIn);
        //imageSwitcher.setOutAnimation(fadeOut);
        Animation slideUp = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        imageSwitcher.setInAnimation(slideDown);
        imageSwitcher.setOutAnimation(slideUp);
    }


}
