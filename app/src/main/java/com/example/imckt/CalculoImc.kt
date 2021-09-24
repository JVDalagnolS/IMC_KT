package com.example.imckt

import android.os.Parcel
import android.os.Parcelable

class CalculoImc(var peso:Double, var altura:Double, var sexo:Int) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
    ) {
    }

    fun calculo(): Double {
        var calcIMC = this.peso /(this.altura * this.altura)

        return calcIMC
    }

    fun escolhaSexo(): String {
        if (this.sexo == 1){
            return "Masculino"
        } else if (this.sexo == 2){
            return "Feminino"
        }
        return "Não escolhido..."
    }

    fun grauImc(): String {
        val result = this.calculo()

        if (this.sexo == 1){

            if(result < 20.7){
                return "Abaixo do peso"
            }else if( result <= 26.4){
                return "Peso normal"
            }else if(result <= 27.8){
                return "Marginalmente acima do peso"
            }else if(result <= 31.1){
                return "Acima do peso ideal"
            }else if(result > 31.1){
                return "Obesidade"
            }

        }else if (this.sexo == 2){

            if(result < 19.1){
                return "Abaixo do peso"
            }else if( result <= 25.8){
                return "Peso normal"
            }else if(result <= 27.3){
                return "Marginalmente acima do peso"
            }else if(result <= 32.3){
                return "Acima do peso ideal"
            }else if(result > 32.3){
                return "Obesidade"
            }

        } else {
            return "Não selecionado."
        }

        return "Informe corretamente."

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(peso)
        parcel.writeDouble(altura)
        parcel.writeInt(sexo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CalculoImc> {
        override fun createFromParcel(parcel: Parcel): CalculoImc {
            return CalculoImc(parcel)
        }

        override fun newArray(size: Int): Array<CalculoImc?> {
            return arrayOfNulls(size)
        }
    }

}