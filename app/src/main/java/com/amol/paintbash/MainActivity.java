package com.amol.paintbash;

import android.content.DialogInterface;
import android.graphics.Color;
import android.util.DisplayMetrics;
import androidx.appcompat.app.AppCompatActivity;
import android.os.*;
import android.util.Log;
import android.content.Context;
import android.widget.Toast;
import com.amol.paintbash.DrawingView;
import com.amol.paintbash.MainActivity;
import com.google.android.material.button.MaterialButton;
import android.view.View;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.itsaky.colorpicker.ColorPickerDialog;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuffer;
public class MainActivity extends AppCompatActivity {
	
	
	private DrawingView dView;
    private MaterialButton modeSelect,colorPicker;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        init();
        initListener();
         Log.i("MainActivity.java","initListener()");
       
        
        
        
    }
    
    public void init(){
        dView=findViewById(R.id.drawingView);
        modeSelect=findViewById(R.id.mModeSelect);
       
        colorPicker=findViewById(R.id.mColorPicker);
        
        
        DisplayMetrics dMetrics = new DisplayMetrics();
        
        
        
       
        getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        
        dView.init(dMetrics);
  
        
    }
    
    public void initListener(){
       modeSelect.setOnClickListener(new View.OnClickListener()
        {
            
            
            @Override
            public void onClick(View view)
            {
                
                MaterialAlertDialogBuilder mBuilder=new MaterialAlertDialogBuilder(MainActivity.this);
                mBuilder.setItems(new String[] {"Normal","Emboss","Blur","Clear"},new DialogInterface.OnClickListener()
                {
                    
                   
                     @Override
                     
                     public void onClick(DialogInterface dialog,int which)
                     {
                         
                         
                         dialog.dismiss();
                       switch(which){
                           default:
                            case 0:
                            dView.normal();
                            
                            break;
                            
                            case 1:
                            dView.emboss();
                           
                            break;
                            
                            case 2:
                            dView.blur();
                           
                            break;
                            
                            case 3:
                            dView.clear();
                           
                            break;
                            
                           }
                     }
                    
                });
                mBuilder.create().show();
                Log.i("MainActivity.java","mab");

                
           	Toast.makeText(MainActivity.this,"hello",Toast.LENGTH_SHORT).show();
                    
                    
                
        
           }
                
                
                
            
        });
          
                                
            colorPicker.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view)
                {
                    
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
                    
                    dia.setColorPickerCallback(new ColorPickerDialog.ColorPickerCallback(){
 				 @Override
				  public void onColorPicked(int color, String hexColorCode)
                   {
    				
                    dView.setColor(Color.parseColor(hexColorCode));
                    dia.dismiss();
                    
                     }
				});
                dia.show();
                
              }
                    
                    
                
                });
        dView.normal();
        
         
    }
    
    
}












