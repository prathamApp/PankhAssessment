package com.doedelhi.pankhpractice.ui.choose_assessment.science.interfaces;

import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;

import java.util.List;

public interface AssessmentAnswerListener {

    void setAnswerInActivity(String ansId, String answer, String qid, List<ScienceQuestionChoice> list);

    void removeSupervisorFragment();

//    void setParagraph(String para, boolean isParaQuestion);
}
