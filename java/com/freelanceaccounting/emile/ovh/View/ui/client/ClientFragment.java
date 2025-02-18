package com.freelanceaccounting.emile.ovh.View.ui.client;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.freelanceaccounting.emile.ovh.databinding.FragmentClientBinding;

public class ClientFragment extends Fragment {

    private FragmentClientBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ClientViewModel clientViewModel =
                new ViewModelProvider(this).get(ClientViewModel.class);

        binding = FragmentClientBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textClient;
        clientViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}