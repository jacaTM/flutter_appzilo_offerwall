package com.joaquim.pomarico.flutterappziloofferwall;

import android.app.Activity;

import androidx.annotation.NonNull;

import com.appzilo.sdk.Offerwall;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlutterappziloofferwallPlugin */
public class FlutterappziloofferwallPlugin implements FlutterPlugin, MethodCallHandler, ActivityAware {
  private MethodChannel channel;
  private Activity activity;

  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
    channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "flutterappziloofferwall");
    channel.setMethodCallHandler(this);
  }

  private void extractAppziloOfferwall(MethodCall call, Result result){
    String app_key = null;
    if(call.argument("app_key")!=null){
      app_key = call.argument("app_key");
    }else{
      result.error("no_app_key","a null app key was provided", null);
      return;
    }
    String user_id = null;
    if(call.argument("user_id")!= null){
      user_id=call.argument("user_id");
    }
    Offerwall.onNewIntent(activity.getApplicationContext(),activity.getIntent());
    Offerwall.initApp(activity,app_key,user_id);
  }

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("init")) {
      extractAppziloOfferwall(call,result);
    }else if(call.method.equals("show")){
      Offerwall.show();
    }else {
      result.notImplemented();
    }
  }

  @Override
  public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    channel.setMethodCallHandler(null);
  }

  @Override
  public void onAttachedToActivity(@NonNull ActivityPluginBinding activityPluginBinding) {
    activity = activityPluginBinding.getActivity();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {

  }

  @Override
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding activityPluginBinding) {

  }

  @Override
  public void onDetachedFromActivity() {

  }
}
