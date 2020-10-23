package com.doedelhi.pankhpractice.ui.choose_assessment.result;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.doedelhi.pankhpractice.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import java.util.Objects;

import static com.doedelhi.pankhpractice.utilities.Assessment_Constants.SCORE_COUNT;


@EFragment(R.layout.fragment_thank_you)
public class ThankYouFragment extends Fragment {

    @ViewById(R.id.tv_name)
    TextView studentName;

    @ViewById(R.id.tv_thanks)
    TextView thanks;
    String score = "";

    public ThankYouFragment() {
        // Required empty public constructor
    }


    @AfterViews
    public void init() {
        String studName = getArguments().getString("studentName");
        score = getArguments().getString(SCORE_COUNT);
        studentName.setText(studName);

    }

    @Click(R.id.btn_ok)
    public void onOkCLick() {
        Intent intent = new Intent();
        intent.putExtra(SCORE_COUNT, score);
        Objects.requireNonNull(getActivity()).setResult(Activity.RESULT_OK, intent);
        getActivity().finish();

    }
}
