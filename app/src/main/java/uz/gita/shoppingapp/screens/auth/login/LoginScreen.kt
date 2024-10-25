package uz.gita.shoppingapp.screens.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.databinding.LoginScreenBinding
import uz.gita.shoppingapp.util.goNextScreen


class LoginScreen : Fragment() {
    private lateinit var binding: LoginScreenBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = LoginScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.button.setOnClickListener { checkUser() }

    }

    private fun checkUser() {
        if (binding.nickName.text.toString() == LocalStorage.getUserName() && binding.passwordUser.text.toString() == LocalStorage.getPassword()) {
            findNavController().navigate(R.id.action_loginScreen_to_bottomMenu)
        } else {
            Toast.makeText(requireContext(), "User not found!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onPause() {
        super.onPause()
        LocalStorage.setEnter(true)
    }

}