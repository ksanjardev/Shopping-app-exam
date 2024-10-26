package uz.gita.shoppingapp.screens.cart

import uz.gita.shoppingapp.data.entity.HomeItemVertical

class CartPresenter(val view: CartContract.View) : CartContract.Presenter {
    private val model: CartContract.Model = CartModel()
    override fun addButtonClick(id: Int, count: Int) {
        model.setProductCount(id, count + 1)
    }


    override fun minusButtonClick(id: Int, count: Int) {
        if (count == 1) {
            model.setProductCount(id, 0)
        }
        model.setProductCount(id, count - 1)
    }

    override fun buttonPayClick() {
        view.showToast("Coming soon ")
        val list = model.getAllCart()
        for (i in list.indices){
            model.setCartState(list[i].id, 0)
            model.setProductCount(list[i].id, 0)
            model.setLikeState(list[i].id, 0)
        }
    }

    override fun setLikeState(id: Int, newState: Int) {
        var temp = if (newState == 1) 0 else 1
    }

    override fun setData() {
        sizeCartItem()
        totalItemCount()
        totalProductPrice()
    }

    override fun getAllCartItems(): List<HomeItemVertical> {
        return model.getAllCart()
    }

    private fun sizeCartItem() {
        view.showBasketProductsSize(model.getAllCart().size)
    }

    private fun totalItemCount() {
        var sum = 0
        val ls = model.getAllCart()
        for (i in ls.indices) {
            sum += ls[i].countItem
        }
        view.showTotalProductCount(sum)
    }

    private fun totalProductPrice() {
        var sum = 0
        val ls = model.getAllCart()
        for (i in ls.indices) {
            sum += ls[i].countItem * ls[i].newPrice
        }
        view.showSumPrice(sum)
    }


}