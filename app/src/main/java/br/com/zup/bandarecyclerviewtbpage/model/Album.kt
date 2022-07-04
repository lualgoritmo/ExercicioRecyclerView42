package br.com.zup.bandarecyclerviewtbpage.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class Album(var img: Int, var name:String, var descricao: String):Parcelable