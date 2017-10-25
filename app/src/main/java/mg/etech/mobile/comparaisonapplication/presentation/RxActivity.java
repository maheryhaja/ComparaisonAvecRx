package mg.etech.mobile.comparaisonapplication.presentation;

import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import mg.etech.mobile.comparaisonapplication.R;
import mg.etech.mobile.comparaisonapplication.service.DelayServiceSA;
import mg.etech.mobile.comparaisonapplication.service.DelayServiceSAImpl;

@EActivity(R.layout.activity_test)
public class RxActivity extends AppCompatActivity {

    @ViewById(R.id.txtResponse)
    TextView txtResponse;

    @ViewById(R.id.btnLancer)
    Button btnLancer;

    @Bean(DelayServiceSAImpl.class)
    DelayServiceSA delayServiceSA;

    @Click(R.id.btnLancer)
    void onLancerClicked() {


        Observable
                .interval(5, TimeUnit.SECONDS) // on appelle tous les 5 seconde
                .map(aLong -> delayServiceSA.getNumberFromWS(2))
                .filter(valeur -> valeur > 10)   // on filtre la valeur
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(integer -> txtResponse.setText("Le chiffre est (Rx) " + integer));

    }

}
