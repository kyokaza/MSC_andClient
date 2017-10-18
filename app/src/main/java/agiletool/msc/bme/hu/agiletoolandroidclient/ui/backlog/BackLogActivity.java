package agiletool.msc.bme.hu.agiletoolandroidclient.ui.backlog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.robertlevonyan.views.chip.Chip;
import com.robertlevonyan.views.chip.OnCloseClickListener;

import javax.inject.Inject;

import agiletool.msc.bme.hu.agiletoolandroidclient.AgileToolApplication;
import agiletool.msc.bme.hu.agiletoolandroidclient.R;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.BacklogStatus;
import agiletool.msc.bme.hu.agiletoolandroidclient.model.Complexity;
import butterknife.Bind;
import butterknife.ButterKnife;


public class BackLogActivity extends AppCompatActivity implements BacklogScreen {

    @Inject
    BacklogPresenter backlogPresenter;

    @Bind(R.id.backlog_detail_keywords_list)
    ViewGroup keywordsContainer;

    @Bind(R.id.backlog_detail_check_list)
    ViewGroup checkListContainer;

    @Bind(R.id.backlog_detail_keywords_input)
    EditText keywordsInput;

    @Bind(R.id.backlog_detail_check_list_input)
    EditText checkListInput;

    @Bind(R.id.backlog_detail_complexity)
    Spinner complexitySpinner;

    @Bind(R.id.backlog_detail_status)
    Spinner statusSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_log);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        AgileToolApplication.agileToolApplicationComponent.inject(this);

        keywordsInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_NULL && event.getAction() == MotionEvent.ACTION_DOWN){
                handleEnterKey(keywordsContainer, keywordsInput);

                return true;
            }else {
                return false;
            }
        });

        checkListInput.setOnEditorActionListener((v, actionId, event) -> {
            if (actionId == EditorInfo.IME_NULL && event.getAction() == MotionEvent.ACTION_DOWN){
                handleEnterKey(checkListContainer, checkListInput);

                return true;
            }else {
                return false;
            }
        });

        ArrayAdapter<CharSequence> complexityAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Complexity.values());
        complexitySpinner.setAdapter(complexityAdapter);

        ArrayAdapter<CharSequence> statusAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, BacklogStatus.values());
        statusSpinner.setAdapter(statusAdapter);

        backlogPresenter.attach(this);
        backlogPresenter.getUsers("k");
    }

    private void handleEnterKey(ViewGroup container, EditText input){
            String amiVan = input.getText().toString();

            Chip chip = new Chip(BackLogActivity.this);
            chip.setChipText(amiVan);
            chip.setClosable(true);
            chip.setOnCloseClickListener(chipItem -> {
                container.removeView(chip);
            });

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        container.addView(chip, layoutParams);
            input.setText(null);

    }
}
