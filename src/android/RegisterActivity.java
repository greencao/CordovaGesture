package cn.microdone.gesture;

import cn.geemee.lockpattern.view.GestureCallBack;
import cn.geemee.lockpattern.view.GestureContentView;
import cn.geemee.lockpattern.view.LockIndicator;
import cn.geemee.lockpattern_sdk.LockPattern;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class RegisterActivity extends Activity {
	private GestureContentView mGestureContentView;
	private LockIndicator mLockIndicator;
	private FrameLayout mGestureContainer;
	private LockPattern mLockPattern;
	private TextView text_id, text_back, text_Title;
	String str1, str2;
	String strEncryption;
	int i = 1;
	String RSA_Key = "3081890281810092d9d8d04fb5f8ef9b8374f21690fd46fdbf49b40eeccdf416b4e2ac2044b0cfe3bd67eb4416b26fd18c9d3833770a526fd1ab66a83ed969af74238d6c900403fc498154ec74eaf420e7338675cad7f19332b4a56be4ff946b662a3c2d217efbe4dc646fb742b8c62bfe8e25fd5dc59e7540695fa8b9cd5bfd9f92dfad009d230203010001";
	String AES_Key = "abcdefghijklmnopqrstuvwxyz123456";
//	String Lisence = "BBMRreRfQhX2c6hH8tqthEi584UwCg60neiBaddAOu4JCbbVuAH45tCZg397mXgnuSUVR47Bm880wi46LQ+fxq7GCXD5lQMZQOOrP3qCF1L4SMfPJY9dgys5cNK4QzvQHbOI+mWvWNWAwE2FcuvJquOBA40o/LvWy/VJqJErzpxYaTeR0jaYIJsOlrb/rLrqu0J12hwY/6JFLXiEZ4BNKckMSdtTklHIg5flTYtcgf7YS5020CI3mW2jHOafG5OUKUoXz6N/Qgg2CKiTRU/2l7+G8SAZyHU53FhhVTPxK8ONM6NE/GmfVuFdIlSMOuvQbM/gkwhLnIkeL+PM32CTngzOyNZ78Slv2xvHC+DMujc6boZ2OrtCm5cu5l2ivMp4KtIM7Qet9i4re4Pz90zkP7TsAGR5sS8CnZQVpzUYPGbO4kQA/HVyFIxXCnWi0igCsdAD1qk0zeSPubBN0TpIwefyZ5Q5Ae7hGGqU45IhgfwDEuOjjpH4+3U/dfjq119O+I2VW7gUdTbg5jwxPld3P/g6Cwm19hMxOMUMTCi3Dwo8tZHhI2JOZPLYuGnCeirDIdyRhKUDbtwVOxo/t+GVxahrF/Yu0EfDc3564pA6XxoZjDNJqxUZLwRJWZ8gjWWD2UM36IdXvlDdb8UHaTLPy78WWHk2X3PL3W/s2hf2sgS7FnqO3EHP2HcY5FjLuSNzVXmX5WyIomYoJRRtAZT1Yhg65zAaqc5meqQTIDqp8UAQcXSdoBqy0zKn3kKu0u5oobCYnRat1n9i5EkGBNDh0/wd14Ph6CtI3Up11A7Dku8ZIaoSA6nCzSfhQctmgI0HEZGOUl3tiJ6wqVAFUOCTeTWGxAIWnwFIPPK8PomO0oFPwkf2qZFsI356SEqM2WX3ulV+7kU5A/eSQ+DFXlXyhsLY1AXuj0KEqwwqy123L3bqNvTdANaUXDbUNu7PMcTI+sYJEm3ZYIR4fwEdzLicOR47mHdpSxPNRpH/ErPDc8xniuym2PtPO3Qd+Eb8SOAlIaCPpHYHJAkY+/Cj3D8BjFP2U9to75AyRmAp3/6/jyZEyTSEJRhw3CU9QkXqQtJ6bcu6W3dhRtbwhyrvg6rBgKwQNdUnqyKCq/SVc0zYN5IXJ0AkXw==";
	String Lisence="BGkiDY7d2AHJtjf47Wa0UYSZECrlN2UzTwoOtKwbKfQiMM41Jou3VC3eF7crnLLNQ7FfcurAdRp/10CulqjuGYo1qcjzkHFPqWQcZeuJvoSJHCDnP+FP2/dz4FuUKGvHsZ4+AecXMsZifM8N6IJzmuGc9lMCnBPiQr8wKs2/fuRDQhl50/lp5QJiQzuyicnykq0GFbdmv1YcuY1E13DICdQvO57lt9MLY1zqg/5fy31WYGk0hD4jPcD/no3D6W19c81Q8MKudeBPJYYi4FlbiLEojlWEGFMab/mvxXo4W2vi0nxkmLf+htZfaCry37csfbmla+O2ZTT+QbfjuU2qyUiVsRlsrEDWHNEAcNioh5xrEd1gdSNiFlD2xk4dg97rmsMoVs72lintuz8/REpiW+12mlUSvl/QVsI0PxvQbRFeVzhgP9ce9ufqKJajl8leSPRPVXZyyVrRvV08yH2PcyIb35RXePLxzl7ZAbqpTfF50UkEqgO8Rcg6/UaMvZvwtEHmtLnOwmYPWDAjCiA3CAZUZH0qD2ygaPnJPCzavrskltjRiDn3z+QTF6oeHjc1heRk1IKrRLsVf9QXhqSUsm2q+RYFshdz47aCp4JJAKk1h3C7XKmEZHTPioSeFAc5oORRo4nh4Hzbnkh7sA932VHw7TOD5ZP2GHofDFg9Vrh4p03m/Fi+LHkT5/TMdXF5EOVo017D/9KH9G0KH8nXUpdQ3MKony9zaIL0DHtq0MtdNayXEU36LEDlzt+Oj+DsXdHuWwI+jrKxJS5kjaDzTEfptRDMFY26e93X1qgy2QCHD8WMRvPLyNQONnHsAftLejMQyDb71tGbD5uD6kbl7VmoFZbf8pQL7FioiiS57Rz62DHbFhz1lJ3CVAsoxwVOPaNqlAh+5RLKni0JNvwhW0AjOv4N854KNh9DEBISKgox0FweRIfxik+4M3r8Emr/lh9p0NyGR+SeyKQ2kN+e+zkxLjOim5E5gxc2a9NRTq3Io5LJgPSYg4+/WR9BxqK4MrWHeohZM5qdvH97vdLWG8fgZhrInZ+n0grsYj9Ia0E5/FKgXF+rrfzCBFanuKpe9ExgoP94CGoZ3O/c3IdLlrV7zi8i";

	private Button but_replay, but_sure;
	 SharedPreferences sharedPreferences;
	static {
		System.loadLibrary("gnustl_shared");
		System.loadLibrary("Gesture");
	}
	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case 10001:
//				new Thread(new Runnable() {
//					
//					@Override
//					public void run() {
						// TODO Auto-generated method stub
						 updateCodeList("");
//					}
//				}).start();
				break;
				
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);// ȥ��������
		setContentView(R.layout.activity_register);
		// text_id=(TextView)findViewById(R.id.text_id);
		 sharedPreferences = this.getSharedPreferences("share", MODE_PRIVATE); 
		 strEncryption=sharedPreferences.getString("strEncryption", ""); 
		mLockPattern = new LockPattern(RegisterActivity.this, Lisence);
		but_sure = (Button) findViewById(R.id.but_sure);
		but_replay = (Button) findViewById(R.id.but_replay);
		text_Title = (TextView) findViewById(R.id.text_Title);
		text_back = (TextView) findViewById(R.id.text_back);
		text_back.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateCodeList("");
				finish();
			}
		});
		//设置是否显示轨迹
		mLockPattern.IsGesturetrack(true);
		//设置正确时轨迹颜色
		mLockPattern.setLineColor(Color.rgb(68, 154, 247));// RGB #449AF7 100%
		//设置错误时轨迹颜色
		mLockPattern.setWrongLineColor(Color.RED);
		//获取设备唯一标识
		String AndroidId = mLockPattern.getAndroidID();
		// text_id.setText(AndroidId);
		//设置是否使用轨迹提示框 默认不使用
		mLockPattern.IsTracePromptBox(true);
		//设置使用RSA加密
		mLockPattern.EncryptionModeRSA(RSA_Key);
		//设置使用AES加密
		// mLockPattern.EncryptionModeAES(AES_Key);
		mLockIndicator = (LockIndicator) findViewById(R.id.lock_indicator);
		mGestureContainer = (FrameLayout) findViewById(R.id.gesture_container);
		mGestureContentView = new GestureContentView(RegisterActivity.this,
				true, mLockIndicator, new GestureCallBack() {
			//加密值ֵ
					@Override
					public void onGestureCodeInputEncrypt(
							String inputCodeEncrypt) {
						// TODO Auto-generated method stub
						if (inputCodeEncrypt.equals("Error:1")) {
							text_Title.setText("密码长度应大于设定长度");
						}
						Log.e("inputCodeEncrypt:", inputCodeEncrypt);
					}

					// 加密后长度？
					@Override
					public void onGestureCodeInputLength(int inputCodeLength) {
						// TODO Auto-generated method stub
					}

					@Override
					public void onGestureCodeInputHash(String inputCodeHash) {
						// TODO Auto-generated method stub
						if (i == 1) {
							str1 = inputCodeHash;
							i++;
							text_Title.setText("请再次输入手势密码");
							mGestureContentView.clearDrawlineState(0L);
						} else {
							str2 = inputCodeHash;
							if (str1.equals(str2)) {
								i = 1;
								str1 = str2;
								text_Title.setText("设置成功");
	
										 handler.sendEmptyMessage(10001);
								strEncryption=str1;
								Editor editor = sharedPreferences.edit(); 
								editor.putString("strEncryption", strEncryption);
								editor.commit(); 
								str1 = null;
								str2 = null;
								mGestureContentView.clearDrawlineState(0L);
								
							} else {
								text_Title.setText("请输入与第一次相同的手势密码");
								mGestureContentView.clearDrawlineState(2000L);
							}
						}
					}

				});
		but_sure.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				updateCodeList("");
				i = 1;
				str1 = null;
				str2 = null;
				mGestureContentView.clearDrawlineState(0L);
			}
		});

		mGestureContentView.setParentView(mGestureContainer);
		// updateCodeList("");
	}

	private void updateCodeList(String inputCode) {
		Log.e("11111", "22222");
		mLockIndicator.setPath(inputCode);
	}

}
