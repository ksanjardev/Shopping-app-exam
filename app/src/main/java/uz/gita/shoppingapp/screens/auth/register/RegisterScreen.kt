package uz.gita.shoppingappforexam.screens.auth.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.databinding.RegisterScreenBinding
import uz.gita.shoppingapp.screens.auth.register.RegisterContract
import uz.gita.shoppingapp.screens.auth.register.RegisterPresenter

class RegisterScreen : Fragment(), RegisterContract.View {
    private lateinit var binding: RegisterScreenBinding
    private lateinit var presenter: RegisterContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = RegisterScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = RegisterPresenter(this)
        binding.button.setOnClickListener {
            presenter.addAccountButtonClick(
                name = binding.fullName.text.toString().trim(),
                nickName = binding.nicknameUser.text.toString().trim(),
                password = binding.passwordUser.text.toString().trim(),
                age = binding.ageUser.text.toString().trim(),
                phoneNumber = binding.phoneUser.text.toString().trim()
            )
        }
        binding.goToLogin.setOnClickListener { presenter.loginButtonClick() }
    }

    override fun onStop() {
        super.onStop()
        presenter.saveNickName(binding.nicknameUser.text.toString())
    }

    override fun openLogin() {
        findNavController().navigate(R.id.action_registerScreen_to_loginScreen)
    }

    override fun openMainScreen() {
        findNavController().navigate(R.id.action_registerScreen_to_bottomMenu)
    }

    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }
}