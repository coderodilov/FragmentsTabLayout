package uz.coderodilov.fragmentstablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import uz.coderodilov.fragmentstablayout.databinding.FragmentSignUpBinding


class SignUpFragment : Fragment() {

    private var _binding: FragmentSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.editName.addTextChangedListener { checkName(it.toString()) }

        binding.editEmail.addTextChangedListener { checkMail(it.toString()) }

        binding.editPassword.addTextChangedListener { checkPassword(it.toString()) }

        binding.editConfirmPassword.addTextChangedListener{ checkConfirmPass(it.toString(),
        binding.editPassword.text.toString()) }

        binding.btnLogin.setOnClickListener{

        }
    }


    private fun checkPassword(password:String) : Boolean {
       if ((!(password.length > 8 && "[A-Za-z\\d!@#$%^&*()]+".toRegex().matches(password)))){
           binding.editPassword.error = "Invalid password! password must be more than 8 character"
           return false
       }
        return true
    }

    private fun checkConfirmPass(password: String, pass:String): Boolean{
        if (password != pass){
            binding.editConfirmPassword.error = "Password mismatch"
            return false
        }
        return true
    }


    private fun checkMail(mail:String):Boolean {
        if (!("[@.]+".toRegex().containsMatchIn(mail))){
            binding.editEmail.error = "Invalid mail!"
            return false
        }
        return true
    }


    private fun checkName(name: String): Boolean {
        if (!(name.length > 2 && "[A-Za-z]+".toRegex().matches(name))){
            binding.editName.error = "Invalid name please enter the correct name!"
            return false
        }
        return true
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}