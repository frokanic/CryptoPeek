package com.frokanic.cryptopeek.model

import com.google.gson.annotations.SerializedName

// Todo: Do I have to keep ALL the data?
data class CurrencyInfoResponseModel(
    val id: String,
    val symbol: String,
    val name: String,
    @SerializedName("web_slug") val webSlug: String?,
    @SerializedName("asset_platform_id") val assetPlatformId: String?,
    val platforms: Map<String, String>,
    @SerializedName("detail_platforms") val detailPlatforms: Map<String, DetailPlatform>,
    @SerializedName("block_time_in_minutes") val blockTimeInMinutes: Int,
    @SerializedName("hashing_algorithm") val hashingAlgorithm: String,
    val categories: List<String>,
    @SerializedName("preview_listing") val previewListing: Boolean,
    @SerializedName("public_notice") val publicNotice: String?,
    @SerializedName("additional_notices") val additionalNotices: List<String>,
    val localization: Map<String, String>,
    val description: Map<String, String>,
    val links: CurrencyLinks,
    val image: CurrencyImage,
    @SerializedName("country_origin") val countryOrigin: String?,
    @SerializedName("genesis_date") val genesisDate: String?,
    @SerializedName("sentiment_votes_up_percentage") val sentimentVotesUpPercentage: Double,
    @SerializedName("sentiment_votes_down_percentage") val sentimentVotesDownPercentage: Double,
    @SerializedName("ico_data") val icoData: IcoData?,
    @SerializedName("watchlist_portfolio_users") val watchlistPortfolioUsers: Long,
    @SerializedName("market_cap_rank") val marketCapRank: Int?,
    @SerializedName("market_data") val marketData: MarketData,
    val communityData: CommunityData,
    val developerData: DeveloperData,
    val statusUpdates: List<String>,
    @SerializedName("last_updated") val lastUpdated: String,
    val tickers: List<Ticker>
)

data class DetailPlatform(
    @SerializedName("decimal_place") val decimalPlace: Int?,
    @SerializedName("contract_address") val contractAddress: String
)

data class CurrencyLinks(
    val homepage: List<String>,
    val whitepaper: String?,
    @SerializedName("blockchain_site") val blockchainSite: List<String>,
    @SerializedName("official_forum_url") val officialForumUrl: List<String>,
    @SerializedName("chat_url") val chatUrl: List<String>,
    @SerializedName("announcement_url") val announcementUrl: List<String>,
    @SerializedName("twitter_screen_name") val twitterScreenName: String?,
    @SerializedName("facebook_username") val facebookUsername: String?,
    @SerializedName("bitcointalk_thread_identifier") val bitcointalkThreadIdentifier: Long?,
    @SerializedName("telegram_channel_identifier") val telegramChannelIdentifier: String?,
    @SerializedName("subreddit_url") val subredditUrl: String?,
    val reposUrl: ReposUrl
)

data class CurrencyImage(
    val thumb: String,
    val small: String,
    val large: String
)

data class IcoData(
    @SerializedName("ico_start_date") val icoStartDate: String?,
    @SerializedName("ico_end_date") val icoEndDate: String?,
    @SerializedName("short_desc") val shortDesc: String?,
    val description: String?,
    val links: Map<String, String>,
    @SerializedName("softcap_currency") val softcapCurrency: String?,
    @SerializedName("hardcap_currency") val hardcapCurrency: String?,
    @SerializedName("total_raised_currency") val totalRaisedCurrency: String?,
    @SerializedName("softcap_amount") val softcapAmount: Long?,
    @SerializedName("hardcap_amount") val hardcapAmount: Long?,
    @SerializedName("total_raised") val totalRaised: Long?,
    @SerializedName("quote_pre_sale_currency") val quotePreSaleCurrency: String?,
    @SerializedName("base_pre_sale_amount") val basePreSaleAmount: Long?,
    @SerializedName("quote_pre_sale_amount") val quotePreSaleAmount: Long?,
    @SerializedName("quote_public_sale_currency") val quotePublicSaleCurrency: String?,
    @SerializedName("base_public_sale_amount") val basePublicSaleAmount: Long?,
    @SerializedName("quote_public_sale_amount") val quotePublicSaleAmount: Long?,
    @SerializedName("accepting_currencies") val acceptingCurrencies: String?,
    @SerializedName("country_origin") val icoCountryOrigin: String?,
    @SerializedName("pre_sale_start_date") val preSaleStartDate: String?,
    @SerializedName("pre_sale_end_date") val preSaleEndDate: String?,
    @SerializedName("whitelist_url") val whitelistUrl: String?,
    @SerializedName("whitelist_start_date") val whitelistStartDate: String?,
    @SerializedName("whitelist_end_date") val whitelistEndDate: String?,
    @SerializedName("bounty_detail_url") val bountyDetailUrl: String?,
    @SerializedName("amount_for_sale") val amountForSale: Long?,
    @SerializedName("kyc_required") val kycRequired: Boolean,
    @SerializedName("whitelist_available") val whitelistAvailable: Boolean?,
    @SerializedName("pre_sale_available") val preSaleAvailable: Boolean?,
    @SerializedName("pre_sale_ended") val preSaleEnded: Boolean
)

