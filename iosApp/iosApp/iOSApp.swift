import SwiftUI
import shared

@main
struct iOSApp: App {
	init() {
		// Start Koin with the shared modules before any screen is created
		KoinIosKt.doInitKoinIos()
	}

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
