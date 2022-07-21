import React from 'react';
import {StyleSheet, Text, TouchableOpacity, View} from 'react-native';
import MyView from './MyView';

const App = () => {
  const ref = React.useRef();

  const incrementHanlder = () => {
    ref.current.increment();
  };

  const decrementHandler = () => {
    ref.current.decrement();
  };

  return (
    <View style={styles.container}>
      <MyView
        ref={ref}
        style={{
          width: '100%',
          height: '50%',
          backgroundColor: 'red',
          justifyContent: 'center',
          alignItems: 'center',
        }}
      />
      <TouchableOpacity onPress={incrementHanlder}>
        <Text>Add</Text>
      </TouchableOpacity>
      <TouchableOpacity onPress={decrementHandler}>
        <Text>Minus</Text>
      </TouchableOpacity>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: 'white',
    justifyContent: 'center',
    alignItems: 'center',
  },
});

export default App;
