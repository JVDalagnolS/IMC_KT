package com.example.imckt

import android.os.Parcel
import android.os.Parcelable

class CalculoImc(var peso:Double, var altura:Double, var nome:String, var sexo:String) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    fun calcular(): String {
        var result = this.peso /(this.altura * this.altura)

        if(result < 18.5){
            return "Abaixo do peso"
        }else if( result <= 24.9){
            return "Peso normal"
        }else if(result <= 29.9){
            return "Sobrepeso"
        }else if(result <= 34.9){
            return "Obesidade Grau 1"
        }else if(result <= 39.9){
            return "Obesidade Grau 2"
        }else if(result > 40){
            return "Obesidade Grau 3 ou Mórbida"
        }
        return "Informe corretamente."
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(peso)
        parcel.writeDouble(altura)
        parcel.writeString(nome)
        parcel.writeString(sexo)
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