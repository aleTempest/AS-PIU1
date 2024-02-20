package upvictoria.pm_ene_abr_2024.iti_271164.pg1u1_eq02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MainSurfaceView mainSurfaceView;
    private Button buttonClass;
    private Button buttonLine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainSurfaceView = findViewById(R.id.surfaceview);
        buttonClass = findViewById(R.id.bt1);
        buttonLine = findViewById(R.id.bt2);

        buttonClass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the flag to indicate drawing a figure
                mainSurfaceView.setDrawingFigure(true);
                mainSurfaceView.setDrawingLine(false);
            }
        });

        buttonLine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Set the flag to indicate drawing a line
                mainSurfaceView.setDrawingFigure(false);
                mainSurfaceView.setDrawingLine(true);
            }
        });
    }
}
