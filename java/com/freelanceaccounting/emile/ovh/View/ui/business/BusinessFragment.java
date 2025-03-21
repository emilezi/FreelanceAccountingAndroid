package com.freelanceaccounting.emile.ovh.View.ui.business;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.freelanceaccounting.emile.ovh.databinding.FragmentBusinessBinding;

/**
     * BusinessFragment view class.
     *
     * @author Emile Z.
     */

public class BusinessFragment extends Fragment {

    private FragmentBusinessBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        BusinessViewModel businessViewModel =
                new ViewModelProvider(this).get(BusinessViewModel.class);

        binding = FragmentBusinessBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textBusiness;
        businessViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}