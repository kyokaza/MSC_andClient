package agiletool.msc.bme.hu.agiletoolandroidclient.ui.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import agiletool.msc.bme.hu.agiletoolandroidclient.R;

import static agiletool.msc.bme.hu.agiletoolandroidclient.helper.MyLogger.logme;

public class MainActivity extends AppCompatActivity {
    private static final String api = "http://balogotthon.ddns.net/api";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logme();
    }
}
