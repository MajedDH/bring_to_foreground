import 'package:flutter/services.dart';

class Bringtoforeground {
  static const MethodChannel _channel =
      const MethodChannel('bringtoforeground');

  static void bringAppToForeground() {
    _channel.invokeMethod("bringAppToForeground");
  }
}
