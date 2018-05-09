package com.example.android.orc2word;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.vision.Frame;
import com.google.android.gms.vision.text.TextBlock;
import com.google.android.gms.vision.text.TextRecognizer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.text);
        final Button button = findViewById(R.id.button);
        final TextRecognizer detector = new TextRecognizer.Builder(getApplicationContext()).build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!detector.isOperational()){
                    textView.setText("detector is not online");
                }

                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.forget);
                Frame frame = new Frame.Builder().setBitmap(bitmap).build();
                SparseArray<TextBlock> text = detector.detect(frame);

                for (int i = 0; i<text.size(); i++){

                    TextBlock textBlock = text.valueAt(i);
                    button.setText("yo whats up");
                    textView.setText(textBlock.getValue());
                }

            }
        });
    }
}
