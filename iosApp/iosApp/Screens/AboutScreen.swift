//
//  AboutScreen.swift
//  iosApp
//
//  Created by Yuri Barbosa on 12/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AboutScreen: View {
    
    @Environment(\.dismiss)
    private var dismiss
    
    var body: some View {
        NavigationStack {
            AboutListView()
                .navigationTitle("About Screen")
                .toolbar(content: {
                    ToolbarItem(placement: .primaryAction) {
                        Button {
                            dismiss()
                        } label: {
                            Text("Done")
                                .bold()
                        }
                    }
                })
        }
    }
}

#Preview {
    AboutScreen()
}
