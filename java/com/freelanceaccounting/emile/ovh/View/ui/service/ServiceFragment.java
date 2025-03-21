package com.freelanceaccounting.emile.ovh.View.ui.service;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.freelanceaccounting.emile.ovh.databinding.FragmentServiceBinding;

/**
     * ServiceFragment view class.
     *
     * @author Emile Z.
     */

public class ServiceFragment extends Fragment {

    private FragmentServiceBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ServiceViewModel serviceViewModel =
                new ViewModelProvider(this).get(ServiceViewModel.class);

        binding = FragmentServiceBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textService;
        serviceViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}