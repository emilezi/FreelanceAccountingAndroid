package com.freelanceaccounting.emile.ovh.View.ui.bank;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class BankViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public BankViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is bank fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}