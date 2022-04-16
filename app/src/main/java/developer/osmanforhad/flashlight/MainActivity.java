package developer.osmanforhad.flashlight;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;
import android.hardware.Camera;


public class MainActivity extends AppCompatActivity {
    //__Define Variables__//
    ToggleButton toggleButton;
    Camera camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //__Initial variables wih XML UI Id__//
        toggleButton = (ToggleButton) findViewById(R.id.torchId);

        //__Setup Click Event in to the toggle button__//
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if(isChecked){
                    toggleButton.setBackgroundResource(R.drawable.ic_on);
                    //Open Flash Fight from Android Mobile Camera
                     camera = Camera.open();
                    Camera.Parameters p = camera.getParameters();
                    p.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
                    camera.setParameters(p);
                    camera.startPreview();
                }
                else {
                    toggleButton.setBackgroundResource(R.drawable.ic_off);
                    //Odd Flash Fight from Android Mobile Camera
                    camera.stopPreview();
                    camera.release();
                }
            }
        });

    }
}