package com.example.session_1

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.DialogFragment

class MyDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater

            builder.setView(inflater.inflate(R.layout.dialog_sign_in, null))
                .setTitle(R.string.alert_dialog_title)
                .setNegativeButton(R.string.add,
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
                    })
                .setPositiveButton(R.string.cancel,
                    DialogInterface.OnClickListener { dialog, id ->
                        getDialog()?.cancel()
                    })
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}