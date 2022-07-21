package com.myapp;
import android.util.Log;
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

public class RNCounterManager extends SimpleViewManager<TextView> {
    public static final String REACT_CLASS = "MyCounter";
    ReactApplicationContext mCallerContext;
    TextView textView;
    Integer counter = 0;

    public final String INCREMENT = "INCREMENT";
    public final String DECREMENT = "DECREMENT";

    public RNCounterManager(ReactApplicationContext reactContext) {
        mCallerContext = reactContext;
    }

    private void updateUI() {
        Log.d("Daniel debug", "UpdateUi " + counter);
        textView.setText(String.valueOf(counter));
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public TextView createViewInstance(ThemedReactContext context) {
        textView = new TextView(context);
        textView.setText("0");
        return textView;
    }

    @Override
    public void receiveCommand(@NonNull TextView root, String commandId, @Nullable ReadableArray args) {
        super.receiveCommand(root, commandId, args);
        Log.d("Daniel debug", commandId);
        switch(commandId) {
            case INCREMENT:
                counter++;
                updateUI();
                break;
            case DECREMENT:
                counter--;
                updateUI();
                break;
        }
    }

    @ReactProp(name = "count")
    public void setCount(TextView view, @Nullable int count) {
        counter = count;
        view.setText(String.valueOf(count));
    }
}
