package com.doedelhi.pankhpractice.custom.circular_progress_view;

public interface CircleViewChangeListener {

    void onPointsChanged(CircleView circleView, float points);

    void onStartTracking(CircleView circleView);

    void onStopTracking(CircleView circleView);

}