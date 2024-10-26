package uz.gita.shoppingapp.app

import android.app.Application
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.data.entity.CatalogItem
import uz.gita.shoppingapp.data.entity.HomeItemVertical

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        LocalStorage.setSharedPreference(getSharedPreferences("Manager", MODE_PRIVATE))
        AppDatabase.init(this)
        loadData()
        loadDefaultCategory()
    }

    private fun loadDefaultCategory() {
        val itemCatalog = AppDatabase.instance.catalogItem()
        if (itemCatalog.getAllItem().isEmpty()) {
            val items = listOf(
                CatalogItem(0, R.drawable.headphone_ic, "Electronics"),
                CatalogItem(0, R.drawable.blender_ic, "Household appliances"),
                CatalogItem(0, R.drawable.car_ic, "Auto goods"),
                CatalogItem(0, R.drawable.ball_ic, "Sport and meditation"),
                CatalogItem(0, R.drawable.hobby_ic, "Hobby and art"),
            )
            items.forEach {
                itemCatalog.insertItem(it)
            }
        }
    }

    private fun loadData() {
        val itemVertical = AppDatabase.instance.homeItemVerticalDao()
        if (itemVertical.getAllItem().isEmpty()) {
            val items = listOf(
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_1,
                    "Kungaboqar yog'i Oila tanlovi, tozalangan va xidsizlantirilgan, 90…",
                    15000,
                    13000,
                    1560,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_2,
                    "Smartfon Xiaomi Redmi Note 13, 6/128 GB, 8/128 GB, 8/256GB,…",
                    3010000,
                    2499000,
                    299880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_3,
                    "Kir yuvish kukuni Oila tanlovi \"Ayoz tazeligi\", avtomat, 3 kg",
                    57000,
                    41000,
                    4920,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_5,
                    "Sdobnoe pechenye Zarqand Brownie cookies, 490 g",
                    59000,
                    36000,
                    11880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_4,
                    "Yangi tug'ilgan chaqaloqlar uchun tana to'plami 100% paxta, 3 dona",
                    160000,
                    99000,
                    11880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_6,
                    "Televizor Samsung Crystal UHD 4K\n43\", 50\", 55\", 65\" CU7100 Smart TV",
                    5830000,
                    4899000,
                    587880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_7,
                    "Avtomobil va uy uchun portativ, simsiz, kuchli JB-107 changyutgic…",
                    620000,
                    199000,
                    23880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_8,
                    "Sumka shopper ayollar uchun, yelkama, charmdan, eko zamsh,…",
                    400000,
                    99000,
                    11880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_9,
                    "Smartfon Xiaomi Redmi Note 13 Pro, 8/256 ГБ, 12/512 ГБ, 6.67\", 1…",
                    15000,
                    13000,
                    1560,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_10,
                    "Yostiqlar to'plami, bambukdan, gipoallergenli, ekologik toza, 70 *…",
                    107000,
                    89000,
                    10680,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_11,
                    "Drel shurup buragich L-FINE, cho'tkasiz to'plam, 54 ta buyumdan",
                    850000,
                    599000,
                    71880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_12,
                    "Erkaklar uchun krossovka Jomar.vitaly men 2201 black",
                    687000,
                    349000,
                    41880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_13,
                    "Kir yuvish mashinasi Beko WSPE7612A, Inverter ProSmart, 7…",
                    4570000,
                    3799000,
                    455880,
                    0,
                    0, 0
                ),
                HomeItemVertical(
                    0,
                    R.drawable.item_vertical_14,
                    "Gazlangan ichimlik Pepsi, 1.5 litr",
                    13000,
                    12000,
                    1440,
                    0,
                    0, 0
                ),
            )
            items.forEach { product ->
                itemVertical.insertItem(product)
            }
        }
    }
}