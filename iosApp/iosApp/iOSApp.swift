import SwiftUI
import shared

@main
struct iOSApp: App {
	init() {
		// Start Koin with the shared modules before any screen is created
		#if DEBUG
		KoinIosKt.doInitKoinIos(enableNetworkLogs: true)
		#else
		KoinIosKt.doInitKoinIos(enableNetworkLogs: false)
		#endif
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
