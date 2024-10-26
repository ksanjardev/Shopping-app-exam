package uz.gita.shoppingapp.screens.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.databinding.LoginScreenBinding


class LoginScreen : Fragment(), LoginContract.View {
    private lateinit var binding: LoginScreenBinding
    private lateinit var presenter: LoginContract.Presenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = LoginScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = LoginPresenter(this)
        binding.button.setOnClickListener {
            presenter.nextButtonClick(
                binding.nickName.text.toString().trim(),
                binding.passwordUser.text.toString().trim()
            )
        }

        binding.goToLogin.setOnClickListener{
            presenter.btnRegisterClicked()
        }

    }

    override fun onStop() {
        super.onStop()
        presenter.saveNickName(binding.nickName.text.toString())
    }

    override fun showToast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    override fun openRegisterScreen() {
        findNavController().navigate(R.id.action_loginScreen_to_registerScreen)
    }

    override fun openMainScreen() {
        findNavController().navigate(R.id.action_loginScreen_to_bottomMenu)
    }


}