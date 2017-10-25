package mg.etech.mobile.comparaisonapplication;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import mg.etech.mobile.comparaisonapplication.presentation.AnnotationActivity_;
import mg.etech.mobile.comparaisonapplication.presentation.RxActivity_;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Click(R.id.btnAA)
    void gotoAnnotation() {
        AnnotationActivity_.intent(this).start();

    }

    @Click(R.id.btnRx)
    void goToRxActivity() {
        RxActivity_.intent(this).start();
    }
}
