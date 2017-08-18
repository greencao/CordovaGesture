package cn.microdone.gesture;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.util.Log;

import android.content.Intent;
import android.widget.Toast;

public class Gesture extends CordovaPlugin {
	private static String REGISTER = "register";
	private static String VERIFICATION = "verification";
	private static String RESTART = "restart";
	
	@Override
	  public void initialize(CordovaInterface cordova, CordovaWebView webView) {
	    super.initialize(cordova, webView);
	     Log.e("initialize","============================");
	  }
	@Override
	public boolean execute(String action, JSONArray args,
			CallbackContext callbackContext) throws JSONException {
		// TODO Auto-generated method stub
		if (REGISTER.equals(action)) {
			startCls(RestartActivity.class);
			callbackContext.success("success");
			return true;
		} else if (VERIFICATION.equals(action)) {
			startCls(VerificationActivity.class);
			callbackContext.success("success");
			return true;
		} else if (RESTART.equals(action)) {
			Log.i("======", "jinrufangfa");
			startCls(RestartActivity.class);
			callbackContext.success("success");
			return true;
		}
		callbackContext.error("error");
		return false;
	}

	@SuppressWarnings("rawtypes")
	public void startCls(Class cls) {
		cordova.getActivity().startActivity(new Intent(cordova.getActivity(), cls));
    }

}
