#import "BringtoforegroundPlugin.h"
#if __has_include(<bringtoforeground/bringtoforeground-Swift.h>)
#import <bringtoforeground/bringtoforeground-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "bringtoforeground-Swift.h"
#endif

@implementation BringtoforegroundPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftBringtoforegroundPlugin registerWithRegistrar:registrar];
}
@end
