package com.freelanceaccounting.emile.ovh.View.ui.client;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ClientViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ClientViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is FreelanceAccounting fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}