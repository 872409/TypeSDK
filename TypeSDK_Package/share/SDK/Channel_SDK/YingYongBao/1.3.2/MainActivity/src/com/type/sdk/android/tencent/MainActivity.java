package com.type.sdk.android.tencent;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.content.Intent;
import android.os.Bundle;

import com.type.sdk.android.BaseMainActivity;
import com.type.sdk.android.TypeSDKHelper;
import com.type.sdk.android.TypeSDKLogger;

public class MainActivity extends BaseMainActivity   {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		TypeSDKHelper.onCreate(this);
	}

	@Override
	protected void onResume() {
		super.onResume();
		TypeSDKHelper.onResume(this);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		TypeSDKHelper.onRestart(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		TypeSDKHelper.onPause(this);
	}

	@Override
	protected void onStop() {
		super.onStop();
		TypeSDKHelper.onStart(this);
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		TypeSDKHelper.onDestroy(this);

	}

	@Override
	protected void onNewIntent(Intent intent) {
		super.onNewIntent(intent);
		TypeSDKHelper.onNewIntent(this, intent);
	}

	// TODO GAME 在onActivityResult中需要调用WGPlatform.onActivityResult
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		TypeSDKHelper.onActivityResult(this, requestCode, resultCode, data);
	}

	public void CallInitSDK() {
		String _in_data = "";
		TypeSDKHelper.CallInitSDK(this, _in_data);
	}

	public void CallLogin(String _in_data) {
		TypeSDKLogger.i(_in_data);
		TypeSDKHelper.CallLogin(this, _in_data);
	}

	public void CallLogout() {
		String _in_data = "";
		TypeSDKHelper.CallLogout(this, _in_data);
	}

	public String CallPayItem(String _in_data) {
		TypeSDKLogger.i("CallPayItem:" + _in_data);
		return TypeSDKHelper.CallPayItem(this, _in_data);
	}

	@Deprecated
	public String CallExchangeItem(String _in_data) {
		return TypeSDKHelper.CallPayItem(this, _in_data);
	}

	@Deprecated
	public void CallToolBar() {
		TypeSDKBonjour.Instance().ShowToolBar(_in_context);
	}

	@Deprecated
	public void CallHideToolBar() {
		TypeSDKBonjour.Instance().HideToolBar(_in_context);
	}

	@Deprecated
	public void CallPersonCenter() {
		TypeSDKBonjour.Instance().ShowPersonCenter(_in_context);
	}

	@Deprecated
	public void CallHidePersonCenter() {
		TypeSDKBonjour.Instance().HidePersonCenter(_in_context);
	}

	public void CallShare(String _in_data) {
		TypeSDKHelper.CallShare(this, _in_data);
	}

	public void CallSetPlayerInfo(String _in_data) {
		TypeSDKHelper.CallSetPlayerInfo(this, _in_data);
	}

	public void CallExitGame() {
		TypeSDKHelper.CallExitGame(this, "");
	}

	@Deprecated
	public void CallDestory() {
		TypeSDKBonjour.Instance().OnDestroy();
	}

	@Deprecated
	public int CallLoginState() {
		return TypeSDKBonjour.Instance().LoginState(_in_context);
	}

	public String CallUserData() {
		return TypeSDKHelper.CallUserData(this, "");
	}

	public String CallPlatformData() {
		return TypeSDKHelper.CallPlatformData(this, "");
	}

	public boolean CallIsHasRequest(String _in_data) {
		return TypeSDKHelper.CallIsHasRequest(this, _in_data);
	}

	@Deprecated
	public void CallCopyClipboard(String _in_data) {
		TypeSDKBonjour.Instance().OnCopyClipboard(_in_context,
				_in_data);
	}

	@Deprecated
	public String CallAnyFunction(String FuncName, String _in_data) {
		Method[] me = TypeSDKBonjour.Instance().getClass()
				.getMethods();
		for (int i = 0; i < me.length; ++i) {
			if (me[i].getName().equals(FuncName)) {
				try {
					return (String) me[i].invoke(
							TypeSDKBonjour.Instance(), _in_context,
							_in_data);
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return "error";
	}

	
	public void AddLocalPush(String _in_data) {
		TypeSDKLogger.i(_in_data);
		TypeSDKHelper.AddLocalPush(this, _in_data);
	}

	public void RemoveLocalPush(String _in_data) {
		TypeSDKLogger.i(_in_data);
		TypeSDKHelper.RemoveLocalPush(this, _in_data);
	}

	public void RemoveAllLocalPush() {
		TypeSDKHelper.RemoveAllLocalPush(this, "");
	}
}
