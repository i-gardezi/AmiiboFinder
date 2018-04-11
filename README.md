# AmiiboFinder

This is a very simple application which queries the Amiibo api found at www.amiiboapi.com, and loads a list of Amiibo's corresponding to a name.

The architecture follows the MVVM (Model View ViewModel) design pattern.

It uses Android Architecture Components provided by Google i.e LiveData and AndroidViewModel, 
allowing us to keep the business logic away from the view layer, and respect the life cycle of our activites and fragments.

It uses Retrofit 2 for handing Network Requests, alongside RxJava for thread management of the asynchronous data streams.

Together, LiveData and RxJava are a powerful combination for the flow of data from 'back-end' tasks to be represented in the view layer.

It uses DataBinding for binding the data directly to the views, reducing the need for the monotonous boilerplate 'findViewById, .setText' etc..

It uses Dagger 2 for dependency injection, allowing better management of reused dependencies such as the webservice and daos.

It uses Room for storing data locally on an internal database.

Following the use of LifeCycle aware classes such as AndroidViewModel, Glide is also used for Image Loading and Caching, 
and through a custom databinder adapter, we can utilize this library for our data binding practices.

A Kotlin version is available on the 'kotlin_version' branch, and a Java version is available on the 'java_version' branch. 



