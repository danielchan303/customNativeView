//
//  MyCustomView.m
//  MyApp
//
//  Created by daniel on 22/7/2022.
//

#import <Foundation/Foundation.h>
#import "MyCustomView.h"

@implementation MyCustomView
- (id)init {
  self = [super init];
  self.player = [[QNRTPlayer alloc] init];
  self.player.playView.fillMode = QNRTVideoFillModePreserveAspectRatio;
  self.player.playView = self;

  return self;
}

- (void)setSource:(NSString *)source{
  _source = source;
  [self startPlay];
}

- (void)startPlay{
  if (self.source==nil) {
    return;
  }
  [self.player playWithUrl:[NSURL URLWithString:self.source] supportHttps:YES];
}

- (void)stopPlay{
  [self.player stop];
}

- (void)destroyPlay{
  if (self.player) {
    [self.player stop];
    [self.player.playView removeFromSuperview];
    self.player.delegate = nil;
    self.player = nil;
  }
}

- (void)setShowVideo:(BOOL *)shouldShow{
  [self.player muteVideo:shouldShow];
}
@end
