package com.doedelhi.pankhpractice.ui.choose_assessment.result;

public interface ResultContract {
    interface ResultPresenter {


        String getStudent(String studentId);

        String getSubjectName(String examId);

        String getTopicName(String examId);
    }

    interface ResultView {


    }

}
