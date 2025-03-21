package com.freelanceaccounting.emile.ovh.View.ui.bank;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.freelanceaccounting.emile.ovh.databinding.FragmentBankBinding;

/**
     * BankFragment view class.
     *
     * @author Emile Z.
     */

public class BankFragment extends Fragment {

    private FragmentBankBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BankViewModel bankViewModel =
                new ViewModelProvider(this).get(BankViewModel.class);

        binding = FragmentBankBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBank;
        bankViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}