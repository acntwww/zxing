package com.zxing;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.view.SurfaceView;

import com.google.zxing.Result;
import com.google.zxing.client.android.AutoScannerView;
import com.google.zxing.client.android.BaseCaptureActivity;

public class MainActivity extends BaseCaptureActivity {

    SurfaceView surfaceView;

    AutoScannerView autoScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        autoScannerView = (AutoScannerView) findViewById(R.id.autoscanner_view);
    }

    @Override
    public SurfaceView getSurfaceView() {
        return (surfaceView == null) ? (SurfaceView) findViewById(R.id.preview_view) : surfaceView;
    }

    @Override
    public void dealDecode(Result result, Bitmap bitmap, float v) {
        //Log.i(TAG, "dealDecode ~~~~~ " + rawResult.getText() + " " + barcode + " " + scaleFactor);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                reScan();
            }
        }, 3000);
        playBeepSoundAndVibrate(true, false);
    }

    @Override
    protected void onResume() {
        super.onResume();
        autoScannerView.setCameraManager(cameraManager);
    }
}
