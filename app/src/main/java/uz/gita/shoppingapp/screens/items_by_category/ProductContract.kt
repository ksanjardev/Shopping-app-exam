package uz.gita.shoppingapp.screens.items_by_category

import uz.gita.shoppingapp.data.entity.ProductEntity

interface ProductContract {
    interface Model{
        fun getProductsByCategoryId(id: Int): List<ProductEntity>
    }
    interface View{
        fun showProducts(items: List<ProductEntity>)
    }
    interface Presenter{
        fun addProductClick()
        fun insertItem(id: Int)
    }
}