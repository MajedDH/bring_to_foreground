package rikaz.tech.bringtoforeground;

import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * BringtoforegroundPlugin
 */
public class BringtoforegroundPlugin implements FlutterPlugin, MethodCallHandler {

    private static Context context;

    @Override
    public void onAttachedToEngine(@NonNull FlutterPluginBinding flutterPluginBinding) {
        final MethodChannel channel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "bringtoforeground");
        channel.setMethodCallHandler(new BringtoforegroundPlugin());
        context = flutterPluginBinding.getApplicationContext();
    }

    // This static function is optional and equivalent to onAttachedToEngine. It supports the old
    // pre-Flutter-1.12 Android projects. You are encouraged to continue supporting
    // plugin registration via this function while apps migrate to use the new Android APIs
    // post-flutter-1.12 via https://flutter.dev/go/android-project-migration.
    //
    // It is encouraged to share logic between onAttachedToEngine and registerWith to keep
    // them functionally equivalent. Only one of onAttachedToEngine or registerWith will be called
    // depending on the user's project. onAttachedToEngine or registerWith must both be defined
    // in the same class.
    public static void registerWith(Registrar registrar) {
        final MethodChannel channel = new MethodChannel(registrar.messenger(), "bringtoforeground");
        channel.setMethodCallHandler(new BringtoforegroundPlugin());
    }

    @Override
    public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
        if (call.method.equals("bringAppToForeground")) {
            Intent intent2 = context.getPackageManager().getLaunchIntentForPackage(context.getPackageName());
//            Intent intent2 = new Intent(context, context.getClass() );
            intent2.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); // You need this if starting
            // the activity from a service
//            intent2.setAction(Intent.ACTION_MAIN);
//            intent2.addCategory(Intent.CATEGORY_LAUNCHER);
            context.startActivity(intent2);
            result.success(null);
        } else {
            result.notImplemented();
        }
    }

    @Override
    public void onDetachedFromEngine(@NonNull FlutterPluginBinding binding) {
    }
}
