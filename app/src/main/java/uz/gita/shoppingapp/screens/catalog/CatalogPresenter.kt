package uz.gita.shoppingapp.screens.catalog

import android.util.Log

class CatalogPresenter(val view: CatalogContract.View): CatalogContract.Presenter {
    private val model: CatalogContract.Model = CatalogModel()
    override fun getAllCatalogItem() {

        view.showCatalogItems(model.getAllCatalogItems())
        Log.d("TAAAS", "getAllCatalogItems: ${ model.getAllCatalogItems()}")
    }
}