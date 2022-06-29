package com.amol.paintbash;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.*;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.amol.paintbash.BrushSettings;
import com.amol.paintbash.databinding.ActivityMainBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.slider.Slider;
import com.itsaky.colorpicker.ColorPickerDialog;

public class MainActivity extends AppCompatActivity {
  private ActivityMainBinding binding;
  private BrushSettings brushListener;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = ActivityMainBinding.inflate(getLayoutInflater());
    setContentView(binding.getRoot());

    init();
    initListener();
    
  }

  public void init() {
    
    DisplayMetrics dMetrics = new DisplayMetrics();

    getWindowManager().getDefaultDisplay().getMetrics(dMetrics);

    binding.drawingView.init(dMetrics);
    
    
  }

  public void initListener() {
    binding.brushWidth.addOnChangeListener(
        new Slider.OnChangeListener() {
          @Override
          public void onValueChange(Slider p1, float p2, boolean p3) {

            binding.drawingView.setSize(p2);
          }
        });
    binding.mModeSelect.setOnClickListener(
        new View.OnClickListener() {

          @Override
          public void onClick(View view) {

            MaterialAlertDialogBuilder mBuilder = new MaterialAlertDialogBuilder(MainActivity.this);
            mBuilder.setItems(
                new String[] {"Normal", "Emboss", "Blur", "Clear"},
                new DialogInterface.OnClickListener() {

                  @Override
                  public void onClick(DialogInterface dialog, int which) {

                    dialog.dismiss();
                    switch (which) {
                      default:
                      case 0:
                        binding.drawingView.normal();

                        break;

                      case 1:
                        binding.drawingView.emboss();

                        break;

                      case 2:
                        binding.drawingView.blur();

                        break;

                      case 3:
                        binding.drawingView.clear();

                        break;
                    }
                  }
                });
            mBuilder.create().show();
          }
        });

    binding.mColorPicker.setOnClickListener(
        new View.OnClickListener() {
          @Override
          public void onClick(View view) {

            // Alpha slider will be invisible
            ColorPickerDialog dia = new ColorPickerDialog(MainActivity.this);
            // Setters
            dia.setAlpha(255);
            dia.setRed(255);
            dia.setGreen(255);
            dia.setBlue(255);
            dia.withAlpha(true); // enables alpha slider
            dia.setCloseOnPicked(false); // Prevents closing of dialog when 'pick' is clicked

            dia.getAlpha();
            dia.getRed();
            dia.getGreen();
            dia.getBlue();
            dia.getColor(); // returns int value of current color
            dia.getHexColorCode(); // if withAlpha then with alpha hex value else without it
            dia.getHexWithAlpha();

            dia.getHexWithoutAlpha();

            dia.setColorPickerCallback(
                new ColorPickerDialog.ColorPickerCallback() {
                  @Override
                  public void onColorPicked(int color, String hexColorCode) {

                    binding.drawingView.setColor(Color.parseColor(hexColorCode));
                    dia.dismiss();
                  }
                });
            dia.show();
          }
        });
    binding.drawingView.normal();
  }
}
