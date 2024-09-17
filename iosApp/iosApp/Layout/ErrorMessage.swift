//
//  ErrorMessage.swift
//  iosApp
//
//  Created by Yuri Barbosa on 14/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct ErrorMessage: View {
    var message: String
    
    var body: some View {
        Text(message)
            .font(.title)
    }
}

#Preview {
    ErrorMessage(message: "Something Wrong")
}
