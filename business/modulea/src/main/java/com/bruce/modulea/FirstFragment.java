package com.bruce.modulea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.andrew.architecture.services.service.AnalyticsService3;
import com.andrew.architecture.services.service.AnalyticsService3One;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        testHiltInFragment();

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }

    @AnalyticsService3One
    @Inject
    // 测试通过xw@Provides提供的单例
    AnalyticsService3 analyticsServiceImp_b2;

    private void testHiltInFragment() {
        System.out.println("test----########################################################################\n");
        if (analyticsServiceImp_b2 == null) {
            System.out.println("test----in FirstFragment analyticsServiceImp_b2 null!");
        } else {
            System.out.println("test----in FirstFragment analyticsServiceImp_b2 AnalyticsService3 not null:" + analyticsServiceImp_b2);
            analyticsServiceImp_b2.analytics();
        }
    }
}
