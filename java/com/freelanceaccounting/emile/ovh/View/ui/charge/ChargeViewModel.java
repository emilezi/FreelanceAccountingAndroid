package com.freelanceaccounting.emile.ovh.View.ui.charge;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ChargeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ChargeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is charge fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}