package com.doedelhi.pankhpractice.ui.choose_assessment.science.custom_dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;

import com.doedelhi.pankhpractice.ui.choose_assessment.science.interfaces.QuestionTrackerListener;
import com.doedelhi.pankhpractice.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AssessmentTimeUpDialog extends Dialog {

    @BindView(R.id.btn_ok_time_up)
    Button btn_ok;
    Context context;
    QuestionTrackerListener questionTrackerListener;

    public AssessmentTimeUpDialog(@NonNull Context context) {
        super(context, android.R.style.Theme_Holo_Light_Dialog_NoActionBar);
        this.context = context;
        questionTrackerListener = (QuestionTrackerListener) context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.assessment_time_up_dialog);
        ButterKnife.bind(this);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        setCancelable(false);
        setCanceledOnTouchOutside(false);

    }

    @OnClick(R.id.btn_ok_time_up)
    public void closeDialog() {
//        ((Activity) context).finish();
        dismiss();
        questionTrackerListener.onSaveAssessmentClick();
    }
}

