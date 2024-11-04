package com.frokanic.cryptopeek

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.frokanic.cryptopeek.usecase.CurrencyDetailsUseCase
import com.frokanic.model.model.CodeAdditionsDeletions4Weeks
import com.frokanic.model.model.CommunityData
import com.frokanic.model.model.CurrencyDetails
import com.frokanic.model.model.DeveloperData
import com.frokanic.model.model.Image
import com.frokanic.model.model.Links
import com.frokanic.model.model.Market
import com.frokanic.model.model.MarketData
import com.frokanic.model.model.Project
import com.frokanic.model.model.PublicInterestStats
import com.frokanic.model.model.ROI
import com.frokanic.model.model.ReposUrl
import com.frokanic.model.model.StatusUpdate
import com.frokanic.model.model.Ticker
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import com.frokanic.model.util.Result
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class CryptoDetailsViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    val currencyDetailsUseCase: CurrencyDetailsUseCase
) : ViewModel() {
    private val cryptoId = savedStateHandle.get<String>("id").also { Log.d("ARGH", it.toString()) }

    val currencyDetails: StateFlow<CryptoDetailsUIState> = flow {
        val uiState = if (!cryptoId.isNullOrEmpty()) {

            when (val response = currencyDetailsUseCase(cryptoId)) {
                is Result.Success ->
                    response.data.toSuccessUIState()

                is Result.Failure ->
                    CryptoDetailsUIState.Failure(errorDescription = response.errorDescription)

                else ->
                    CryptoDetailsUIState.Loading
            }
        } else {
            CryptoDetailsUIState.Failure(errorDescription = "")
        }

        emit(uiState)
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = CryptoDetailsUIState.Loading
    )



    private fun CurrencyDetails.toSuccessUIState(): CryptoDetailsUIState.Success = CryptoDetailsUIState.Success(
        id = id,
        symbol = symbol,
        name = name,
        assetPlatformId = assetPlatformId,
        platforms = platforms,
        blockTimeInMinutes = blockTimeInMinutes,
        hashingAlgorithm = hashingAlgorithm,
        categories = categories,
        publicNotice = publicNotice,
        additionalNotices = additionalNotices,
        description = description,
        links = links.toLinksUIState(),
        image = image.toImageUIState(),
        countryOrigin = countryOrigin,
        genesisDate = genesisDate,
        sentimentVotesUpPercentage = sentimentVotesUpPercentage,
        sentimentVotesDownPercentage = sentimentVotesDownPercentage,
        marketCapRank = marketCapRank,
        coingeckoRank = coingeckoRank,
        coingeckoScore = coingeckoScore,
        developerScore = developerScore,
        communityScore = communityScore,
        liquidityScore = liquidityScore,
        publicInterestScore = publicInterestScore,
        marketData = marketData?.toMarketDataUIState(),
        communityData = communityData?.toCommunityDataUIState(),
        developerData = developerData?.toDeveloperDataUIState(),
        publicInterestStats = publicInterestStats?.toPublicInterestStatsUIState(),
        statusUpdates = statusUpdates.map { it.toStatusUpdateUIState() },
        lastUpdated = lastUpdated,
        tickers = tickers.map { it.toTickerUIState() }
    )

    private fun Links.toLinksUIState(): CryptoDetailsUIState.Success.LinksUIState = CryptoDetailsUIState.Success.LinksUIState(
        homepage = homepage,
        blockchainSite = blockchainSite,
        officialForumUrl = officialForumUrl,
        chatUrl = chatUrl,
        announcementUrl = announcementUrl,
        twitterScreenName = twitterScreenName,
        facebookUsername = facebookUsername,
        bitcointalkThreadIdentifier = bitcointalkThreadIdentifier,
        telegramChannelIdentifier = telegramChannelIdentifier,
        subredditUrl = subredditUrl,
        reposUrl = reposUrl.toReposUrlUIState()
    )

    private fun ReposUrl.toReposUrlUIState(): CryptoDetailsUIState.Success.ReposUrlUIState = CryptoDetailsUIState.Success.ReposUrlUIState(
        github = github,
        bitbucket = bitbucket
    )

    private fun Image.toImageUIState(): CryptoDetailsUIState.Success.ImageUIState = CryptoDetailsUIState.Success.ImageUIState(
        thumb = thumb,
        small = small,
        large = large
    )

    private fun MarketData.toMarketDataUIState(): CryptoDetailsUIState.Success.MarketDataUIState = CryptoDetailsUIState.Success.MarketDataUIState(
        currentPrice = currentPrice,
        roi = roi?.toROIUIState(),
        marketCap = marketCap,
        marketCapRank = marketCapRank,
        totalVolume = totalVolume,
        high24h = high24h,
        low24h = low24h,
        priceChange24h = priceChange24h,
        priceChangePercentage24h = priceChangePercentage24h,
        priceChangePercentage7d = priceChangePercentage7d,
        priceChangePercentage14d = priceChangePercentage14d,
        priceChangePercentage30d = priceChangePercentage30d,
        priceChangePercentage60d = priceChangePercentage60d,
        priceChangePercentage200d = priceChangePercentage200d,
        priceChangePercentage1y = priceChangePercentage1y,
        marketCapChange24h = marketCapChange24h,
        marketCapChangePercentage24h = marketCapChangePercentage24h,
        priceChange24hInCurrency = priceChange24hInCurrency,
        priceChangePercentage1hInCurrency = priceChangePercentage1hInCurrency,
        priceChangePercentage24hInCurrency = priceChangePercentage24hInCurrency,
        priceChangePercentage7dInCurrency = priceChangePercentage7dInCurrency,
        priceChangePercentage14dInCurrency = priceChangePercentage14dInCurrency,
        priceChangePercentage30dInCurrency = priceChangePercentage30dInCurrency,
        priceChangePercentage60dInCurrency = priceChangePercentage60dInCurrency,
        priceChangePercentage200dInCurrency = priceChangePercentage200dInCurrency,
        priceChangePercentage1yInCurrency = priceChangePercentage1yInCurrency,
        marketCapChange24hInCurrency = marketCapChange24hInCurrency,
        marketCapChangePercentage24hInCurrency = marketCapChangePercentage24hInCurrency,
        totalSupply = totalSupply,
        maxSupply = maxSupply,
        circulatingSupply = circulatingSupply,
        lastUpdated = lastUpdated
    )

    private fun ROI.toROIUIState(): CryptoDetailsUIState.Success.ROIUIState = CryptoDetailsUIState.Success.ROIUIState(
        times = times,
        currency = currency,
        percentage = percentage
    )

    private fun CommunityData.toCommunityDataUIState(): CryptoDetailsUIState.Success.CommunityDataUIState = CryptoDetailsUIState.Success.CommunityDataUIState(
        facebookLikes = facebookLikes,
        twitterFollowers = twitterFollowers,
        redditAveragePosts48h = redditAveragePosts48h,
        redditAverageComments48h = redditAverageComments48h,
        redditSubscribers = redditSubscribers,
        redditAccountsActive48h = redditAccountsActive48h,
        telegramChannelUserCount = telegramChannelUserCount
    )

    private fun DeveloperData.toDeveloperDataUIState(): CryptoDetailsUIState.Success.DeveloperDataUIState = CryptoDetailsUIState.Success.DeveloperDataUIState(
        forks = forks,
        stars = stars,
        subscribers = subscribers,
        totalIssues = totalIssues,
        closedIssues = closedIssues,
        pullRequestsMerged = pullRequestsMerged,
        pullRequestContributors = pullRequestContributors,
        codeAdditionsDeletions4Weeks = codeAdditionsDeletions4Weeks?.toCodeAdditionsDeletions4WeeksUIState(),
        commitCount4Weeks = commitCount4Weeks,
        last4WeeksCommitActivitySeries = last4WeeksCommitActivitySeries
    )

    private fun CodeAdditionsDeletions4Weeks.toCodeAdditionsDeletions4WeeksUIState(): CryptoDetailsUIState.Success.CodeAdditionsDeletions4WeeksUIState =
        CryptoDetailsUIState.Success.CodeAdditionsDeletions4WeeksUIState(
            additions = additions,
            deletions = deletions
        )

    private fun PublicInterestStats.toPublicInterestStatsUIState(): CryptoDetailsUIState.Success.PublicInterestStatsUIState = CryptoDetailsUIState.Success.PublicInterestStatsUIState(
        alexaRank = alexaRank,
        bingMatches = bingMatches
    )

    private fun StatusUpdate.toStatusUpdateUIState(): CryptoDetailsUIState.Success.StatusUpdateUIState = CryptoDetailsUIState.Success.StatusUpdateUIState(
        description = description,
        category = category,
        createdAt = createdAt,
        user = user,
        userTitle = userTitle,
        pin = pin,
        project = project?.toProjectUIState(),
        updatedAt = updatedAt
    )

    private fun Project.toProjectUIState(): CryptoDetailsUIState.Success.ProjectUIState = CryptoDetailsUIState.Success.ProjectUIState(
        type = type,
        id = id,
        name = name,
        image = image?.toImageUIState()
    )

    private fun Ticker.toTickerUIState(): CryptoDetailsUIState.Success.TickerUIState = CryptoDetailsUIState.Success.TickerUIState(
        base = base,
        target = target,
        market = market?.toMarketUIState(),
        last = last,
        volume = volume,
        convertedLast = convertedLast,
        convertedVolume = convertedVolume,
        trustScore = trustScore,
        bidAskSpreadPercentage = bidAskSpreadPercentage,
        timestamp = timestamp,
        lastTradedAt = lastTradedAt,
        lastFetchAt = lastFetchAt,
        isAnomaly = isAnomaly,
        isStale = isStale,
        tradeUrl = tradeUrl,
        tokenInfoUrl = tokenInfoUrl,
        coinId = coinId,
        targetCoinId = targetCoinId
    )

    private fun Market.toMarketUIState(): CryptoDetailsUIState.Success.MarketUIState = CryptoDetailsUIState.Success.MarketUIState(
        name = name,
        identifier = identifier,
        hasTradingIncentive = hasTradingIncentive
    )

}