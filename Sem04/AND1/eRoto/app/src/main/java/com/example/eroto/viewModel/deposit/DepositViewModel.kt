package com.example.eroto.viewModel.deposit

import androidx.lifecycle.LiveData
import com.example.eroto.models.CreditCard
import com.example.eroto.models.CreditCardList

interface DepositViewModel {
    fun getSavedCreditCards(): LiveData<List<CreditCard>>
}