package cn.microdone.gesture;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button but_register,but_verfication,but_restart;
//	 static {
//	    	//System.loadLibrary("GeeMeeSDKBase");
//	    	System.loadLibrary("gnustl_shared");
//	    	System.loadLibrary("Gesture");
//	    }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);//ȥ��������
		setContentView(R.layout.activity_main);
		but_register=(Button)findViewById(R.id.but_register);
		but_verfication=(Button)findViewById(R.id.but_verfication);
		but_restart=(Button)findViewById(R.id.but_restart);
		but_register.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(MainActivity.this,RegisterActivity.class);
				startActivity(myIntent);
//				String str=LockPatternEncrypt.getOutput1(1,"123456","12345678901234567890123456789012");
//				Log.e("AESstr", str);
			}
		});
		but_verfication.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(MainActivity.this,VerificationActivity.class);
				startActivity(myIntent);
			}
		});
		but_restart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent myIntent=new Intent(MainActivity.this,RestartActivity.class);
				startActivity(myIntent);
			}
		});
	}
}
