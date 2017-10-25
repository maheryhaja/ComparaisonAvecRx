package mg.etech.mobile.comparaisonapplication.presentation;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import mg.etech.mobile.comparaisonapplication.R;
import mg.etech.mobile.comparaisonapplication.service.DelayServiceSA;
import mg.etech.mobile.comparaisonapplication.service.DelayServiceSAImpl;

@EActivity(R.layout.activity_test)
public class AnnotationActivity extends AppCompatActivity {

    @ViewById(R.id.txtResponse)
    TextView txtResponse;

    @ViewById(R.id.btnLancer)
    Button btnLancer;

    @Bean(DelayServiceSAImpl.class)
    DelayServiceSA delayServiceSA;

    @Click(R.id.btnLancer)
    void onLancerClicked() {
        getChiffreFromWs();
    }

    @Background
    void getChiffreFromWs() {
        int nb = delayServiceSA.getNumberFromWS(2);
        afficherChiffre(nb);
    }

    @UiThread
    void afficherChiffre(int chiffre) {
        txtResponse.setText("Le chiffre est "+chiffre);
    }

}
