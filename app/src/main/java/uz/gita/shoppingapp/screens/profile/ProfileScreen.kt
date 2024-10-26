package uz.gita.shoppingapp.screens.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import uz.gita.shoppingapp.MainActivity
import uz.gita.shoppingapp.R
import uz.gita.shoppingapp.adapters.ProfileItemAdapter
import uz.gita.shoppingapp.data.database.AppDatabase
import uz.gita.shoppingapp.data.database.LocalStorage
import uz.gita.shoppingapp.data.entity.ProfileItemEntity
import uz.gita.shoppingapp.databinding.ProfileScreenBinding

class ProfileScreen : Fragment(), ProfileContract.View {
    private lateinit var binding: ProfileScreenBinding
    private lateinit var presenter: ProfileContract.Presenter
    private lateinit var profileAdapter: ProfileItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ProfileScreenBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ProfilePresenter(this)
        profileAdapter = ProfileItemAdapter()
        binding.recyclerViewProfile.adapter = profileAdapter
        binding.recyclerViewProfile.layoutManager = LinearLayoutManager(context)
        presenter.getAllItem()

        profileAdapter.setItemListener { presenter.showMessage() }

        binding.editButton.setOnClickListener {
            presenter.editProfileButtonClick()
        }
        binding.logOut.setOnClickListener { presenter.logOutButtonClick() }

        binding.nameOfUser.text =
            AppDatabase.instance.userItem().getUserByNickName(LocalStorage.getNickName())?.nickName
        binding.phoneOfUser.text = AppDatabase.instance.userItem()
            .getUserByNickName(LocalStorage.getNickName())?.phoneNumber
    }

    override fun showAllItem(items: List<ProfileItemEntity>) {
        profileAdapter.submitList(items)
    }

    override fun showToast(msg: String) {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
    }

    override fun showPersonalInfoScreen() {
        findNavController().navigate(R.id.action_profile_to_personalScreen)
    }

    override fun backToRegister() {
        LocalStorage.isUserSignedIn(false)
        requireActivity().startActivity(Intent(requireContext(), MainActivity::class.java))
        requireActivity().finish()
    }

    override fun showLogOutDialog() {
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Logout")
            .setMessage("Are you sure you want to log out?")
            .setPositiveButton("Yes") { _, _ ->
                presenter.dialogYesButtonClick()
            }
            .setNegativeButton("Cancel", null) // Dismiss the dialog
            .create()

        dialog.show()
    }
}