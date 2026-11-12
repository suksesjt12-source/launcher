package com.pcrecomp.launcher;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {

    private static final int PICK_GAME = 100;

    private TextView status;

    static {
        System.loadLibrary("pcruntime");
    }

    public native String getNativeStatus();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        LinearLayout root = new LinearLayout(this);

        root.setOrientation(LinearLayout.VERTICAL);
        root.setPadding(30, 30, 30, 30);
        root.setBackgroundColor(0xFF101522);

        TextView title = new TextView(this);

        title.setText("PC RECOMPILER");
        title.setTextSize(25);
        title.setTextColor(0xFFFFFFFF);
        title.setGravity(Gravity.CENTER);

        root.addView(title);

        Button importGame = new Button(this);

        importGame.setText("IMPORT PC GAME");

        importGame.setOnClickListener(v -> {

            Intent intent = new Intent(
                Intent.ACTION_OPEN_DOCUMENT
            );

            intent.addCategory(
                Intent.CATEGORY_OPENABLE
            );

            intent.setType("*/*");

            startActivityForResult(
                intent,
                PICK_GAME
            );
        });

        root.addView(importGame);

        status = new TextView(this);

        status.setTextColor(0xFFFFFFFF);
        status.setTextSize(15);

        status.setText(
            "Runtime: " + getNativeStatus()
        );

        root.addView(status);

        setContentView(root);
    }

    @Override
    protected void onActivityResult(
        int requestCode,
        int resultCode,
        Intent data
    ) {

        super.onActivityResult(
            requestCode,
            resultCode,
            data
        );

        if (requestCode == PICK_GAME &&
            resultCode == RESULT_OK &&
            data != null) {

            Uri game = data.getData();

            status.setText(
                "Game dipilih: " + game.getLastPathSegment()
            );
        }
    }
}
