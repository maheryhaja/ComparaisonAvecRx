package mg.etech.mobile.comparaisonapplication.service;

import org.androidannotations.annotations.EBean;

/**
 * Created by mahery.haja on 25/10/2017.
 */
@EBean(scope = EBean.Scope.Singleton)
public class DelayServiceSAImpl implements DelayServiceSA {
    @Override
    public int getNumberFromWS(int delay) {
        try {
            Thread.sleep(delay*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return delay;
    }
}
