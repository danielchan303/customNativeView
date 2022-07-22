package com.myapp;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.image.ReactImageView;

import java.util.Map;

public class RNCounterManager extends SimpleViewManager<FrameLayout> {
    public static final String REACT_CLASS = "MyCounter";
    ReactApplicationContext mCallerContext;
    FrameLayout frameLayout;
    Integer counter = 0;

    public final String INCREMENT = "INCREMENT";
    public final String DECREMENT = "DECREMENT";

    public RNCounterManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    private void updateUI() {
        Log.d("Daniel debug", "UpdateUi " + counter);
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public FrameLayout createViewInstance(ThemedReactContext context) {
        frameLayout = new MyCustomView(context);
        return frameLayout;
    }

    @Override
    public void receiveCommand(@NonNull FrameLayout root, String commandId, @Nullable ReadableArray args) {
        super.receiveCommand(root, commandId, args);
        Log.d("Daniel debug", commandId);
    }

    @ReactProp(name = "count")
    public void setCount(FrameLayout view, @Nullable int count) {
        counter = count;
    }
}
