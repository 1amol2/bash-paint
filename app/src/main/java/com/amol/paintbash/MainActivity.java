package com.amol.paintbash;

import android.content.DialogInterface;
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
import java.lang.Override;
import java.lang.String;
public class MainActivity extends AppCompatActivity {
	
	private Context ctx;
	private DrawingView dView;
    private MaterialButton modeSelect,colorPicker;
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		String str = "Amol chandra";
        
        dView=findViewById(R.id.drawingView);
        modeSelect=findViewById(R.id.mModeSelect);
       
        colorPicker=findViewById(R.id.mColorPicker);
        
        
        DisplayMetrics dMetrics = new DisplayMetrics();
        
        
        
        getWindowManager().getDefaultDisplay().getMetrics(dMetrics);
        
        dView.init(dMetrics);
        
        modeSelect.setOnClickListener(new View.OnClickListener(){
            
            @Override
            public void onClick(View v){
                
                MaterialAlertDialogBuilder mab=new MaterialAlertDialogBuilder(MainActivity.this);
                mab.setItems(new String[]{"Normal","Emboss","Blur","Clear"},new DialogInterface.OnClickListener(){
                   
                     @Override
                     public void onClick(DialogInterface d,int p){
                       switch(p){
                           default:
                            case 0:
                            dView.normal();
                            d.dismiss();
                            break;
                            
                            case 1:
                            dView.emboss();
                            d.dismiss();
                            break;
                            
                            case 2:
                            dView.blur();
                            d.dismiss();
                            break;
                            
                            case 3:
                            dView.clear();
                            d.dismiss();
                            break;
                            
                           }
                         }
                    
                    });
                    
                    mab.create().show();
           
                    
                    
                
                }
            
            });
        
        
        
        dView.normal();
        
        
        
    }
}




