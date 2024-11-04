package com.frokanic.cryptopeek.model

import com.google.gson.annotations.SerializedName

data class CoinDetailResponseModel(
    @SerializedName("id") val id: String,
    @SerializedName("symbol") val symbol: String,
    @SerializedName("name") val name: String,
    @SerializedName("asset_platform_id") val assetPlatformId: String?,
    @SerializedName("platforms") val platforms: Map<String, String?>,
    @SerializedName("block_time_in_minutes") val blockTimeInMinutes: Int?,
    @SerializedName("hashing_algorithm") val hashingAlgorithm: String?,
    @SerializedName("categories") val categories: List<String>,
    @SerializedName("public_notice") val publicNotice: String?,
    @SerializedName("additional_notices") val additionalNotices: List<String>,
    @SerializedName("description") val description: Map<String, String>,
    @SerializedName("links") val linksResponseModel: LinksResponseModel,
    @SerializedName("image") val imageResponseModel: ImageResponseModel,
    @SerializedName("country_origin") val countryOrigin: String,
    @SerializedName("genesis_date") val genesisDate: String?,
    @SerializedName("sentiment_votes_up_percentage") val sentimentVotesUpPercentage: Double?,
    @SerializedName("sentiment_votes_down_percentage") val sentimentVotesDownPercentage: Double?,
    @SerializedName("market_cap_rank") val marketCapRank: Int?,
    @SerializedName("coingecko_rank") val coingeckoRank: Int?,
    @SerializedName("coingecko_score") val coingeckoScore: Double?,
    @SerializedName("developer_score") val developerScore: Double?,
    @SerializedName("community_score") val communityScore: Double?,
    @SerializedName("liquidity_score") val liquidityScore: Double?,
    @SerializedName("public_interest_score") val publicInterestScore: Double?,
    @SerializedName("market_data") val marketDataResponseModel: MarketDataResponseModel?,
    @SerializedName("community_data") val communityDataResponseModel: CommunityDataResponseModel?,
    @SerializedName("developer_data") val developerDataResponseModel: DeveloperDataResponseModel?,
    @SerializedName("public_interest_stats") val publicInterestStatsResponseModel: PublicInterestStatsResponseModel?,
    @SerializedName("status_updates") val statusUpdateResponseModels: List<StatusUpdateResponseModel>,
    @SerializedName("last_updated") val lastUpdated: String?,
    @SerializedName("tickers") val tickerResponseModels: List<TickerResponseModel>
)

data class LinksResponseModel(
    @SerializedName("homepage") val homepage: List<String?>,
    @SerializedName("blockchain_site") val blockchainSite: List<String?>,
    @SerializedName("official_forum_url") val officialForumUrl: List<String?>,
    @SerializedName("chat_url") val chatUrl: List<String?>,
    @SerializedName("announcement_url") val announcementUrl: List<String?>,
    @SerializedName("twitter_screen_name") val twitterScreenName: String?,
    @SerializedName("facebook_username") val facebookUsername: String?,
    @SerializedName("bitcointalk_thread_identifier") val bitcointalkThreadIdentifier: Long?,
    @SerializedName("telegram_channel_identifier") val telegramChannelIdentifier: String?,
    @SerializedName("subreddit_url") val subredditUrl: String?,
    @SerializedName("repos_url") val reposUrlResponseModel: ReposUrlResponseModel
)

data class ReposUrlResponseModel(
    @SerializedName("github") val github: List<String>,
    @SerializedName("bitbucket") val bitbucket: List<String>
)

data class ImageResponseModel(
    @SerializedName("thumb") val thumb: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("large") val large: String?
)

data class MarketDataResponseModel(
    @SerializedName("current_price") val currentPrice: Map<String, Double>,
    @SerializedName("roi") val roiResponseModel: ROIResponseModel?,
    @SerializedName("market_cap") val marketCap: Map<String, Double>,
    @SerializedName("market_cap_rank") val marketCapRank: Int?,
    @SerializedName("total_volume") val totalVolume: Map<String, Double>,
    @SerializedName("high_24h") val high24h: Map<String, Double>,
    @SerializedName("low_24h") val low24h: Map<String, Double>,
    @SerializedName("price_change_24h") val priceChange24h: Double?,
    @SerializedName("price_change_percentage_24h") val priceChangePercentage24h: Double?,
    @SerializedName("price_change_percentage_7d") val priceChangePercentage7d: Double?,
    @SerializedName("price_change_percentage_14d") val priceChangePercentage14d: Double?,
    @SerializedName("price_change_percentage_30d") val priceChangePercentage30d: Double?,
    @SerializedName("price_change_percentage_60d") val priceChangePercentage60d: Double?,
    @SerializedName("price_change_percentage_200d") val priceChangePercentage200d: Double?,
    @SerializedName("price_change_percentage_1y") val priceChangePercentage1y: Double?,
    @SerializedName("market_cap_change_24h") val marketCapChange24h: Double?,
    @SerializedName("market_cap_change_percentage_24h") val marketCapChangePercentage24h: Double?,
    @SerializedName("price_change_24h_in_currency") val priceChange24hInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_1h_in_currency") val priceChangePercentage1hInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_24h_in_currency") val priceChangePercentage24hInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_7d_in_currency") val priceChangePercentage7dInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_14d_in_currency") val priceChangePercentage14dInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_30d_in_currency") val priceChangePercentage30dInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_60d_in_currency") val priceChangePercentage60dInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_200d_in_currency") val priceChangePercentage200dInCurrency: Map<String, Double>,
    @SerializedName("price_change_percentage_1y_in_currency") val priceChangePercentage1yInCurrency: Map<String, Double>,
    @SerializedName("market_cap_change_24h_in_currency") val marketCapChange24hInCurrency: Map<String, Double>,
    @SerializedName("market_cap_change_percentage_24h_in_currency") val marketCapChangePercentage24hInCurrency: Map<String, Double>,
    @SerializedName("total_supply") val totalSupply: Double?,
    @SerializedName("max_supply") val maxSupply: Double?,
    @SerializedName("circulating_supply") val circulatingSupply: Double?,
    @SerializedName("last_updated") val lastUpdated: String?
)

