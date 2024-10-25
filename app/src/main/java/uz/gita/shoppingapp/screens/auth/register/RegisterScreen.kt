package uz.gita.shoppingappforexam.screens.auth.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.databinding.RegisterScreenBinding
import uz.gita.shoppingapp.util.goNextScreen

class RegisterScreen : Fragment() {
    private lateinit var binding: RegisterScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.button.setOnClickListener { checkAllInput() }
        binding.goToLogin.setOnClickListener{goNextScreen(requireView(), R.id.loginScreen)}
    }

    private fun checkAllInput() {
        if (binding.fullName.text.isNullOrBlank() || binding.ageUser.text.isNullOrEmpty()
            || binding.phoneUser.text.isNullOrBlank() || binding.nicknameUser.text.isNullOrBlank()
            || binding.passwordUser.text.isNullOrBlank()
        ) {
            Toast.makeText(context, "Fill in the blanks", Toast.LENGTH_SHORT).show()
        } else{
            findNavController().navigate(R.id.action_registerScreen_to_bottomMenu)
        }
    }

    override fun onPause() {
        super.onPause()
        LocalStorage.setName(binding.nicknameUser.text.toString())
        LocalStorage.setPassword(binding.passwordUser.text.toString())
        LocalStorage.setEnter(true)
    }
}