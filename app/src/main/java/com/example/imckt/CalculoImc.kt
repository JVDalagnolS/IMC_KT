package com.example.imckt

import android.content.Context
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

        return Math.round(calcIMC * 100.0) / 100.0
    }

    fun escolhaSexo(context: Context): String {

        if (this.sexo == 1){
            return context.getString(R.string.masculino)
        } else if (this.sexo == 2){
            return context.getString(R.string.feminino)
        }
        return context.getString(R.string.nEsc)
    }

    fun grauImc(context: Context): String {
        val result = this.calculo()

        if (this.sexo == 1){

            if(result < 20.7){
                return context.getString(R.string.aPeso)
            }else if( result <= 26.4){
                return context.getString(R.string.nrPeso)
            }else if(result <= 27.8){
                return context.getString(R.string.maPeso)
            }else if(result <= 31.1){
                return context.getString(R.string.aPeso)
            }else if(result > 31.1){
                return context.getString(R.string.oPeso)
            }

        }else if (this.sexo == 2){

            if(result < 19.1){
                return context.getString(R.string.aPeso)
            }else if( result <= 25.8){
                return context.getString(R.string.nrPeso)
            }else if(result <= 27.3){
                return context.getString(R.string.maPeso)
            }else if(result <= 32.3){
                return context.getString(R.string.aPeso)
            }else if(result > 32.3){
                return context.getString(R.string.oPeso)
            }

        } else {
            return context.getString(R.string.nSelec)
        }

        return context.getString(R.string.inCorretamente)

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeDouble(Math.round(peso * 100.0) / 100.0)
        parcel.writeDouble(Math.round(altura * 100.0) / 100.0)
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