//data class ROI(
//    @SerializedName("times") val times: Double?,
//    @SerializedName("currency") val currency: String?,
//    @SerializedName("percentage") val percentage: Double?
//)

data class CommunityDataResponseModel(
    @SerializedName("facebook_likes") val facebookLikes: Int?,
    @SerializedName("twitter_followers") val twitterFollowers: Int?,
    @SerializedName("reddit_average_posts_48h") val redditAveragePosts48h: Double?,
    @SerializedName("reddit_average_comments_48h") val redditAverageComments48h: Double?,
    @SerializedName("reddit_subscribers") val redditSubscribers: Int?,
    @SerializedName("reddit_accounts_active_48h") val redditAccountsActive48h: String?,
    @SerializedName("telegram_channel_user_count") val telegramChannelUserCount: Int?
)

data class DeveloperDataResponseModel(
    @SerializedName("forks") val forks: Int?,
    @SerializedName("stars") val stars: Int?,
    @SerializedName("subscribers") val subscribers: Int?,
    @SerializedName("total_issues") val totalIssues: Int?,
    @SerializedName("closed_issues") val closedIssues: Int?,
    @SerializedName("pull_requests_merged") val pullRequestsMerged: Int?,
    @SerializedName("pull_request_contributors") val pullRequestContributors: Int?,
    @SerializedName("code_additions_deletions_4_weeks") val codeAdditionsDeletions4WeeksResponseModel: CodeAdditionsDeletions4WeeksResponseModel?,
    @SerializedName("commit_count_4_weeks") val commitCount4Weeks: Int?,
    @SerializedName("last_4_weeks_commit_activity_series") val last4WeeksCommitActivitySeries: List<Int>
)

data class CodeAdditionsDeletions4WeeksResponseModel(
    @SerializedName("additions") val additions: Int?,
    @SerializedName("deletions") val deletions: Int?
)

data class PublicInterestStatsResponseModel(
    @SerializedName("alexa_rank") val alexaRank: Int?,
    @SerializedName("bing_matches") val bingMatches: Int?
)

data class StatusUpdateResponseModel(
    @SerializedName("description") val description: String?,
    @SerializedName("category") val category: String?,
    @SerializedName("created_at") val createdAt: String?,
    @SerializedName("user") val user: String?,
    @SerializedName("user_title") val userTitle: String?,
    @SerializedName("pin") val pin: Boolean?,
    @SerializedName("project") val projectResponseModel: ProjectResponseModel?,
    @SerializedName("updated_at") val updatedAt: String?
)

data class ProjectResponseModel(
    @SerializedName("type") val type: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("image") val imageResponseModel: ImageResponseModel?
)

data class TickerResponseModel(
    @SerializedName("base") val base: String?,
    @SerializedName("target") val target: String?,
    @SerializedName("market") val marketResponseModel: MarketResponseModel?,
    @SerializedName("last") val last: Double?,
    @SerializedName("volume") val volume: Double?,
    @SerializedName("converted_last") val convertedLast: Map<String, Double>,
    @SerializedName("converted_volume") val convertedVolume: Map<String, Double>,
    @SerializedName("trust_score") val trustScore: String?,
    @SerializedName("bid_ask_spread_percentage") val bidAskSpreadPercentage: Double?,
    @SerializedName("timestamp") val timestamp: String?,
    @SerializedName("last_traded_at") val lastTradedAt: String?,
    @SerializedName("last_fetch_at") val lastFetchAt: String?,
    @SerializedName("is_anomaly") val isAnomaly: Boolean?,
    @SerializedName("is_stale") val isStale: Boolean?,
    @SerializedName("trade_url") val tradeUrl: String?,
    @SerializedName("token_info_url") val tokenInfoUrl: String?,
    @SerializedName("coin_id") val coinId: String?,
    @SerializedName("target_coin_id") val targetCoinId: String?
)

data class MarketResponseModel(
    @SerializedName("name") val name: String?,
    @SerializedName("identifier") val identifier: String?,
    @SerializedName("has_trading_incentive") val hasTradingIncentive: Boolean?
)