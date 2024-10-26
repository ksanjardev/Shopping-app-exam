package uz.gita.shoppingapp.screens.items_by_category

class ProductPresenter(val view: ProductContract.View, private val categoryId: Int):ProductContract.Presenter {
    private val model: ProductContract.Model = ProductModel()

    init {
        view.showProducts(model.getProductsByCategoryId(categoryId))
    }
    override fun addProductClick() {
        view
    }

    override fun insertItem(id: Int) {
        model
    }
}