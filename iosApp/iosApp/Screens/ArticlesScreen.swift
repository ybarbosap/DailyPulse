//
//  ArticlesScreen.swift
//  iosApp
//
//  Created by Yuri Barbosa on 14/09/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI
import shared

extension ArticlesScreen {
    @MainActor
    class ArticlesViewModelWrapper: ObservableObject {
        let articlesViewModel: ArticlesViewModel
        
        @Published
        var articleState: ArticlesState
        
        init() {
            articlesViewModel = ArticlesViewModel()
            articleState = articlesViewModel.articlesState.value
        }
        
        func startObserving() {
            Task {
                for await articles in articlesViewModel.articlesState {
                    self.articleState = articles
                }
            }
        }
    }
}

struct ArticlesScreen: View {
   
    @ObservedObject
    private(set) var viewModel: ArticlesViewModelWrapper
    
    var body: some View {
        VStack {
            AppBar(title: "Articles")
            
            if viewModel.articleState.isLoading {
                Loader()
            } else if let error = viewModel.articleState.error {
                ErrorMessage(message: error)
            }
            
            ScrollView {
                LazyVStack(spacing: 10) {
                    ForEach(viewModel.articleState.articles, id: \.title) { article in
                        ArticleItemView(article: article)
                    }
                }
            }
        }.onAppear {
            viewModel.startObserving()
        }
    }
}

private struct ArticleItemView: View {
    var article: Article
    
    var body: some View {
        VStack(alignment: .leading, spacing: 8) {
            AsyncImage(url: URL(string: article.imageUrl)) { phase in
                if phase.image != nil {
                    phase.image!
                        .resizable()
                        .aspectRatio(contentMode: .fit)
                } else if phase.error != nil {
                    Text("Image Load Error")
                } else {
                    ProgressView()
                }
            }
            Text(article.title)
                .font(.title)
                .fontWeight(.bold)
            Text(article.desc)
            Text(article.date)
                .frame(maxWidth: .infinity, alignment: .trailing)
                .foregroundStyle(.gray)
        }.padding(16)
    }
}
