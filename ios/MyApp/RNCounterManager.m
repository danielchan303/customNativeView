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
- (UIView *)view
{
  RNMyCustomView * myView = [[RNMyCustomView alloc] init];
  return myView;
}

+ (BOOL)requiresMainQueueSetup {
    return YES;
}

@end
