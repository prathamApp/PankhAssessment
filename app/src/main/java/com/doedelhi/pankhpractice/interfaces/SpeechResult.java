package com.doedelhi.pankhpractice.interfaces;

import java.util.List;

public interface SpeechResult {


    void onResult(List<String> results);
    void onResult(String results);
}
