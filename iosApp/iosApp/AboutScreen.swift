//
//  AboutScreen.swift
//  iosApp
//
//  Created by Yuri Barbosa on 12/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    var body: some View {
        NavigationStack {
            AboutListView()
                .navigationTitle("About Screen")
        }
    }
}

#Preview {
    AboutScreen()
}
