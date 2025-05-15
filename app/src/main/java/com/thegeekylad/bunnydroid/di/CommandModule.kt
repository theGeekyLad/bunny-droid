package com.thegeekylad.bunnydroid.di

import com.thegeekylad.bunnydroid.data.CommandChatGPT
import com.thegeekylad.bunnydroid.data.CommandDDSearch
import com.thegeekylad.bunnydroid.data.CommandEmail
import com.thegeekylad.bunnydroid.data.CommandGCalEventCreate
import com.thegeekylad.bunnydroid.data.CommandGKeepCreate
import com.thegeekylad.bunnydroid.data.CommandGPhotos
import com.thegeekylad.bunnydroid.data.CommandGSearch
import com.thegeekylad.bunnydroid.data.CommandGTasks
import com.thegeekylad.bunnydroid.data.CommandGpSearch
import com.thegeekylad.bunnydroid.data.CommandMaps
import com.thegeekylad.bunnydroid.data.CommandWut
import com.thegeekylad.bunnydroid.data.CommandYt
import com.thegeekylad.bunnydroid.data.CommandYtMusic
import com.thegeekylad.bunnydroid.data.amazon.CommandAmazonCart
import com.thegeekylad.bunnydroid.data.amazon.CommandAmazonOrders
import com.thegeekylad.bunnydroid.data.amazon.CommandAmazonSearch
import com.thegeekylad.bunnydroid.data.CommandEbaySearch
import com.thegeekylad.bunnydroid.data.instgaram.CommandIgDm
import com.thegeekylad.bunnydroid.data.instgaram.CommandIgUserSearch
import com.thegeekylad.bunnydroid.data.twitter.CommandTwitterExplore
import com.thegeekylad.bunnydroid.data.twitter.CommandTwitterSearch
import com.thegeekylad.bunnydroid.repository.ICommand
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey

@Module
@InstallIn(SingletonComponent::class)
object CommandModule {
    @Provides
    @IntoMap
    @StringKey("igu")
    fun commandIgUserSearch(): ICommand = CommandIgUserSearch()

    @Provides
    @IntoMap
    @StringKey("igdm")
    fun commandIgDm(): ICommand = CommandIgDm()

    @Provides
    @IntoMap
    @StringKey("cc")
    fun commandGCalEventCreate(): ICommand = CommandGCalEventCreate()

    @Provides
    @IntoMap
    @StringKey("tw")
    fun commandTwitterSearch(): ICommand = CommandTwitterSearch()

    @Provides
    @IntoMap
    @StringKey("twt")
    fun commandTwitterExplore(): ICommand = CommandTwitterExplore()

    @Provides
    @IntoMap
    @StringKey("gp")
    fun commandGpSearch(): ICommand = CommandGpSearch()

    @Provides
    @IntoMap
    @StringKey("g")
    fun commandGSearch(): ICommand = CommandGSearch()

    @Provides
    @IntoMap
    @StringKey("tt")
    fun commandGTasks(): ICommand = CommandGTasks()

    @Provides
    @IntoMap
    @StringKey("y")
    fun commandYt(): ICommand = CommandYt()

    @Provides
    @IntoMap
    @StringKey("ym")
    fun commandYtMusic(): ICommand = CommandYtMusic()

    @Provides
    @IntoMap
    @StringKey("pp")
    fun commandGPhotos(): ICommand = CommandGPhotos()

    @Provides
    @IntoMap
    @StringKey("kk")
    fun commandGKeepCreate(): ICommand = CommandGKeepCreate()

    @Provides
    @IntoMap
    @StringKey("az")
    fun commandAmazonSearch(): ICommand = CommandAmazonSearch()

    @Provides
    @IntoMap
    @StringKey("azc")
    fun commandAmazonCart(): ICommand = CommandAmazonCart()

    @Provides
    @IntoMap
    @StringKey("azo")
    fun commandAmazonOrders(): ICommand = CommandAmazonOrders()

    @Provides
    @IntoMap
    @StringKey("mt")
    fun commandEmail(): ICommand = CommandEmail()

    @Provides
    @IntoMap
    @StringKey("wut")
    fun commandWut(): ICommand = CommandWut()

    @Provides
    @IntoMap
    @StringKey("dd")
    fun commandDDSearch(): ICommand = CommandDDSearch()

    @Provides
    @IntoMap
    @StringKey("qq")
    fun commandChatGPT(): ICommand = CommandChatGPT()

    @Provides
    @IntoMap
    @StringKey("go")
    fun commandMaps(): ICommand = CommandMaps()

    @Provides
    @IntoMap
    @StringKey("eb")
    fun commandEbaySearch(): ICommand = CommandEbaySearch()
}