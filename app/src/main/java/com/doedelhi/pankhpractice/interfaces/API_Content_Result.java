package com.doedelhi.pankhpractice.interfaces;

public interface API_Content_Result {

    void receivedContent(String header, String response);

    void receivedError(String header);

}
