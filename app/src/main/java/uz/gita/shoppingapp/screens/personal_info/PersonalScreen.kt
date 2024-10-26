package uz.gita.shoppingapp.screens.personal_info

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingapp.MainActivity
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.data.entity.UserDataEntity
import uz.gita.shoppingapp.databinding.PersonalScreenBinding

class PersonalScreen : Fragment(), PersonalContract.View {
    private lateinit var binding: PersonalScreenBinding
    private lateinit var presenter: PersonalContract.Presenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = PersonalScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = PersonalPresenter(this)
        presenter.loadUserData(LocalStorage.getNickName())

        binding.editButton.setOnClickListener {
            val updatedUser = UserDataEntity(
                id = AppDatabase.instance.userItem().getUserByNickName(LocalStorage.getNickName())!!.id,
                name = binding.fullName.text.toString(),
                age = binding.ageUser.text.toString(),
                nickName = binding.nicknameUser.text.toString(),
                password = binding.passwordUser.text.toString(),
                phoneNumber = binding.phoneUser.text.toString()
            )
            presenter.saveButtonClick(updatedUser)
        }


    }
    override fun displayUserData(user: UserDataEntity) {
        Log.d("USER", "displayUserData: ${user.name}")
        binding.fullName.setText(user.name)
        binding.ageUser.setText(user.age)
        binding.nicknameUser.setText(user.nickName)
        binding.passwordUser.setText(user.password)
        binding.phoneUser.setText(user.phoneNumber)
    }

    override fun showUpdateSuccess() {
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }

    override fun showUpdateError(error: String) {
        Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
    }

    override fun backToProfile() {
        findNavController().navigate(R.id.action_personalScreen_to_profile)
    }


}