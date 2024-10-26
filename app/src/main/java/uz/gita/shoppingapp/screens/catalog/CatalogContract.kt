package uz.gita.shoppingapp.screens.catalog

import uz.gita.shoppingapp.data.entity.CatalogItem

interface CatalogContract {
    interface Model{
        fun getAllCatalogItems():List<CatalogItem>
    }
    interface View{
        fun showCatalogItems(items:List<CatalogItem>)
        fun openProductScreen(catalogItem: CatalogItem)
        fun openNewCategoryDialog()
    }
    interface Presenter{
        fun getAllCatalogItem()
        fun catalogItemClick(catalogItem: CatalogItem)
        fun addCategoryButtonClick()
    }
}