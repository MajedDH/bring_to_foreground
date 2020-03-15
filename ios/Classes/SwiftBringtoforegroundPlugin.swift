import Flutter
import UIKit

public class SwiftBringtoforegroundPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "bringtoforeground", binaryMessenger: registrar.messenger())
    let instance = SwiftBringtoforegroundPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    result("dummy function")
  }
}
