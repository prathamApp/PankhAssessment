package com.doedelhi.pankhpractice.ui.content_player;

import android.annotation.TargetApi;
import android.os.Build;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.util.Locale;


public class TtsListener implements TextToSpeech.OnInitListener {
    float spRate;
    public TtsListener(float spRate) {
        this.spRate = spRate;
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            TextToSpeechCustom.textToSpeech.setLanguage(new Locale("hi", "IN"));
            TextToSpeechCustom.textToSpeech.setSpeechRate(spRate);
        } else {
            TextToSpeechCustom.textToSpeech = null;
            Toast.makeText(TextToSpeechCustom.mContext, "Failed to initialize TTS engine.",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
