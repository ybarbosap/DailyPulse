//
//  AppBar.swift
//  iosApp
//
//  Created by Yuri Barbosa on 14/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct AppBar: View {
    var title: String
    
    init(title: String) {
        self.title = title
    }
    
    var body: some View {
        Text(title)
    }
}

#Preview {
    AppBar(title: "Title")
}
