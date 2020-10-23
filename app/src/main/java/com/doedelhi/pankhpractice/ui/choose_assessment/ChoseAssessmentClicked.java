package com.doedelhi.pankhpractice.ui.choose_assessment;

import com.doedelhi.pankhpractice.domain.AssessmentLanguages;
import com.doedelhi.pankhpractice.domain.AssessmentSubjects;
import com.doedelhi.pankhpractice.domain.AssessmentTest;

public interface ChoseAssessmentClicked {
    public void subjectClicked(int position, AssessmentSubjects nodeId);
    void languageClicked(int pos, AssessmentLanguages languages);
    void topicClicked(int pos, AssessmentTest test);
}
