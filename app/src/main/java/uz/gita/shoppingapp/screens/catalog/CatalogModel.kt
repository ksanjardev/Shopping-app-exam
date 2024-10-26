package uz.gita.shoppingapp.screens.catalog

import android.util.Log
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.CatalogItem

class CatalogModel: CatalogContract.Model {
    private val catalogItem = AppDatabase.instance.catalogItem()
    override fun getAllCatalogItems(): List<CatalogItem> {
        Log.d("TAAA", "getAllCatalogItems: ${ catalogItem.getAllItem()}")
        return catalogItem.getAllItem()
    }
}