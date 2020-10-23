package com.doedelhi.pankhpractice.ui.choose_assessment.science.interfaces;

import android.support.v7.widget.RecyclerView;

import com.doedelhi.pankhpractice.domain.ScienceQuestionChoice;

import java.util.List;

public interface StartDragListener {
    void requestDrag(RecyclerView.ViewHolder viewHolder);
    void onItemDragged(List<ScienceQuestionChoice> draggedList);

}
