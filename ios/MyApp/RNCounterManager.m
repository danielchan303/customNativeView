//
//  RNCounterManager.m
//  MyApp
//
//  Created by daniel on 22/7/2022.
//

#import <Foundation/Foundation.h>
#import "RNCounterManager.h"
#import "MyCustomView.h"


@implementation RNCounterManager

RCT_EXPORT_MODULE(MyCounter)

RCT_EXPORT_VIEW_PROPERTY(source, NSString)
RCT_EXPORT_VIEW_PROPERTY(setMute, BOOL)

RCT_EXPORT_METHOD(startPlay:(nonnull NSNumber *) reactTag){
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
    MyCustomView * myCustomView  = (MyCustomView *) viewRegistry[reactTag];
    [myCustomView startPlay];
  }];
}

RCT_EXPORT_METHOD(stopPlay:(nonnull NSNumber *) reactTag){
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
    MyCustomView * myCustomView  = (MyCustomView *) viewRegistry[reactTag];
    [myCustomView stopPlay];
  }];
}

RCT_EXPORT_METHOD(destroyPlay:(nonnull NSNumber *) reactTag){
  [self.bridge.uiManager addUIBlock:^(RCTUIManager *uiManager, NSDictionary<NSNumber *,UIView *> *viewRegistry) {
    MyCustomView * myCustomView  = (MyCustomView *) viewRegistry[reactTag];
    [myCustomView destroyPlay];
  }];
}

- (UIView *)view
{
  MyCustomView * myView = [[MyCustomView alloc] init];
  return myView;
}

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

@end
