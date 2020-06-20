import 'dart:async';

import 'package:flutter/services.dart';

class AppziloOfferwall {
  static const MethodChannel _channel =
      const MethodChannel('flutterappziloofferwall');

  Future<void> init({String appKey, String userId}) async {
    assert(appKey!=null && appKey.isNotEmpty);
    return _channel.invokeMethod("init", <String, dynamic>{
      "app_key": appKey,
      "user_id": userId
    });
  }
  Future<void> show() async {
    return _channel.invokeMethod('show');
  }
}
