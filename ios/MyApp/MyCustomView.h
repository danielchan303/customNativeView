#import "UIKit/UIKit.h"
#import <QNRTPlayerKit/QNRTPlayerKit.h>

@interface MyCustomView: QNRTVideoView
  @property(nonatomic, strong) QNRTPlayer *player;
  @property(nonatomic, strong) NSString *source;

  -(void)startPlay;
  -(void)stopPlay;
  -(void)destroyPlay;
@end
