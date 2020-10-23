package com.doedelhi.pankhpractice.ui.choose_assessment.science.interfaces;

import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;

import java.util.List;

public interface QuestionTypeListener {

    public void setType(int QType, String answer);

    void setAnswer(String ansId, String answer, String qid, List<ScienceQuestionChoice> list);
}
