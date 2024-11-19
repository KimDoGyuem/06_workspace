import { StatusBar } from 'expo-status-bar';						
import { StyleSheet, Text, View, ImageBackground } from 'react-native';						
export default function App() {						
	return (					
		<View style={styles.container}>				
			<Text>헬로 키티 월드 !!!</Text>			
			<StatusBar style="auto" />		
		</View>				
	);					
}						
const styles = StyleSheet.create({						
	container: {					
		flex: 1,				
		backgroundColor: '#fff',				
		alignItems: 'center',				
		justifyContent: 'center',			
	},					
});						