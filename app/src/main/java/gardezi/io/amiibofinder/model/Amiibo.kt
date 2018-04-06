package gardezi.io.amiibofinder.model

data class Amiibo(val amiiboSeries: String,
                  val character: String,
                  val gameSeries: String,
                  val head: String,
                  val image: String,
                  val name: String,
                  val release: Map<String, String>,
                  val tail: String,
                  val type: String)