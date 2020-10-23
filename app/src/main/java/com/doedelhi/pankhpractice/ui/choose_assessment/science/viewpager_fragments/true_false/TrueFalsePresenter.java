package com.doedelhi.pankhpractice.ui.choose_assessment.science.viewpager_fragments.true_false;

import android.content.Context;

import com.doedelhi.pankhpractice.database.AppDatabase;
import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;

import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class TrueFalsePresenter implements TrueFalseContract.TrueFalsePresenter {
    Context context;
    TrueFalseContract.TrueFalseView trueFalseView;

    public TrueFalsePresenter(Context context) {
        this.context = context;
    }

    @Override
    public void setView(TrueFalseContract.TrueFalseView view) {
        trueFalseView = view;
    }

    @Override
    public void getOptions(String qid) {
        List<ScienceQuestionChoice> options = AppDatabase.getDatabaseInstance(context).getScienceQuestionChoicesDao().getQuestionChoicesByQID(qid);
        trueFalseView.setOptions(options);
    }


}
