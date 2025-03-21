package com.freelanceaccounting.emile.ovh.View.ui.currency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.freelanceaccounting.emile.ovh.databinding.FragmentCurrencyBinding;

/**
     * CurrencyFragment view class.
     *
     * @author Emile Z.
     */

public class CurrencyFragment extends Fragment {

    private FragmentCurrencyBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CurrencyViewModel currencyViewModel =
                new ViewModelProvider(this).get(CurrencyViewModel.class);

        binding = FragmentCurrencyBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textCurrency;
        currencyViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}