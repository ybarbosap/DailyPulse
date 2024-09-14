//
//  AboutListView.swift
//  iosApp
//
//  Created by Yuri Barbosa on 12/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

struct AboutListView: View {
    
    private struct RowItem : Hashable {
        let title: String
        let subtitle: String
        
        init(title: String, subtitle: String) {
            self.title = title
            self.subtitle = subtitle
        }
    }
    
    private let items: [RowItem] = {
        let platform = Platform()
        let result: [RowItem] = [
            .init(title: "Operation Sytem", subtitle: "\(platform.osName) \(platform.osVersion)"),
            .init(title: "Device", subtitle: platform.deviceModel),
            .init(title: "Density", subtitle: "@\(platform.density)x")
        ]
        return result
    }()
    
    var body: some View {
        List {
            ForEach(items, id: \.self) { item in
                VStack(alignment: .leading) {
                    Text(item.title)
                        .font(.footnote)
                        .foregroundStyle(.secondary)
                    Text(item.subtitle)
                        .font(.body)
                        .foregroundStyle(.primary)
                }.padding(.vertical, 4)
            }
        }
    }
}

#Preview {
    AboutListView()
}
