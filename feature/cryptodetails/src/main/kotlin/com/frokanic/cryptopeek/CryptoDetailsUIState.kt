package com.frokanic.cryptopeek

import com.frokanic.model.model.CurrencyOverview

sealed interface CryptoDetailsUIState {

    data class Success(
        val id: String,
        val symbol: String,
        val name: String,
        val assetPlatformId: String?,
        val platforms: Map<String, String?>,
        val blockTimeInMinutes: Int?,
        val hashingAlgorithm: String?,
        val categories: List<String>,
        val publicNotice: String?,
        val additionalNotices: List<String>,
        val description: Map<String, String>,
        val links: LinksUIState,
        val image: ImageUIState,
        val countryOrigin: String,
        val genesisDate: String?,
        val sentimentVotesUpPercentage: Double?,
        val sentimentVotesDownPercentage: Double?,
        val marketCapRank: Int?,
        val coingeckoRank: Int?,
        val coingeckoScore: Double?,
        val developerScore: Double?,
        val communityScore: Double?,
        val liquidityScore: Double?,
        val publicInterestScore: Double?,
        val marketData: MarketDataUIState?,
        val communityData: CommunityDataUIState?,
        val developerData: DeveloperDataUIState?,
        val publicInterestStats: PublicInterestStatsUIState?,
        val statusUpdates: List<StatusUpdateUIState>,
        val lastUpdated: String?,
        val tickers: List<TickerUIState>
    ) : CryptoDetailsUIState {

        data class ROIUIStateModel(
            val times: Double?,
            val currency: String?,
            val percentage: Double?
        )

        data class LinksUIState(
            val homepage: List<String?>,
            val blockchainSite: List<String?>,
            val officialForumUrl: List<String?>,
            val chatUrl: List<String?>,
            val announcementUrl: List<String?>,
            val twitterScreenName: String?,
            val facebookUsername: String?,
            val bitcointalkThreadIdentifier: Long?,
            val telegramChannelIdentifier: String?,
            val subredditUrl: String?,
            val reposUrl: ReposUrlUIState
        )

        data class ReposUrlUIState(
            val github: List<String>,
            val bitbucket: List<String>
        )

        data class ImageUIState(
            val thumb: String?,
            val small: String?,
            val large: String?
        )

        data class MarketDataUIState(
            val currentPrice: Map<String, Double>,
            val roi: ROIUIState?,
            val marketCap: Map<String, Double>,
            val marketCapRank: Int?,
            val totalVolume: Map<String, Double>,
            val high24h: Map<String, Double>,
            val low24h: Map<String, Double>,
            val priceChange24h: Double?,
            val priceChangePercentage24h: Double?,
            val priceChangePercentage7d: Double?,
            val priceChangePercentage14d: Double?,
            val priceChangePercentage30d: Double?,
            val priceChangePercentage60d: Double?,
            val priceChangePercentage200d: Double?,
            val priceChangePercentage1y: Double?,
            val marketCapChange24h: Double?,
            val marketCapChangePercentage24h: Double?,
            val priceChange24hInCurrency: Map<String, Double>,
            val priceChangePercentage1hInCurrency: Map<String, Double>,
            val priceChangePercentage24hInCurrency: Map<String, Double>,
            val priceChangePercentage7dInCurrency: Map<String, Double>,
            val priceChangePercentage14dInCurrency: Map<String, Double>,
            val priceChangePercentage30dInCurrency: Map<String, Double>,
            val priceChangePercentage60dInCurrency: Map<String, Double>,
            val priceChangePercentage200dInCurrency: Map<String, Double>,
            val priceChangePercentage1yInCurrency: Map<String, Double>,
            val marketCapChange24hInCurrency: Map<String, Double>,
            val marketCapChangePercentage24hInCurrency: Map<String, Double>,
            val totalSupply: Double?,
            val maxSupply: Double?,
            val circulatingSupply: Double?,
            val lastUpdated: String?
        )

        data class ROIUIState(
            val times: Double?,
            val currency: String?,
            val percentage: Double?
        )

        data class CommunityDataUIState(
            val facebookLikes: Int?,
            val twitterFollowers: Int?,
            val redditAveragePosts48h: Double?,
            val redditAverageComments48h: Double?,
            val redditSubscribers: Int?,
            val redditAccountsActive48h: String?,
            val telegramChannelUserCount: Int?
        )

        data class DeveloperDataUIState(
            val forks: Int?,
            val stars: Int?,
            val subscribers: Int?,
            val totalIssues: Int?,
            val closedIssues: Int?,
            val pullRequestsMerged: Int?,
            val pullRequestContributors: Int?,
            val codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4WeeksUIState?,
            val commitCount4Weeks: Int?,
            val last4WeeksCommitActivitySeries: List<Int>
        )

        data class CodeAdditionsDeletions4WeeksUIState(
            val additions: Int?,
            val deletions: Int?
        )

        data class PublicInterestStatsUIState(
            val alexaRank: Int?,
            val bingMatches: Int?
        )

        data class StatusUpdateUIState(
            val description: String?,
            val category: String?,
            val createdAt: String?,
            val user: String?,
            val userTitle: String?,
            val pin: Boolean?,
            val project: ProjectUIState?,
            val updatedAt: String?
        )

        data class ProjectUIState(
            val type: String?,
            val id: String?,
            val name: String?,
            val image: ImageUIState?
        )

        data class TickerUIState(
            val base: String?,
            val target: String?,
            val market: MarketUIState?,
            val last: Double?,
            val volume: Double?,
            val convertedLast: Map<String, Double>,
            val convertedVolume: Map<String, Double>,
            val trustScore: String?,
            val bidAskSpreadPercentage: Double?,
            val timestamp: String?,
            val lastTradedAt: String?,
            val lastFetchAt: String?,
            val isAnomaly: Boolean?,
            val isStale: Boolean?,
            val tradeUrl: String?,
            val tokenInfoUrl: String?,
            val coinId: String?,
            val targetCoinId: String?
        )

        data class MarketUIState(
            val name: String?,
            val identifier: String?,
            val hasTradingIncentive: Boolean?
        )
    }

    data class Failure(
        val errorDescription: String
    ) : CryptoDetailsUIState

    data object Loading : CryptoDetailsUIState

}