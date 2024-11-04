package com.frokanic.cryptopeek.mapper

import com.frokanic.cryptopeek.model.*
import com.frokanic.cryptopeek.model.CodeAdditionsDeletions4WeeksResponseModel
import com.frokanic.cryptopeek.model.CommunityDataResponseModel
import com.frokanic.cryptopeek.model.DeveloperDataResponseModel
import com.frokanic.cryptopeek.model.ImageResponseModel
import com.frokanic.cryptopeek.model.LinksResponseModel
import com.frokanic.cryptopeek.model.MarketResponseModel
import com.frokanic.cryptopeek.model.MarketDataResponseModel
import com.frokanic.cryptopeek.model.ProjectResponseModel
import com.frokanic.cryptopeek.model.PublicInterestStatsResponseModel
import com.frokanic.cryptopeek.model.ReposUrlResponseModel
import com.frokanic.cryptopeek.model.StatusUpdateResponseModel
import com.frokanic.cryptopeek.model.TickerResponseModel
import com.frokanic.cryptopeek.model.ROIResponseModel
import com.frokanic.model.model.*

fun CoinDetailResponseModel.toCurrencyDetails(): CurrencyDetails =
    CurrencyDetails(
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
        links = linksResponseModel.toLinks(),
        image = imageResponseModel.toImage(),
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
        marketData = marketDataResponseModel?.toMarketData(),
        communityData = communityDataResponseModel?.toCommunityData(),
        developerData = developerDataResponseModel?.toDeveloperData(),
        publicInterestStats = publicInterestStatsResponseModel?.toPublicInterestStats(),
        statusUpdates = statusUpdateResponseModels.map { it.toStatusUpdate() },
        lastUpdated = lastUpdated,
        tickers = tickerResponseModels.map { it.toTicker() }
    )

fun LinksResponseModel.toLinks(): Links =
    Links(
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
        reposUrl = reposUrlResponseModel.toReposUrl()
    )

fun ReposUrlResponseModel.toReposUrl(): ReposUrl =
    ReposUrl(
        github = github,
        bitbucket = bitbucket
    )

fun ImageResponseModel.toImage(): Image =
    Image(
        thumb = thumb,
        small = small,
        large = large
    )

fun MarketDataResponseModel.toMarketData(): MarketData =
    MarketData(
        currentPrice = currentPrice,
        roi = roiResponseModel?.toROI(),
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

fun ROIResponseModel.toROI(): ROI =
    ROI(
        times = times,
        currency = currency,
        percentage = percentage
    )

fun CommunityDataResponseModel.toCommunityData(): CommunityData =
    CommunityData(
        facebookLikes = facebookLikes,
        twitterFollowers = twitterFollowers,
        redditAveragePosts48h = redditAveragePosts48h,
        redditAverageComments48h = redditAverageComments48h,
        redditSubscribers = redditSubscribers,
        redditAccountsActive48h = redditAccountsActive48h,
        telegramChannelUserCount = telegramChannelUserCount
    )

fun DeveloperDataResponseModel.toDeveloperData(): DeveloperData =
    DeveloperData(
        forks = forks,
        stars = stars,
        subscribers = subscribers,
        totalIssues = totalIssues,
        closedIssues = closedIssues,
        pullRequestsMerged = pullRequestsMerged,
        pullRequestContributors = pullRequestContributors,
        codeAdditionsDeletions4Weeks = codeAdditionsDeletions4WeeksResponseModel?.toCodeAdditionsDeletions4Weeks(),
        commitCount4Weeks = commitCount4Weeks,
        last4WeeksCommitActivitySeries = last4WeeksCommitActivitySeries
    )

fun CodeAdditionsDeletions4WeeksResponseModel.toCodeAdditionsDeletions4Weeks(): CodeAdditionsDeletions4Weeks =
    CodeAdditionsDeletions4Weeks(
        additions = additions,
        deletions = deletions
    )

fun PublicInterestStatsResponseModel.toPublicInterestStats(): PublicInterestStats =
    PublicInterestStats(
        alexaRank = alexaRank,
        bingMatches = bingMatches
    )

fun StatusUpdateResponseModel.toStatusUpdate(): StatusUpdate =
    StatusUpdate(
        description = description,
        category = category,
        createdAt = createdAt,
        user = user,
        userTitle = userTitle,
        pin = pin,
        project = projectResponseModel?.toProject(),
        updatedAt = updatedAt
    )

fun ProjectResponseModel.toProject(): Project =
    Project(
        type = type,
        id = id,
        name = name,
        image = imageResponseModel?.toImage()
    )

fun TickerResponseModel.toTicker(): Ticker =
    Ticker(
        base = base,
        target = target,
        market = marketResponseModel?.toMarket(),
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

fun MarketResponseModel.toMarket(): Market =
    Market(
        name = name,
        identifier = identifier,
        hasTradingIncentive = hasTradingIncentive
    )
