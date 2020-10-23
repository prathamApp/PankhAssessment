package com.doedelhi.pankhpractice.ui.login.group_selection.fragment_child_attendance;

import com.doedelhi.pankhpractice.domain.Student;


public interface ContractChildAttendance {
    interface attendanceView {
        void childItemClicked(Student student, int position);
        void clickPhoto(String studentID, int pos);

    }
}
