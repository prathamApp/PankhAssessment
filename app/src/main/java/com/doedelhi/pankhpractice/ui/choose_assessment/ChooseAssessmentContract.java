package com.doedelhi.pankhpractice.ui.choose_assessment;


import com.doedelhi.pankhpractice.domain.AssessmentSubjects;

import java.util.List;

public interface ChooseAssessmentContract {

    public interface ChooseAssessmentView {
        void clearContentList();

        void addContentToViewList(List<AssessmentSubjects> contentTable);

        void showNoExamLayout(boolean show);

        void notifyAdapter();

    }

    public interface ChooseAssessmentPresenter {

        public void versionObtained(String latestVersion);

        public void startActivity(String activityName);

        void copyListData();

        void clearNodeIds();

        void endSession();

//        void startAssessSession();
    }

}
