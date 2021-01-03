package com.example.snackbarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btn_snackbar);
        Log.d(TAG, "onCreate: started");
        FloatingActionButton floating = (FloatingActionButton) findViewById(R.id.btn_floating);
        CoordinatorLayout layout = (CoordinatorLayout) findViewById(R.id.snackbar_layout);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(layout,"you just clicked the snack bar button", Snackbar.LENGTH_LONG);
                snackbar.show();

                    // set duration of the snack bar message

                snackbar.setDuration(10000);

                 //snack bar to show above the floating action button, option 1
                    // option 2 is to set a coordinator layout. Gives you option to swipe the snack bar

                snackbar.setAnchorView(floating);

                 // Changing the animation from fade to slide for the snack bar

                snackbar.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);

                 //set the action to be done when snack bar is displayed

                snackbar.setAction("Okay", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
            }
        });
    }
}