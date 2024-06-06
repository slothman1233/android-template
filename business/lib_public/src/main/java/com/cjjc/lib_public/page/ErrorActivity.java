package com.cjjc.lib_public.page;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.cjjc.lib_public.R;
import com.cjjc.lib_public.common.router.ARouterPathPublic;

@Route(path = ARouterPathPublic.APP_PUBLIC.ERROR_ACTIVITY)
public class ErrorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
    }
}