package com.rupinder.customalertdialog

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rupinder.customalertdialog.databinding.ActivitySecondBinding
import com.rupinder.customalertdialog.databinding.Customdialog1Binding

class SecondActivity : AppCompatActivity() {
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener {
            var dialogBinding = Customdialog1Binding.inflate(layoutInflater)
            var dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.etName.setText(binding.tvName1.text.toString())
            dialogBinding.etAge.setText((binding.tvAge1.text.toString()))
            if (binding.tvGender1.text.toString().equals("she")) {
                dialogBinding.rbShe.isChecked = true
            } else if (binding.tvGender1.text.toString().equals("he")) {
                dialogBinding.rbHee.isChecked = true
            } else if (binding.tvGender1.text.toString().equals("other")) {
                dialogBinding.rbOther.isChecked = true
                dialogBinding.etDescription.visibility = View.GONE
                dialogBinding.etDescription.setText(binding.tvDescription.text.toString())
            }

            dialogBinding.rgGender.setOnCheckedChangeListener { group, id ->
                when (id) {
                    R.id.rbOther -> dialogBinding.etDescription.visibility = View.VISIBLE

                    else-> {
                        dialogBinding.etDescription.visibility = View.GONE
                    }
                }
            }
            dialogBinding.btnSubmit.setOnClickListener {
                if (dialogBinding.etName.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "ENTER NAME", Toast.LENGTH_LONG).show()
                } else if (dialogBinding.etAge.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "ENTER AGE", Toast.LENGTH_LONG).show()
                } else if (dialogBinding.etDescription.text.toString().isNullOrEmpty()) {
                    Toast.makeText(this, "ENTER DESCRIPTION", Toast.LENGTH_LONG)
                    if (dialogBinding.rbShe.isChecked) {
                        binding.tvName1.setText("SHE")
                    } else if (dialogBinding.rbHee.isChecked) {
                        binding.tvName1.setText("HE")
                    } else if (dialogBinding.rbOther.isChecked) {
                        binding.tvGender1.setText("OTHER")
                    }
                    dialog.dismiss()
                }

            }
            dialog.show()
        }

        }
    }
