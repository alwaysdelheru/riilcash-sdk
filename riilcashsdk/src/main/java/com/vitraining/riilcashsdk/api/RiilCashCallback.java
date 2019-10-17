package com.vitraining.riilcashsdk.api;

public interface RiilCashCallback {
    void onSuccess(String response);
    void onError(String response);
}
