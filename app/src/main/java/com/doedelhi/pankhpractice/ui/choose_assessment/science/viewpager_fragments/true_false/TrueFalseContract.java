package com.doedelhi.pankhpractice.ui.choose_assessment.science.viewpager_fragments.true_false;

import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;

import java.util.List;

public interface TrueFalseContract {
    interface TrueFalsePresenter {
        void getOptions(String qid);

        void setView(TrueFalseView view);

    }

    interface TrueFalseView {
       void setOptions(List<ScienceQuestionChoice> options);
    }
}
