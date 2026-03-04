package com.ipManager.ipManager.services

import com.emv.qrcode.core.model.mpm.TagLengthString
import com.emv.qrcode.model.mpm.MerchantAccountInformationTemplate
import com.emv.qrcode.model.mpm.MerchantAccountInformationReserved
import com.emv.qrcode.model.mpm.MerchantAccountInformationReservedAdditional
import com.emv.qrcode.model.mpm.MerchantPresentedMode
import org.springframework.stereotype.Service

@Service
class PaymentService(

) {
    fun generatePix(): String{
        val pixMai = MerchantAccountInformationReservedAdditional()
        pixMai.setGloballyUniqueIdentifier("br.gov.bcb.pix")  // Pix GUI
        val pixKeyTlv = TagLengthString("01", "50607841850")  // Pix Key (CPF)
        pixMai.addPaymentNetworkSpecific(pixKeyTlv)

        val merchantAccountInformation = MerchantAccountInformationTemplate("26", pixMai)

        val pix = MerchantPresentedMode()
        pix.setPayloadFormatIndicator("01")
        pix.setPointOfInitiationMethod("12")  // 12 = Dynamic Pix
        pix.addMerchantAccountInformation(merchantAccountInformation)
        pix.setMerchantCategoryCode("0000")
        pix.setTransactionCurrency("986")
        pix.setTransactionAmount("100.00")
        pix.setMerchantName("HERICK GUIMARAES")
        pix.setMerchantCity("SAO PAULO")
        pix.setCountryCode("BR")

        return pix.toString()
    }

}