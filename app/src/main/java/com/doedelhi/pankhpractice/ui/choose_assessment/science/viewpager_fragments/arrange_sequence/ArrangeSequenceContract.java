package com.doedelhi.pankhpractice.ui.choose_assessment.science.viewpager_fragments.arrange_sequence;

import com.doedelhi.pankhpractice.domain.ScienceQuestion;
import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;

import java.util.List;

public interface ArrangeSequenceContract {

    interface ArrangeSeqPresenter {
        void setView(ArrangeSeqView view);

        void getShuffledList(ScienceQuestion scienceQuestion);
    }

    interface ArrangeSeqView {
        void setShuffledList(List<ScienceQuestionChoice> shuffledList);

    }

}
