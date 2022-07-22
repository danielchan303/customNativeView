//
//  MyCustomView.m
//  MyApp
//
//  Created by daniel on 22/7/2022.
//

#import <Foundation/Foundation.h>
#import "MyCustomView.h"

@implementation RNMyCustomView
- (id)init {
  self = [super init];
  self.player = [[QNRTPlayer alloc] init];
  self.player.playView.fillMode = QNRTVideoFillModePreserveAspectRatio;
  self.player.playView = self;
  [self.player playWithUrl:[NSURL URLWithString:@"https://live-pilidemo.cloudvdn.com/pilidemo/timestamp.m3u8"] supportHttps:YES];
  return self;
}
@end