data class MarketData(
    @SerializedName("current_price") val currentPrice: Map<String, Double>,
    @SerializedName("total_value_locked") val totalValueLocked: String?,
    @SerializedName("mcap_to_tvl_ratio") val mcapToTvlRatio: String?,
    @SerializedName("fdv_to_tvl_ratio") val fdvToTvlRatio: String?,
    val roi: Roi?,
    val ath: Map<String, Double>,
    @SerializedName("ath_change_percentage") val athChangePercentage: Map<String, Double>,
    @SerializedName("ath_date") val athDate: Map<String, String>,
    val atl: Map<String, Double>,
    @SerializedName("atl_change_percentage") val atlChangePercentage: Map<String, Double>,
    @SerializedName("atl_date") val atlDate: Map<String, String>,
    @SerializedName("last_updated") val lastUpdated: String
)

data class CommunityData(
    @SerializedName("facebook_likes") val facebookLikes: Long?,
    @SerializedName("twitter_followers") val twitterFollowers: Long,
    @SerializedName("reddit_average_posts_48h") val redditAveragePosts48h: Double,
    @SerializedName("reddit_average_comments_48h") val redditAverageComments48h: Double,
    @SerializedName("reddit_subscribers") val redditSubscribers: Long,
    @SerializedName("reddit_accounts_active_48h") val redditAccountsActive48h: String?
)

data class DeveloperData(
    val forks: Int,
    val stars: Int,
    val subscribers: Int,
    @SerializedName("total_issues") val totalIssues: Int,
    @SerializedName("closed_issues") val closedIssues: Int,
    @SerializedName("pull_requests_merged") val pullRequestsMerged: Int,
    @SerializedName("pull_request_contributors") val pullRequestContributors: Int,
    @SerializedName("code_additions_deletions_4_weeks") val codeAdditionsDeletions4Weeks: AdditionsDeletions,
    @SerializedName("commit_count_4_weeks") val commitCount4Weeks: Int,
    @SerializedName("last_4_weeks_commit_activity_series") val last4WeeksCommitActivitySeries: List<CommitActivity>
)

data class AdditionsDeletions(
    val additions: Int,
    val deletions: Int
)

data class CommitActivity(
    val date: String,
    val count: Int,
    val intensity: Int
)

data class Roi(
    val times: Double,
    val currency: String,
    val percentage: Double
)

data class Ticker(
    val base: String,
    val target: String,
    val market: Market,
    val last: Double,
    val volume: Double,
    @SerializedName("converted_last") val convertedLast: Map<String, Double>,
    @SerializedName("converted_volume") val convertedVolume: Map<String, Double>,
    @SerializedName("trust_score") val trustScore: String,
    @SerializedName("bid_ask_spread_percentage") val bidAskSpreadPercentage: Double,
    val timestamp: String,
    @SerializedName("last_traded_at") val lastTradedAt: String,
    @SerializedName("last_fetch_at") val lastFetchAt: String,
    @SerializedName("is_anomaly") val isAnomaly: Boolean,
    @SerializedName("is_stale") val isStale: Boolean,
    @SerializedName("trade_url") val tradeUrl: String?,
    @SerializedName("token_info_url") val tokenInfoUrl: String?,
    @SerializedName("coin_id") val coinId: String,
    @SerializedName("target_coin_id") val targetCoinId: String?
)

data class Market(
    val name: String,
    val identifier: String,
    @SerializedName("has_trading_incentive") val hasTradingIncentive: Boolean
)

data class ReposUrl(
    @SerializedName("github") val github: List<String>,
    @SerializedName("bitbucket") val bitbucket: List<String>
)