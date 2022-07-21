import * as React from 'react';
import {findNodeHandle, requireNativeComponent, UIManager} from 'react-native';
import {Text, View, StyleSheet} from 'react-native';

const CounterView = requireNativeComponent('MyCounter');

interface MyViewProps {
  style: any;
}

const MyView = React.forwardRef((props: MyViewProps, ref) => {
  const componentRef = React.useRef(null);

  React.useImperativeHandle(ref, () => ({
    increment: () => {
      increment();
    },
    decrement,
  }));

  const increment = () => {
    console.log('increment');
    UIManager?.dispatchViewManagerCommand(
      findNodeHandle(componentRef?.current),
      'INCREMENT',
      undefined,
    );
  };

  const decrement = () => {
    console.log('decrement');
    UIManager?.dispatchViewManagerCommand(
      findNodeHandle(componentRef?.current),
      'DECREMENT',
      undefined,
    );
  };

  return <CounterView ref={componentRef} count={5} style={props.style} />;
});

export default MyView;

const styles = StyleSheet.create({
  container: {},
});
