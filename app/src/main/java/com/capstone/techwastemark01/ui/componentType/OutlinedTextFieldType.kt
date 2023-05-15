package com.capstone.techwastemark01.ui.componentType

sealed class OutlinedTextFieldType(val labelText: String, val placeHolderText: String) {
    object Email: OutlinedTextFieldType(labelText = "Email", placeHolderText = "user email")
    object Password: OutlinedTextFieldType(labelText = "Password", placeHolderText = "user password")
    object FullName: OutlinedTextFieldType(labelText = "Full Name", placeHolderText = "user full name")
}
