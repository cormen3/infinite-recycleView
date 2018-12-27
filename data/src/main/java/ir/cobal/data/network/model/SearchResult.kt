package ir.cobal.data.network.model


class SearchResult constructor(
    var Response:Boolean=true,
    var totalResults:Int=0,
    var Search: ArrayList<SearchEntity>
     )