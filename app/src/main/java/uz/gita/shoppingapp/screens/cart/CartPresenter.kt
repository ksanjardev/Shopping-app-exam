package uz.gita.shoppingapp.screens.cart

import uz.gita.shoppingapp.data.entity.HomeItemVertical

class CartPresenter(val view: CartContract.View) : CartContract.Presenter {
    private val model: CartContract.Model = CartModel()
    override fun addButtonClick(data: HomeItemVertical) {
        model.setProductCount(data)
    }

    override fun minusButtonClick(data: HomeItemVertical) {
        model.setProductCount(data)
    }


//    override fun minusButtonClick() {
//        if (count == 1) {
//            model.setProductCount()
//        }
//        model.setProductCount()
//    }

    override fun buttonPayClick() {
        view.showToast("Coming soon ")
        val list = model.getAllCart()
        for (i in list.indices){
            model.updateAll()
        }
    }

    override fun setLikeState(data: HomeItemVertical) {
        model.setLikeState(data)
    }

    override fun setData() {
        sizeCartItem()
        totalItemCount()
        totalProductPrice()
    }

    override fun setCartState(data: HomeItemVertical) {
        val newCartState = if (data.cart == 1) 0 else 1
        val updateData = data.copy(cart = newCartState)
        model.setCartState(updateData)
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