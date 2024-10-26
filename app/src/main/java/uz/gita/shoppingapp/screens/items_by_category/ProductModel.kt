package uz.gita.shoppingapp.screens.items_by_category

import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.entity.ProductEntity

class ProductModel: ProductContract.Model {
    private val productDao = AppDatabase.instance.productItem()

    override fun getProductsByCategoryId(id: Int): List<ProductEntity> {
        return productDao.getAllProducts()
    }
}